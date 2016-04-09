import java.util.Scanner;

public class Bank2
{
	public static void main(String[] args)
	{
		Customer2 customer = new Customer2();
		Scanner s = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("1. 계좌개설    2. 입금    3. 출금    4. 계좌이체    5. 계좌 확인   6. 거래내역");
			System.out.print("선택 -> " );
			int choice = s.nextInt();
			
			switch (choice)
			{
			case 1:
				customer.makeAccount();
				break;
				
			case 2:
				customer.depositAccount();
				break;
				
			case 3:
				customer.withdrawAccount();
				break;
				
			case 4:
				customer.transportAccount();
				break;
				
			case 5:
				customer.printAccount();
				break;
				
			case 6:
				customer.transactionalAccount();
				break;
				
			default:
				System.out.println("Input menu number");
				break;
			} // end switch
		} // end while
	}// end main method
}// end Bank.java

class Account2
{
	private int account_number;
	private int money;
	private String transactional_type;
	private int account1, account2, trans_money;
	
	public Account2(int account_number, int money)
	{
		this.account_number = account_number;
		this.money = money;
	}
	
	public Account2(String transactional_type, int account1, int account2, int trans_money)
	{
		this.transactional_type = transactional_type;
		this.account1 = account1;
		this.account2 = account2;
		this.trans_money = trans_money;
	}
	
	public int getAccountNumber() { return account_number; }
	public int getMoney() { return money; }
	public String getTransactional() { return transactional_type; }
	public int getAccount1(){ return account1; }
	public int getAccount2(){ return account2; }
	public int getTransMoney(){ return trans_money; }
	
	public void setMoney(int money) { this.money = money; }
}

class Customer2
{
	private Account2[] customer = new Account2[100];
	private Account2[] transactional_list = new Account2[100];
	private Scanner s = new Scanner(System.in);
	private int count = 0;
	private int count2 = 0;
	private int transactional_num;
	
	public Customer2() { }
	public void makeAccount()
	{
		System.out.println(count + "번째 계좌번호가 개설 되었습니다.");
		customer[count] = new Account2(count, 0);
		count++;
	}// end makeAccount method
	
	public void depositAccount()
	{
		System.out.print("입금할 계좌 : ");
		int deposit_account = s.nextInt();
		
		if( !findAccount(deposit_account) )
		{
			System.out.println("존재하지 않는 계좌입니다.");
		}
		
		else
		{
			System.out.print("입금액 : ");
			int deposit_money = s.nextInt();
			
			customer[deposit_account].setMoney(customer[deposit_account].getMoney() + deposit_money);
			System.out.println(deposit_account + "의 현재 금액 : " + customer[deposit_account].getMoney());
			transactional_list[count2++] = new Account2("입금", deposit_account, 0, deposit_money);
		}		
	}// end depositAccount method
	
	public void withdrawAccount()
	{
		System.out.print("출금할 계좌 : ");
		int withdraw_account = s.nextInt();
		
		if( !findAccount(withdraw_account) )
		{
			System.out.println("존재하지 않는 계좌입니다.");
		}
		
		else
		{
			System.out.print("출금액 : ");
			int withdraw_money = s.nextInt();
			
			customer[withdraw_account].setMoney(customer[withdraw_account].getMoney() - withdraw_money);
			System.out.println(withdraw_account + "의 현재 금액 : " + customer[withdraw_account].getMoney());
			transactional_list[count2++] = new Account2("출금", withdraw_account, 0, withdraw_money);
		}
	}// end withdrawAccount method
	
	public void transportAccount()
	{
		System.out.println("계좌 이체를 합니다.");
		System.out.print("이체 할 계좌번호 : ");
		int out_account = s.nextInt();
		
		if( !findAccount(out_account) )
		{
			System.out.println("존재하지 않는 계좌입니다.");
			return;
		}
		
		System.out.print("이체 받을 계좌번호 : ");
		int in_account = s.nextInt();
		
		if( !findAccount(in_account) )
		{
			System.out.println("존재하지 않는 계좌입니다.");
			return;
		}
		
		System.out.print("이체 금액 : ");
		int trans_money = s.nextInt();
		
		customer[out_account].setMoney(customer[out_account].getMoney() - trans_money);
		customer[in_account].setMoney(customer[in_account].getMoney() + trans_money);
		transactional_list[count2++] = new Account2("계좌이체", out_account, in_account, trans_money);
	}// end transportAccount method
	
	public void printAccount()
	{
		for (int i = 0; i < count; i++)
		{
			System.out.println("계좌번호 : " + customer[i].getAccountNumber());
			System.out.println("현재금액 : " + customer[i].getMoney());
			System.out.println();
		}
	}// end printAccount method
	
	public void transactionalAccount()
	{
		for (int i = 0; i < count2; i++) 
		{
			System.out.println((i+1) + "번째 거래내역");
			if( transactional_list[i].getTransactional().equals("입금"))
			{
				System.out.println("거래 유형 : " + transactional_list[i].getTransactional() );
				System.out.println("입금계좌 : " + transactional_list[i].getAccount1());
				System.out.println("입금액 : " + transactional_list[i].getTransMoney());
				System.out.println();
			}
			
			else if( transactional_list[i].getTransactional().equals("출금"))
			{
				System.out.println("거래 유형 : " + transactional_list[i].getTransactional() );
				System.out.println("출금계좌 : " + transactional_list[i].getAccount1());
				System.out.println("출금액 : " + transactional_list[i].getTransMoney());
				System.out.println();
			}
			
			else if( transactional_list[i].getTransactional().equals("계좌이체"))
			{
				System.out.println("거래 유형 : " + transactional_list[i].getTransactional() );
				System.out.println("출금계좌 : " + transactional_list[i].getAccount1());
				System.out.println("입금계좌 : " + transactional_list[i].getAccount2());
				System.out.println("이체금액 : " + transactional_list[i].getTransMoney());
				System.out.println();
			}
		} // end for
	}// end transactionalAccount method
	
	public boolean findAccount(int i_accountNumber)
	{
		for (int i = 0; i < count; i++)
		{
			if( customer[i].getAccountNumber() == i_accountNumber)
			{
				return true;
			}
		}
		return false;
	}// end findAccount method
}// end Bank2.java
