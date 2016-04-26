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

import java.util.List;

import com.squid.core.domain.IDomain;
import com.squid.core.domain.operators.ExtendedType;
import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.domain.operators.OperatorDiagnostic;

public class TrimOperatorDefinition extends OperatorDefinition {

  // TODO USE STRING registry for STRING_BASE
  public static final String STRING_BASE = "com.squid.domain.operator.string.";

  public static final String STRING_TRIM = STRING_BASE + "TRIM";
  public static final String STRING_LTRIM = STRING_BASE + "LTRIM";
  public static final String STRING_RTRIM = STRING_BASE + "RTRIM";

  private String hint = "";

  public TrimOperatorDefinition(String name, String ID, IDomain domain) {
    super(name, ID, PREFIX_POSITION, name, IDomain.STRING);
    setDomain(domain);
    hint = name + "(string[,trim_character])";
  }

  public TrimOperatorDefinition(String name, String ID, IDomain domain, int categoryType) {
    super(name, ID, PREFIX_POSITION, name, domain);
    setDomain(domain);
    hint = name + "(string[,trim_character])";
  }

  @Override
  public int getType() {
    return ALGEBRAIC_TYPE;
  }

  @Override
  public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
    if (!(imageDomains.size() == 1 || imageDomains.size() == 2)) {
      return new OperatorDiagnostic("Invalid number of parameters", hint);
    }
    if (!imageDomains.get(0).isInstanceOf(IDomain.STRING)) {
      return new OperatorDiagnostic("Parameter must be a string", 0, hint);
    }
    if (imageDomains.size() == 2 && !imageDomains.get(1).isInstanceOf(IDomain.STRING)) {
      return new OperatorDiagnostic("Parameter must be a string", 1, hint);
    }
    return OperatorDiagnostic.IS_VALID;
  }

  @Override
  public ExtendedType computeExtendedType(ExtendedType[] types) {
    if (types.length > 0) {
      return types[0];
    } else {
      return ExtendedType.UNDEFINED;
    }
  }

}
