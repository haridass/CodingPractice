package com.cars.conversion.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Constants {

	public static int PC_TIME_INDEX 				= 0;
	public static int PC_USERID_INDEX 				= 1;
	public static int PC_ADUNITPATH_INDEX 			= 2;
	public static int PC_ADUNITID_INDEX 			= 3;
	public static int PC_ADVERTISERID_INDEX 		= 4;
	public static int PC_MAKE_INDEX 				= 5;
	public static int PC_MODEL_INDEX 				= 6;
	public static int PC_COMPARETOTIME_INDEX 		= 7;
	
	public static int IMP_TIME_INDEX 				= 0;
	public static int IMP_USERID_INDEX 				= 1;
	public static int IMP_LINEITEMID_INDEX 			= 2;
	public static int IMP_ORDERID_INDEX 			= 3;
	public static int IMP_ADUNITID_INDEX 			= 4;
	public static int IMP_ADVERTISRID_INDEX 		= 5;
	public static int IMP_MAKE_INDEX 				= 6;
	public static int IMP_MODEL_INDEX 				= 7;
	
	public static int CLK_TIME_INDEX				= 0;
	public static int CLK_USERID_INDEX				= 1;
	public static int CLK_LINEITEMID_INDEX			= 2;
	public static int CLK_ORDERID_INDEX				= 3;
	public static int CLK_ADUNITID_INDEX			= 4;
	public static int CLK_ADVERTISERID_INDEX		= 5;
	public static int CLK_MAKE_INDEX				= 6;
	public static int CLK_MODEL_INDEX				= 7;
	
	
	
	public static  SimpleDateFormat SDF_yyyyMMddhhmmss  = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
	public static SimpleDateFormat SDF_yyyyMMdd 		= new SimpleDateFormat("yyyy-MM-dd");
	public static DecimalFormat DF_4 					= new DecimalFormat("#.####");
	public static int CLICKS_NUM_DAYS_IN_PAST			= 30;
	public static int IMPRESSIONS_NUM_DAYS_IN_PAST		= 7;
	public static int ADVERTISER_KEY_POS		= 0;
	public static int ADVERTISER_VALUE_POS		= 2;
	public static int ADVERTISER_EXP_POS		= 3;
	
	public static int ORDERID_KEY_POS		= 2;
	public static int ORDERID_VALUE_POS		= 3;
	public static int ORDERID_EXP_POS		= 4;
	
	
	public static String CLICKS_NUM_DAYS_IN_PAST_VAR			= "CLK_OFFSET";
	public static String IMPRESSIONS_NUM_DAYS_IN_PAST_VAR		= "IMP_OFFSET";
	
	public static String PC_REC_IDENTIFIER  = "PCS";
	public static String IMP_REC_IDENTIFIER = "IMP";
	public static String CLK_REC_IDENTIFIER = "CLK";
	
	public static String PCS_PATH_LIKE  = "pcs";
	public static String IMP_PATH_LIKE  = "imp";
	public static String CLK_PATH_LIKE  = "clk";
	
	public static String CTC_COUNT = "CTC";
	public static String VTC_COUNT = "VTC";
	
	public static String TAB_SEPERATOR = "\t";
	public static String UNDERSCORE_SEPERATOR = "_";
	
	
	public static final String ADVERTISERID_LEVEL_OUTPUT_FILE   = "AdvertiserIdLevel";
	public static final String LINEITEMID_LEVEL_OUTPUT_FILE 	 = "LineItemIdLevel";
	public static final String ORDERID_LEVEL_OUTPUT_FILE	     = "OrderIdLevel";
	
	public static final String ADVERTISERID_TO_MAKE_MAPPING_FILE_NAME = "advertiserToMake.txt";
	public static final String ORDER_TO_MAKE_MAPPING_FILE_NAME = "orderIdToMake.txt";
	
	public static final String HADOOP_MR_OUTPUT_DIR_PROPERTY_NAME="mapreduce.output.fileoutputformat.outputdir";
}

