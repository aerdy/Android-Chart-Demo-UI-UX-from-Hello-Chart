package com.necisstudio.statistics.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import com.necisstudio.statistics.R;
import com.necisstudio.statistics.adapter.DashboardAdapter;
import com.necisstudio.statistics.item.DashboardItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by vim on 31/10/16.
 */

public class DashboardFragment extends Fragment {
    ArrayList<DashboardItem> itemlist;
    DashboardAdapter adapter;

    @InjectView(R.id.recycleView)
    RecyclerView recycleView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.inject(this, view);
        initUI();
        getDataPercent();
        return view;
    }

    private void initUI(){
        recycleView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        recycleView.getItemAnimator().setAddDuration(700);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemlist = new ArrayList<>();
        adapter = new DashboardAdapter(getActivity(), itemlist);
        recycleView.setAdapter(adapter);
    }

    private void getDataPercent(){
        for(int a=0;a<20;a++){
            DashboardItem item = new DashboardItem();
            adapter.add(item,a);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
