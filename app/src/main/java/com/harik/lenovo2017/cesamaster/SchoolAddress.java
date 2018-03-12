package com.harik.lenovo2017.cesamaster;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class SchoolAddress extends Activity implements View.OnClickListener {
Button badd;
    EditText enom,eadresse;
    Recepteur juste;
ProgressDialog prd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_address);
    enom= (EditText) findViewById(R.id.enom);
        eadresse= (EditText) findViewById(R.id.eadresse);
        badd= (Button) findViewById(R.id.bajouter);
        badd.setOnClickListener(this);

  juste=new Recepteur();

registerReceiver(juste,new IntentFilter("messagewsale"));
    }

class Recepteur extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
String reponseServeur=intent.getStringExtra("reponse");
        Toast.makeText(SchoolAddress.this, "Reponse au serveur "+reponseServeur, Toast.LENGTH_SHORT).show();
        Vibrator v= (Vibrator) getSystemService(VIBRATOR_SERVICE);
        v.vibrate(3000);
        TextView tvz= (TextView) findViewById(R.id.grandzero);
        tvz.setText(reponseServeur);
        if(prd.isShowing()){
            prd.dismiss();
        }

    }
}

    @Override
    protected void onDestroy() {
        unregisterReceiver(juste);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int ids = v.getId();
        switch (ids){
            case R.id.bajouter :
                prd=new ProgressDialog(SchoolAddress.this);
                prd.setTitle("envoie ....");
                prd.setMessage("envoie en cours....");
                prd.show();
                //recup des infos depuis l'interface
                String nom=enom.getText().toString();
                String adresse=eadresse.getText().toString();
//on crée une intent
                Intent message=new Intent(SchoolAddress.this,ServicePhp.class);
                message.putExtra("nom",nom);
                message.putExtra("adresse",adresse);
                startService(message);
                break;

        }
    }
}
