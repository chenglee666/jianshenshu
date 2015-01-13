package com.example.webviewtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper{
	private static final String DATABASENAME = "t_app";
	private static final int DATABASEVERSION = 1;
	
	private static final String TABLENAME_1 = "table_1";
	private static final String TABLENAME_2 = "table_2";
	private static final String TABLENAME_3 = "table_3";
	private static final String TABLENAME_4 = "table_4";
	
	private static final String FIELD_C_ID   = "c_id";
	private static final String FIELD_C_CATE = "c_cate";
	private static final String FIELD_C_BMI  = "c_bmi";
	private static final String FIELD_C_TYPE = "c_type";
	private static final String FIELD_C_URL  = "c_url";
	private static final String FIELD_C_TIME = "c_time";
	
	private static final String FIELD_S_ID   = "s_id";
	private static final String FIELD_S_DATE = "s_date";
	private static final String FIELD_S_CATE = "s_cate";
	private static final String FIELD_S_TIME = "s_time";
	private static final String FIELD_S_RES  = "s_res";
	private static final String FIELD_S_SCORE= "s_score";
	
	private static final String FIELD_I_ID   = "i_id";
	private static final String FIELD_I_NAME = "i_name";
	private static final String FIELD_I_SEX  = "i_sex";
	private static final String FIELD_I_HEIGHT = "i_height";
	private static final String FIELD_I_WEIGHT = "i_weight";
	private static final String FIELD_I_BMI  = "i_bmi";
	private static final String FIELD_I_TYPE = "i_type";
	
	private static final String FIELD_T_ID    = "t_id";
	private static final String FIELD_T_START = "t_start";
	private static final String FIELD_T_END   = "t_end";
	private static final String FIELD_T_TITLE = "t_title";

	
	public MyDatabaseHelper(Context context)
	{
		super(context, DATABASENAME, null, DATABASEVERSION);
	}
	
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql_1="Create table "+TABLENAME_1+"("+
		FIELD_C_ID     +   " integer primary key autoincrement,"+
		FIELD_C_CATE   +   " varchar(100)," +
		FIELD_C_BMI    +   " integer," +
		FIELD_C_TYPE   +   " integer," +
		FIELD_C_URL    +   " varchar(200)," +
		FIELD_C_TIME   +   " integer " 
		+");";
		db.execSQL(sql_1);
		
		String sql_2="Create table "+TABLENAME_2+"("+
		FIELD_S_ID     +   " integer primary key autoincrement,"+
		FIELD_S_DATE   +   " varchar(50)," +
		FIELD_S_CATE   +   " varchar(100)," +
		FIELD_S_TIME   +   " integer," +
		FIELD_S_RES    +   " integer," +
		FIELD_S_SCORE  +   " integer " 
		+");";
		db.execSQL(sql_2);
		
		String sql_3="Create table "+TABLENAME_3+"("+
		FIELD_I_ID     +   " integer primary key autoincrement,"+
		FIELD_I_NAME   +   " varchar(100)," +
		FIELD_I_SEX    +   " integer," +
		FIELD_I_HEIGHT +   " integer," +
		FIELD_I_WEIGHT +   " integer," +
		FIELD_I_BMI    +   " integer," +
		FIELD_I_TYPE   +   " integer " 
		+");";
		db.execSQL(sql_3);
		
		String sql_4="Create table "+TABLENAME_4+"("+
		FIELD_T_ID     +   " integer primary key autoincrement,"+
		FIELD_T_START  +   " varchar(50)," +
		FIELD_T_END    +   " varchar(50)," +
		FIELD_T_TITLE  +   " varchar(50) " 
		+");";
		db.execSQL(sql_4);
	}
//	@Override
//	public void onCreate(SQLiteDatabase db){
//		String sql = "CREATE TABLE" + TABLENAME + "(" +
//				"id  integer primary key autoincrement," +
//				"cate_1 VARCHAR(10) NOT NULL,"  +
//				"cate_2 VARCHAR(10) NOT NULL,"  +
//				"cate_3 VARCHAR(10) NOT NULL)"; 
//				
//		db.execSQL(sql);
//	}
//	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql_1 = "DROP TABLE IF EXISTS" + TABLENAME_1;
		db.execSQL(sql_1);
		this.onCreate(db);
		
		String sql_2 = "DROP TABLE IF EXISTS" + TABLENAME_2;
		db.execSQL(sql_2);
		this.onCreate(db);
		
		String sql_3 = "DROP TABLE IF EXISTS" + TABLENAME_3;
		db.execSQL(sql_3);
		this.onCreate(db);
		
		String sql_4 = "DROP TABLE IF EXISTS" + TABLENAME_4;
		db.execSQL(sql_4);
		this.onCreate(db);
	}
}
