package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.NumberingSystem;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView numbers=(TextView)findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent NumbersIntent=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(NumbersIntent);
            }
        });

        TextView FamilyMembers=(TextView)findViewById(R.id.family);
        FamilyMembers.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(familyIntent);
            }
        }));


        TextView Colors=(TextView)findViewById(R.id.colors);
        Colors.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorsIntent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorsIntent);
            }
        }));
        TextView Phrases=(TextView)findViewById(R.id.phrases);
        Phrases.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        }));

    }





}
