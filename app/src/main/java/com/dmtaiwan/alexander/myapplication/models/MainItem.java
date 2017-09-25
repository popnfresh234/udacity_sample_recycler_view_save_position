package com.dmtaiwan.alexander.myapplication.models;

/**
 * Created by Alexander on 9/25/2017.
 */

public class MainItem {

    private int itemNumber;

    public MainItem(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDescription() {
        return "This is item number: " + itemNumber;
    }
}
