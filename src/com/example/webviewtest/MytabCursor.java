package com.example.webviewtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.attr;
import android.R.integer;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MytabCursor {
	private static final String TABLENAME_1 = "table_1";
	private static final String TABLENAME_2 = "table_2";
	private static final String TABLENAME_3 = "table_3";
	private static final String TABLENAME_4 = "table_4";
	
	private static final String TABLENAME = "m_c";
	private SQLiteDatabase db = null;
	public String sql_ = "SELECT * FROM " + TABLENAME  + " WHERE id = 1; " ;
	
	public MytabCursor(SQLiteDatabase db){
		this.db = db;
	}

//	public List<Map<String, Integer>> find(){
////		String num = new String("id = 3");
//		List<Map<String, Integer>> alll =  new ArrayList<Map<String,Integer>>();
// 		Map<String, Integer> all = new HashMap<String, Integer>();	
//		Cursor result = this.db.rawQuery(sql,null);
//		for(result.moveToFirst();!result.isAfterLast();result.moveToNext()){
//			all.put("cate_2", result.getInt(1));
//			all.put("cate_3", result.getInt(2));
//			all.put("cate_1", result.getInt(3));
//			alll.add(all);
//		}
//		this.db.close();
//		return alll;
//	}
	
	public String t3_check(){
		String sql = "SELECT * FROM " + TABLENAME_3  + " WHERE id = 1; ";
		Cursor res = this.db.rawQuery(sql,null);
		String res_checked = res.toString();
		this.db.close();
		return res_checked;
	}
}
