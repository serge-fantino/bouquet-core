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
package com.squid.core.domain.extensions.string.pad;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.squid.core.domain.*;
import com.squid.core.domain.extensions.registry.StringFunctionsRegistry;
import com.squid.core.domain.operators.ExtendedType;
import com.squid.core.domain.operators.ListContentAssistEntry;
import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.domain.operators.OperatorDiagnostic;

public class PadOperatorDefinition extends OperatorDefinition {

  public static final String STRING_RPAD = StringFunctionsRegistry.STRING_BASE + "RPAD";
  public static final String STRING_LPAD = StringFunctionsRegistry.STRING_BASE + "LPAD";

  private String hint = "";


  public PadOperatorDefinition(String name, String ID, IDomain domain) {
    super(name, ID, PREFIX_POSITION, name, IDomain.STRING);
    setDomain(domain);
    hint = name + "(string,n,string_pad)";
  }

  public PadOperatorDefinition(String name, String ID, IDomain domain, int categoryType) {
    super(name, ID, PREFIX_POSITION, name, domain, categoryType);
    setDomain(domain);
    hint = name + "(string,n[,string_pad])";
  }

  @Override
  public int getType() {
    return ALGEBRAIC_TYPE;
  }

  @Override
  public ListContentAssistEntry getListContentAssistEntry(){
    if(super.getListContentAssistEntry()==null){
      List <String> descriptions = new ArrayList<String>();
      descriptions.add("Pad n characters to the left of the right of the first argument.");
      descriptions.add("Pad n characters (using the final argument as the sequence of characters to use) to the left of the right of the first argument.");

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
    string1.setContentAssistLabel("string");
    string1.setContentAssistProposal("${1:string}");

    IDomain num2 = new DomainNumeric();
    num2.setContentAssistLabel("n");
    num2.setContentAssistProposal("${2:n}");

    IDomain string3 = new DomainString();
    string3.setContentAssistLabel("string_pad");
    string3.setContentAssistProposal("${3:string_pad}");


    type.add(string1);
    type.add(num2);

    poly.add(type);
    type = new ArrayList<IDomain>();

    type.add(string1);
    type.add(num2);
    type.add(string3);

    poly.add(type);
    return poly;

  }


  @Override
  public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
    if (imageDomains.size() < 2 || imageDomains.size() > 3) {
      return new OperatorDiagnostic("Invalid number of parameters", hint);
    }
    if (!imageDomains.get(0).isInstanceOf(IDomain.STRING)) {
      return new OperatorDiagnostic("Parameter must be a string", 0, hint);
    }
    if (!imageDomains.get(1).isInstanceOf(IDomain.NUMERIC)) {
      return new OperatorDiagnostic("Parameter must be a static integer", 1, hint);
    }
    // Null pointer exception.
    if(imageDomains.size() == 3) {
      if (!imageDomains.get(2).isInstanceOf(IDomain.STRING)) {
        return new OperatorDiagnostic("Parameter must be a string", 2, hint);
      }
    }
    return OperatorDiagnostic.IS_VALID;
  }

  @Override
  public ExtendedType computeExtendedType(ExtendedType[] types) {
    if (types.length > 0) {
      int size = 250;
      try {
        size = new Double(((DomainNumericConstant) types[1].getDomain()).getValue()).intValue();
      } catch (Exception e) {
      }
      ExtendedType type = new ExtendedType(IDomain.STRING, Types.VARCHAR, 0, size);
      return type;
    } else {
      return ExtendedType.UNDEFINED;
    }
  }

}
