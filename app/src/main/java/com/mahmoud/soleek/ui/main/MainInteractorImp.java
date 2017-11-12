package com.mahmoud.soleek.ui.main;

import android.util.Log;

import com.mahmoud.soleek.data.RetrofitClient;
import com.mahmoud.soleek.data.ServicesInterface;
import com.mahmoud.soleek.data.models.TipModel;
import com.mahmoud.soleek.data.models.TodoModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud on 11/11/2017.
 */

public class MainInteractorImp implements MainInterActor {


    @Override
    public void loadData(final OnTodoCompletedListner onTodoCompletedListner, final OnTipCompletedListner onTipCompletedListner) {

        RetrofitClient.getClient().create(ServicesInterface.class).getTips().enqueue(new Callback<TipModel>() {
            @Override
            public void onResponse(Call<TipModel> call, Response<TipModel> response) {
                try {
                    Log.d("MahmoudTag", response.body().toString());
                    onTipCompletedListner.onGetTipSuccess(response.body().getData());

                } catch (Exception ex) {
                    ex.printStackTrace();
                    onTipCompletedListner.onGetTipFail();
                }
            }

            @Override
            public void onFailure(Call<TipModel> call, Throwable t) {
                t.printStackTrace();
                onTipCompletedListner.onGetTipFail();
            }
        });

        RetrofitClient.getClient().create(ServicesInterface.class).getTodos().enqueue(new Callback<TodoModel>() {
            @Override
            public void onResponse(Call<TodoModel> call, Response<TodoModel> response) {
                try {
                    Log.d("MahmoudTag", response.body().toString());

                    onTodoCompletedListner.onGetTodoSuccess(response.body().getData());

                } catch (Exception ex) {
                    ex.printStackTrace();
                    onTodoCompletedListner.onGetTodoFail();
                }
            }

            @Override
            public void onFailure(Call<TodoModel> call, Throwable t) {
                t.printStackTrace();
                onTodoCompletedListner.onGetTodoFail();
            }
        });


    }
}
