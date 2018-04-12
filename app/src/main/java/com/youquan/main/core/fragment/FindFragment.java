package com.youquan.main.core.fragment;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.base.BFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youquan.R;
import com.youquan.main.core.adapter.EssayAdapter;
import com.youquan.main.model.Essay;
import com.youquan.main.present.PFind;
import com.youquan.main.view.VFind;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("InflateParams")
public class FindFragment extends BFragment implements VFind {
    private XRecyclerView rvEssay;

    private PFind pFind;
    private List<Essay> essays;
    private EssayAdapter essayAdapter;
    private float lng, lat;

    @Override
    protected View getView(LayoutInflater layoutInflater, ViewGroup root) {
        return layoutInflater.inflate(R.layout.fragment_find, null);
    }

    @Override
    protected void loadView() {
        rvEssay = (XRecyclerView) findViewById(R.id.rvEssay);
        //LinearLayoutManager是线性布局，setOrientation可以设置他的方向是横向还是纵向。
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvEssay.setLayoutManager(layoutManager);
        ImageView iv = new ImageView(getActivity());
        iv.setImageResource(R.drawable.ic_adver);
        rvEssay.addHeaderView(iv);
        //XRecyclerView的上下拉监听方法
        rvEssay.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            //下拉刷新
            public void onRefresh() {
                lazyLoad();
            }

            @Override
            //上拉加载
            public void onLoadMore() {
                lazyLoad();
            }
        });
    }

    @Override
    protected void onActivityCreated() {
        pFind = new PFind(this);
    }

    @Override
    protected void lazyLoad() {
        if (pFind != null) {
            pFind.reqNearEssay();
        }
    }

    @Override
    public String getLng() {
        return String.valueOf(lng);
    }

    @Override
    public String getLat() {
        return String.valueOf(lat);
    }

    @Override
    public void setEssays(List<Essay> datas) {
        this.essays = datas;
        setEssayListView();
    }

    // 设置圈子帖子View
    private void setEssayListView() {
        if (rvEssay != null) {
            if (essays == null) {
                essays = new ArrayList<Essay>();
            }
            if (essayAdapter == null) {
                essayAdapter = new EssayAdapter(getActivity(), essays);
                rvEssay.setAdapter(essayAdapter);
            } else {
                essayAdapter.refresh(essays);
            }
        }
        rvEssay.refreshComplete();
    }
}
