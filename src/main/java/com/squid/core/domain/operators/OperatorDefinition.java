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

import java.util.ArrayList;
import java.util.List;

import com.squid.core.domain.IDomain;

/**
 * Definition of an operator: name, ID, position, ...
 * 
 * @author serge fantino
 */
public abstract class OperatorDefinition {

  public static final int ALGEBRAIC_TYPE = 0;
  public static final int AGGREGATE_TYPE = 1;
  public static final int DELEGATE_TYPE = 2;

  public static final int PREFIX_POSITION = 1;
  public static final int INFIX_POSITION = 2;
  public static final int POSTFIX_POSITION = 4;
  public static final int WRAPPER_POSITION = 8;// e.g. (..)
  public static final int STANDARD_POSITIONS = PREFIX_POSITION | INFIX_POSITION | POSTFIX_POSITION;

  // loivd added category type, Ticket #1134
  public static final int MATHS_TYPE = 0;
  public static final int STRING_TYPE = 1;
  public static final int DATE_TIME_TYPE = 2;
  public static final int MISC_TYPE = 3;
  public static final int TRIGO_TYPE = 4;


  private String m_name;
  private int m_id = IntrinsicOperators.UNDEFINED_ID;
  /**
   * the extended ID; if the ID is not EXTENED_ID, the string INTRINSIC_EXTENDED_ID.ID is used. If the ID is EXTENDED_ID, extendedID is an unique string identifying the operator.
   */
  private String extendedID = null;

  /**
   * PREFIX_POSITION, INFIX_POSITION or POSTFIX_POSITION
   */
  private int m_position;

  private String m_symbol;

  private int paramCount = -1;// undefined

  private IDomain m_domain = IDomain.UNKNOWN;

  private List m_parameters;

  // category type
  private int categoryType = MISC_TYPE;// MISC is default category

  /**
   * create simple prefix operator with symbol equals to operator's name
   * 
   * @param name
   * @param id
   */
  public OperatorDefinition(String name, int id, IDomain domain) {
    this(name, id, PREFIX_POSITION, name, domain);
  }

  /**
   * OperatorDefinition
   * 
   * @param name
   * @param id
   * @param domain
   * @param categoryType
   */
  public OperatorDefinition(String name, int id, IDomain domain, int categoryType) {
    this(name, id, PREFIX_POSITION, name, domain);
    this.categoryType = categoryType;
  }

  /**
   * @param name
   * @param id
   * @param position
   */
  public OperatorDefinition(String name, int id, int position, IDomain domain) {
    this(name, id, position, name, domain);
  }

  /**
   * Create infix operator
   * 
   * @param name
   * @param id
   * @param symbol
   */
  public OperatorDefinition(String name, int id, String symbol, IDomain domain) {
    this(name, id, INFIX_POSITION, symbol, domain);
  }

  /**
   * Create operator at the specified position...
   * 
   * @param name
   * @param id
   * @param position
   * @param symbol
   * @param domain
   */
  public OperatorDefinition(String name, int id, int position, String symbol, IDomain domain) {
    super();
    m_name = name;
    m_id = id;
    extendedID = IntrinsicOperators.INTRINSIC_EXTENDED_ID + "." + id;
    m_symbol = symbol;
    m_position = position;
    m_domain = domain;
  }

  /**
   * Create operator at the specified position...
   * 
   * @param name
   * @param id
   * @param position
   * @param symbol
   * @param domain
   * @param categoryType
   */
  public OperatorDefinition(String name, int id, int position, String symbol, IDomain domain, int categoryType) {
    super();
    m_name = name;
    m_id = id;
    extendedID = IntrinsicOperators.INTRINSIC_EXTENDED_ID + "." + id;
    m_symbol = symbol;
    m_position = position;
    m_domain = domain;
    this.categoryType = categoryType;
  }

  /**
   * return the extendedID for a regularID
   * 
   * @param regularID
   * @return
   */
  public static final String getExtendedId(int regularID) {
    return IntrinsicOperators.INTRINSIC_EXTENDED_ID + "." + regularID;
  }

  public OperatorDefinition(String name, String extendedID, int position, String symbol, IDomain domain) {
    super();
    m_name = name;
    m_id = IntrinsicOperators.EXTENDED_ID;
    this.extendedID = extendedID;
    m_symbol = symbol;
    m_position = position;
    m_domain = domain;
  }

  public OperatorDefinition(String name, String extendedID, int position, String symbol, IDomain domain, int categoryType) {
    super();
    m_name = name;
    m_id = IntrinsicOperators.EXTENDED_ID;
    this.extendedID = extendedID;
    m_symbol = symbol;
    m_position = position;
    m_domain = domain;
    this.categoryType = categoryType;
  }

  public int getId() {
    return m_id;
  }

  /**
   * the new (M8) extended ID allowing to plug new operators
   * 
   * @return
   */
  public String getExtendedID() {
    return extendedID;
  }

  /**
   * return true if the operator use an extendedID
   * 
   * @return
   */
  public boolean isExtendedID() {
    return m_id == IntrinsicOperators.EXTENDED_ID;
  }

  public List getParametersTypes(){
    return m_parameters;
  }

  public void setParametersTypes(List parameters){
     m_parameters=parameters;
  }

  public String getName() {
    return m_name;
  }

  public int getPosition() {
    return m_position;
  }

  public String getSymbol() {
    return m_symbol;
  }

