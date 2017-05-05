package com.example.yyyyyyyyyyyyyyyyyyyy.orange;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;

public class LoginActivity extends Activity {
    private EditText usernameet;
    private EditText passwordet;
    // private Button button;
    private Button clearButton1;
    private Button clearButton2;

    // 得到strings中的属性
    // private String string2 = getResources().getString(R.string.inaccount);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AVOSCloud.initialize(this,"ogoQ5q6C4KylIn3j2dkiqG2K-gzGzoHsz","yH9fAPae86F7WzgR8gWuPWbW");
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    Log.d("saved","success!");
                }
            }
        });


        usernameet = (EditText) findViewById(R.id.usernameet);
        passwordet = (EditText) findViewById(R.id.passwordet);

        // button = (Button) findViewById(R.id.button1);
        clearButton1 = (Button) findViewById(R.id.deletebt1);
        clearButton2 = (Button) findViewById(R.id.deletebt2);

        // 对EditText进行焦点变更监听
        usernameet.setOnFocusChangeListener(new EditTextListener(clearButton1));
        passwordet.setOnFocusChangeListener(new EditTextListener(clearButton2));

        // 对清空按钮进行点击监听
        clearButton1.setOnClickListener(new ClearButtonListener());
        clearButton2.setOnClickListener(new ClearButtonListener());

        // 对EditText进行编辑监听
        usernameet.addTextChangedListener(new MyEditTextWatcher(usernameet));
        passwordet.addTextChangedListener(new MyEditTextWatcher(passwordet));

        Button browseBt=(Button) findViewById(R.id.browsebt);
        browseBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button loginbt=(Button) findViewById(R.id.loginbt);
        loginbt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=usernameet.getText().toString();
                String password=passwordet.getText().toString();

                    try {
                        AVUser.logInInBackground(username, password, new LogInCallback<AVUser>() {
                            @Override
                            public void done(AVUser avUser, AVException e) {
                                if (e == null) {
                                    LoginActivity.this.finish();
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                } else {
                                    //showProgress(false);
                                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }catch (IllegalArgumentException e){
                        Toast.makeText(LoginActivity.this, "账号或密码为空", Toast.LENGTH_SHORT).show();
                    }

                }


        });

        Button registerbt=(Button)findViewById(R.id.registerbt);
        registerbt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


    }


    /**
     * 对EditText的内容进行实时监控
     *
     * @author Auser
     *
     */
    class MyEditTextWatcher implements TextWatcher {
        private CharSequence temp;
        private EditText editText;

        public MyEditTextWatcher(EditText editText) {
            this.editText = editText;
        }

        @Override
        // int start开始的位置, int count被改变的旧内容数, int after改变后的内容数量
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // 这里的s表示改变之前的内容，通常start和count组合，可以在s中读取本次改变字段中被改变的内容。而after表示改变后新的内容的数量。
        }

        @Override
        // int start开始的位置, int before改变前的内容数量, int count新增量
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            // 这里的s表示改变之后的内容，通常start和count组合，可以在s中读取本次改变字段中新的内容。而before表示被改变的内容的数量。
            temp = s;
        }

        @Override
        // 表示最终内容
        public void afterTextChanged(Editable s) {
            if (temp.length() > 0) {
                // 设置清空按钮为可见
                if (editText == usernameet) {
                    clearButton1.setVisibility(View.VISIBLE);
                } else if (editText == passwordet) {
                    clearButton2.setVisibility(View.VISIBLE);
                }
            } else {
                // 设置清空按钮不可见
                if (editText == usernameet) {
                    clearButton1.setVisibility(View.INVISIBLE);
                } else if (editText == passwordet) {
                    clearButton2.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    /**
     * 清空按钮点击事件
     *
     * @author
     *
     */
    class ClearButtonListener implements OnClickListener {

        @Override
        public void onClick(View view) {
            if (view == clearButton1) {
                usernameet.setText("");
            } else if (view == clearButton2) {
                passwordet.setText("");
            }
        }
    }

    /**
     * 焦点变更事件
     *
     * @author Auser
     *
     */
    class EditTextListener implements OnFocusChangeListener {
        private Button clear;

        public EditTextListener(Button clear) {
            this.clear = clear;
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            EditText textView = (EditText) v;
            String hint;
            if (hasFocus) {
                // 当获取焦点时如果内容不为空则清空按钮可见
                if (!textView.getText().toString().equals("")) {
                    clear.setVisibility(View.VISIBLE);
                }
                // if (textView == editText2) {
                // // 设置输入格式为不可见的密码格式
                // textView.setInputType(InputType.TYPE_CLASS_TEXT
                // | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                // }
                hint = textView.getHint().toString();
                // 给TextView添加额外的数据
                textView.setTag(hint);
                textView.setHint("");
            } else {
                // 当失去焦点时清空按钮不可见
                clear.setVisibility(View.INVISIBLE);
                // if (textView == editText2) {
                // // 设置输入格式为可见的密码格式
                // textView.setInputType(InputType.TYPE_CLASS_TEXT
                // | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                // }
                // 取出之前添加的额外数据
                hint = textView.getTag().toString();
                textView.setHint(hint);
            }
        }
    }
}

