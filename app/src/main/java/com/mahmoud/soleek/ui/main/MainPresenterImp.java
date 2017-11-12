package com.mahmoud.soleek.ui.main;

import com.mahmoud.soleek.data.models.Tip;
import com.mahmoud.soleek.data.models.Todo;

import java.util.List;

/**
 * Created by Mahmoud on 11/11/2017.
 */

public class MainPresenterImp implements MainPresenter, MainInterActor.OnTipCompletedListner, MainInterActor.OnTodoCompletedListner {

    MainView mainView;
    MainInterActor interActor;

    public MainPresenterImp(MainView mainView) {

        this.mainView = mainView;
        interActor = new MainInteractorImp();
    }

    @Override
    public void onResume() {
        interActor.loadData(this, this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }


    @Override
    public void onGetTipSuccess(List<Tip> tips) {
        if (mainView != null)
            mainView.onSuccessLoadingTips(tips);
    }

    @Override
    public void onGetTipFail() {
        if (mainView != null)

            mainView.onFailLoading();
    }

    @Override
    public void onGetTodoSuccess(List<Todo> todos) {
        if (mainView != null)

            mainView.onSuccessLoadingTodos(todos);
    }

    @Override
    public void onGetTodoFail() {
        mainView.onFailLoading();

    }
}
