package calculators;

import objects.Projectile;
import objects.Railgun;

public class LaunchVariablesCalculator {
	static class Variables {
		/**
		 * The muzzle velocity of the projectile in m/s
		 */
		static double muzzleVelocity;
		
		/**
		 * The acceleration of the projectile in m/s^2
		 */
		static double acceleration;
		
		/**
		 * The force exerted on the projectile due to the Lorentz Force in Newtons
		 */
		static double lorentzForce;
		
		/**
		 * The force exerted on the projectile due to air pressure in N/m^2
		 */
		static double airPressure;
		
		/**
		 * The surface area the air pressure contacts
		 */
		static double contactSA;
		
		/**
		 * The overall force acting on the projectile in Newtons
		 */
		static double force;
		
		/**
		 * The mass of the projectile in kilograms
		 */
		static double mass;
		
		/**
		 * The length of the barrel in meters
		 */
		static double displacement;
		
		/**
		 * The time the projectile travels in the barrel in seconds
		 */
		static double timeInBarrel;
		
		/**
		 * The vertical velocity of the projectile at launch in m/s
		 */
		static double verticalLaunchVelocity;
		
		/**
		 * The horizontal velocity of the projectile in m/s
		 */
		static double horizontalVelocity;
		
		/**
		 * The angle of launch of the projectile in radians
		 */
		static double angleOfLaunch;
		
		/**
		 * The muzzle energy of the projectile in Joules
		 */
		static double muzzleEnergy;
	}
	
	
	//*****START CONSTRUCTOR*****
	
	
	/**
	 * Constructor for Apollo 2.0's launch variables calculator
	 * 
	 * @Precondition p and r must be fully initialized in order for the variables to be properly calculated
	 * 
	 * @param p the projectile being fired
	 * @param r the railgun being used to fire the projectile
	 */
	public LaunchVariablesCalculator(Projectile p, Railgun r) {
		Variables.airPressure = r.getAirPressureN(); Variables.angleOfLaunch = r.getAngleOfLaunchR();
		Variables.lorentzForce = r.getLorentzForce(); Variables.mass = p.getMassKg(); Variables.contactSA = p.getContactSAM();
	}
	
	
	//*****END CONSTRUCTOR*****
	
	
	//*****START CALCULATION METHODS*****
	
	
	/**
	 * Method that calculates all of the launch variables
	 */
	public void calcAll() {
		calcMuzzleVelocity(); calcVectorComponents(); calcMuzzleEnergy();
	}
	
	//***Start muzzle velocity calculations***
	
	/**
	 * Method that calculates the muzzle velocity in m/s
	 */
	void calcMuzzleVelocity() {
		calcAcceleration(); calcTimeInBarrel();
		
		Variables.muzzleVelocity = Variables.acceleration * Variables.timeInBarrel;
	}
	
	/**
	 * Method that calculates the acceleration of the projectile in m/s^2 
	 */
	void calcAcceleration() {
		calcOverallForce();
		
		Variables.acceleration = Variables.force / Variables.mass;
	}
	
	/**
	 * Method that calculates the overall force acting on the projectile in Newtons
	 */
	void calcOverallForce() {
		Variables.force = (Variables.lorentzForce + Variables.airPressure) * Variables.contactSA;
	}
	
	/**
	 * Method that calculates the time the projectile is in the barrel in seconds
	 */
	void calcTimeInBarrel() {
		Variables.timeInBarrel = Math.sqrt(Variables.displacement / (.5 * Variables.acceleration));
	}
	
	//***End muzzle velocity calculations***
	
	//***Start vector component calculations***
	
	/**
	 * Method that calculates the vector components of the muzzle velocity of the projectile
	 */
	void calcVectorComponents() {
		calcLaunchVerticalVelocity(); calcHorizontalVelocity();
	}
	
	/**
	 * Method that calculates the vertical launch velocity of the projectile in m/s
	 */
	void calcLaunchVerticalVelocity() {
		Variables.verticalLaunchVelocity = Variables.muzzleVelocity * Math.sin(Variables.angleOfLaunch);
	}
	
	/**
	 * Method that calculates the horizontal velocity of the projectile in m/s
	 */
	void calcHorizontalVelocity() {
		Variables.horizontalVelocity = Variables.muzzleVelocity * Math.cos(Variables.angleOfLaunch);
	}
	
	//***End vector component calculations***
	
	/**
	 * Method that calculates the muzzle energy of the projectile in Joules
	 */
	void calcMuzzleEnergy() {
		double mVSqrd = Math.pow(Variables.muzzleVelocity, 2);
		
		Variables.muzzleEnergy = .5 * Variables.mass * mVSqrd;
	}
	
	
	//*****END CALCULATION METHODS*****
	
	
	//*****START GETTERS*****
	
	
	/**
	 * @return the muzzleVelocity of the projectile in m/s
	 */
	public static double getMuzzleVelocity() {
		return Variables.muzzleVelocity;
	}

	/**
	 * @return the acceleration of the projectile in m/s^2
	 */
	public static double getAcceleration() {
		return Variables.acceleration;
	}

	/**
	 * @return the overall force acting on the projectile in Newtons
	 */
	public static double getForce() {
		return Variables.force;
	}

	/**
	 * @return the timeInBarrel that the projectile spends in seconds
	 */
	public static double getTimeInBarrel() {
		return Variables.timeInBarrel;
	}

	/**
	 * @return the verticalLaunchVelocity of the projectile in m/s
	 */
	public static double getVerticalLaunchVelocity() {
		return Variables.verticalLaunchVelocity;
	}

	/**
	 * @return the horizontalVelocity of the projectile in m/s
	 */
	public static double getHorizontalVelocity() {
		return Variables.horizontalVelocity;
	}

	/**
	 * @return the muzzleEnergy of the projectile in Joules
	 */
	public static double getMuzzleEnergy() {
		return Variables.muzzleEnergy;
	}
	
	
	//******END GETTERS*****
}