  public IDomain getDomain() {
    return m_domain;
  }

  protected void setDomain(IDomain domain) {
    this.m_domain = domain;
  }

  public int getParamCount() {
    return paramCount;
  }

  /**
   * @return the categoryType
   */

  public int getCategoryType() {
    return categoryType;
  }

  public OperatorDefinition setParamCount(int paramCount) {
    this.paramCount = paramCount;
    return this;
  }

  /**
   * ALGEBRAIC_TYPE or AGGREGATE_TYPE
   */
  public abstract int getType();

  public int getPrecedenceOrder() {
    switch (getId()) {
      case IntrinsicOperators.CONCAT:
      case IntrinsicOperators.PLUS:
      case IntrinsicOperators.SUBTRACTION:
        return OperatorPrecedence.ARITHMETIC_GROUP_PRECEDENCE;
      case IntrinsicOperators.MINUS:
      case IntrinsicOperators.MULTIPLY:
      case IntrinsicOperators.DIVIDE:
        return OperatorPrecedence.PRODUCT_RING_PRECEDENCE;
      case IntrinsicOperators.MAX:
      case IntrinsicOperators.MIN:
      case IntrinsicOperators.AVG:
      case IntrinsicOperators.SUM:
      case IntrinsicOperators.MEDIAN:
      case IntrinsicOperators.ABS:
      case IntrinsicOperators.STDDEV:
      case IntrinsicOperators.VARIANCE:
      case IntrinsicOperators.COUNT:
      case IntrinsicOperators.ADD_MONTHS:
      case IntrinsicOperators.IDENTITY:
        return OperatorPrecedence.GROUPING_PRECEDENCE;
      case IntrinsicOperators.ISNULL:
      case IntrinsicOperators.IS_NOTNULL:
        return OperatorPrecedence.FUNCTION_PRECEDENCE;
      case IntrinsicOperators.LESS:
      case IntrinsicOperators.LESS_OR_EQUAL:
      case IntrinsicOperators.GREATER:
      case IntrinsicOperators.GREATER_OR_EQUAL:
        return OperatorPrecedence.INEQUALITY_PRECEDENCE;
      case IntrinsicOperators.EQUAL:
      case IntrinsicOperators.LIKE:
      case IntrinsicOperators.RLIKE:
      case IntrinsicOperators.NOT_EQUAL:
      case IntrinsicOperators.IN:
        return OperatorPrecedence.EQUALITY_PRECEDENCE;
      case IntrinsicOperators.NOT:
        return OperatorPrecedence.LOGICAL_NEGATION_PRECEDENCE;
      case IntrinsicOperators.AND:
        return OperatorPrecedence.LOGICAL_AND_PRECEDENCE;
      case IntrinsicOperators.OR:
        return OperatorPrecedence.LOGICAL_OR_PRECEDENCE;
      default:
        if (getPosition() == INFIX_POSITION) {
          return OperatorPrecedence.FUNCTION_PRECEDENCE;
        } else {
          return OperatorPrecedence.GROUPING_PRECEDENCE;
        }
    }
  }

  public IDomain computeImageDomain(List<IDomain> imageDomains) {
    return m_domain;
  }

  public ExtendedType computeExtendedType(ExtendedType[] types) {
    return null;
  }

  /**
   * fix the extendedType to enforce that the domain is consistent with computeImageDomain()
   * 
   * @param result
   * @param types
   */
  protected ExtendedType fixExtendedTypeDomain(ExtendedType fixme, ExtendedType[] types) {
    ArrayList<IDomain> domains = new ArrayList<IDomain>(types.length);
    for (ExtendedType ext : types) {
      domains.add(ext.getDomain());
    }
    IDomain true_domain = computeImageDomain(domains);
    return new ExtendedType(true_domain, fixme);
  }

  /**
   * This is a custom method allowing an operator to validate the parameters domain definition...
   * 
   * @param imageDomains
   * @return
   */
  public OperatorDiagnostic validateParameters(List<IDomain> imageDomains) {
    return OperatorDiagnostic.IS_VALID;
  }

  public String prettyPrint(String[] args, boolean showBrackets) {
    return prettyPrint(getPrettyPrintSymbol(), m_position, args, showBrackets);
  }

  /**
   * allow to override the symbol used for pretty-printing...
   * 
   * @return
   */
  protected String getPrettyPrintSymbol() {
    return getSymbol();
  }

  /**
   * allowed in order to be able to override the default operator name
   * 
   * @param symbol
   * @param position
   * @param args
   * @param showBrackets
   * @return
   */
  public String prettyPrint(String symbol, int position, String[] args, boolean showBrackets) {
    String result = "";
    switch (position) {
      case OperatorDefinition.PREFIX_POSITION: {
        result += symbol + "(";
        break;
      }
      case OperatorDefinition.POSTFIX_POSITION: {
        result += "(";
        break;
      }
    }
    for (int i = 0; i < args.length; i++) {
      if (i > 0) {
        if (position == OperatorDefinition.INFIX_POSITION) {
          result += symbol;
        } else {
          result += ",";
        }
      }
      result += args[i];
    }
    switch (position) {
      case OperatorDefinition.PREFIX_POSITION: {
        result += ")";
        break;
      }
      case OperatorDefinition.POSTFIX_POSITION: {
        result += ")" + symbol;
        break;
      }
    }
    return result;
  }

  @Override
  public String toString() {
    return getSymbol();
  }

}
