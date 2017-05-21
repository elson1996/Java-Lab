import java.util.Scanner;

public final class FormalShirt extends Color{
	String color;
	double size;
	char gender;
	static Scanner inp = new Scanner(System.in);
	
	FormalShirt(double s, char g)	{
		size = s;
		gender = g;
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
		System.out.println("Color of Formal Shirt is : " + color);
	}
	void putSize()	{
		System.out.println("Size of formal Shirt: " + size);
	}
	void putGender()	{
		System.out.println("Gender: " + gender);
	}
}
