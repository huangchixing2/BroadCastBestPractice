package com.example.admin.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

    public class BaseActivity extends AppCompatActivity {


    private ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ActivityCollector.addActivity(this);
    }

        /**
         *  动态注册一个广播接收器
         */
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.admin.broadcastbestpractice.FORCE_OFFLINE");
        receiver = new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(receiver != null)
        {
            unregisterReceiver(receiver); //取消注册强制下线，只有处于栈顶的activity才能来接受到这条强制下线广播  
            receiver = null;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    private class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context); //构建对话框
            builder.setTitle("Warning");
            builder.setMessage("you are forced to be offline,please try to login again!");
            builder.setCancelable(false); //将对话框设置为不可取消
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();//销毁所有活动，并重新启动LoginActivity
                    Intent intent = new Intent(context, LoginActivity.class); //启动LoginActivity
                    context.startActivity(intent);
                }
            });
            builder.show();
        }
    }
}
