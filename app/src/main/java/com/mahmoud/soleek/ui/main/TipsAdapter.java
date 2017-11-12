package com.mahmoud.soleek.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahmoud.soleek.R;
import com.mahmoud.soleek.data.models.Tip;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mahmoud on 11/11/2017.
 */

public class TipsAdapter extends RecyclerView.Adapter<TipsAdapter.CustomViewHolder> {

    List<Tip> tipsList;
    Context mcontext;
    View itemView;


    public TipsAdapter(Context mcontext, List<Tip> tipsList) {
        this.mcontext = mcontext;
        this.tipsList = tipsList;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_tips, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Tip tip = tipsList.get(position);
        holder.textView.setText(tip.getTitle());


    }

    @Override
    public int getItemCount() {
        return tipsList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_numb)
        ImageView ivNumb;
        @BindView(R.id.textView)
        TextView textView;


        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(CustomViewHolder.this, itemView);
        }
    }
}
