package com.mahmoud.soleek.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mahmoud.soleek.R;
import com.mahmoud.soleek.data.models.Todo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mahmoud on 11/11/2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.CustomViewHolder> {

    List<Todo> todoList;
    Context mcontext;
    View itemView;


    public TodoAdapter(Context mcontext, List<Todo> todoList) {
        this.todoList = todoList;
        this.mcontext = mcontext;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_todo, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Todo todo = todoList.get(position);
         holder.tvTxt.setText(todo.getTitle());
        //  holder.radioBtn.setChecked(todo.);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_txt)
        TextView tvTxt;
        @BindView(R.id.radioBtn)
        RadioButton radioBtn;

        public CustomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(CustomViewHolder.this, itemView);
        }
    }
}
