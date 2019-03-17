package com.example.marijampipsem.rm_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b_single = (Button)findViewById(R.id.btnSingle);
        b_single.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                openSinglePlayer();
            }
        });
        Button b_multi = (Button) findViewById(R.id.btnMulti);
        b_multi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                openMultiPlayer();
            }
        });

    }
    public void openMultiPlayer()
    {
        Toast.makeText(MainActivity.this, "currently unavailable", Toast.LENGTH_LONG)
                .show();
        //Intent intent2 = new Intent(this , Main3Activity.class);
        //startActivity(intent2);
    }

    public void openSinglePlayer()
    {
        Intent intent = new Intent(this , Main2Activity.class);
        startActivity(intent);
    }
}
