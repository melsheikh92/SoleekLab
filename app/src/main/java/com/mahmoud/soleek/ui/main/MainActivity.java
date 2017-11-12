package com.mahmoud.soleek.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mahmoud.soleek.R;
import com.mahmoud.soleek.data.models.Tip;
import com.mahmoud.soleek.data.models.Todo;
import com.mahmoud.soleek.ui.NewLoveStoryActivity;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.ArrayList;
import java.util.List;

import az.plainpie.PieView;
import az.plainpie.animation.PieAngleAnimation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_days)
    TextView tvDays;
    @BindView(R.id.tv_hours)
    TextView tvHours;
    @BindView(R.id.tv_mins)
    TextView tvMins;
    @BindView(R.id.tv_sec)
    TextView tvSec;
    @BindView(R.id.tv_addcover)
    TextView tvAddcover;
    @BindView(R.id.pieView)
    PieView pieView;
    @BindView(R.id.rv_tips)
    RecyclerView rvTips;
    @BindView(R.id.rv_todo)
    RecyclerView rvTodo;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    Context mcontext;
    int counter = 0;
    MainPresenter presenter;
    List<Tip> tipsList;
    List<Todo> todoList;
    TipsAdapter tipsAdapter;
    TodoAdapter todoAdapter;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        mcontext = this;
        init();
        presenter = new MainPresenterImp(this);
        showProgressBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void init() {
        pieView.setPercentageBackgroundColor(getResources().getColor(R.color.colorPrimary));
        pieView.setMainBackgroundColor(getResources().getColor(R.color.colorBg));
        pieView.setInnerBackgroundColor(getResources().getColor(R.color.colorWhite));
        pieView.setTextColor(getResources().getColor(R.color.colorPrimary));
        PieAngleAnimation animation = new PieAngleAnimation(pieView);
        animation.setDuration(3000);
        pieView.startAnimation(animation);
        pieView.setInnerText("50%");
        pieView.setPercentageTextSize(28);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mcontext, 1);
        rvTips.setLayoutManager(mLayoutManager);
        rvTips.setItemAnimator(new DefaultItemAnimator());
        rvTips.setNestedScrollingEnabled(false);
        tipsList = new ArrayList<Tip>();
        tipsAdapter = new TipsAdapter(mcontext, tipsList);
        rvTips.setAdapter(tipsAdapter);
        RecyclerView.LayoutManager mLayoutManager2 = new GridLayoutManager(mcontext, 1);

        rvTodo.setLayoutManager(mLayoutManager2);
        rvTodo.setItemAnimator(new DefaultItemAnimator());
        rvTodo.setNestedScrollingEnabled(false);
        todoList = new ArrayList<Todo>();
        todoAdapter = new TodoAdapter(mcontext, todoList);
        rvTodo.setAdapter(todoAdapter);

    }

    @Override
    public void onFailLoading() {
        Toast.makeText(mcontext, "Error while loading data", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccessLoadingTodos(List<Todo> todos) {
        this.todoList = todos;
        todoAdapter = new TodoAdapter(mcontext, todoList);
        rvTodo.setAdapter(todoAdapter);
        counter++;
        if (counter < 2) {
            hideProgressBar();
        }
    }

    @Override
    public void onSuccessLoadingTips(List<Tip> tips) {

        this.tipsList = tips;
        tipsAdapter = new TipsAdapter(mcontext, tipsList);
        rvTips.setAdapter(tipsAdapter);
        counter++;
        if (counter < 2) {
            hideProgressBar();
        }
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);

    }

    @OnClick({R.id.tv_addcover, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_addcover:

                PickImageDialog.build(new IPickResult() {

                    @Override
                    public void onPickResult(PickResult pickResult) {
                        imageView.setImageBitmap(pickResult.getBitmap());
                    }
                }).show(this);


                break;
            case R.id.fab:
                Intent intent = new Intent(this, NewLoveStoryActivity.class);
                startActivity(intent);
                break;
        }
    }
}
