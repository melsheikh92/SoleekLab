package com.mahmoud.soleek.data;

import com.mahmoud.soleek.data.models.TipModel;
import com.mahmoud.soleek.data.models.TodoModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Mahmoud on 11/11/2017.
 */

public interface ServicesInterface {

    @POST("guest_todos")
    Call<TodoModel> getTodos();

    @GET("tips")
    Call<TipModel> getTips();
}
