package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;

import static com.example.android.miwok.R.id.phrases;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        // Create a list of words
        final ArrayList<Word> w = new ArrayList<Word>();
        w.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        w.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        w.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        w.add(new Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        w.add(new Word("I’m feeling good", "kuchi achit",R.raw.phrase_im_feeling_good));
        w.add(new Word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        w.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        w.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        w.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        w.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        phrasesAdapter adapter = new phrasesAdapter(this,w,R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.activity_phrases);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word=w.get(position);
                final MediaPlayer mediaPlayer = MediaPlayer.create(PhrasesActivity.this,word.getaudioResourceId());
                mediaPlayer.start();
            }
        });
    }
}
