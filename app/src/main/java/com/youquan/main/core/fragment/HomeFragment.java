package com.youquan.main.core.fragment;

import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.base.BFragment;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.util.StringUtils;
import com.youquan.R;
import com.youquan.custom.HorizontalListView;
import com.youquan.main.core.adapter.EssayAdapter;
import com.youquan.main.core.adapter.MainQuanAdapter;
import com.youquan.main.model.Essay;
import com.youquan.main.model.Gam;
import com.youquan.main.present.PHome;
import com.youquan.main.view.VHome;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BFragment implements VHome {
    private HorizontalListView lvQuan;
    private XRecyclerView rvEssay;
    private TextView tvQuanName;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;

    private MainQuanAdapter quanAdapter;
    private EssayAdapter essayAdapter;
    private List<Gam> gams;
    private List<Essay> essays;
    private PHome pHome;
    private Gam gam;// 当前显示圈子
    private String gamId; // 当前显示圈子ID

    @Override
    protected View getView(LayoutInflater layoutInflater, ViewGroup root) {
        return layoutInflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    protected void loadView() {
        tvQuanName = (TextView) findViewById(R.id.tvQuanName);
        lvQuan = (HorizontalListView) findViewById(R.id.lvQuan);
        rvEssay = (XRecyclerView) findViewById(R.id.rvEssay);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //LinearLayoutManager是线性布局，setOrientation可以设置他的方向是横向还是纵向。
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvEssay.setLayoutManager(layoutManager);
    }

    @Override
    protected void onActivityCreated() {
        // 初始化加载
        setListener();
        pHome = new PHome(this);
        pHome.reqMainGams();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        lvQuan.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                gam = gams.get(arg2);
                setEssayByGam();
            }
        });
        //XRecyclerView的上下拉监听方法
        rvEssay.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            //下拉刷新
            public void onRefresh() {
                setEssayByGam();
            }

            @Override
            //上拉加载
            public void onLoadMore() {
                setEssayByGam();
                rvEssay.loadMoreComplete();
            }
        });
        //滑动监听
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    toolbar.setVisibility(View.VISIBLE);
                } else {
                    toolbar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    // 设置圈子View
    private void setQuanListView() {
        if (lvQuan != null) {
            if (gams == null) {
                gams = new ArrayList<Gam>();
            }
            if (quanAdapter == null) {
                quanAdapter = new MainQuanAdapter(getActivity(), gams);
                lvQuan.setAdapter(quanAdapter);
            } else {
                quanAdapter.refresh(gams);
            }
        }
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

    @Override
    public String getUserId() {
        return "";
    }

    @Override
    public void setMainGams(List<Gam> datas) {
        this.gams = datas;
        setQuanListView();
        if (StringUtils.isEmptyString(gamId) && this.gams != null && this.gams.size() > 0) {
            gam = this.gams.get(0);
            setEssayByGam();
        }
    }

    // 根据圈子设置GAM
    private void setEssayByGam() {
        if (gam != null) {
            gamId = gam.id;
            tvQuanName.setText(StringUtils.reviseEmpty(gam.name));
            pHome.reqEssayByGamId();
        }
    }

    @Override
    public String getGamId() {
        return gamId;
    }

    @Override
    public void setEssays(List<Essay> datas) {
        this.essays = datas;
        setEssayListView();
    }
}