package com.example.suryanarayan.sample.ExpandDrawer.data;

/**
 * Created by awidiyadew on 12/09/16.
 */
public class BaseItem {
    private String mName;
    private int image;

    // for group items
    public BaseItem(String name) {
        mName = name;
    }

    //for only the item


    public String getName() {
        return mName;
    }


}
