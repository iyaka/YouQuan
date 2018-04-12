
package com.youquan.main.core.adapter;

import java.util.List;

import com.base.BAdapter;
import com.base.BHolder;
import com.util.PicassoUtils;
import com.util.StringUtils;
import com.youquan.R;
import com.youquan.custom.RoundImageView;
import com.youquan.main.model.Gam;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class MainQuanAdapter extends BAdapter<Gam> {
    public MainQuanAdapter(Context context, List<Gam> matters) {
        super(context, matters);
    }

    @Override
    public View getView(Gam t, View view) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_main_quan, null);
        }
        TextView tvName = BHolder.get(view, R.id.tvName);
        final RoundImageView riv = BHolder.get(view, R.id.riv);
        // 设置数据
        tvName.setText(StringUtils.reviseEmpty(t.name));
        PicassoUtils.loadUrlPic(context, riv, StringUtils.reviseEmpty(t.photo));
        riv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return view;
    }

}
