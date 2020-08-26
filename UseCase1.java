package UseCase1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.json.simple.JSONObject;

public class UseCase1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new FileReader(new File("C:\\Users\\Ashutosh Ranjan\\Downloads\\Memory.txt")));
		DecimalFormat df=new DecimalFormat("#.00");
		List<Double>list=new ArrayList<Double>();
		JSONObject obj1=new JSONObject();
		double sum=0.0;
		
		String s;
		int count=1,i=0;
		while((s=br.readLine())!=null)
		{
			if(s.isEmpty()||s.trim().equals("")||s.trim().equals("\n"))
			{
				continue;
			}
			else
			{
				if(count%2!=0)
				{
					count++;
					continue;
				}
				else
				{
					count++;
					String st[]=s.split("\\s+");
					double data=(Double.parseDouble(st[2]))/1024;
					//data=data/1024;
					String d=df.format(data);
					//double data2=Double.parseDouble(d);
					list.add(data);
					sum+=data;
					obj1.put((i+1)+"s",d);
					i++;
				
				}
			}
		}
		String avg=df.format(sum/list.size());
		
		Comparator<Double> comp=(i1,i2)->i1.compareTo(i2);
		String Max=df.format(list.stream().max(comp).get());
		JSONObject obj2=new JSONObject();
		obj2.put("values",obj1);
		obj2.put("AverageMemory(MB)",avg);
		obj2.put("MaxMemory(MB)",Max);
		obj2.put("Usecasename","HomePage");
		FileWriter fw=new FileWriter("C:\\Users\\Ashutosh Ranjan\\Downloads\\MemoryOutput.json");
		fw.write(obj2.toJSONString());
		fw.close();
		System.out.println(obj2);
	}

}
