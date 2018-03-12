package com.harik.lenovo2017.cesamaster;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class IntentServiceDb extends IntentService {


    public IntentServiceDb(){
        super("db");

    }
    public IntentServiceDb(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
String nom=intent.getStringExtra("nom");
String adresse= intent.getStringExtra("adresse");
        JSONObject json=new JSONObject();
        try {
            json.put("nom",nom);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            json.put("adresse",adresse);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            Utils.post("http://10.0.2.2/android/add.php",json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
