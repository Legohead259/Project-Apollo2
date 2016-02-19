package objects;

import util.converters.AreaConverter;
import util.converters.MassConverter;

public class Projectile {
	static class Variables {
		/**
		 * The mass of the projectile in pounds
		 */
		static double mass;
		
		/**
		 * The mass of the projectile in kilograms
		 */
		static double massKg;
		
		/**
		 * The air pressure contact surface area in in^2
		 */
		static double contactSA;
		
		/**
		 * The air pressure contact surface area in m^2
		 */
		static double contactSAM;
	}
	
	
	//*****START CONSTRUCTOR*****
	
	
	/**
	 * Constructor for Apollo 2.0's projectile
	 * 
	 * @Precondition m must be in pounds, c must be in in^2
	 * 
	 * @param m the mass of the projectile
	 * @param c the air pressure's contact surface area
	 */
	public Projectile(double m, double c) {
		Variables.mass = m; Variables.contactSA = c; init();
	}
	
	
	//*****END CONSTRUCTOR*****
	
	
	//*****START METHODS*****
	
	
	/**
	 * Method that initializes the converted unit variables
	 */
	void init() {
		Variables.massKg = MassConverter.convertToKilograms(Variables.mass, "lbs");
		Variables.contactSAM = AreaConverter.convertToSqMeters(Variables.contactSA, "in^2");
	}
	
	
	//*****END METHODS*****
	
	
	//*****START GETTERS*****
	
	
	/**
	 * @return the mass of the projectile in lbs
	 */
	public double getMass() {
		return Variables.mass;
	}

	/**
	 * @return the mass of the projectile in kg
	 */
	public double getMassKg() {
		return Variables.massKg;
	}

	/**
	 * @return the contactSA of the projectile in in^2
	 */
	public double getContactSA() {
		return Variables.contactSA;
	}

	/**
	 * @return the contactSA of the projectile in m^2
	 */
	public double getContactSAM() {
		return Variables.contactSAM;
	}
	
	
	//*****END GETTERS*****
}
