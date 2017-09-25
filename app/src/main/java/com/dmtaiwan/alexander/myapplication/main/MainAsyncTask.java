package com.dmtaiwan.alexander.myapplication.main;

import android.os.AsyncTask;

import com.dmtaiwan.alexander.myapplication.models.MainItem;

import java.util.ArrayList;

/**
 * Created by Alexander on 9/25/2017.
 */

public class MainAsyncTask extends AsyncTask<Void, Void, ArrayList<MainItem>> {

    private static final int NUM_OF_ITEMS = 100;
    private ArrayList<MainItem> items;
    private MainListener listener;

    public MainAsyncTask(MainListener listener) {
        this.listener = listener;
    }


    @Override
    protected ArrayList<MainItem> doInBackground(Void... voids) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        items = new ArrayList<>();
        for(int i = 0; i < NUM_OF_ITEMS; i++) {
            MainItem item = new MainItem(i);
            items.add(item);
        }
        return items;
    }

    @Override
    protected void onPostExecute(ArrayList<MainItem> items) {
        super.onPostExecute(items);
        listener.returnResults(items);
    }
}
