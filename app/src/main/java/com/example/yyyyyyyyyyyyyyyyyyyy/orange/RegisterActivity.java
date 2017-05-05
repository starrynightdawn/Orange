package com.example.yyyyyyyyyyyyyyyyyyyy.orange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register_registerbt=(Button)findViewById(R.id.register_registerbt);
        register_registerbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVUser user = new AVUser();// 新建 AVUser 对象实例
                EditText register_usernameet=(EditText)findViewById(R.id.register_usernameet);
                String username=register_usernameet.getText().toString();
                EditText register_passwordet=(EditText)findViewById(R.id.register_passwordet);
                String password=register_passwordet.getText().toString();
                user.setUsername(username);// 设置用户名
                user.setPassword(password);// 设置密码
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e == null) {
                            // 注册成功，把用户对象赋值给当前用户 AVUser.getCurrentUser()
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            RegisterActivity.this.finish();
                        } else {
                            // 失败的原因可能有多种，常见的是用户名已经存在。
                            //showProgress(false);
                            Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
