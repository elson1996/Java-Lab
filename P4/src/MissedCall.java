import java.util.Date;

public class MissedCall {
	int telephoneNumber;
	Date callDate;
	String nameOfCaller;
	public static int numberOfCalls = 0;
	MissedCall(int telephoneNumber, String nameOfCaller)	{
		this.telephoneNumber = telephoneNumber;
		this.nameOfCaller = nameOfCaller;
		callDate = new Date();
	}
	MissedCall(int telephoneNumber)	{
		this.telephoneNumber = telephoneNumber;
		this.nameOfCaller = "Private caller";
		callDate = new Date();
	}
	public static boolean callsExceedten()	{
		return (numberOfCalls >= 10)?true:false;
	}
	void displayAllDetails()	{
		System.out.println("Name of caller: " + nameOfCaller);
		System.out.println("Number: " + telephoneNumber);
		System.out.println("Time Of call: " +callDate);
	}
	protected void finalize()	{
		System.out.println(telephoneNumber + "Deleted");
	}
}
