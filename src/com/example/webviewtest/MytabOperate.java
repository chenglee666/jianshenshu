package com.example.webviewtest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class MytabOperate {
	private static final String TABLENAME_1 = "table_1";
	private static final String TABLENAME_2 = "table_2";
	private static final String TABLENAME_3 = "table_3";
	private static final String TABLENAME_4 = "table_4";
	private SQLiteDatabase db = null;
	
	public MytabOperate(SQLiteDatabase db){
		this.db = db;
	}
	/******* db-insert, args should be a array   **********/	
	public int c_insert(String s[][] ){
		for (int i = 0; i < s[i].length; i++) {
			ContentValues cv = new ContentValues();
			cv.put("c_id",   Integer.parseInt(s[i][0]));
			cv.put("c_cate", s[i][1]);
			cv.put("c_bmi",  s[i][2]);
			cv.put("c_type", Integer.parseInt(s[i][3]));
			cv.put("c_url",  Integer.parseInt(s[i][4]));
			cv.put("c_time", Integer.parseInt(s[i][5]));
			this.db.insert(TABLENAME_1, null, cv);
		}
		return 0;
	}
	
	public int s_insert(String s[][] ){
		for (int i = 0; i < s[i].length; i++) {
			ContentValues cv = new ContentValues();
			cv.put("s_id",   Integer.parseInt(s[i][0]));
			cv.put("s_date", s[i][1]);
			cv.put("s_cate", s[i][2]);
			cv.put("s_time", Integer.parseInt(s[i][3]));
			cv.put("s_res",  Integer.parseInt(s[i][4]));
			cv.put("s_score",Integer.parseInt(s[i][5]));
			this.db.insert(TABLENAME_2, null, cv);
		}
		return 10;
	}
	
	public int i_insert(String s[] ){
			ContentValues cv = new ContentValues();
			cv.put("i_id",    Integer.parseInt(s[0]));
			cv.put("i_name",  s[1]);
			cv.put("i_sex",   Integer.parseInt(s[2]));
			cv.put("i_height",Integer.parseInt(s[3]));
			cv.put("i_weight",Integer.parseInt(s[4]));
			cv.put("i_bmi",   Integer.parseInt(s[5]));
			cv.put("i_type",  Integer.parseInt(s[6]));
			this.db.insert(TABLENAME_3, null, cv);
		return 0;
	}
	
	public int t_insert(String s[] ){
		ContentValues cv = new ContentValues();
		cv.put("t_id",    Integer.parseInt(s[0]));
		cv.put("t_title", s[1]);
		cv.put("t_start",   Integer.parseInt(s[2]));
		cv.put("t_end", Integer.parseInt(s[3]));
		this.db.insert(TABLENAME_4, null, cv);
		return 0;
	}

	public int i_update(String s[])
	{
		//SQLiteDatabase db=this.getWritableDatabase();
		String where = "i_id=? AND i_name=? AND i_sex=? AND i_height AND i_weight AND i_bmi AND i_type";
		String[] whereValue = s;
		ContentValues cv = new ContentValues(); 
		cv.put("i_id", Integer.parseInt(s[0]));
		cv.put("i_name", s[1]);
		cv.put("i_sex", s[2]);
		cv.put("i_height", Integer.parseInt(s[3]));
		cv.put("i_weight", Integer.parseInt(s[4]));
		cv.put("i_bmi", s[5]);
		cv.put("i_type", s[6]);
		db.update(TABLENAME_3, cv, where, whereValue);
		return 0;
	}
	
	public int i_update_level(int level, int type)
	{
		//SQLiteDatabase db=this.getWritableDatabase();
		
		String where = "i_level=?";
		String[] whereValue = new String[]{"i_level"};;
		ContentValues cv = new ContentValues(); 
		cv.put("i_level", level);
		db.update(TABLENAME_3, cv, where, whereValue);
		return 0;
	}
}
//	public void insert(int id, char cate, int res){
//		ContentValues cv = new ContentValues();
//		switch (cate) {
//		case cate_1:
//			cv.put("cate_1",res);
//			cv.put("id", id);
//			this.db.insert(TABLENAME, null, cv);
//			
//			break;
//		case cate_2:
//			cv.put("cate_2",res);
//			this.db.insert(TABLENAME, null, cv);
//			
//			break;
//		case cate_3:
//			cv.put("cate_3",res);
//			this.db.insert(TABLENAME, null, cv);
//			
//			break;
//		default:
//			break;
//		}
//		
//	}
//	
//	public void update(int id, char cate, int res){
//		String whereClause = "id=?";
//		String whereArgs[]  = new String[]{String.valueOf(id)};
//		ContentValues cv = new ContentValues();
//		switch (cate) {
//		case cate_1:
//			cv.put("cate_1",res);
//			this.db.update(TABLENAME, cv, whereClause, whereArgs);
//			this.db.close();
//			break;
//		case cate_2:
//			cv.put("cate_2",res);
//			this.db.update(TABLENAME, cv, whereClause, whereArgs);
//			this.db.close();
//			break;
//		case cate_3:
//			cv.put("cate_3",res);
//			this.db.update(TABLENAME, cv, whereClause, whereArgs);
//			this.db.close();
//			break;
//		default:
//			break;
//		}
//	}
//	
//	public void delete(int id){
//		String whereClause = "id=?";
//		String whereArgs[] = new String[]{String.valueOf(id)};
//		this.db.delete(TABLENAME, whereClause, whereArgs);
//	}
//	

