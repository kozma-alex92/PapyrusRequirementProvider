package hu.bme.mit.papyrus.oslc.adaptor.util;

public class WhereParam {


		public String prefix;
		public String property;
		public String operator;
		public String value;

		WhereParam(String prefix, String property, String operator, String value) {
			this.prefix = prefix;
			this.property = property;
			this.operator = operator;
			this.value = value;
		}

		public String toString() {

			String s = "prefix: " + prefix + ", " + "property: " + property + ", " + "operator: " + operator
					+ ", " + "value: " + value;
			return s;

		}

	
}
