import java.io.IOException;
import java.util.Scanner;

public class Process {
	private static Scanner sc;

	public static void main(String[] args) throws IOException{
		sc = new Scanner(System.in);
		System.out.println("1.Stock\n2.Customer\n3.Exit");
		System.out.println("Enter your choice: ");
		int a,b;
		a = sc.nextInt();
		while(a!=3){
			switch(a){
				case 1:
					System.out.println("1.Update the existing stock\n2.Delete the stock\n3.Insert new stock\n4.show current status\n5.show progress of particular share");
					b = sc.nextInt();
					Stock st = new Stock();
					if(b==1){
						System.out.println("Please enter the name of the share that you want to update.");
						String s = sc.next();
						System.out.println("enter the new prize of the share.");
						String p = sc.next();
						st.update(s, p);
					}
					else if(b==2){
						System.out.println("Please enter the name of the share that you want to delete.");
						String s = sc.next();
						st.delete(s);
					}
					else if(b==3){
						System.out.println("Please enter the name of the new share.");
						String s = sc.next();
						System.out.println("enter the prize of share.");
						float p = sc.nextFloat();
						st.insert(s,p);
					}
					else if(b==4){
						st.currentstatus();
					}
					else if(b==5){
						System.out.println("Please enter the name of the share.");
						String s = sc.next();
						st.showprogress(s);
					}
					break;
				case 2:
					System.out.println("1.Create account\n2.Buy the stock\n3.Sell the stock\n4.Add money\n5.Take out money\n6.Show customer's current account detail");
					b = sc.nextInt();
					customer ct = new customer();
						if(b==1){
							System.out.println("Enter the name of the customer.");
							String name = sc.next();
							System.out.println("Enter the balance of the customer.");
							float balance = sc.nextFloat();
							ct.createaccount(name,balance);
						}
						else if(b==2){
							System.out.println("Enter the name of the customer.");
							String name = sc.next();
							System.out.println("Enter the name of the stock that customer want to buy.");
							String s = sc.next();
							System.out.println("Enter the number of stocks that customer want to buy.");
							int x = sc.nextInt();
							ct.buy(name, s, x);
						}
						else if(b==3){
							System.out.println("Enter the name of the customer.");
							String name = sc.next();
							System.out.println("Enter the name of the stock that customer want to sell.");
							String s = sc.next();
							System.out.println("Enter the number of stocks that customer want to sell.");
							int x = sc.nextInt();
							ct.buy(name, s, (-1)*x);
						}
						else if(b==4){
							System.out.println("Enter the name of the customer.");
							String name = sc.next();
							System.out.println("Enter the amount that you want to add.");
							float amount = sc.nextFloat();
							ct.addmoney(name, amount);
						}
						else if(b==5){
							System.out.println("Enter the name of the customer.");
							String name = sc.next();
							System.out.println("Enter the amount that you want to take out from your account.");
							float amount = sc.nextFloat();
							ct.addmoney(name, (-1)*amount);
						}
						else if(b==6){
							System.out.println("Enter the name of the customer.");
							String name = sc.next();
							ct.myaccount(name);
						}
					break;
				default: System.out.println("Please enter the right choice: ");
			}
			System.out.println("\n1.Stock\n2.Customer\n3.Exit");
			System.out.println("Enter your choice: ");
			a = sc.nextInt();
		}
		System.out.println("Thanks for using this application!");
	}
}
