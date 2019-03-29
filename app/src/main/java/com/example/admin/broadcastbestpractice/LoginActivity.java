package com.example.admin.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    Button loginBt;
    EditText usernameEt;
    EditText passedEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEt = (EditText) findViewById(R.id.user_et);
        passedEt =(EditText) findViewById(R.id.passwd_et);
        loginBt = (Button)findViewById(R.id.login);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = usernameEt.getText().toString();//获取用户名
                String passWord = passedEt.getText().toString();//获取密码
                //如果用户名是huangchixing,密码是123456就登录成功
                if(userName.equals("huangchixing")&&passWord.equals("123456")){
                    Intent intent =  new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else{
                    Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}
