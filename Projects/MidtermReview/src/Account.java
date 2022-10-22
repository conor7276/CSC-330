
public class Account implements Lockable {

	private int accountNumber;
	private double balance;
	private String name;
	private int key;    //key for unlocking or locking.
	private boolean isLocked;
	
	private final double interestRate = .035;
	
	public Account(int an, double b, String n) {
		accountNumber = an;
		balance = b;
		name = n;
		isLocked = true;    //just me...no points lost if forgotten.
		key = -9999999;
	}
	
	//Before I get to the two methods, we need to define the methods
	//from Lockable
	public void setKey(int key) {
		//set something equal to something???
		this.key = key;
	}
	
	public void lock(int key) {
		if (this.key == key) {
			isLocked = true;
		}
	}
	
	public void unlock(int key) {
		if (this.key == key) {
			isLocked = false;
		}
	}
	
	public boolean locked() {
		return isLocked;
	}
	
	/**
	 * Deposits the specified amount into the account. Returns the new 
	 * balance.
	 * @param amount the amount to be deposited (assume it is positive)
	 * @return the new balance
	 */
	public double deposit(double amount) {
		//We need to check if the object is locked!
		if (locked()) {
			System.out.println("Sorry.  The object is locked and cannot be altered.");
			return -1;
		} else {
			balance += amount;
			return balance;
		}
			
	}

	/**
	 * Withdraws the specified amount from the account. Returns the new 
	 * balance.  If the new balance is negative, it must be set to zero, and a 
	 * message must be printed about the new balance.
	 * @param amount the amount to be withdrawn
	 * @return the new balance
	 */
	public double withdraw(double amount) {
		if (locked()) {
			System.out.println("Sorry.  The object is locked and cannot be altered.");
			return -1;
		} else {
			balance -= amount;
			return balance;
		}
	}

	/**
	 * Adds interest to the account and returns the new balance
	 * @return the new balance with added interest
	 */
	public double addInterest() {
		if (locked()) {
			System.out.println("Sorry.  The object is locked and cannot be altered.");
			return -1;
		} else {
			balance += (balance * interestRate);
			return balance;
		}
	}

	
}
