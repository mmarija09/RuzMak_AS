package com.example.marijampipsem.rm_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    EditText editText;
    Button addButton;
    ListView listView;
    //ListView listView2;
    ArrayList<String> listItems;
    ArrayList<String> listItems2;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    int numb;
    generateRandomNumber grn = new generateRandomNumber();
    int random = grn.getNumb();
    findTrue ft = new findTrue();
    findMak fm = new findMak();
    checkFoZeroes cfz = new checkFoZeroes();
    String r;
    String m;
    String out;
    TextView tv;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = (EditText) findViewById(R.id.editText);
        addButton = (Button) findViewById(R.id.addItem);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button)findViewById(R.id.button);
        //listView2 = (ListView) findViewById(R.id.listView2);

        tv = (TextView) findViewById(R.id.textView);
        listItems = new ArrayList<String>();
        listItems2 = new ArrayList<String>();
        listItems.add( "Your guess : ");


        numb = grn.getNumb();
        tv.setText(String.valueOf(numb));
        tv.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setMessage("Are you sure?");
                builder.setCancelable(true);

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        tv.setVisibility(View.VISIBLE);
                        editText.setEnabled(false);
                        addButton.setEnabled(false);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //alert.dismiss();
                    }
                });


                final AlertDialog alert = builder.create();
                alert.show();
            }
        });

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);

        adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems2); // za listItems2

        listView.setAdapter(adapter);
        //listView2.setAdapter(adapter2);

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                cfz = new checkFoZeroes();
                if(editText.getText().length() == 0 || editText.getText().length() < 4)
                {
                    editText.setError("Invalid input. Please enter four digit number");
                    editText.setText("");
                }
                else {

                    if(cfz.checkZeroes(Integer.parseInt(editText.getText().toString())))
                    {
                        editText.setError("You number can not contain digit 0");
                        //editText.setError(null);
                        //listItems.add("broj so nula");
                        listItems2.add("");
                        editText.setText("");
                    }
                    else
                        {


                        int et = Integer.parseInt(editText.getText().toString());
                                r = Integer.toString(ft.checkRuz(et , random));
                        m = Integer.toString(Integer.valueOf(fm.checkMak(et , random)));
                        if( Integer.parseInt(r) == 4)
                        {
                            out = "                 " + "R:" + r + "   M:" + m;
                            listItems.add(editText.getText().toString() + out);
                            listItems.add("YOU WON");
                            adapter.notifyDataSetChanged();
                            addButton.setEnabled(false);
                            final AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                            builder.setMessage("YOU WON");
                            builder.setCancelable(true);
                              builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    finish();
                                }
                            });


                              AlertDialog alert = builder.create();
                              alert.show();
                        }
                        else {
                            out = "                 " + "R:" + r + "   M:" + m;
                            listItems.add(editText.getText().toString() + out);
                            adapter.notifyDataSetChanged();
                            //listItems2.add(out);
                            //adapter2.notifyDataSetChanged();
                            editText.getText().clear();
                        }
                    }
                }


            }
        });








        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                Toast.makeText(Main2Activity.this, "Clicked", Toast.LENGTH_LONG)
                        .show();

            }
        });
    }
}





