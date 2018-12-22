package com.cars.userconversion.mr;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.log4j.Logger;





public class commonFriendsReducer extends Reducer<Text, Text, Text, Text> {

	private static final Logger log = Logger.getLogger(commonFriendsReducer.class);
	StringBuffer outputvaluebf = new StringBuffer();

	Text outputText = new Text();
	Context context;

	private String outputPath;

	@Override
	protected void setup(Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try{
			super.setup(context);

			this.context = context;

		}catch(Exception ex){
			throw ex;
		}finally{
			try{
				if(br != null)
					br.close();
			}catch(Exception ex){
				throw ex;
			}
		}

	}

	String inputdelimiter = ",";

	@Override
	protected void reduce(Text key, Iterable<Text> values,
			Reducer<Text, Text, Text, Text>.Context context) throws IOException,
			InterruptedException {
		HashSet<String> firstSetFriends = new HashSet<String>();
		String[] friendsdsKey = key.toString().split("_");
		String[] valArry = new String[2];
		valArry[0] = null;
		valArry[1] = null;
		int i=0;
		for(Text value:values){
			valArry[i] = value.toString();
			i++;
		}
		String[] firstFriendsList = valArry[0].split(inputdelimiter);
		if (valArry[1] != null) {
			String[] secondFriendsList = valArry[1].split(inputdelimiter);
			for (int k = 0; k < firstFriendsList.length; k++) {
				firstSetFriends.add(firstFriendsList[k]);
			}

			StringBuffer commonFriends = new StringBuffer();
			boolean firstCommonFriend = true;
			for (int k = 0; k < secondFriendsList.length; k++) {
				if (firstSetFriends.contains(secondFriendsList[k])
						&& ( !secondFriendsList[k].equalsIgnoreCase(friendsdsKey[0])
								&& !secondFriendsList[k].equalsIgnoreCase(friendsdsKey[1]))
						) {
					if (!firstCommonFriend) {
						commonFriends.append(',');
					}
					commonFriends.append(secondFriendsList[k]);
					firstCommonFriend = false;
				}
			}

			Text outputCountVal = new Text();
			outputCountVal.clear();
			outputCountVal.set(commonFriends.toString());
			
			context.write(key, outputCountVal);
		}
	}

	@Override
	protected void cleanup(Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		super.cleanup(context);

	}


}
