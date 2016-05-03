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
package com.squid.core.sql.db.templates;

import com.squid.core.database.model.DatabaseProduct;
import com.squid.core.domain.aggregate.QuotientOperatorDefinition;
import com.squid.core.domain.analytics.WindowingOperatorRegistry;
import com.squid.core.domain.extensions.AddMonthsOperatorDefinition;
import com.squid.core.domain.extensions.cast.CastOperatorDefinition;
import com.squid.core.domain.extensions.DateOperatorDefinition;
import com.squid.core.domain.extensions.DateTruncateOperatorDefinition;
import com.squid.core.domain.extensions.DateTruncateShortcutsOperatorDefinition;
import com.squid.core.domain.extensions.date.extract.ExtractOperatorDefinition;
import com.squid.core.domain.extensions.OneArgStringOperatorDefinition;
import com.squid.core.domain.extensions.PadOperatorDefinition;
import com.squid.core.domain.extensions.RegexpOperatorDefinition;
import com.squid.core.domain.extensions.SplitPartOperatorDefinition;
import com.squid.core.domain.extensions.StringLengthOperatorsDefinition;
import com.squid.core.domain.extensions.TranslateOperatorDefinition;
import com.squid.core.domain.extensions.TrimOperatorDefinition;
import com.squid.core.domain.maths.CeilOperatorDefintion;
import com.squid.core.domain.maths.DegreesOperatorDefintion;
import com.squid.core.domain.maths.FloorOperatorDefintion;
import com.squid.core.domain.maths.GreatestLeastOperatorDefinition;
import com.squid.core.domain.maths.PiOperatorDefintion;
import com.squid.core.domain.maths.PowerOperatorDefintion;
import com.squid.core.domain.maths.RoundOperatorDefintion;
import com.squid.core.domain.maths.SignOperatorDefintion;
import com.squid.core.domain.maths.SinhCoshTanhOperatorDefintion;
import com.squid.core.domain.maths.TruncateOperatorDefintion;
import com.squid.core.domain.operators.IntrinsicOperators;
import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.domain.operators.OperatorScope;
import com.squid.core.domain.sort.SortOperatorDefinition;
import com.squid.core.sql.db.render.AddMonthsOperatorRenderer;
import com.squid.core.sql.db.render.AverageOperatorRenderer;
import com.squid.core.sql.db.render.CaseOperatorRender;
import com.squid.core.sql.db.render.CastOperatorRenderer;
import com.squid.core.sql.db.render.CeilOperatorRenderer;
import com.squid.core.sql.db.render.CoVarianceRenderer;
import com.squid.core.sql.db.render.CountOperatorRenderer;
import com.squid.core.sql.db.render.CurrentDateTimestampRenderer;
import com.squid.core.sql.db.render.DateAddOperatorRenderer;
import com.squid.core.sql.db.render.DateEpochOperatorRenderer;
import com.squid.core.sql.db.render.DateIntervalOperatorRenderer;
import com.squid.core.sql.db.render.DateSubOperatorRenderer;
import com.squid.core.sql.db.render.DateTruncateOperatorRenderer;
import com.squid.core.sql.db.render.DegreesOperatorRenderer;
import com.squid.core.sql.db.render.ExtractOperatorRenderer;
import com.squid.core.sql.db.render.FloorOperatorRenderer;
import com.squid.core.sql.db.render.GreatestLeastOperatorRenderer;
import com.squid.core.sql.db.render.InOperatorRenderer;
import com.squid.core.sql.db.render.MinMaxOperatorRenderer;
import com.squid.core.sql.db.render.OperatorRenderer;
import com.squid.core.sql.db.render.PadOperatorRenderer;
import com.squid.core.sql.db.render.PiOperatorRenderer;
import com.squid.core.sql.db.render.PowerOperatorRenderer;
import com.squid.core.sql.db.render.QuotientOperatorRenderer;
import com.squid.core.sql.db.render.RegexpOperatorRenderer;
import com.squid.core.sql.db.render.RoundOperatorRenderer;
import com.squid.core.sql.db.render.RowsOperatorRenderer;
import com.squid.core.sql.db.render.SignOperatorRenderer;
import com.squid.core.sql.db.render.SinhCoshTanhOperatorRenderer;
import com.squid.core.sql.db.render.SortOperatorRenderer;
import com.squid.core.sql.db.render.StddevOperatorRenderer;
import com.squid.core.sql.db.render.StringLengthRenderer;
import com.squid.core.sql.db.render.StringOneArgOperatorRenderer;
import com.squid.core.sql.db.render.ThreeArgsFunctionRenderer;
import com.squid.core.sql.db.render.TrimOperatorRenderer;
import com.squid.core.sql.db.render.TruncateOperatorRenderer;
import com.squid.core.sql.render.ISkinFeatureSupport;
import com.squid.core.sql.render.ISkinPref;
import com.squid.core.sql.render.SQLSkin;

