package resultPackage;
import studentPackage.RegisterStudent;
import studentPackage.Subject;
public class SubjectGrades extends RegisterStudent{

	SubjectGrades() {
		super();
		registration();
		setSubjectGrades();
		// TODO Auto-generated constructor stub
	}
	void setSubjectGrades()	{
		System.out.println("\n\nEnter Marks of each subject: ");
		System.out.println("\nSubCode\tSubName\tSem\tCredits\tMarks");
		for(Subject S: subjectList)	{
			while(true) {
				System.out.print(S.subjectCode + "\t" + S.subjectName + "\t" +S.semester + "\t" + S.subjectCredits + "\t");
				try	{	
					S.subjectMarks = Integer.parseInt(inp.next());
					S.setGrade();
					break;
				}catch (NumberFormatException e)	{
					System.out.println("Invalid Marks please enter again : " + e);
				}
			}
		}
	}
}
