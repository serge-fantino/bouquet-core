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

import com.squid.core.domain.IDomain;

public abstract class DelegateOperatorDefinition extends OperatorDefinition {

	public DelegateOperatorDefinition(String name) {
		super (name, -1, IDomain.AGGREGATE);
	}
	
	protected DelegateOperatorDefinition(String name, int id, IDomain domain) {
		super(name, id, domain);
		// TODO Auto-generated constructor stub
	}

	protected DelegateOperatorDefinition(String name, int id, int position,
			IDomain domain) {
		super(name, id, position, domain);
		// TODO Auto-generated constructor stub
	}

	protected DelegateOperatorDefinition(String name, int id, String symbol,
			IDomain domain) {
		super(name, id, symbol, domain);
		// TODO Auto-generated constructor stub
	}

	protected DelegateOperatorDefinition(String name, int id, int position,
			String symbol, IDomain domain) {
		super(name, id, position, symbol, domain);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return AGGREGATE_TYPE | DELEGATE_TYPE;
	}
	
	@Override
	/**
	 * in that case we use the operator name as the extendedID 
	 * (if extendedID was not set yet ...)
	 */
	
	public String getExtendedID() {
		String id = super.getExtendedID();
		if (id.equals(IntrinsicOperators.INTRINSIC_EXTENDED_ID + "." + IntrinsicOperators.EXTENDED_ID))
			return getName();
		return id;
	}
	
}
