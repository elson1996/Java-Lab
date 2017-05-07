import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Recorder {
	ArrayList<MissedCall> missedCallList;
	static Scanner inp = new Scanner(System.in);
	static HashMap<Integer,String> numberMap = new HashMap<Integer,String>();
	Recorder()	{
		System.out.println("Call Recording Machine");
		missedCallList = new ArrayList<MissedCall>();
	}
	static void loadNumbers()	{
		numberMap.put(123, "ASD");
		numberMap.put(456, "QWERTT");
		numberMap.put(789, "ZXC");
		numberMap.put(980, "FGH");
	}
	void recordMissedCall()	{
		if(MissedCall.callsExceedten())	{
			missedCallList.remove(0);
			MissedCall.numberOfCalls--;
		}
		System.out.println("\nEnter Caller Details: ");
		System.out.print("Origin Number: ");
		int telephoneNumber = inp.nextInt();
		if(numberMap.containsKey(telephoneNumber))
			missedCallList.add(new MissedCall(telephoneNumber,numberMap.get(telephoneNumber)));
		else
			missedCallList.add(new MissedCall(telephoneNumber));
		MissedCall.numberOfCalls++;
		System.out.println("Missed Call recorded\n\n");
	}
	
	void recallMissedCalls()	{
		System.out.println("Missed Call List:-");
		outsideLoop:
		for(int i = 0; i < missedCallList.size(); i++)	{
			System.out.println("\n" + (i+1) + ")" + missedCallList.get(i).telephoneNumber);
			innerLoop:
			while(true){
				System.out.println("\t1.Delete Call\n\t2.Next Missed Call\n\t3.View Details");
				System.out.print("\tChoice: ");
				switch(inp.nextInt())	{
				case 1:
					missedCallList.remove(i);
					System.out.println("Deleted");
					break innerLoop;
				case 2:
					continue outsideLoop;
				case 3:
					missedCallList.get(i).displayAllDetails();
					break;
				default:
					System.out.println("Wrong Choice");
				}
			}
			
		}
		System.out.println("End of Missed call log");
	}
	int findNumber(int telephoneNumber){
		for(int i = 0; i < missedCallList.size(); i++)	{
			if(missedCallList.get(i).telephoneNumber == telephoneNumber)
				return i;
		}
		return -1;
	}
	boolean deleteNumber(int index)	{
		if(index >= 0){
			missedCallList.remove(index);
			MissedCall.numberOfCalls--;
			return true;
		}
		return false;
	}
	public static void main(String[]args)	{
		loadNumbers();
		Recorder R1 = new Recorder();
		while(true)	{
			System.out.println("1.Add Missed Call\n2.View Missed Calls\n3.Delete Missed Call");
			System.out.print("Choice: ");
			switch(inp.nextInt())	{
			case 1:
				R1.recordMissedCall();
				break;
			case 2:
				R1.recallMissedCalls();
				break;
			case 3:
				System.out.print("Enter Number to delete: ");
				if(!R1.deleteNumber(R1.findNumber(inp.nextInt())))
					System.out.println("Number Not Found");
				break;
			case 4:
				return;
			default:
				System.out.println("Wrong choice");
				break;
			}
		}
	}
}
