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
import com.squid.core.domain.aggregate.AggregateDomain;
import com.squid.core.domain.analytics.AnalyticDomain;

public class CountOperatorDefinition 
extends OrderedAnalyticOperatorDefinition {

	public CountOperatorDefinition(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public IDomain computeImageDomain(List<IDomain> sourceDomain) {
		if (sourceDomain.size()<=1) {
			return AggregateDomain.MANAGER.createMetaDomain(IDomain.NUMERIC);
		} else {
			return AnalyticDomain.MANAGER.createMetaDomain(IDomain.NUMERIC);
		}
	}
	
	@Override
	public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
		if (imageDomains.size()==0) {
			// count(*)
	    	return OperatorDiagnostic.IS_VALID;
		} else {
			return super.validateParameters(imageDomains);
		}
	}

}
