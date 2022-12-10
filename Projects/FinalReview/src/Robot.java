
public class Robot {

	private double speed;
	private double mass;
	
	public Robot() {
		setMass(0);
		setSpeed(0);
	}
	
	public Robot(double m, double s) {
		setMass(m);
		setSpeed(s);
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}
	
}