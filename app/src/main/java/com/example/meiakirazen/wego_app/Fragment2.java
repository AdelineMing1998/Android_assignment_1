package com.example.meiakirazen.wego_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class Fragment2 extends Fragment implements View.OnClickListener{
    /**
     * 定义六个按钮的点击事件
     */
    private ImageButton button_1;//今日运动
    private ImageButton button_2;//近期比赛
    private ImageButton button_3;//运动品牌
    private ImageButton button_4;//运动社区
    private ImageButton button_5;//运动项目
    private ImageButton button_6;//赛事回顾


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment2,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button_1 = (ImageButton)getActivity().findViewById(R.id.imageButton1);
        button_2 = (ImageButton)getActivity().findViewById(R.id.imageButton2);
        button_3 = (ImageButton)getActivity().findViewById(R.id.imageButton3);
        button_4 = (ImageButton)getActivity().findViewById(R.id.imageButton4);
        button_5 = (ImageButton)getActivity().findViewById(R.id.imageButton5);
        button_6 = (ImageButton)getActivity().findViewById(R.id.imageButton6);
        //设置监听方法
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);

    }

    /**
     * 重写主类的按钮点击方法
     * @param v
    //     */

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton1:
                Intent intent1 = new Intent(getActivity(),RunActivity.class);
                startActivity(intent1);
                break;
            case R.id.imageButton2:
                Intent intent2 = new Intent(getActivity(), MatchActivity.class);
                startActivity(intent2);
                break;
            case R.id.imageButton3:
                Intent intent3 = new Intent(getActivity(), BrandActivity.class);
                startActivity(intent3);
                break;
            case R.id.imageButton4:
                Intent intent4 = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent4);
                break;
            case R.id.imageButton5:
                Intent intent5 = new Intent(getActivity(), ItemActivity.class);
                startActivity(intent5);
                break;
            case R.id.imageButton6:
                Intent intent6 = new Intent(getActivity(), ReviewActivity.class);
                startActivity(intent6);
                break;
        }
    }
}
