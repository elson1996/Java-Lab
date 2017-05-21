
public class PartyWear extends PullOver{

	char gender;
	PartyWear(double s, char g) {
		super(s);
		gender = g;
	}
	
	@Override
	void putGender()	{
		System.out.println("Gender : " + gender);
	}

}
