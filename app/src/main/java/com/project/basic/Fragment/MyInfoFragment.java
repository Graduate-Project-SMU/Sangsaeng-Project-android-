package com.project.basic.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.project.basic.MyInfo.MyInfoModifyActivity;
import com.project.basic.R;


public class MyInfoFragment extends Fragment {

    private Button modifyBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_info, container, false);

        modifyBtn = (Button)view.findViewById(R.id.myInfoModify);

        modifyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent connectModifyActicity = new Intent(getActivity(), MyInfoModifyActivity.class );
                startActivity(connectModifyActicity);
            }
        });

        return view;
    }

}
