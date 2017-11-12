package com.mahmoud.soleek.ui.main;

import com.mahmoud.soleek.data.models.Tip;
import com.mahmoud.soleek.data.models.Todo;

import java.util.List;

/**
 * Created by Mahmoud on 11/11/2017.
 */

public interface MainInterActor {

    interface OnTodoCompletedListner {
        void onGetTodoSuccess(List<Todo> todos);

        void onGetTodoFail();
    }

    interface OnTipCompletedListner {
        void onGetTipSuccess(List<Tip> tips);

        void onGetTipFail();
    }

    void loadData(OnTodoCompletedListner onTodoCompletedListner, OnTipCompletedListner onTipCompletedListner);


}
