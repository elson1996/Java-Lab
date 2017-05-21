import java.util.Scanner;

public class PullOver extends Color{
	String color;
	double size;
	static Scanner inp = new Scanner(System.in);
	
	PullOver(double s)	{
		size = s;
	}
	
	@Override
	void getColor() {
		// TODO Auto-generated method stub
		System.out.println("Enter the color: ");
		color = inp.next();
	}

	@Override
	void putColor() {
		// TODO Auto-generated method stub
		System.out.println("Color of Pull Over is : " + color);
	}
	void putSize()	{
		System.out.println("Size of Pull over is : "  + size);
	}
	void putGender()	{
		System.out.println("For men and women");
	}
}
