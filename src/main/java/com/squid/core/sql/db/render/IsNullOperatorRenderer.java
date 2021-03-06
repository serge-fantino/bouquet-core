package com.squid.core.sql.db.render;

import com.squid.core.domain.operators.OperatorDefinition;
import com.squid.core.sql.render.RenderingException;
import com.squid.core.sql.render.SQLSkin;

public class IsNullOperatorRenderer extends  BaseOperatorRenderer{

	@Override
	public String prettyPrint(SQLSkin skin, OperatorDefinition opDef, String[] args) throws RenderingException {
		if (args.length == 1) {
			return "(" + args[0] + ") IS NULL";
		}else
			return opDef.prettyPrint(args, true);
	}

}
