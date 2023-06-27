package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
public static final String CHANNEL_ID = "My Channel";
    public static final int NOTIFICATION_ID = 101   ;

    public static final  int PI_REQUESTCODE = 1;//new thing  (this is used to take to specific activity when there are multiple notification with intents)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //these are new things about intent passing through notification
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this,PI_REQUESTCODE,intent,PendingIntent.FLAG_UPDATE_CURRENT);


        //end of new things

        //this is needed because the setLargeIcon requires image in bitmap format
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.data_base,null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable)drawable;

        Bitmap largeIcon = bitmapDrawable.getBitmap();

        //two style in notification 1.BigPictureStyle and 2.Inbox Style (shows only 7 lines)
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable)ResourcesCompat.getDrawable(getResources(),R.drawable.data_base,null)).getBitmap())//in drawable use jpg or jpeg format
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent By Athreya")
                .setSummaryText("Image Message");

        //inbox Style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("a")
                .addLine("b")
                .addLine("c")
                .addLine("d")
                .addLine("e")
                .addLine("f")
                .addLine("g")
                .addLine("h")
                .setBigContentTitle("Mesaage Sent By Athreya")
                .setSummaryText("Inbox message");

        //this is for only one notification
        Notification notification;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.data_base)
                    .setContentText("New Message")
                    .setSubText("New Message from Athreya")
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                    .setOngoing(true)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"Sample Channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            notification = new Notification.Builder(MainActivity.this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.data_base)
                    .setContentText("New Message")
                    .setSubText("New Message from Athreya")
                    .setContentIntent(pi)
                    .setStyle(inboxStyle)
                    .setOngoing(true)
                    .build();
        }
        nm.notify(NOTIFICATION_ID,notification);

    }
}