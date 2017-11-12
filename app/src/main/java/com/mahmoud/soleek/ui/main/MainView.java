package com.mahmoud.soleek.ui.main;

import com.mahmoud.soleek.data.models.Tip;
import com.mahmoud.soleek.data.models.Todo;

import java.util.List;

/**
 * Created by Mahmoud on 11/11/2017.
 */

public interface MainView {
    void init();

    void onFailLoading();

    void onSuccessLoadingTodos(List<Todo> todos);

    void onSuccessLoadingTips(List<Tip> tips);

    void showProgressBar();

    void hideProgressBar();
}
