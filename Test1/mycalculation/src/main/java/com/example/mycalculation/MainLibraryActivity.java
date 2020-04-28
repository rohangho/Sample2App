package com.example.mycalculation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainLibraryActivity extends AppCompatActivity {

    String a;
    String b;
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_library);

        a=getIntent().getStringExtra("Input1");
        b=getIntent().getStringExtra("Input2");
        c=getIntent().getStringExtra("Action");

        if(a!=null && b!=null && c!=null)
        {

            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.mytest2");
            launchIntent.putExtra("Input1",a);
            launchIntent.putExtra("Input2",b);
            launchIntent.putExtra("Action",c);
            if (launchIntent != null) {

                startActivity(launchIntent);



            }

            else
            {
                Toast.makeText(getApplicationContext(),"Please Install the other app",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getIntent().getExtras()!=null) {
            Intent intent=new Intent();
            intent.putExtra("abcd", getIntent().getExtras().getInt("result"));
            intent.putExtra("efgh", getIntent().getExtras().getString("input1"));
            intent.putExtra("ijkl", getIntent().getExtras().getString("input2"));
            intent.putExtra("mnop", getIntent().getExtras().getString("action"));
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }
}
