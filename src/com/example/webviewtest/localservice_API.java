package com.example.webviewtest;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class localservice_API {
	
	public int notification(Context context, String tickerText, String contentTitle, String contentContent) {
		NotificationManager nm = (NotificationManager) context.getSystemService(Activity.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher,
				tickerText, System.currentTimeMillis());
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
				new Intent(context, MainActivity.class), PendingIntent.FLAG_ONE_SHOT);
		notification.setLatestEventInfo(context, contentTitle, contentContent, pendingIntent); 
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		notification.defaults = Notification.DEFAULT_SOUND;
		nm.notify(0, notification);
		return 1;
	}
	
	public void sendBroadcast(Context context) {
		Intent intent = new Intent();  
        intent.setAction("com.example");  
        intent.putExtra("name", "jenny");  
        context.sendOrderedBroadcast(intent, null); 
        Toast.makeText(context, "发送广播成功", Toast.LENGTH_SHORT).show();  
	}
	  
	public int alarm(Context context, int time) {
		AlarmManager am = (AlarmManager) context
				.getSystemService(Activity.ALARM_SERVICE);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, time);
		PendingIntent pending = PendingIntent.getBroadcast(context, 0,
				new Intent(context, Receiver.class),
				PendingIntent.FLAG_ONE_SHOT);
		am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending);
		return 1;
	}
	
	public int alarmcancel(Context context) {
		PendingIntent pending = PendingIntent.getBroadcast(context, 0,
				new Intent(context, Receiver.class),
				PendingIntent.FLAG_ONE_SHOT);
		AlarmManager am = (AlarmManager) context
				.getSystemService(Activity.ALARM_SERVICE);
		am.cancel(pending);
		return 1;
	}
	
}


