package studentPackage;

public class Subject {
	public int subjectCredits;
	public String subjectName;
	public String subjectCode;
	public char subjectGrade;
	public int subjectMarks;
	public int semester;
	Subject(String SN, int SC, String SCD, int sem)	{
		subjectName = SN;
		subjectCredits = SC;
		subjectCode = SCD;
		subjectGrade = 'Z';
		semester = sem;
		subjectMarks = 0;
	}
	public void setGrade()	{
		if(subjectMarks <= 100 && subjectMarks >= 90 )
			subjectGrade = 'S';
		else if(subjectMarks < 90 && subjectMarks >= 75 )
			subjectGrade = 'A';
		else if(subjectMarks < 75 && subjectMarks >= 60 )
			subjectGrade = 'B';
		else if(subjectMarks < 60 && subjectMarks >= 50)
			subjectGrade = 'C';
		else if(subjectMarks < 50 && subjectMarks >= 40)
			subjectGrade = 'D';
		else if(subjectMarks < 40)
			subjectGrade = 'F';
	}
}
