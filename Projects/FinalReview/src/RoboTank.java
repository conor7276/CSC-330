
public class RoboTank extends Robot {

	private double treadLength;
	private double minSensorDistance;
	private boolean hasSensor;
	
	public RoboTank() {
		//DO NOT NEED TO TYPE SUPER()
		setTreadLength(0);
		setHasSensor(false);
		setMinSensorDistance(1);
	}
	
	public RoboTank(double m, double s, double tl, boolean hs, double msd) {
		//call the parent constructor to initialize those variables
		super(m, s);  
		setTreadLength(tl);
		setHasSensor(hs);
		setMinSensorDistance(msd);		
	}

	/**
	 * @return the treadLength
	 */
	public double getTreadLength() {
		return treadLength;
	}

	/**
	 * @param treadLength the treadLength to set
	 */
	public void setTreadLength(double treadLength) {
		this.treadLength = treadLength;
	}

	/**
	 * @return the minSensorDistance
	 */
	public double getMinSensorDistance() {
		return minSensorDistance;
	}

	/**
	 * @param minSensorDistance the minSensorDistance to set
	 */
	public void setMinSensorDistance(double minSensorDistance) {
		this.minSensorDistance = minSensorDistance;
	}

	/**
	 * @return the hasSensor
	 */
	public boolean isHasSensor() {
		return hasSensor;
	}

	/**
	 * @param hasSensor the hasSensor to set
	 */
	public void setHasSensor(boolean hasSensor) {
		this.hasSensor = hasSensor;
	}
	
	public boolean senseSomething(double distance) {
		return (hasSensor && distance <= minSensorDistance);
		
		//if (hasSensor && distance <= minSensorDistance) return true;
		//else return false;
	}
	
}