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
package com.squid.core.domain.extensions.string;

import java.util.ArrayList;
import java.util.List;

import com.squid.core.domain.DomainNumericConstant;
import com.squid.core.domain.DomainString;
import com.squid.core.domain.DomainStringConstant;
import com.squid.core.domain.IDomain;
import com.squid.core.domain.extensions.registry.StringFunctionsRegistry;
import com.squid.core.domain.operators.ExtendedType;
import com.squid.core.domain.operators.ListContentAssistEntry;
import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.domain.operators.OperatorDiagnostic;

public class StringLengthOperatorsDefinition extends OperatorDefinition {

	public static final String STRING_LENGTH = StringFunctionsRegistry.STRING_BASE+"LENGTH";
	
	public StringLengthOperatorsDefinition(String name, String ID, IDomain domain) {
		super(name,ID,PREFIX_POSITION,name,IDomain.NUMERIC);
		setDomain(domain);
	}
	
	public StringLengthOperatorsDefinition(String name, String ID, IDomain domain, int categoryType) {
		super(name,ID,PREFIX_POSITION,name,IDomain.NUMERIC, categoryType);
		setDomain(domain);
	}
	
	@Override
	public int getType() {
		return ALGEBRAIC_TYPE;
	}


	@Override
	public ListContentAssistEntry getListContentAssistEntry(){
		if(super.getListContentAssistEntry()==null){
			List <String> descriptions = new ArrayList<String>();
			descriptions.add("Return the length of the string.");
			ListContentAssistEntry entry = new ListContentAssistEntry(descriptions,getParametersTypes());
			setListContentAssistEntry(entry);
		}
		return super.getListContentAssistEntry();
	}

	@Override
	public List getParametersTypes() {
		List poly = new ArrayList<List>();
		List type = new ArrayList<IDomain>();

		IDomain string1 = new DomainString();
		string1.setContentAssistLabel("input_string");
		string1.setContentAssistProposal("${1:input_string}");

		type.add(string1);

		poly.add(type);

		return poly;

	}

	@Override
	public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
		if (imageDomains.size()!=1) return new OperatorDiagnostic("Invalid number of parameters",getName()+"(string)");
		if (!imageDomains.get(0).isInstanceOf(IDomain.STRING)) return new OperatorDiagnostic("Parameter must be a string",getName()+"(string)");
		return OperatorDiagnostic.IS_VALID;
	}
	
	@Override
	public ExtendedType computeExtendedType(ExtendedType[] types) {
		return ExtendedType.INTEGER;
	}
	
}
