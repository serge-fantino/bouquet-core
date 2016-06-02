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

/**
 * Created by lrabiet on 02/05/16.
 */
public class ExtractDayOperatorDefinition extends ExtractOperatorDefinition {

    public static final String ID = ExtractOperatorDefinition.EXTRACT_BASE+"DAY";

    public ExtractDayOperatorDefinition(String name, int categoryType) {
        super(name, ID, categoryType);
    }

    public ExtractDayOperatorDefinition(String name, String ID, int categoryType) {
        super(name, ID, categoryType);
    }
    
}