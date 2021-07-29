package com.shakibmansoori.sqlitedatabaseoperations.Activities;

public class Model {

    private int mImgViewid;
    private String mTitle;
    private String mSubtitle;

    Model(int mImgViewid, String mTitle, String mSubtitle) {

        this.mImgViewid = mImgViewid;
        this.mTitle = mTitle;
        this.mSubtitle = mSubtitle;

    }

    public Model(String mTitle) {

        this.mTitle = mTitle;
    }


    public int getmImgViewid() {
        return mImgViewid;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSubtitle() {
        return mSubtitle;
    }
}
