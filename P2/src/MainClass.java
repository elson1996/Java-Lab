import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inp = new Scanner(System.in);
		double tempSize;
		char tempGender;
		int ch;
		while(true)	{
			System.out.println("\n\n1.Formal Shirt\n2.Pull Over\n3.Party Wear\n4.Exit");
			ch = inp.nextInt();
			switch(ch)	{
			case 1:
				//Creating formal shirt object
				System.out.println("Formal Shirt:-");
				System.out.println("Enter Size & gender: ");
				tempSize = inp.nextDouble();
				tempGender = inp.next().charAt(0);
				FormalShirt FS = new FormalShirt(tempSize, tempGender);
				FS.getColor();
				FS.putColor();
				FS.putGender();
				FS.putSize();
				break;
			case 2:
				//Creating pull over object
				System.out.println("\n\nPull Over:- ");
				System.out.println("Enter Size: ");
				tempSize = inp.nextDouble();
				PullOver PO = new PullOver(tempSize);
				PO.getColor();
				PO.putColor();
				PO.putSize();
				PO.putGender();
				break;
			case 3:
				//Creating party wear object
				System.out.println("\n\nParty Wear:- ");
				System.out.println("Enter Size & gender: ");
				tempSize = inp.nextDouble();
				tempGender = inp.next().charAt(0);
				PartyWear PW = new PartyWear(tempSize,tempGender);
				PW.getColor();
				PW.putColor();
				PW.putSize();
				PW.putGender();
				break;
			case 4:
				inp.close(); //Closing Scanner
				return;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
	}

}
