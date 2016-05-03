/*******************************************************************************
 * Copyright © Squid Solutions, 2016
 * <p/>
 * This file is part of Open Bouquet software.
 * <p/>
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation (version 3 of the License).
 * <p/>
 * There is a special FOSS exception to the terms and conditions of the
 * licenses as they are applied to this program. See LICENSE.txt in
 * the directory of this program distribution.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * <p/>
 * Squid Solutions also offers commercial licenses with additional warranties,
 * professional functionalities or services. If you purchase a commercial
 * license, then it supersedes and replaces any other agreement between
 * you and Squid Solutions (above licenses and LICENSE.txt included).
 * See http://www.squidsolutions.com/EnterpriseBouquet/
 *******************************************************************************/
package com.squid.core.domain.extensions.date.extract;

import com.squid.core.domain.IDomain;
import com.squid.core.domain.operators.OperatorDiagnostic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lrabiet on 02/05/16.
 */
public class ExtractSecondOperatorDefinition extends ExtractOperatorDefinition {

    public static final String ID = ExtractOperatorDefinition.EXTRACT_BASE+"SECOND";

    public ExtractSecondOperatorDefinition(String name, int categoryType) {
        super(name, ID, categoryType);
    }

    public ExtractSecondOperatorDefinition(String name, String ID, int categoryType) {
        super(name, ID, categoryType);
    }

    @Override
    public List getSignature(){
        List signature =  new ArrayList();
        signature.add(IDomain.TIME);
        signature.add(IDomain.NUMERIC);
        return signature;
    }

    @Override
    public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
        if (imageDomains.size()!=1) {
            return new OperatorDiagnostic("Invalid number of parameters", getName() + "(temporal)");
        }
        if (!imageDomains.get(0).isInstanceOf(IDomain.TIME)
                && !imageDomains.get(0).isInstanceOf(IDomain.TIMESTAMP)
                ) {
            return new OperatorDiagnostic("Parameter #1 must be a time or timestamp but it is a " + imageDomains.get(0).getName(), 1, getName() + "(time or timestamp)");
        }
        return OperatorDiagnostic.IS_VALID;
    }

}
