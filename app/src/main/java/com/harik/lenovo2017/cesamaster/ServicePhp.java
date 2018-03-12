package com.harik.lenovo2017.cesamaster;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by lenovo on 3/5/2018.
 */

public class ServicePhp extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ServicePhp(String name) {
        super("cesa");
    }
public ServicePhp(){
    super("process school");
}
    @Override
    protected void onHandleIntent(Intent intent) {
      String nom=  intent.getStringExtra("nom");
        String adresse=intent.getStringExtra("adresse");
        JSONObject js=new JSONObject();//{}
        try {
            js.put("nom",nom);//{"nom":nom}
            js.put("adresse",adresse);

        } catch (JSONException e) {
            e.printStackTrace();
            //signaler une erreur dans le journal log
            Log.e("erreur json",e.getMessage());
        }
        try {

            //10.0.2.2
         String reponse =   Utils.post("http://192.168.1.119/androservice/add.php",js.toString());
        Intent i =new Intent("messagewsale");
            i.putExtra("reponse",reponse);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sendBroadcast(i);

        } catch (IOException e) {
            Log.e("erreur post serveur",e.getMessage());
        }



    }
}
