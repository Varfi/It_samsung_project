package com.example.myapplication.data;

import android.app.Application;

import com.example.myapplication.models.OptionsObject;

import java.util.ArrayList;
import java.util.List;

public class Options extends Application {
    private List<OptionsObject> globalList = new ArrayList<>();

    public List<OptionsObject> getGlobalList() {
        return globalList;
    }

    public void addToGlobalList(OptionsObject obj) {
        globalList.add(obj);
    }

    public void removeFromGlobalList(OptionsObject obj) {
        globalList.remove(obj);
    }
}
