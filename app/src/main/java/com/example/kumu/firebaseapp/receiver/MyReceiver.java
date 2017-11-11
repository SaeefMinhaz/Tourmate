package com.example.kumu.firebaseapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.kumu.firebaseapp.service.NotificationBuilderService;

public class MyReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Intent service1 = new Intent(context, NotificationBuilderService.class);
        context.startService(service1);
    }
}
