package com.example.webviewtest;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView wv;

	private Handler handler;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
/******* To close the block on the top when the Activity is started.*******/
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
/******* To satisfy web operation changing UI, normally it is not useful for web calling local functions.*******/
		handler = new Handler();
		
/******* Setting layout of web .*******/
		wv = (WebView) findViewById(R.id.wv);
		
/******* Enabling JS in web.*******/
		wv.getSettings().setJavaScriptEnabled(true);

 
		
/******* Setting normal WV as the client, it also provides Chrome Client.*******/
		wv.setWebViewClient(new WebViewClient() {
			
/******* To forbidden local browser activity.	*******/
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		
/******* Setting web operations.*******/
//		wv.setOnKeyListener(new View.OnKeyListener() {   
//            @Override    
//            public boolean onKey(View v, int keyCode, KeyEvent event) {    
//                if (event.getAction() == KeyEvent.ACTION_DOWN) {    
//                    if (keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack()) {  
//                    	wv.goBack();   
//                        //webview.goForward();
//                        return true;    // Done
//                    }    
//                }    
//                return false;    
//            }    
//        });  
		
/******* Setting JS communications with local functions.*******/
		wv.addJavascriptInterface(new Object() {
/******* Local service functions*******/	
			public int alarm(int time, String tickerText, String contentTitle, String contentContent) {
				 Receiver receiver = new Receiver();
				 receiver.tickerText = tickerText;
				 receiver.contentTitle = contentTitle;
				 receiver.contentContent = contentContent;
				 localservice_API alarm = new localservice_API();
				 alarm.alarm(MainActivity.this,time);				
				return 911; 
			}		
			
			public int alarmcancel() {
				localservice_API alarm = new localservice_API();
				alarm.alarmcancel(MainActivity.this);
				return 999;
			}
			
			public int sendBroadcast(int s) {
				 localservice_API bc = new localservice_API();
				 bc.sendBroadcast(MainActivity.this);		
				return 911; 
			}		
			
			public int notification(Context context, String tickerText, String contentTitle, String contentContent){
				localservice_API api = new localservice_API();
				int s = api.notification(MainActivity.this, tickerText, contentTitle, contentContent );
				return s;
			}
/******* Local DB functions*******/		
			
			
			
			public int db_create(String db_name, String table_name, String sql) {
				webdb_API.DB_NAME = db_name;
				webdb_API.TABLE_NAME = table_name;
				webdb_API.sql = sql;
				webdb_API db = new webdb_API(MainActivity.this);	
				db.getWritableDatabase();
				return 1;
			}
			
			public int table_create(String sql){
				webdb_API db = new webdb_API(MainActivity.this);
				int res = db.table_create(sql);
				return res;	
			}
			
			public long insert_row(String table_name, String[] fields, String[] contents){
				webdb_API db = new webdb_API(MainActivity.this);
				long res = db.insert_row(table_name, fields, contents);
				return res;		
			}
			
			public long insert_field(String table_name, String field, String content){
				webdb_API db = new webdb_API(MainActivity.this);
				long res = db.insert_field(table_name, field, content);
				return res;		
			}
			
			public int deletes(String sql){
				webdb_API db = new webdb_API(MainActivity.this);
				int res = db.delete(sql);
				return res;	
			}
			
			public int update(String sql){
				webdb_API db = new webdb_API(MainActivity.this);
				int res = db.update(sql);
				return res;	
			}
			
			public int insert_sql(String sql) {
				webdb_API db = new webdb_API(MainActivity.this);
				int res = db.insert_sql(sql);
				return res;
			}
			
			public String select_sql(String sql, String[] content){
				webdb_API db = new webdb_API(MainActivity.this);
				String res = db.select_sql(sql,content);
				int xString = res.length();
				if(xString == 0){
					return "null";
				}else{
					return res;
				}	
			}
			
			public String select_args(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit){
				webdb_API db = new webdb_API(MainActivity.this);
				String res = db.select_args(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
				int xString = res.length();
				if(xString == 0){
					return "null";
				}else{
					return res;
				}	
			}
			
			public int drop(String sql) {
				webdb_API db = new webdb_API(MainActivity.this);
				int res = db.drop(sql);
				return res;
			}
			/*** demo is the name of local functions in the JS ****/
		}, "demo");
		
/******* Loading the URL  **********/
		//wv.loadUrl("file:///android_asset/menu/demo/index.html");
		//wv.loadUrl("file:///android_asset/register/register.html");
		//wv.loadUrl("file:///android_asset/register/wel.html");
		wv.loadUrl("file:///android_asset/register/test.html");
	}
	
	
	
}
