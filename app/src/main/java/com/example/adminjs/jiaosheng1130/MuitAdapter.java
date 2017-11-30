package com.example.adminjs.jiaosheng1130;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Adminjs on 2017/11/30.
 */

public class MuitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MultiBean.DataBean> list;

    public MuitAdapter(Context context, List<MultiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

//    public void addData(List<MultiBean.ResultBean.ListBean> list) {
//        if (this.list == null) {
//            this.list = new ArrayList<>();
//        }
//        this.list.addAll(list);
//        notifyDataSetChanged();
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.title.setText(list.get(position).getTitle());
        holder1.name.setText(list.get(position).getSubhead());

        String[] split = list.get(1).getImages().split("\\|");
        Uri uri = Uri.parse(split[0]);
        holder1.simpledraweeview.setImageURI(uri);
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        holder1.simpledraweeview.getHierarchy().setRoundingParams(roundingParams);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpledraweeview)
        SimpleDraweeView simpledraweeview;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
