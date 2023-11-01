package ecom.genericUtilities;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
public class JavaUtility 
{
		Random r=new Random();
		Date dr = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		public int getRandomNumber()
		{
			int n=r.nextInt(100);
			return n;
		}
		
		public String getDate()
		{
			String rdata=sim.format(dr);
			return rdata;
		}
		
		public String getDate(int reqcount)
		{
			Calendar cal=Calendar.getInstance();
			cal.add(Calendar.DATE, reqcount);
			Date d=cal.getTime();
			String rdata=sim.format(d);
			return rdata;
		}
}
