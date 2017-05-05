package com.example.yyyyyyyyyyyyyyyyyyyy.orange;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yyyyyyyyyyyyyyyyyyyy on 2017/4/22.
 */

public class news_fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.news_fragment, null);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> hashmap = new HashMap<String,Object>();
        hashmap.put("news_item_name","慵懒的早晨");
        hashmap.put("news_item_content","可以帮我寄快递吗");
        list.add(hashmap);
        hashmap=new HashMap<String, Object>();
        hashmap.put("news_item_name","光");
        hashmap.put("news_item_content","什么时候把快递送去");
        list.add(hashmap);
        ListView newsListview=(ListView)getActivity().findViewById(R.id.news_fragment_listview);
        int[] idAggregate={R.id.news_fragment_item_headline,R.id.news_fragment_item_content};
        SimpleAdapter newsItemSimpleAdapter=new SimpleAdapter(getActivity(),list,R.layout.news_fragment_item,
                new String[]{"news_item_name","news_item_content"},idAggregate);
        newsListview.setAdapter(newsItemSimpleAdapter);
    }

}

