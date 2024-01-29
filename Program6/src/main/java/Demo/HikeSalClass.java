package Demo;

public class HikeSalClass {

	public double hikeSal(String desig,double sal)
	{
		if(desig.equals("dev"))
		{
			sal=sal+sal*0.3;
		}
		else 
		{
			sal=sal+sal*0.2;
		}
		return sal;
	}
}
