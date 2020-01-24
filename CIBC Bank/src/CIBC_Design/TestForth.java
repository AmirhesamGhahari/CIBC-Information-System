package CIBC_Design;

public class TestForth {

	
	
	public static void main(String[] args) {
		
		Client c1 = new Client(209, "AmirHesam");
		Client c2 = new Client(1112, "Rana");
		Client c3 = new Client(20984, "Mina");
		Client c4 = new Client(3, "Tina");
		Client c5 = new Client(329859, "Bob");
		Client c6 = new Client(435, "Rose");
		Client c7 = new Client(32, "Erika");
		Client c8 = new Client(48222, "Ross");
		
		CheckingAccount ca1 = new CheckingAccount(c1);
		CreditAccount cr1 = new CreditAccount(c2);
		CheckingAccount ca2 = new CheckingAccount(c3);
		CreditAccount cr2 = new CreditAccount(c4);
		CheckingAccount ca3 = new CheckingAccount(c5);
		CreditAccount cr3 = new CreditAccount(c6);
		CheckingAccount ca4 = new CheckingAccount(c7);
		CreditAccount cr4 = new CreditAccount(c8);
		
		ca1.deposit(400);
		cr1.withdraw(50);
		ca2.deposit(500);
		ca2.transfer(cr2, 200);
		ca2.setOverdraftLimit(1000);
		ca1.suspend();
		ca1.reactivate();
		ca2.cancelAccount();
		cr2.deposit(200);
		ca3.setOverdraftOption(3);
		cr3.setCreditLimit(1000);
		ca4.deposit(100);
		cr4.getBalance();
		
		
		// testing the sorting of activityLog
		
		
		System.out.println(AccountActivity.ACTIVITY_LOG.size());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(0).getAccount().getClient().getSIN());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(0).getAccount().getClient().getName());

		
		AccountActivity.sortActivityLog();
		
		System.out.println(AccountActivity.ACTIVITY_LOG.size());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(0).getAccount().getClient().getSIN());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(0).getAccount().getClient().getName());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(0).getActivityType());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(0).getTime());


		System.out.println(AccountActivity.ACTIVITY_LOG.get(1).getAccount().getClient().getSIN());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(1).getActivityType());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(1).getTime());
		
		System.out.println(AccountActivity.ACTIVITY_LOG.get(2).getAccount().getClient().getSIN());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(2).getActivityType());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(2).getTime());
		
		
		System.out.println(AccountActivity.ACTIVITY_LOG.get(4).getAccount().getClient().getSIN());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(4).getActivityType());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(4).getTime());
		
		System.out.println(AccountActivity.ACTIVITY_LOG.get(22).getAccount().getClient().getSIN());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(22).getActivityType());
		System.out.println(AccountActivity.ACTIVITY_LOG.get(22).getTime());
		
		
		System.out.println(AccountActivity.ACTIVITY_LOG.size());





	}
}
