package Controller;

public class Calculation {
	public double calculate(String mName,String tName,int qty) 
	{
		double price=0.0;
		if(mName.equals("Avater") && tName.equals("Inox") && qty<=180)
		{
			price=qty*249;
		}
		else if(mName.equals("Life of Pie") && tName.equals("Cinepolis") && qty<=150)
		{
			price=qty*349;
		}
		else if(mName.equals("Avatar") && tName.equals("PVR") && qty<=100)
		{
			price=qty*249;
		}
		else if(mName.equals("Avengers End Game") && tName.equals("City Pride") && qty<=150)
		{
			price=qty*199;
		}
		else if(mName.equals("Conjuring3") && tName.equals("Inox") && qty<=50)
		{
			price=qty*499;
		}
		else if(mName.equals("Anabella") && tName.equals("PVR") && qty<=100)
		{
			price=qty*249;
		}
		else
		{
			price=qty*211;
		}
		return price;
		
	}
}
