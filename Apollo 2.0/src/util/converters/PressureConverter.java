package util.converters;

public class PressureConverter {
	
	/**
	 * Method that returns the passed value to Pascals (N/m^2)
	 * @param value the value to be converted
	 * @param unit the unit being converted from
	 * @return the value converted in N/m^2
	 */
	public static double convertToPascals(double value, String unit) {
		double pa = 0;
		
		if (unit.contains("pound") || unit.equalsIgnoreCase("psi")) {
			pa = value * 6894.76;
		}
		
		return pa;
	}
	
	/**
	 * Method that returns the passed value to PSI
	 * @param value the value to be converted
	 * @param unit the unit being converted from
	 * @return the value converted in PSI
	 */
	public static double convertToPSI(double value, String unit) {
		double psi = 0;
		
		if (unit.contains("pascal") || unit.equalsIgnoreCase("pa")) {
			psi = value / 6894.76;
		}
		
		return psi;
	}
}
