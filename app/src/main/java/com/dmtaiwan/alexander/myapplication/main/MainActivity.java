package com.dmtaiwan.alexander.myapplication.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dmtaiwan.alexander.myapplication.R;
import com.dmtaiwan.alexander.myapplication.models.MainItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainListener{

    private static final String KEY_STATE = "com.dmtaiwan.alexander.state";


    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private Parcelable layoutState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //restore state if it exists
        if (savedInstanceState != null) {
            layoutState = savedInstanceState.getParcelable(KEY_STATE);
        }

        //Setup recycler view
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        adapter = new MainAdapter();

        //Get data
        MainAsyncTask asyncTask = new MainAsyncTask(this);
        asyncTask.execute();

    }

    @Override
    public void returnResults(ArrayList<MainItem> items) {
        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adapter.setData(items);
        recyclerView.setAdapter(adapter);

        //restore state if it exists
        if (layoutState != null) {
            recyclerView.getLayoutManager().onRestoreInstanceState(layoutState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Parcelable parcelable = recyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable(KEY_STATE, parcelable);
    }
}
