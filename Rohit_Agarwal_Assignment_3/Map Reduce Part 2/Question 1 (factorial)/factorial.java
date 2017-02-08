package Cloud.fact;

import java.io.IOException;  
import java.util.*;  
import org.apache.hadoop.fs.Path;  
import org.apache.hadoop.conf.*;  
import org.apache.hadoop.io.*;  
import org.apache.hadoop.mapred.*;  
import org.apache.hadoop.util.*;  


public class factorial{
    
    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
        
        public void map(LongWritable Key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException{
            String fact = value.toString();  
            //StringTokenizer tokenizer = new StringTokenizer(fact);  
            output.collect(new Text("Factorial"), new IntWritable(Integer.parseInt(fact)));
        }
    }
    
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
        
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException{
            int calc = 1;
            while (values.hasNext()) {  
                calc *= values.next().get();  
            }
            output.collect(key, new IntWritable(calc));  
            
        }
    }
    public static void main(String[] args) throws Exception {  
      JobConf conf = new JobConf(factorial.class);  
      conf.setJobName("factorial");  
  
      conf.setOutputKeyClass(Text.class);  
      conf.setOutputValueClass(IntWritable.class);  
  
      conf.setMapperClass(Map.class);  
      conf.setCombinerClass(Reduce.class);  
      conf.setReducerClass(Reduce.class);  
  
      conf.setInputFormat(TextInputFormat.class);  
      conf.setOutputFormat(TextOutputFormat.class);  
  
      FileInputFormat.setInputPaths(conf, new Path(args[0]));  
      FileOutputFormat.setOutputPath(conf, new Path(args[1]));  
  
      JobClient.runJob(conf);  
    } 
}



