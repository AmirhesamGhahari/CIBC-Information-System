package CIBC_Design;

import java.io.Serializable;
import java.util.Random;

/**
 * @author ahesam.gh
 *
 *the abstract class Account having the similar methods and variables of credit and checking accounts.
 */
public abstract class Account implements Serializable {
	
	/**
	 * client owner of this account
	 */
	protected Client owner;
	/**
	 * boolean variable determining if the account is suspended or not.
	 */
	protected boolean isSuspended;
	/**
	 * the account number of this account
	 */
	protected int accountNumber;
	/**
	 * the total balance of this account
	 */
	protected double balance;
	
	
	
	
	/**
	 * @param o1 class constructor with a client object argument
	 */
	public Account(Client o1)
	{
		this.owner = o1;
		this.createAccount();
		
	}
	
	
	/**
	 * @param ac1 account which is going to be copied.
	 * 
	 * copy constructor which is only used by the accountactivity class to copy an object of class account to
	 * keep its object for holding it in the activitylog sequence.
	 * therefore it does not make an accountactivity object.
	 */
	public Account(Account ac1)
	{
		this.owner = ac1.owner;
		this.isSuspended = ac1.isSuspended;
		this.accountNumber = ac1.accountNumber;
		this.balance = ac1.balance;
		
	}
	
	
	
	
	/**
	 * private method helping to initiate the fields of an object of class account.
	 */
	private final void createAccount()
	{
		Random rand = new Random();
		int n1 = rand.nextInt(90000000) + 10000000;
		this.accountNumber = n1;
		
		isSuspended = false;
		balance = 0;
		
		
	}
	/**
	 * method to turn this account suspended.
	 */
	public void suspend()
	{
		this.isSuspended = true;
		new AccountActivity(this, 5, this.balance);
	}
	/**
	 * method to reactivate a suspended account
	 */
	public void reactivate()
	{
		this.isSuspended = false;
		new AccountActivity(this, 6, this.balance);
	}
	/**
	 * @param amount that is going to be deposited into account
	 * 
	 * deposit the custom amount into account
	 */
	public void deposit(double amount)
	{
		if( amount <= 0)
		{
			throw new IllegalArgumentException("you cant deposit negative amount");
		}
		this.balance += amount;
		new AccountActivity(this, 2, amount, this.balance);
	}
	/**
	 * @return the balance of account
	 * 
	 */
	public double getBalance()
	{
		new AccountActivity(this, 7, this.balance);
		
		return this.balance;
		
	}
	/**
	 * @return an object of class DemandLoanAccount having the info about the debt or credit of a client 
	 * after termination of its account.
	 * 
	 * terminate an account and return the balance as an object of DemandLoanAccount.
	 */
	public DemandLoanAccount terminateAccount()
	{
		DemandLoanAccount dla1 = new DemandLoanAccount(this.owner, this.balance);
		new AccountActivity(this, 8, dla1, this.balance);
		return dla1;
	}
	/**
	 * @return an object of class DemandLoanAccount having the info about the debt or credit of a client 
	 * after cancelation of its account.
	 * 
	 * cancel an account and return the balance as an object of DemandLoanAccount.
	 */
	public DemandLoanAccount cancelAccount()
	{
		DemandLoanAccount dla1 = new DemandLoanAccount(this.owner, this.balance);
		new AccountActivity(this, 4, dla1, this.balance);
		return dla1;
		
	}
	/**
	 * used for endofmonthprocess method of account activity
	 * it does not produce an accountactivity object
	 * 
	 * @return the balance of this account
	 */
	public double getBalanceForProcess()
	{
		return this.balance;
	}
	
	
	
	
	/**
	 * @return the the account number
	 */
	public int getAccountNumber()
	{
		return this.accountNumber;
	}
	/**
	 * @return the client who is owner of this account
	 */
	public Client getClient()
	{
		return this.owner;
	}
	/**
	 * @return a boolean variable indicating if this account is suspended or not.
	 */
	public boolean isAccountSuspended()
	{
		return isSuspended;
	}
	
	/**
	 * set the balance of this account to zero.
	 * used for termination and cancellation activities of an account
	 */
	public void zeroBalance()
	{
		this.balance = 0;
	}

	
	
	/**
	 * @param amount that will be deposited.
	 * 
	 * abstract method for depositing custom amount into account.
	 */
	public abstract void withdraw(double amount);
	/**
	 * @return the type of account
	 * abstract method returning the type of an account
	 */
	public abstract String getAccountType();
	/**
	 * @param account1 account that money will be transfered to.
	 * @param amount that will be transfered.
	 * 
	 * abstract method responsible for transferring a custom amount from this account to a destination account
	 */
	public abstract void transfer(Account account1, double amount);
	

	

}