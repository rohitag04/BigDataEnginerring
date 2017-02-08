package Cloud.ApacheLog;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class iPMapperDesc1 extends MapReduceBase implements Mapper<LongWritable, Text, IntWritable, Text>
{
 // private static final Pattern ipPattern = Pattern.compile("^([\\d\\.]+)\\s([\\d]+)"); // regex reads IP and Count
  private static final IntWritable one = new IntWritable(1);
  
  public void map(LongWritable key, Text values,
      OutputCollector<IntWritable,Text> output, Reporter reporter)
      throws IOException {
		  
    //Matcher matcher = ipPattern.matcher(values.toString());
    //if(matcher.find())
    //{
      String ip = values.toString();
      String[] sortIP = ip.split("\\t");
      IntWritable value = new IntWritable(Integer.parseInt(sortIP[1]) * -1);
      
      Text txt = new Text(sortIP[0]);
      output.collect(value, txt);
    //}
	
}
}