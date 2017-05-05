package com.example.yyyyyyyyyyyyyyyyyyyy.orange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by yyyyyyyyyyyyyyyyyyyy on 2017/4/22.
 */

public class person_fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.person_fragment, null);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button personBt=(Button)getActivity().findViewById(R.id.person_add_button);
        personBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),PublihActivity.class);
                startActivity(intent);
            }
        });

    }

}

