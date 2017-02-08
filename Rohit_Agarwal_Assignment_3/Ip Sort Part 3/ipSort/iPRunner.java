package Cloud.ApacheLog;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class iPRunner {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception
  {
        JobConf conf = new JobConf(iPRunner.class);
        JobConf conf1 = new JobConf(iPRunner.class);
        
        // first
        conf.setJobName("ip-count");
        
        conf.setMapperClass(iPMapperDesc.class);
        
        conf.setMapOutputKeyClass(Text.class);
        conf.setMapOutputValueClass(IntWritable.class);
        
        conf.setReducerClass(iPReducerDesc.class);
      
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
       

        JobClient.runJob(conf);
      
        
        // Second
        
        conf1.setJobName("ip-count-sort");
        
        conf1.setMapperClass(iPMapperDesc1.class);
        
        conf1.setMapOutputKeyClass(IntWritable.class);
        conf1.setMapOutputValueClass(Text.class);
        
        conf1.setReducerClass(iPReducerDesc1.class);
                
        FileInputFormat.setInputPaths(conf1, new Path(args[1]));
        FileOutputFormat.setOutputPath(conf1, new Path(args[2]));
        
        JobClient.runJob(conf1);
	}

}
