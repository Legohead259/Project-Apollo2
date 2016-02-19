package calculators;

import util.QuadraticEquation;

public class FlightVariablesCalculator {
	static class Variables {
		/**
		 * The representational formula of the projectile's trajectory
		 */
		static String trajectoryFormula;
		
		/**
		 * The time the projectile is in flight in seconds
		 */
		static double timeOfFlight;
		
		/**
		 * The distance the projectile travels in meters
		 */
		static double distanceTravelled;
		
		/**
		 * The maximum height of the projectile's trajectory in meters
		 */
		static double maxHeight;
		
		/**
		 * The horizontal velocity of the projectile in m/s
		 */
		static double horizontalVelocity;
		
		/**
		 * The vertical velocity of the projectile at launch in m/s
		 */
		static double verticalLaunchVelocity;
		
		/**
		 * The angle at which the projectile is launched
		 */
		static double angleOfLaunch;
		
		/**
		 * Velocity of the projectile as it exits the barrel
		 */
		static double muzzleVelocity;
		
		/**
		 * Acceleration of the projectile due to gravity in m/s^2;
		 */
		static final double GRAVITY = 9.8;
	}
	
	HI
	
	//*****START CONSTRUCTOR*****
	
	
	/**
	 * Constructor for Apollo 2.0's flight variables calculator
	 * 
	 * @Precondition vLV must be in m/s, a must be in radians, and mV must be in m/s
	 * 
	 * @param vLV the vertical launch velocity of the projectile
	 * @param a the angle the projectile is launch at
	 * @param mV the muzzle velocity of the projectile
	 */
	public FlightVariablesCalculator(double vLV, double a, double mV) {
		Variables.verticalLaunchVelocity = vLV; Variables.angleOfLaunch = a; Variables.muzzleVelocity = mV;
	}
	
	
	//*****END CONSTRUCTOR*****
	
	
	//*****START CALCULATION METHODS*****
	
	
	/**
	 * Method that calculates all of the flight variables
	 */
	public void calcAll() {
		calcTrajectoryFormula(); calcMaxHeight(); calcTimeOfFlight(); calcDistanceTravelled();
	}
	
	/**
	 * Method that creates the formula for the projectile's trajectory
	 */
	void calcTrajectoryFormula() {
		Variables.trajectoryFormula = "-4.9x^2" + Variables.verticalLaunchVelocity + "x";
	}
	
	/**
	 * Method that calculates the projectile's maximum altitude
	 */
	void calcMaxHeight() {
		double numerator = Math.pow(Variables.verticalLaunchVelocity, 2);
		double denominator = 2 * Variables.GRAVITY;
		
		Variables.maxHeight = numerator / denominator;
	}
	
	/**
	 * Method that calculates the time that the projectile is in the air
	 */
	void calcTimeOfFlight() {
		double a = -.5 * Variables.GRAVITY;
		double b = Variables.verticalLaunchVelocity;
		
		QuadraticEquation qe = new QuadraticEquation(a, b, 0); qe.solveEquation();
		
		Variables.timeOfFlight = qe.solution;
	}
	
	/**
	 * Method that calculates how far the projectile travels
	 */
	void calcDistanceTravelled() {
		double numerator = Math.pow(Variables.muzzleVelocity, 2) * Math.sin(2 * Variables.angleOfLaunch);
		
		Variables.distanceTravelled = numerator / Variables.GRAVITY;
	}
	
	
	//*****END CALCULATION METHODS*****
	
	
	//*****START GETTERS*****
	
	
	/**
	 * @return the trajectoryFormula of the projectile 
	 */
	public static String getTrajectoryFormula() {
		return Variables.trajectoryFormula;
	}

	/**
	 * @return the timeOfFlight of the projectile in seconds
	 */
	public static double getTimeOfFlight() {
		return Variables.timeOfFlight;
	}

	/**
	 * @return the distanceTravelled in meters
	 */
	public static double getDistanceTravlled() {
		return Variables.distanceTravelled;
	}
	
	/**
	 * @return the maxHeight of the projectile's trajectory in meters
	 */
	public static double getMaxHeight() {
		return Variables.maxHeight;
	}
	
	
	//******END GETTERS*****
}
