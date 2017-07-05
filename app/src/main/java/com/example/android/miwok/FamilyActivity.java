package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.colors;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        // Create a list of words
        final ArrayList<Word> w = new ArrayList<Word>();
        w.add(new Word("father", "әpә",R.drawable.family_father,R.raw.family_father));
        w.add(new Word("mother", "әṭa",R.drawable.family_mother,R.raw.family_mother));
        w.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        w.add(new Word("daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter));
        w.add(new Word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        w.add(new Word("younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        w.add(new Word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        w.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        w.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        w.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this,w,R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.activity_family);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=w.get(position);
                final MediaPlayer mediaPlayer = MediaPlayer.create(FamilyActivity.this,word.getaudioResourceId());
                mediaPlayer.start();
            }
        });

    }
}
