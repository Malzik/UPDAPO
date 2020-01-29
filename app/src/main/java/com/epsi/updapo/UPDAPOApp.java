package com.epsi.updapo;

import android.app.Application;

public class UPDAPOApp extends Application {

    private String title = "";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
