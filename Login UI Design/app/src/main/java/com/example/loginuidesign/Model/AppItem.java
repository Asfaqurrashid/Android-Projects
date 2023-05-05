package com.example.loginuidesign.Model;

import java.util.List;

public class AppItem {
    private String appName;
    private double appRating;


    public AppItem(String appName, double appRating) {
        this.appName = appName;
        this.appRating = appRating;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public double getAppRating() {
        return appRating;
    }

    public void setAppRating(double appRating) {
        this.appRating = appRating;
    }


}
