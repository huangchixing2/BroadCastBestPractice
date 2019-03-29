package com.example.admin.broadcastbestpractice;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button forceBt;

    /**
     * 强制下线功能
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forceBt = (Button) findViewById(R.id.force_bt);
        forceBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这条广播是通知程序 强制用户下线的
                Intent intent = new Intent("com.example.admin.broadcastbestpractice.FORCE_OFFLINE");
//                intent.setComponent(new ComponentName("com.example.admin.broadcastbestpractice","com.example.admin.broadcastbestpractice.BaseActivity"));
                sendBroadcast(intent);
            }
        });
    }
}
