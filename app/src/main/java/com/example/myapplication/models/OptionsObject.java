package com.example.myapplication.models;

public class OptionsObject {
    String name;
    String serves;
    String actionFunction;
    Boolean isOn = Boolean.TRUE;

    public OptionsObject(String name, String serves, String actionFunction, Boolean isOn){
        this.name = name;
        this.serves = serves;
        this.actionFunction = actionFunction;
        this.isOn = isOn;
    }

    public boolean isChecked() {
        return isOn;
    }

    public void setChecked(boolean checked) {
        isOn = checked;
    }

    public String getName() {
        return name;
    }

    public String getServes() {
        return serves;
    }

    public String getFunction() {
        return actionFunction;
    }



    public void CallFunction(String actionFunction){

    }

}
