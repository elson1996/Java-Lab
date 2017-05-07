import java.util.Scanner;

public class Bank extends Account{
	static Scanner inp = new Scanner(System.in);
	static Account temp = null;
	private static void newAccount()	{
		
		System.out.println("\n\nEnter the following details");
		temp = new Account();
		if(!temp.getInformation())	{
			System.out.println("Account number already exists");
			return;
		}
		ACS[NumberOfAccounts] = temp;
		NumberOfAccounts++;
	}
	private static void existingAccount()	{
		System.out.print("\n\nEnter the Account Number: ");
		int AccNum = inp.nextInt();
		Account currentAccount = new Account();
		currentAccount = SearchAccountNumber(AccNum);
		if(currentAccount == null)	{
			System.out.println("Account Not Found");
			return;
		}
		currentAccount.welcomeMessage();
		outside:
		while(true)	{
			System.out.println("\n\n1.Deposit\n2.Withdraw\n3.Transfer\n4.Display Details\n5.Return to main menu");
			int chs = inp.nextInt();
			boolean status = false;
			switch(chs)	{
			case 1:
				status = currentAccount.deposit();
				break;
			case 2:
				status = currentAccount.withdraw();
				break;
			case 3:
				System.out.print("\nEnter Account number to transfer to: ");
				int transferAccount = inp.nextInt();
				Account transferAcc = SearchAccountNumber(transferAccount);
				if(transferAcc == null)	{
					System.out.println("Account Not Found");
					break;
				}
				if(transferAcc == currentAccount) 	{
					System.out.println("Can not transfer to your own account");
					break;
				}
				status = transferAcc.transferTo(currentAccount.transferFrom());
				break;
			case 4:
				currentAccount.showDetails();
				status = true;
				break;
			case 5:
				break outside;
			default:
				System.out.println("Invalid Choice");
			}
			if(status && chs <= 3)
				System.out.println("Transaction Successful");
			else if(!status && chs <= 3)
				System.out.println("Transaction Failure");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ch;
		while (true)	{
			System.out.println("\n\n1. Add New Account\n2. Existing Account\n3. Exit");
			System.out.print("Enter Choice: ");
			ch = inp.nextInt();
			switch(ch)	{
			case 1:
				newAccount();
				break;
			case 2:
				existingAccount();
				break;
			case 3:
				inp.close();
				return;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

}
