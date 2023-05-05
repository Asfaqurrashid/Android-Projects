package com.example.loginuidesign.Model;

import android.icu.lang.UProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataManager {

    private String headerTitle;
    private final ArrayList<AppItem> apps = new ArrayList<>();

    public DataManager() {
        addAppItems();
    }

    public String getHeaderTitle(){
        return headerTitle;
    }
    public void setHeaderTitle(String headerTitle){
        this.headerTitle = headerTitle;
    }

    private void addAppItems() {

        apps.add(
                new AppItem(
                        "Feather AI: Essays Writing GPT",
                        -1

                )
        );
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5

                        )
        );
        apps.add(
                new AppItem(
                        "Speak Pal - English practice",
                        4.4


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5


                )
        );

        // todo: change data of the following item
        apps.add(
                new AppItem(
                        "Official Cambridge Guide to IE",
                        3.5

                )
        );
    }

    public ArrayList<AppItem> getApps() {
        return apps;
    }
}
