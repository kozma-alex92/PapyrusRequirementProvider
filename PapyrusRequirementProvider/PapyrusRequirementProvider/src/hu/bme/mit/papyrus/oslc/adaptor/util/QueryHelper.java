package hu.bme.mit.papyrus.oslc.adaptor.util;

import java.util.ArrayList;

public final class QueryHelper {
	
	public static ArrayList<WhereParam> whereParams;
	public static ArrayList<String> propertyParams;

	public static ArrayList<WhereParam> getWhereParams(String where) {

		whereParams = new ArrayList<WhereParam>();

		if(where!=null){
			String[] whereParamArray = where.split("and");
			
			for (String s : whereParamArray) {
				s = s.trim();
				String[] sSplit = s.split(":");
				String prefix = sSplit[0];
				String prop = sSplit[1];
				String operator = "";

				if (prop.contains("=")) {
					operator = "=";
				} else if (prop.contains(">")) {
					operator = ">";
				} else if (prop.contains("<")) {
					operator = "<";
				}
				String property = prop.split(operator)[0];
				String value = prop.split(operator)[1].replace("\"", "");;

				whereParams.add(new WhereParam(prefix, property, operator, value));
			}
		}


		
		return whereParams;
	}
	
	public static ArrayList<String> getPropertyParams(String properties) {

		propertyParams = new ArrayList<String>();
		if(properties!=null){
		String[] stringsArray = properties.split(",");
		
		for (String s : stringsArray) {
			s = s.trim();
			String[] sSplit = s.split(":");
			String prefix = sSplit[0];
			String prop = sSplit[1];

			propertyParams.add(prop);
		}
		}
		return propertyParams;
	}



}
