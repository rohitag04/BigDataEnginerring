package Cloud.formula;

import java.io.IOException;  
import java.util.*;  
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.conf.*;  
import org.apache.hadoop.io.*;  
import org.apache.hadoop.mapred.*;  
import org.apache.hadoop.util.*;  


public class pie{
    
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, DoubleWritable>{
        
        public void map(LongWritable Key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException{
            String pie = value.toString();  
            output.collect(new Text("pie"), new DoubleWritable(Double.parseDouble(pie)));
        }
    }
    
    public static class Reduce extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable>{
        
        public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException{
            double sum = 0.0d;
            int i=0;
            while (values.hasNext()) {  
              double val = values.next().get(); 
               double element = Math.pow(-1,i) / (2*i +1);
                sum += element;
                i++;
            }
            double result = 4.0d * sum;
            output.collect(key, new DoubleWritable(result));  
            
        }
    }
    public static void main(String[] args) throws Exception {  
      JobConf conf = new JobConf(pie.class);  
      conf.setJobName("pie");  
  
      conf.setOutputKeyClass(Text.class);  
      conf.setOutputValueClass(DoubleWritable.class);  
  
      conf.setMapperClass(Map.class);  
      conf.setReducerClass(Reduce.class);  
  
      conf.setInputFormat(TextInputFormat.class);  
      conf.setOutputFormat(TextOutputFormat.class);  
  
      FileInputFormat.setInputPaths(conf, new Path(args[0]));  
      FileOutputFormat.setOutputPath(conf, new Path(args[1]));  
  
      JobClient.runJob(conf);  
    } 
}