import java.util.List;

/**
 * The default skin provider
 *
 * @author serge fantino
 *
 */
public class DefaultSkinProvider implements ISkinProvider {

	private DelegateOperatorRendererRegistry delegateRendererRegistry;

	public DefaultSkinProvider() {
		delegateRendererRegistry = new DelegateOperatorRendererRegistry();
		//
		registerOperatorRender(OperatorScope.getDefault().lookupByID(OperatorScope.COUNT).getExtendedID(),
				new CountOperatorRenderer());
		//
		registerOperatorRender(AddMonthsOperatorDefinition.ADD_MONTHS, new AddMonthsOperatorRenderer());
		//
		registerOperatorRender(DateOperatorDefinition.DATE_ADD, new DateAddOperatorRenderer());
		registerOperatorRender(DateOperatorDefinition.DATE_SUB, new DateSubOperatorRenderer());
		registerOperatorRender(DateOperatorDefinition.DATE_INTERVAL, new DateIntervalOperatorRenderer());
		registerOperatorRender(DateOperatorDefinition.FROM_UNIXTIME,
				new DateEpochOperatorRenderer(DateEpochOperatorRenderer.FROM));
		registerOperatorRender(DateOperatorDefinition.TO_UNIXTIME,
				new DateEpochOperatorRenderer(DateEpochOperatorRenderer.TO));
		registerOperatorRender(DateTruncateOperatorDefinition.DATE_TRUNCATE, new DateTruncateOperatorRenderer());
		registerOperatorRender(DateTruncateShortcutsOperatorDefinition.HOURLY_ID, new DateTruncateOperatorRenderer());
		registerOperatorRender(DateTruncateShortcutsOperatorDefinition.DAILY_ID, new DateTruncateOperatorRenderer());
		registerOperatorRender(DateTruncateShortcutsOperatorDefinition.WEEKLY_ID, new DateTruncateOperatorRenderer());
		registerOperatorRender(DateTruncateShortcutsOperatorDefinition.MONTHLY_ID, new DateTruncateOperatorRenderer());
		registerOperatorRender(DateTruncateShortcutsOperatorDefinition.YEARLY_ID, new DateTruncateOperatorRenderer());
		//
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_DAY, new ExtractOperatorRenderer("DAY"));
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_DAY_OF_WEEK,
				new ExtractOperatorRenderer("DAY_OF_WEEK"));
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_DAY_OF_YEAR,
				new ExtractOperatorRenderer("DAY_OF_YEAR"));
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_MONTH, new ExtractOperatorRenderer("MONTH"));
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_YEAR, new ExtractOperatorRenderer("YEAR"));
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_HOUR, new ExtractOperatorRenderer("HOUR"));
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_MINUTE, new ExtractOperatorRenderer("MINUTE"));
		registerOperatorRender(ExtractOperatorDefinition.EXTRACT_SECOND, new ExtractOperatorRenderer("SECOND"));
		//
		// See Ticket #1620
		// registerOperatorRender(IntervalOperatorDefinition.INTERVAL_DAY, new
		// IntervalOperatorRenderer("DAY"));
		// registerOperatorRender(IntervalOperatorDefinition.INTERVAL_MONTH, new
		// IntervalOperatorRenderer("MONTH"));
		// registerOperatorRender(IntervalOperatorDefinition.INTERVAL_YEAR, new
		// IntervalOperatorRenderer("YEAR"));
		// registerOperatorRender(IntervalOperatorDefinition.INTERVAL_HOUR, new
		// IntervalOperatorRenderer("HOUR"));
		// registerOperatorRender(IntervalOperatorDefinition.INTERVAL_MINUTE,
		// new IntervalOperatorRenderer("MINUTE"));
		// registerOperatorRender(IntervalOperatorDefinition.INTERVAL_SECOND,
		// new IntervalOperatorRenderer("SECOND"));
		//
		registerOperatorRender(OperatorDefinition.getExtendedId(IntrinsicOperators.CASE), new CaseOperatorRender());
		//
		registerOperatorRender(StringLengthOperatorsDefinition.STRING_LENGTH, new StringLengthRenderer());
		registerOperatorRender(TranslateOperatorDefinition.STRING_REPLACE, new ThreeArgsFunctionRenderer("REPLACE"));
		registerOperatorRender(TranslateOperatorDefinition.STRING_TRANSLATE,
				new ThreeArgsFunctionRenderer("TRANSLATE"));
		registerOperatorRender(OneArgStringOperatorDefinition.STRING_UPPER, new StringOneArgOperatorRenderer("UPPER"));
		registerOperatorRender(OneArgStringOperatorDefinition.STRING_LOWER, new StringOneArgOperatorRenderer("LOWER"));
		registerOperatorRender(OneArgStringOperatorDefinition.STRING_REVERSE,
				new StringOneArgOperatorRenderer("REVERSE"));
		registerOperatorRender(OneArgStringOperatorDefinition.STRING_MD5, new StringOneArgOperatorRenderer("MD5"));
		registerOperatorRender(SplitPartOperatorDefinition.STRING_SPLIT_PART,
				new ThreeArgsFunctionRenderer("SPLIT_PART"));
		registerOperatorRender(TrimOperatorDefinition.STRING_TRIM, new TrimOperatorRenderer("BOTH"));
		registerOperatorRender(TrimOperatorDefinition.STRING_LTRIM, new TrimOperatorRenderer("LEADING"));
		registerOperatorRender(TrimOperatorDefinition.STRING_RTRIM, new TrimOperatorRenderer("TRAILING"));
		registerOperatorRender(PadOperatorDefinition.STRING_LPAD, new PadOperatorRenderer("LPAD"));
		registerOperatorRender(PadOperatorDefinition.STRING_RPAD, new PadOperatorRenderer("RPAD"));
		//
		registerOperatorRender(RegexpOperatorDefinition.REGEXP_REPLACE, new RegexpOperatorRenderer("REGEXP_REPLACE"));
		registerOperatorRender(RegexpOperatorDefinition.REGEXP_SUBSTR, new RegexpOperatorRenderer("REGEXP_SUBSTR"));
		//
		registerOperatorRender(SortOperatorDefinition.ASC_ID, new SortOperatorRenderer("ASC"));
		registerOperatorRender(SortOperatorDefinition.DESC_ID, new SortOperatorRenderer("DESC"));
		registerOperatorRender(DateOperatorDefinition.CURRENT_DATE, new CurrentDateTimestampRenderer());
		registerOperatorRender(DateOperatorDefinition.CURRENT_TIMESTAMP, new CurrentDateTimestampRenderer());
		registerOperatorRender(CastOperatorDefinition.TO_CHAR, new CastOperatorRenderer());
		registerOperatorRender(CastOperatorDefinition.TO_DATE, new CastOperatorRenderer());
		registerOperatorRender(CastOperatorDefinition.TO_INTEGER, new CastOperatorRenderer());
		registerOperatorRender(CastOperatorDefinition.TO_NUMBER, new CastOperatorRenderer());
		registerOperatorRender(CastOperatorDefinition.TO_TIMESTAMP, new CastOperatorRenderer());
		registerOperatorRender(CeilOperatorDefintion.CEIL, new CeilOperatorRenderer());
		registerOperatorRender(FloorOperatorDefintion.FLOOR, new FloorOperatorRenderer());
		registerOperatorRender(SignOperatorDefintion.SIGN, new SignOperatorRenderer());
		registerOperatorRender(TruncateOperatorDefintion.TRUNCATE, new TruncateOperatorRenderer());
		registerOperatorRender(RoundOperatorDefintion.ROUND, new RoundOperatorRenderer());
		registerOperatorRender(PowerOperatorDefintion.POWER, new PowerOperatorRenderer());
		registerOperatorRender(PiOperatorDefintion.PI, new PiOperatorRenderer());
		registerOperatorRender(DegreesOperatorDefintion.DEGREES, new DegreesOperatorRenderer());
		registerOperatorRender(SinhCoshTanhOperatorDefintion.SINH, new SinhCoshTanhOperatorRenderer("SINH"));
		registerOperatorRender(SinhCoshTanhOperatorDefintion.COSH, new SinhCoshTanhOperatorRenderer("COSH"));
		registerOperatorRender(SinhCoshTanhOperatorDefintion.TANH, new SinhCoshTanhOperatorRenderer("TANH"));
		//
		// VECTOR SUPPORT
		registerOperatorRender(OperatorDefinition.getExtendedId(IntrinsicOperators.AVG), new AverageOperatorRenderer());
		registerOperatorRender(OperatorDefinition.getExtendedId(IntrinsicOperators.MIN), new MinMaxOperatorRenderer());
		registerOperatorRender(OperatorDefinition.getExtendedId(IntrinsicOperators.MAX), new MinMaxOperatorRenderer());
		registerOperatorRender(OperatorDefinition.getExtendedId(IntrinsicOperators.STDDEV),
				new StddevOperatorRenderer());
		registerOperatorRender(OperatorDefinition.getExtendedId(IntrinsicOperators.IN), new InOperatorRenderer());
		//
		registerOperatorRender(OperatorDefinition.getExtendedId(IntrinsicOperators.COVAR_POP),
				new CoVarianceRenderer());
		// default support for LEAST and GREATEST
		registerOperatorRender(GreatestLeastOperatorDefinition.LEAST, new GreatestLeastOperatorRenderer());
		registerOperatorRender(GreatestLeastOperatorDefinition.GREATEST, new GreatestLeastOperatorRenderer());
		//
		// proto: QUOTIENT operator
		registerOperatorRender(QuotientOperatorDefinition.ID, new QuotientOperatorRenderer());
		//
		registerOperatorRender(WindowingOperatorRegistry.WINDOWING_ROWS_ID, new RowsOperatorRenderer());
	}

	@Override
	public DelegateOperatorRendererRegistry getDelegateRendererRegistry() {
		return delegateRendererRegistry;
	}

	/**
	 * register an OperatorRenderer for an operator extendedID
	 *
	 * @param extract_day
	 * @param renderer
	 */
	protected void registerOperatorRender(String extendedID, OperatorRenderer renderer) {
		delegateRendererRegistry.registerOperatorRender(extendedID, renderer);
	}

	protected void unregisterOperatorRender(String extendedID) {
		delegateRendererRegistry.unregisterOperatorRender(extendedID);
	}

	@Override
	public double computeAccuracy(DatabaseProduct product) {
		/**
		 * the accuracy of the default provider is the lowest acceptable
		 * possible
		 */
		return LOWEST_APPLICABLE;
	}

	@Override
	public SQLSkin createSkin(DatabaseProduct product) {
		return new DefaultJDBCSkin(this, product);
	}

	@Override
	public boolean canRender(String extendedID) {
		return delegateRendererRegistry.canRender(extendedID);
	}

	@Override
	public List<String> canRender() {
		return delegateRendererRegistry.canRender();
	}

	@Override
	public ISkinFeatureSupport getFeatureSupport(DefaultJDBCSkin skin, String featureID) {
		return ISkinFeatureSupport.IS_NOT_SUPPORTED;
	}

	@Override
	public String getSkinPrefix(DatabaseProduct product) {
		return "default";
	}

	@Override
	public ISkinProvider getParentSkinProvider() {
		return null;
	}

	@Override
	public ISkinPref getPreferences(DefaultJDBCSkin skin, String featureID) {
		return ISkinPref.NOPREF;
	}
}
