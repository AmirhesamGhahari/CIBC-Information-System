package CIBC_Design;

import java.io.File;
import java.util.ArrayList;

public class TestFifth {

	public static void main(String[] args) {

		//testing endofday and endofmonth process methods:
		
		Client c1 = new Client(209, "AmirHesam");
		Client c2 = new Client(1112, "Rana");
		Client c3 = new Client(20984, "Mina");
		Client c4 = new Client(3, "Tina");
		Client c5 = new Client(329859, "Bob");
		Client c6 = new Client(435, "Rose");
		Client c7 = new Client(32, "Erika");
		Client c8 = new Client(48222, "Ross");
		
		CheckingAccount ch1 = new CheckingAccount(c1);
		CheckingAccount ch3 = new CheckingAccount(c3);
		CheckingAccount ch4 = new CheckingAccount(c4);
		CheckingAccount ch2 = new CheckingAccount(c2);
		CreditAccount cr6 = new CreditAccount(c6);
		
		ch1.setOverdraftOption(2);
		ch1.setOverdraftLimit(500);
		ch1.withdraw(100);
		ch2.deposit(400);
		ch2.withdraw(100);
		ch4.setOverdraftLimit(1000);
		ch4.setOverdraftOption(3);
		ch4.deposit(400);
		ch4.withdraw(100);
		
		ch3.setOverdraftOption(3);
		ch3.setOverdraftLimit(1000);
		ch3.withdraw(200);
		ch3.withdraw(200);
		ch3.withdraw(200);
		ch2.setOverdraftLimit(1000);
		ch2.setOverdraftOption(2);
			
		
		System.out.println(AccountActivity.ACTIVITY_LOG.size());
		
		AccountActivity.endOfDayProcess();
		System.out.println(ch3.getBalance());
		System.out.println(AccountActivity.ACTIVITY_LOG.size());
		System.out.println(ch4.getBalance());

		ch4.withdraw(500);

		AccountActivity.endOfDayProcess();
		System.out.println(ch3.getBalance());
		System.out.println(ch4.getBalance());
		
		ch4.terminateAccount();
		
		ArrayList<DemandLoanAccount> t1 = AccountActivity.endOfDayProcess();
		
		System.out.println(AccountActivity.ACTIVITY_LOG.size());
		System.out.println(t1.size());
		System.out.println(t1.get(0).getAmount());
		System.out.println(t1.get(0).getClient().getName());

		System.out.println(ch3.getBalance());
		
		System.out.println(ch1.getBalance());
		System.out.println(ch2.getBalance());
		System.out.println(ch4.getBalance());
		System.out.println(AccountActivity.ACTIVITY_LOG.size());

		AccountActivity.endOfMonthProcess();

		System.out.println(ch3.getBalance());

		System.out.println(ch1.getBalance());
		System.out.println(ch2.getBalance());
		System.out.println(ch4.getBalance());
		System.out.println(AccountActivity.ACTIVITY_LOG.size());
		
		
		AccountActivity.endOfDayProcess();
		
		System.out.println(ch3.getBalance());

		System.out.println(ch1.getBalance());
		System.out.println(ch2.getBalance());
		System.out.println(ch4.getBalance());
		
		AccountActivity.endOfMonthProcess();

		System.out.println(ch3.getBalance());

		System.out.println(ch1.getBalance());
		System.out.println(ch2.getBalance());
		System.out.println(ch4.getBalance());
		System.out.println(AccountActivity.ACTIVITY_LOG.size());
		
		//testing save and retrieve the activitylog
		
		AccountActivity.saveActivityLog();
		
		
		ArrayList<AccountActivity> ke = AccountActivity.retrieveActivityLog();
		System.out.println(ke.size());
		System.out.println(ke.get(0).getActivityType());
		System.out.println(ke.get(0).getAccount().getClient().getName());
		
		
		
	}

}
