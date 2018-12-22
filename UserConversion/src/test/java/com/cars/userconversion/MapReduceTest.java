package com.cars.userconversion;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.mock.MockMapContextWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cars.conversion.utils.Constants;
import com.cars.userconversion.mr.PCImpClckReducer;
import com.cars.userconversion.mr.commonFriendsMapper;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.mrunit.mock.MockInputSplit;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class MapReduceTest {
	  MapDriver<LongWritable, Text, Text, Text> mapDriver;
	  ReduceDriver<Text, Text, NullWritable, Text> reduceDriver;
	  MapReduceDriver<LongWritable, Text, Text, IntWritable, Text, IntWritable> mapReduceDriver;
	  Configuration config;

	  @Before
	  public void setUp() {
	
				    //Job job=new Job(config ,"Yearly");
		  commonFriendsMapper mapper = new commonFriendsMapper();
		 PCImpClckReducer reducer = new PCImpClckReducer();
		 //Context context = MockMapContextWrapper(mapper.getContext());
		 //mapper.getContext().set
	    //SMSCDRReducer reducer = new SMSCDRReducer();
	    mapDriver = MapDriver.newMapDriver(mapper);
	    reduceDriver = ReduceDriver.newReduceDriver(reducer);
	    //mapReduceDriver = MapReduceDriver.newMapReduceDriver(mapper, reducer);
	  }
	 
	  @Test
	  public void testMapper() {
		 config = mapDriver.getConfiguration();
		 config.set("srcpath","pcs");
		 config.set("DistributedCache", "local");
		 mapDriver.withInput(new LongWritable(), new Text("A,B,C,D"));
		 mapDriver.withOutput(new Text("A_B"), new Text("A,B,C,D"));
		 mapDriver.runTest();
	  }
	  
	  @Test
	  public void testReducer(){
		config = reduceDriver.getConfiguration();
		config.set("MultipleOutPut","false");
		config.set("INPUT_DELIMITER", "\t");
		  List<Text> values = new ArrayList<Text>();
		  values.add(new Text("A,B,C,D"));
//		  values.add(new Text("B,C,D,E"));
		  reduceDriver.withInput(new Text("A_B"), values);
		  reduceDriver.withOutput(NullWritable.get(), new Text("2015-10-03-12:54:46	2015-10-03	2015-10-01-14:00:00	125	258083429	88949069	60006749	23447309	fiat	NULL	0	1"));
		  reduceDriver.runTest();
	  }
	  
	  
	  
	  
}
