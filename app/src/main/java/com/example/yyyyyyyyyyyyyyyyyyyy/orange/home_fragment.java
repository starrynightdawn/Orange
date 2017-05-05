package com.example.yyyyyyyyyyyyyyyyyyyy.orange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yyyyyyyyyyyyyyyyyyyy on 2017/4/22.
 */

public class home_fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home_fragment, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {




        super.onActivityCreated(savedInstanceState);
      //  Button button = (Button) getActivity().findViewById(R.id.button);
       // button.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View v) {
        //
        //    }
       // });
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> hashmap = new HashMap<String,Object>();
        //hashmap.put("headLine",R.string.home_fragment_item_content_headline);
        hashmap.put("headLine","帮忙带快递");
        hashmap.put("image",R.drawable.listview_item_image1);
        hashmap.put("username","叶知秋");
        hashmap.put("content","帮忙到南苑的顺路速递取快递，我的手机号是123456");
        hashmap.put("cost","3元/任务");
        hashmap.put("degree","待接单");
        list.add(hashmap);

        hashmap = new HashMap<String,Object>();
        //hashmap.put("headLine",R.string.home_fragment_item_content_headline);
        hashmap.put("headLine","帮忙取车票");
        hashmap.put("image",R.drawable.listview_item_image2);
        hashmap.put("username","一颗橙子");
        hashmap.put("content","帮忙到新西门，取火车票");
        hashmap.put("cost","6元/任务");
        hashmap.put("degree","待接单");
        list.add(hashmap);


        hashmap = new HashMap<String,Object>();
        //hashmap.put("headLine",R.string.home_fragment_item_content_headline);
        hashmap.put("headLine","帮忙卖水果");
        hashmap.put("image",R.drawable.listview_item_image3);
        hashmap.put("username","慵懒的猫");
        hashmap.put("content","麻烦带些苹果给我");
        hashmap.put("cost","5元/任务");
        hashmap.put("degree","待接单");
        list.add(hashmap);
        ListView homeListView=(ListView)getActivity().findViewById(R.id.homeListview);
        int[] idAggregate=new int[]{R.id.home_listview_item_headline,
                R.id.home_listview_item_content_layout_image,
                R.id.home_listview_item_content_layout_username,
                R.id.home_listview_item_short_conent,
                R.id.home_listview_item_short_cost,
                R.id.home_listview_item_short_comletion_degree
        };
        SimpleAdapter adapter=new SimpleAdapter(getActivity(),list,R.layout.home_listview_item,new String[]{"headLine","image","username",
                "content","cost","degree"},idAggregate);
        homeListView.setAdapter(adapter);
        homeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(getActivity(),HomeFragmentListViewItemShow.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        //String[] data={"1","2","3"};
        //ArrayAdapter<String> homeArrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        //homeListView.setAdapter(homeArrayAdapter);

    }


        }

