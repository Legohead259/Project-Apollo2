package objects;

public class CapacitorBank {
	static class Variables {
		/**
		 * The capacitance of the capacitor bank in Farads
		 */
		static double capacitance;
		
		/**
		 * The voltage of the capacitor bank in volts
		 */
		static double voltage;
		
		/**
		 * The charge of the capacitor bank in Coulombs
		 */
		static double charge;
		
		/**
		 * The energy of the capacitor bank in Joules
		 */
		static double energy;
	}
	
	
	//*****START CONSTRUCTOR*****
	
	
	/**
	 * Coonstructor for Apollo 2.0's capacitor bank
	 * 
	 * @Precondition c must be in Farads and v must be in volts
	 * 
	 * @param c the capacitance of the capacitor bank
	 * @param v the voltage of the capacitor bank
	 */
	public CapacitorBank(double c, double v) {
		Variables.capacitance = c; Variables.voltage = v; calcCharge(); calcEnergy();
	}
	
	
	//*****END CONSTRUCTOR*****
	
	
	//*****START METHODS*****
	
	
	/**
	 * Method that calculates the charge of the capacitor bank in Coulombs
	 */
	void calcCharge() {
		Variables.charge = Variables.capacitance * Variables.voltage;
	}
	
	/**
	 * Method that calculates the energy of the capacitor bank in Joules
	 */
	void calcEnergy() {
		Variables.energy = .5 * Variables.charge * Variables.voltage;
	}
	
	
	//*****END METHODS*****
	
	
	//*****START GETTERS*****
	
	
	/**
	 * @return the capacitance of the capacitor bank in Farads
	 */
	public static double getCapacitance() {
		return Variables.capacitance;
	}

	/**
	 * @return the voltage of the capacitor bank in volts
	 */
	public static double getVoltage() {
		return Variables.voltage;
	}

	/**
	 * @return the charge  of the capacitor bank in Coulombs
	 */
	public static double getCharge() {
		return Variables.charge;
	}

	/**
	 * @return the energy of the capacitor bank in Joules
	 */
	public static double getEnergy() {
		return Variables.energy;
	}
	
	
	//*****END GETTERS*****
}
