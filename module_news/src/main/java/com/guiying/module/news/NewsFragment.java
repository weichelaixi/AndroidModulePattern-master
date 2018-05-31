package com.guiying.module.news;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guiying.module.common.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment {

    public AppBarLayout appBarLayout;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NewsFragment.
     */
    public static NewsFragment newInstance() {
        return new NewsFragment();
    }



    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        SwipeRefreshLayout mSwipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipe_layout);
        //设置样式刷新显示的位置
        mSwipeRefreshLayout.setProgressViewOffset(true, -20, 100);
        //转圈的颜色随便你自己指定
        mSwipeRefreshLayout.setColorSchemeColors(Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY);
        mSwipeRefreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        appBarLayout = (AppBarLayout) view.findViewById(R.id.appbar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (verticalOffset >= 0) {
                    mSwipeRefreshLayout.setEnabled(true);
                } else {
                    mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });
        return view;
    }


}
