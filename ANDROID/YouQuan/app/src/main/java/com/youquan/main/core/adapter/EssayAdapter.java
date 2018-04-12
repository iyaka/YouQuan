package com.youquan.main.core.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.base.BHolder;
import com.util.PicassoUtils;
import com.util.StringUtils;
import com.youquan.R;
import com.youquan.custom.RoundImageView;
import com.youquan.custom.grid.MyGridView;
import com.youquan.main.model.Essay;

import java.util.List;

public class EssayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Essay> essays;

    public EssayAdapter(Context context, List<Essay> essays) {
        this.context = context;
        this.essays = essays;
    }

    public void refresh(List<Essay> essays) {
        this.essays = essays;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HoldView(LayoutInflater.from(context).inflate(R.layout.item_essay, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HoldView holdView = (HoldView) holder;
        Essay t = essays.get(position);
        // 设置数据
        if (holdView != null && t != null) {
            if (t.user != null) {
                holdView.tvName.setText(StringUtils.reviseEmpty(t.user.name));
                PicassoUtils.loadUrlPic(context, holdView.riv, StringUtils.reviseEmpty(t.user.photo));
                holdView.riv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }
            holdView.tvTime.setText(t.createTimeChar);
            holdView.tvContent.setText(StringUtils.reviseEmpty(t.content));
            holdView.tvLaud.setText(t.laud == null ? "" : String.valueOf(t.laud));
            holdView.tvComment.setText(t.comment == null ? "" : String.valueOf(t.comment));
            holdView.tvForword.setText(t.forword == null ? "" : String.valueOf(t.forword));
            holdView.myGridView.setIsShowAll(false);
            holdView.myGridView.setUrl(StringUtils.reviseEmpty(t.picture));
            holdView.ivMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return essays.size();
    }

    private class HoldView extends RecyclerView.ViewHolder {
        TextView tvName, tvTime, tvContent, tvLaud, tvComment, tvForword;
        ImageView ivMore;
        RoundImageView riv;
        MyGridView myGridView;

        public HoldView(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvLaud = itemView.findViewById(R.id.tvLaud);
            tvComment = itemView.findViewById(R.id.tvComment);
            tvForword = itemView.findViewById(R.id.tvForword);
            ivMore = itemView.findViewById(R.id.ivMore);
            riv = itemView.findViewById(R.id.riv);
            myGridView = itemView.findViewById(R.id.myGridView);
        }
    }
}
