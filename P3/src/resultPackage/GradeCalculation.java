package resultPackage;

import java.util.ArrayList;
import java.util.HashMap;

import studentPackage.Subject;

public class GradeCalculation extends SubjectGrades{
	
	static HashMap<Character, Integer> gradeTranslation = new HashMap<Character, Integer>();
	ArrayList<Double> SGPA = new ArrayList<Double>();
	double CGPA;
	GradeCalculation()	{
		super();
		gradeTranslation.put('S', 10);
		gradeTranslation.put('A', 9);
		gradeTranslation.put('B', 8);
		gradeTranslation.put('C', 7);
		gradeTranslation.put('D', 6);
		gradeTranslation.put('E', 5);
		gradeTranslation.put('F', 4);
		for(int i = 0; i < 8; i++)
			SGPA.add(0.0);
		CGPA = 0.0;
	}
	
	public void calculateSGPA()	{
		for(Subject S: subjectList)	
			SGPA.set(S.semester-1, SGPA.get(S.semester-1) + (gradeTranslation.get(S.subjectGrade) * S.subjectCredits));
		for(int i = 0; i < 8; i++)	{
			if(SGPA.get(i) != 0 && totalCreditsRegistered.get(i) != 0)
				SGPA.set(i, SGPA.get(i)/totalCreditsRegistered.get(i));
		}
	}
	public void calculateCGPA()	{
		for(Double SG: SGPA){
			if(SG != 0)
				CGPA += SG;
		}
		try	{
			CGPA /= totalSemestersRegistered;
			if(CGPA > 10)	
				throw new InvalidCGPA("" + CGPA);
		}catch(InvalidCGPA e)	{
			System.out.println("CGPA " + e + " is invalid");
		}
	}
}

class InvalidCGPA extends Exception	{
	InvalidCGPA(String s)	{
		super(s);
	}
}