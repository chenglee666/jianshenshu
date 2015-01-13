package com.example.webviewtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
public class Receiver extends BroadcastReceiver {  
	public static String tickerText;
	public static String contentTitle;
	public static String contentContent;
    @Override  
    public void onReceive(Context context, Intent intent) {  
//        String name = intent.getExtras().getString("name");  
//        Toast.makeText(context, "接收到:"+name, Toast.LENGTH_SHORT).show();  
//        Log.i("Recevier1", "接收到:"+name);  \
    	localservice_API alarmApi = new localservice_API();
    	alarmApi.notification(context, tickerText, contentTitle, contentContent);
        abortBroadcast();   
    }  
  
}