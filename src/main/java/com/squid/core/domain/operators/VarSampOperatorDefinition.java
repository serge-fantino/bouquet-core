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
package com.squid.core.domain.operators;

import java.util.List;

import com.squid.core.domain.IDomain;

/**
 * Var_samp operator definition
 * @author loivd
 *
 */
public class VarSampOperatorDefinition extends AggregateOperatorDefinition {
	
	/**
	 * @param name
	 * @param id
	 */
	public VarSampOperatorDefinition(String name, String extendedId) {
		super(name, extendedId, PREFIX_POSITION, name, IDomain.NUMERIC);
		setDomain(IDomain.NUMERIC);
	}
	
	public VarSampOperatorDefinition(String name, int id) {
		super(name, id);
		setDomain(IDomain.NUMERIC);
	}
	
	@Override
	public ExtendedType computeExtendedType(ExtendedType[] types) {
		return ExtendedType.FLOAT;
	}
	
	@Override
	public IDomain computeImageDomain(List<IDomain> sourceDomain) {
		return IDomain.NUMERIC;
	}
	
	@Override
	public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
		if (imageDomains.size() != 1)
			return new OperatorDiagnostic("Invalid number of parameters",
					getName());
		// check if parameter is valid?
		if (!imageDomains.get(0).isInstanceOf(IDomain.NUMERIC)) {
		    return OperatorDiagnostic.invalidType(1,imageDomains.get(0),"Numeric or Date or Timestamp",
                getName());
		}

		return OperatorDiagnostic.IS_VALID;
	}
	
	public String prettyPrint(String symbol, int position, String[] args, boolean showBrackets) {
		if (args.length == 1) {
			return "VAR_SAMP("+ args[0]+")";
		}
		return "UNDEFINED()";
		
	}

}
