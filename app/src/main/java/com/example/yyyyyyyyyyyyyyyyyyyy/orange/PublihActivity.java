package com.example.yyyyyyyyyyyyyyyyyyyy.orange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

public class PublihActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publih);
        Button publishButton=(Button)findViewById(R.id.publish_button);


        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AVObject user = new AVObject("user");
                EditText publishHeadline=(EditText)findViewById(R.id.publish_headline_content);
                user.put("headline", publishHeadline.getText().toString());
                EditText publish_place_content=(EditText)findViewById(R.id.publish_place_content);
                user.put("place", publish_place_content.getText().toString());
                EditText publish_place_deadline_content=(EditText)findViewById(R.id.publish_place_deadline_content);
                user.put("deadline", publish_place_deadline_content.getText().toString());
                EditText publish_describe_content=(EditText)findViewById(R.id.publish_describe_content);
                user.put("describe", publish_describe_content.getText().toString());
                EditText publish_level_content=(EditText)findViewById(R.id.publish_level_content);
                user.put("level", publish_level_content.getText().toString());
                EditText publish_demandNumber_content=(EditText)findViewById(R.id.publish_demandNumber_content);
                user.put("numberofperson", publish_demandNumber_content.getText().toString());
                EditText publish_degree_content=(EditText)findViewById(R.id.publish_degree_content);
                user.put("completedegree", publish_degree_content.getText().toString());
//                user.saveInBackground(new SaveCallback() {
//                    @Override
//                    public void done(AVException e) {
//
//                        if (e == null) {
//                            mProgerss.setVisibility(View.GONE);
//                            PublishActivity.this.finish();
//                        } else {
//                            mProgerss.setVisibility(View.GONE);
//                            Toast.makeText(PublishActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
                user.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(AVException e) {
                        if (e==null){

                        }
                        else{}
                    }
                });




            }
        });
    }


}
