package studentPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterStudent implements Student{

	protected String studentName;
	protected String studentBranch;
	public static Scanner inp = new Scanner(System.in);
	protected ArrayList<Subject> subjectList = new ArrayList<Subject>();
	protected ArrayList<Integer> totalCreditsRegistered = new ArrayList<Integer>();
	protected int totalSemestersRegistered;
	public RegisterStudent()	{
		studentName = "";
		studentBranch = "";
		totalSemestersRegistered = 0;
		for(int i = 0; i < 8; i++)	{
			totalCreditsRegistered.add(0);
		}
	}
	@Override
	public void getStudentName() {
		// TODO Auto-generated method stub
		System.out.print("Enter Student Name: ");
		studentName = inp.next();
	}

	@Override
	public void getStudentBranch() {
		// TODO Auto-generated method stub
		System.out.print("Enter Student's branch: ");
		studentBranch = inp.next();
	}
	protected void registration()	{
		getStudentName();
		getStudentBranch();
		int tempSem;
		while(true)	{
			System.out.print("Enter Semester : ");
			tempSem = inp.nextInt();
			totalSemestersRegistered++;
			System.out.println("Enter Details of subjects of semester: " + tempSem);
			String tempSubName,tempSubCode;
			int tempSubCredit;
			try	{
				while(true)	{
					System.out.print("\nEnter Subject code: ");
					tempSubCode = inp.next();
					System.out.print("Enter Name of " + tempSubCode +": ");
					tempSubName = inp.next();
					System.out.print("Enter Credits for " +tempSubName+ ": ");
					tempSubCredit = inp.nextInt();
					if(totalCreditsRegistered.get(tempSem-1) + tempSubCredit > 30){
						throw new CreditLimit(""+ (totalCreditsRegistered.get(tempSem-1) + tempSubCredit) );
					}
					totalCreditsRegistered.set(tempSem-1,totalCreditsRegistered.get(tempSem-1) + tempSubCredit) ;
					subjectList.add(new Subject(tempSubName,tempSubCredit,tempSubCode,tempSem));
					System.out.print("\nEnter 1 to insert another subject 0 to end semester: ");
					if(inp.nextInt() == 0)	{
						break;
					}
				}
			}catch(CreditLimit e)	{
				System.out.println("Credit limit exceeded ("+e+")");
			}finally	{
				System.out.println("\nTotal Credits Registered for semester "+ tempSem + " : " + totalCreditsRegistered.get(tempSem-1));
				System.out.print("Enter 1 to insert another semester 0 to finish: ");
				if(inp.nextInt() == 0)	{
					break;
				}
			}
		}
		System.out.println("Successfully Registered for " + totalSemestersRegistered + "Semester(s)");	
	}
}

class CreditLimit extends Exception
{
	CreditLimit(String s)	{
		super(s);
	}
	
}
