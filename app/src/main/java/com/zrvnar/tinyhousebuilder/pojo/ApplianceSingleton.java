package com.zrvnar.tinyhousebuilder.pojo;

import java.util.ArrayList;

public class ApplianceSingleton {
    private static ApplianceSingleton mInstance;
    private ArrayList<Appliance> applianceArrayList = null;

    public static ApplianceSingleton getInstance(){
        if (mInstance == null){
            mInstance = new ApplianceSingleton();
        }
            return  mInstance;
    }

    private ApplianceSingleton(){
        applianceArrayList = new ArrayList<Appliance>();
    }

    public ArrayList<Appliance> getApplianceArrayList(){
        return this.applianceArrayList;
    }


}
