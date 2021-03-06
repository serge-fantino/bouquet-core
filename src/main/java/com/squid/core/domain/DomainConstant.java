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
package com.squid.core.domain;

import com.squid.core.domain.operators.ExtendedType;
import com.squid.core.sql.render.SQLSkin;

public class DomainConstant
extends AbstractSingletonDomain
{
	
	public static final IDomain DOMAIN = new DomainConstant();

	@Override
	public ExtendedType computeType(SQLSkin skin){
		return DOMAIN.computeType(skin);
	}

	@Override
	public String getName() {
		return "Constant";
	}

	@Override
	public IDomain getParentDomain() {
		return IDomain.UNKNOWN;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParentDomain(IDomain parent) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setContentAssistLabel(String label){
	}

	@Override
	public void setContentAssistProposal(String proposal){
	}

	@Override
	public void setContentAssistProposal(String proposal, int position){
	}
}
