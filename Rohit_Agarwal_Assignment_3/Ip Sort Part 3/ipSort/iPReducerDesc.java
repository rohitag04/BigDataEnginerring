package Cloud.ApacheLog;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

/**
 * Counts all of the hits for an ip. Outputs all ip's
 */
public class iPReducerDesc extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> 
{
  
  @Override
  public void reduce(Text key, Iterator<IntWritable> counts, OutputCollector<Text, IntWritable> output, Reporter reporter)
      throws IOException {
    
    int totalCount = 0;
    int newTotalCount = 0;
    
    // loop over the count and tally it up
    while (counts.hasNext())
    {
      IntWritable count = counts.next();
      totalCount += count.get();
    }
    
    if(totalCount > 100){
        newTotalCount = totalCount;
        output.collect(key, new IntWritable(newTotalCount));
    }
    
  }

}
