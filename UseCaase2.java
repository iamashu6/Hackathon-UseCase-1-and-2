package UseCase2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import org.json.simple.JSONObject;

public class UseCaase2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader(new File("C:\\Users\\Ashutosh Ranjan\\Downloads\\Battery.txt")));
		JSONObject obj=new JSONObject();
		DecimalFormat df=new DecimalFormat("0.000");
		String s;
	
		while((s=br.readLine())!=null)
		{
			if(s.isEmpty()||s.trim().equals("")||s.trim().equals("\n"))
			{
				continue;
			}
			else
			{
				 if(s.contains("Uid u0a202"))
				{
					String stt[]=s.split("\\s+");
				double batteryDrain=Double.parseDouble(stt[3]);
					
					double batteryPer=batteryDrain/1000;
				String d=df.format(batteryPer);
					
				 obj.put("Battery_percentage",d);
				 obj.put("Battery_drain",batteryDrain);
				}
				 else if(s.contains("Foreground"))
				{
					String st[]=s.split("\\s+");
					String da=st[3]+" "+st[4]+" "+st[5]+" "+st[6]+" "+st[7]+" "+st[8];
					 obj.put("Foreground_time",da);
				
				}

				
				
			
			}
		}
		 System.out.println(obj);
		FileWriter fw=new FileWriter("C:\\Users\\Ashutosh Ranjan\\Downloads\\BatteryOutput.json");
	fw.write(obj.toJSONString());
	fw.close();
	}

}
