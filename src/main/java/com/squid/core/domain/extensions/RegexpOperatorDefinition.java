/*******************************************************************************
 * Copyright © Squid Solutions, 2016
 *
 * This file is part of Open Bouquet software.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation (version 3 of the License).
 *
 * There is a special FOSS exception to the terms and conditions of the
 * licenses as they are applied to this program. See LICENSE.txt in
 * the directory of this program distribution.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Squid Solutions also offers commercial licenses with additional warranties,
 * professional functionalities or services. If you purchase a commercial
 * license, then it supersedes and replaces any other agreement between
 * you and Squid Solutions (above licenses and LICENSE.txt included).
 * See http://www.squidsolutions.com/EnterpriseBouquet/
 *******************************************************************************/
package com.squid.core.domain.extensions;

import java.sql.Types;
import java.util.List;

import com.squid.core.domain.IDomain;
import com.squid.core.domain.operators.ExtendedType;
import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.domain.operators.OperatorDiagnostic;

public class RegexpOperatorDefinition extends OperatorDefinition {

	public static final String JSON_BASE = "com.squid.domain.operator.string.";
	public static final String REGEXP_SUBSTR = JSON_BASE + "REGEXP_SUBSTR";
	public static final String REGEXP_REPLACE = JSON_BASE + "REGEXP_REPLACE";
	public static final String REGEXP_INSTR = JSON_BASE + "REGEXP_INSTR";
	public static final String REGEXP_COUNT = JSON_BASE + "REGEXP_COUNT";

	public RegexpOperatorDefinition(String name, String ID, IDomain domain) {
		super(name, ID, PREFIX_POSITION, name, domain);
	}

	public RegexpOperatorDefinition(String name, String ID, IDomain domain, int categoryType) {
		super(name, ID, PREFIX_POSITION, name, domain, categoryType);
	}

	@Override
	public int getType() {
		return ALGEBRAIC_TYPE;
	}

	@Override
	public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
		String hint = "Invalid number of parameters for " + getName() + "(string, regexp, ...)";
		if (imageDomains.size() < 2) {
			return new OperatorDiagnostic("Invalid number of parameters", hint);
		}
		if (!imageDomains.get(0).isInstanceOf(IDomain.STRING)) {
			return new OperatorDiagnostic("1st parameter must be a string", 0, hint);
		}
		if (!imageDomains.get(1).isInstanceOf(IDomain.STRING)) {
			return new OperatorDiagnostic("2nd parameter must be a string", 1, hint);
		}
		if (this.getExtendedID().equals(REGEXP_REPLACE)) {
			if (imageDomains.size() != 3 || !imageDomains.get(2).isInstanceOf(IDomain.STRING)) {
				return new OperatorDiagnostic("3rd parameter must be a string", 2, hint);
			}
		} else if (imageDomains.size() > 2) {
			return new OperatorDiagnostic("Invalid number of parameters", 2,
					"Invalid number of parameters for " + getName() + "(string, regexp)");
		}
		return OperatorDiagnostic.IS_VALID;
	}

	@Override
	public ExtendedType computeExtendedType(ExtendedType[] types) {
		if (REGEXP_COUNT.equals(this.getExtendedID())) {
			return new ExtendedType(IDomain.NUMERIC, Types.INTEGER, 0, 0);
		} else if (REGEXP_INSTR.equals(this.getExtendedID())) {
			return new ExtendedType(IDomain.NUMERIC, Types.INTEGER, 0, 0);
		}
		return new ExtendedType(IDomain.STRING, Types.VARCHAR, 0, (types[0].getSize()));
	}

	@Override
	public IDomain computeImageDomain(List<IDomain> imageDomains) {
		if (REGEXP_COUNT.equals(this.getExtendedID())) {
			return IDomain.NUMERIC;
		} else if (REGEXP_INSTR.equals(this.getExtendedID())) {
			return IDomain.NUMERIC;
		}
		return IDomain.STRING;
	}

}