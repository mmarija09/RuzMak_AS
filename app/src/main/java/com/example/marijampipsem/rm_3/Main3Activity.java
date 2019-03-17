package com.example.marijampipsem.rm_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.Firebase;




public class Main3Activity extends AppCompatActivity {



    public checkFoZeroes cz = new checkFoZeroes();
    EditText editText2;
    Button btn_check;
    Firebase rootRef;


 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        //rootRef.setAndroidContex(this);
        rootRef = new Firebase("https://<your-app>.firebaseio.com/");


        editText2 = (EditText)findViewById(R.id.editText2);
        btn_check = (Button)findViewById(R.id.btn_check);

        btn_check.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                cz = new checkFoZeroes();
                if(editText2.getText().length() == 0 || editText2.getText().length() < 4)
                {
                    editText2.setError("Invalid input. Please enter four digit number");
                    editText2.setText("");
                }
                else {

                    if(cz.checkZeroes(Integer.parseInt(editText2.getText().toString())))
                    {
                        editText2.setError("You number can not contain digit 0");
                        editText2.setText("");
                    }
                    else
                    {
                        btn_check.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                String value;
                                value = editText2.getText().toString();
                                //Map<String, String> userData = new HashMap<String, String>();
                                //Firebase childRef = rootRef.child("Name");
                                //childRef.setValue(value);

                            }
                        });
                    }

            }
        }
    });
    }
}