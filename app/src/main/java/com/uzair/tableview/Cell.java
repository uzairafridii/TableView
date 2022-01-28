package com.uzair.tableview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.evrencoskun.tableview.filter.IFilterableModel;
import com.evrencoskun.tableview.sort.ISortableModel;

public class Cell
{
    private  String mData;

    public Cell( String  data) {
        this.mData = data;
    }


//    public String getContent() {
//        return mData;
//    }


    public String getmData() {
        return mData;
    }
}
