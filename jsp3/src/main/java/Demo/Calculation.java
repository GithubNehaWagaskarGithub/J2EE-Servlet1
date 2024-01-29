package Demo;

public class Calculation {
	public double calculate(double km,double wt,String type) 
	{
		double res=0.0;
		if(type.equals("mini"))
		{
			res=(km*20+wt*5)+(km*20+wt*5)*(18/100);
		}
		else if (type.equals("micro")) 
		{
			res=(km*20+wt*7)+(km*20+wt*7)*(18/100);
		}
		else {
			res=(km*20+wt*10)+(km*20+wt*10)*(18/100);
		}
		return res;
	}
}