package com.example.yyyyyyyyyyyyyyyyyyyy.orange;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnTabChangeListener {
    private FragmentTabHost mTabHost;
    private Class fragmentArray[]={home_fragment.class,news_fragment.class,person_fragment.class};
    private int mImageViewArray[]={R.drawable.home,R.drawable.news,R.drawable.person};
    private String mTextviewArray[]={"广场","消息","个人"};

    //定义一个布局
    private LayoutInflater layoutInflater;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //下面的代码是测试能不能再一个activity中对fragment中的listview进行数据填充

        initView();




        // 测试 SDK 是否正常工作的代码
       /* AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    Log.d("saved","success!");
                }
            }
        });*/
    }

    private void initView() {
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        int count=fragmentArray.length;
        for(int i=0;i<count;i++){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab_background2);
        }

    }

    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);

        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);

        return view;
    }

    @Override
    public void onTabChanged(String tabId) {

    }
}
