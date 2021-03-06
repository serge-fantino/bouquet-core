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
package com.squid.core.domain.extensions.registry;

import com.squid.core.domain.extensions.JSON.JSONArrayLengthOperatorDefinition;
import com.squid.core.domain.extensions.JSON.JSONExtractArrayElementTextOperatorDefinition;
import com.squid.core.domain.extensions.JSON.JSONExtractPathTextOperatorDefinition;
import com.squid.core.domain.extensions.JSON.JSONOperatorDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squid.core.domain.IDomain;
import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.domain.operators.OperatorRegistry;
import com.squid.core.domain.operators.OperatorScope;
import com.squid.core.domain.operators.OperatorScopeException;

public class JSONOperatorRegistry implements OperatorRegistry {

  private final static Logger logger = LoggerFactory.getLogger(OperatorRegistry.class);

  public JSONOperatorRegistry(OperatorScope scope) {
    try {
      apply(scope);
      logger.info("init JSONOperatorRegistry");
    } catch (OperatorScopeException e) {
      logger.error("unable to init the JSONOperatorRegistry", e);
    }
  }

  @Override
  public void apply(OperatorScope scope) throws OperatorScopeException {
    scope.registerExtension(new JSONArrayLengthOperatorDefinition("JSON_ARRAY_LENGTH", IDomain.NUMERIC));
    scope.registerExtension(new JSONExtractArrayElementTextOperatorDefinition("JSON_EXTRACT_ARRAY_ELEMENT_TEXT", IDomain.STRING));
    scope.registerExtension(new JSONExtractPathTextOperatorDefinition("JSON_EXTRACT_PATH_TEXT", IDomain.STRING));

  }

}
