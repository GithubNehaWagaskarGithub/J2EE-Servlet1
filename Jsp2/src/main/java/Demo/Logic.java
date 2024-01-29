package Demo;

public class Logic {
 
	public double logic(int qty,double price,String category) 
	{
		double res=0.0;
		if(category.equals("veg"))
		{
			res=(qty*price)+(qty*price)*10/100;
		}
		else
		{
			res=(qty*price)+(qty*price)*5/100;
		}
		return res;
	}
}
