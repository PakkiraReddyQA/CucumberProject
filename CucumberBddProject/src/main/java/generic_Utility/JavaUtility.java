package generic_Utility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method will print random numbers
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r=new Random();
		int value = r.nextInt();
		return value;
		
	}
	public String getSystemDate()
	{
		 Date d = new Date();
		 String value = d.toString();
		 return value;
	}
	public String getSystemDateformat()
	{
		Date d = new Date();
		String darr[]=d.toString().split(" ");
		String date = darr[2];
		String month = darr[1];
		String year = darr[5];
		String time = darr[3].replace(":", "-");
		String dateFormat=date+"_"+month+" "+year+" "+time;
		return dateFormat;
		
	}

}
