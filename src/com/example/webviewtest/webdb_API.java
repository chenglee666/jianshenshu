package com.example.webviewtest;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class webdb_API extends SQLiteOpenHelper {
	
	public static String DB_NAME = "";
	public static String TABLE_NAME = "";
	public static String sql;
	
	public webdb_API(Context context) {
		// TODO Auto-generated constructor stub
		super(context, DB_NAME, null, 1);
		return;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql_ = "DROP TABLE IF EXISTS" + TABLE_NAME;
		db.execSQL(sql_);
		this.onCreate(db);
	}

	public int insert_sql(String sql) {
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL(sql);
		return 1;
	}
	
	public long insert_field(String table_name, String field, String content)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues(); 
		cv.put(field, content);
		long row=db.insert(table_name, null, cv);
		return row;
	}
	
	public long insert_row(String table_name, String[] fields, String[] contents)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		if(fields.length != contents.length){
			return 999;
		}
		else{
		ContentValues cv=new ContentValues(); 
		for (int i = 0; i < fields.length; i++) {
			cv.put(fields[i], contents[i]);
		}
		long row=db.insert(table_name, null, cv);
		return row;
		}
	}

	public int delete(String sql)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL(sql);
		return 1;
	}
	
	public int update(String sql)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL(sql);
		return 1;
	}
	
	public JSONObject row_find(String sql) {
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor result = db.rawQuery(sql,null);
		JSONObject jsonObject = new JSONObject();
		try {
			while(result.moveToNext()){	
				int i=0;
				jsonObject.put(result.getColumnName(i), result.getString(i));
				i++;
			}
		} catch (JSONException e) {
			// TODO: handle exception
			 e.printStackTrace();  
		}
		return jsonObject; 
	}
	
	public String select_sql(String sql,String[] content){
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor result = db.rawQuery(sql,null);
		StringBuffer buffer = new StringBuffer();
			while(result.moveToNext()){	
				for (int j = 0; j < content.length; j++) {
					buffer.append(result.getString(result.getColumnIndex(content[j]))).append(",");
				}
			}
		return buffer.toString(); 
	}	
	
	public String select_args(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit){
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor result = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
		StringBuffer buffer = new StringBuffer();
			while(result.moveToNext()){	
				for (int j = 0; j < columns.length; j++) {
					buffer.append(result.getString(result.getColumnIndex(columns[j]))).append(",");
				}
			}
		return buffer.toString(); 
	}	
	
	public int drop(String sql) {
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL(sql);	
		return 1;
	}
	
	public int table_create(String sql) {
		SQLiteDatabase db=this.getWritableDatabase();
		db.execSQL(sql);	
		return 1;
	}
}
