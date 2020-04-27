package com.example.mytest1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import com.example.mycalculation.MainLibraryActivity;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText input1;
    AppCompatEditText input2;
    AppCompatButton addition;
    AppCompatButton substraction;
    AppCompatTextView display1;
    AppCompatTextView display2;
    AppCompatTextView display3;
    AppCompatTextView display4;
    int output;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        input1=findViewById(R.id.input1);
        input2=findViewById(R.id.input2);
        addition=findViewById(R.id.addition);
        substraction=findViewById(R.id.substraction);
        display1=findViewById(R.id.display1);
        display2=findViewById(R.id.display2);
        display3=findViewById(R.id.display3);
        display4=findViewById(R.id.display4);


        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display3.setText("Action : "+"addition");
                Intent intent=new Intent(getApplication(), MainLibraryActivity.class);
                intent.putExtra("Input1",input1.getText().toString());
                intent.putExtra("Input2",input2.getText().toString());
                intent.putExtra("Action","Addition");
                startActivityForResult(intent,1);
            }
        });


        substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display3.setText("Action : "+"substraction");
                Intent intent=new Intent(getApplication(), MainLibraryActivity.class);
                intent.putExtra("Input1",input1.getText().toString());
                intent.putExtra("Input2",input2.getText().toString());
                intent.putExtra("Action","Addition");
                startActivityForResult(intent,1);
            }
        });






    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK)
        {
            display1.setText("Input : " +input1.getText().toString());
            display2.setText("Input : " +input2.getText().toString());
            display3.setVisibility(View.VISIBLE);
            int a=data.getIntExtra("abcd",0);
            display4.setText("output :"+ a);

        }
    }
}
