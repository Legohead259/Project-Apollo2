package util.converters;

public class AreaConverter {
	/**
	 * Method that converts the passed value into square meters (m^2)
	 * @param value the value to be converted
	 * @param unit the unit of the value
	 * @return the converted value of the unit in m^2
	 */
	public static double convertToSqMeters(double value, String unit) {
		double sqMeters = 0;
		
		if (unit.contains("inches") || unit.equalsIgnoreCase("in^2")) {
			sqMeters = value * 1550;
		}
		
		return sqMeters;
	}
	
	/**
	 * Method that converts the passed value into square inches (in^2)
	 * @param value the value to be converted
	 * @param unit the unit of the value
	 * @return the converted value of the unit in in^2
	 */
	public static double convertToSqInches(double value, String unit) {
		double sqInches = 0;
		
		if (unit.contains("meters") || unit.equalsIgnoreCase("m^2")) {
			sqInches = value * 0.00064516;
		}
		
		return sqInches;
	}
}
