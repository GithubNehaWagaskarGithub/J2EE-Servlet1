package Demo;


public class Validation {

	public boolean validate(String name,String pass)
	{
		if(name.equals("Neha")&& pass.equals("Neha@123"))
		{
			return true;
		}
		return false;
	}
}
