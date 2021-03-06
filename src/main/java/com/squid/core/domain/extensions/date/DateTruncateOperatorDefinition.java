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
package com.squid.core.domain.extensions.date;

import java.util.ArrayList;
import java.util.List;

import com.squid.core.domain.DomainDate;
import com.squid.core.domain.DomainStringConstant;
import com.squid.core.domain.DomainTimestamp;
import com.squid.core.domain.IDomain;
import com.squid.core.domain.aggregate.AggregateDomain;
import com.squid.core.domain.operators.ExtendedType;
import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.domain.operators.OperatorDiagnostic;

/**
 * DATE_TRUNCATE(date or timestamp, string). String could be "week", "month" or
 * "year". This function returns the first day of the week, month or year as a
 * date.
 *
 * @author luatnn
 * @rev 2011-06-29 by jth: More enhanced validation of parameters (date or
 *      timestamp for first param & static value for second parameter)
 */
public class DateTruncateOperatorDefinition extends OperatorDefinition {

	public static final String DATE_TRUNCATE_BASE = "com.squid.domain.operator.date.";

	public static final String DATE_TRUNCATE = DATE_TRUNCATE_BASE + "DATE_TRUNCATE";

	public static final String DAY = "DAY";
	public static final String WEEK = "WEEK";
	public static final String MONTH = "MONTH";
	public static final String QUARTER = "QUARTER";
	public static final String YEAR = "YEAR";
	public static final String HOUR = "HOUR";
	public static final String MINUTE = "MINUTE";
	public static final String SECOND = "SECOND";

	private String hint = "";

	public DateTruncateOperatorDefinition(String name, String ID, IDomain domain) {
		super(name, ID, PREFIX_POSITION, name, IDomain.STRING);
		setDomain(domain);
		this.setCategoryType(OperatorDefinition.DATE_TIME_TYPE);
		hint = name + "( date or timestamp,  format = \"DAY\" or \"WEEK\" or \"MONTH\" or \"QUARTER\" or \"YEAR\"  )";
	}

	@Override
	public int getType() {
		return ALGEBRAIC_TYPE;
	}

	@Override
	public List<String> getHint() {
		List<String> hint = new ArrayList<String>();
		hint.add("Add n months to the date");
		hint.add("Add n months to the timestamp");
		return hint;
	}

	@Override
	public List getParametersTypes() {
		List poly = new ArrayList<List>();
		List type = new ArrayList<IDomain>();

		IDomain date = new DomainDate();
		date.setContentAssistLabel("date");
		IDomain timestamp = new DomainTimestamp();
		timestamp.setContentAssistLabel("timestamp");
		IDomain truncateType = new DomainStringConstant("");
		truncateType.setContentAssistLabel("truncateType");
		truncateType.setContentAssistProposal("${2:STRING:truncateType}");
		type.add(date);
		type.add(truncateType);
		poly.add(type);
		type = new ArrayList<IDomain>();
		type.add(timestamp);
		type.add(truncateType);
		poly.add(type);
		return poly;
	}

	@Override
	public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
		if (imageDomains.size() != 2) {
			return new OperatorDiagnostic("Invalid number of parameters", 0, hint);
		} else if (!(imageDomains.get(0).isInstanceOf(IDomain.DATE)
				|| imageDomains.get(0).isInstanceOf(IDomain.TIMESTAMP))) {
			return new OperatorDiagnostic("Invalid type for parameter #1, must be a date or a timestamp but it is a "
					+ imageDomains.get(0).getName(), 1, hint);
		} else if (!(imageDomains.get(1) instanceof DomainStringConstant)) {
			return new OperatorDiagnostic("Invalid type for parameter #2, must be a format constant", 2, hint);
		} else {
			// check the constant value
			String unit = ((DomainStringConstant) imageDomains.get(1)).getValue();
			if (!DAY.equalsIgnoreCase(unit) && !WEEK.equalsIgnoreCase(unit) && !MONTH.equalsIgnoreCase(unit) && !QUARTER.equalsIgnoreCase(unit)
					&& !YEAR.equalsIgnoreCase(unit)) {
				return new OperatorDiagnostic("Invalid format constant for parameter #2", 2, hint);
			}
		}
		if (imageDomains.get(0).isInstanceOf(IDomain.ANY) || imageDomains.get(1).isInstanceOf(IDomain.ANY)) {
			return new OperatorDiagnostic(
					"Parameter #1 should be a date or timestamp Parameter #2 should be a format string", getName());
		}
		return OperatorDiagnostic.IS_VALID;
	}

	@Override
	public ExtendedType computeExtendedType(ExtendedType[] types) {
		return fixExtendedTypeDomain(computeExtendedTypeRaw(types), types);
	}

	@Override
	public ExtendedType computeExtendedTypeRaw(ExtendedType[] types) {
		ExtendedType dateType = types[0];
		return fixExtendedTypeDomain(dateType, types);
	}

	@Override
	public IDomain computeImageDomain(List<IDomain> imageDomains) {
		if (imageDomains.isEmpty()) {
			return IDomain.UNKNOWN;
		}
		IDomain argument0 = imageDomains.get(0);
		boolean is_aggregate = argument0.isInstanceOf(AggregateDomain.DOMAIN);
		DomainStringConstant mode = (DomainStringConstant) imageDomains.get(1);
		IDomain domain = computeImageDomain(mode.getValue(), argument0);
		if (is_aggregate) {
			// compose with Aggregate
			domain = AggregateDomain.MANAGER.createMetaDomain(domain);
		}
		//
		return domain;
	}

	private IDomain computeImageDomain(String mode, IDomain argument) {
		if (mode.equals(YEAR) || argument.isInstanceOf(IDomain.YEARLY)) {
			if (argument.isInstanceOf(IDomain.YEARLY)) {
				return argument;
			} else {
				return IDomain.YEARLY;
			}
		}
		if (mode.equals(QUARTER) || argument.isInstanceOf(IDomain.QUARTERLY)) {
			if (argument.isInstanceOf(IDomain.QUARTERLY)) {
				return argument;
			} else {
				return IDomain.QUARTERLY;
			}
		}
		if (mode.equals(MONTH) || argument.isInstanceOf(IDomain.MONTHLY)) {
			if (argument.isInstanceOf(IDomain.MONTHLY)) {
				return argument;
			} else {
				return IDomain.MONTHLY;
			}
		}
		if (mode.equals(WEEK) || argument.isInstanceOf(IDomain.WEEKLY)) {
			if (argument.isInstanceOf(IDomain.WEEKLY)) {
				return argument;
			} else {
				return IDomain.WEEKLY;
			}
		}
		if (mode.equals(DAY) || argument.isInstanceOf(IDomain.DATE)) {
			return IDomain.DATE;
		}
		// else
		return argument;
	}

}
