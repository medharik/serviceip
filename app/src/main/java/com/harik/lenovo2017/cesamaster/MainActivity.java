package com.harik.lenovo2017.cesamaster;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity  {
Button tester;
    EditText enom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      enom= (EditText) findViewById(R.id.juste);
        tester= (Button) findViewById(R.id.saber);
        tester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Bienvenue "+enom.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
