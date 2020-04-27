package com.example.mytest2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String a=null;
    String b=null;
    String c=null;
    int output=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a=getIntent().getStringExtra("Input1");
        b=getIntent().getStringExtra("Input2");
        c=getIntent().getStringExtra("Action");

        if(a!=null && b!=null && c!=null) {
            if (c.equals("Addition")) {
                output=Integer.parseInt(a) + Integer.parseInt(b);
//                Intent sendIntent = new Intent("com.example.1");
//                sendIntent.putExtra("result",output);
//                sendBroadcast(sendIntent);



                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.mytest1");
                launchIntent.putExtra("result",output);
                if (launchIntent != null) {
                    startActivity(launchIntent);

                }



            } else {
                output=Integer.parseInt(a) - Integer.parseInt(b);
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.mytest1");
                launchIntent.putExtra("result",output);
                if (launchIntent != null) {
                    startActivity(launchIntent);

                }
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please Install the othe App",Toast.LENGTH_SHORT).show();
        }


    }
}
