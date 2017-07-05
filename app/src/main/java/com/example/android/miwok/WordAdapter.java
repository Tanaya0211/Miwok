package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.os.WorkSource;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.x;
import static com.example.android.miwok.R.id.colors;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Created by SANKET on 2/4/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> androidword,int ColorResourceId){
        super(context,0,androidword);
        mColorResourceId=ColorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_textview);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(currentword.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_textview);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentword.getDefaultTranslation());


        ImageView imageview=(ImageView)listItemView.findViewById(R.id.image);
        if(currentword.hasImage()){
            imageview.setImageResource(currentword.getImageResourceId());
            imageview.setVisibility(View.VISIBLE);
            int color = ContextCompat.getColor(getContext(),R.color.tan_background);
            imageview.setBackgroundColor(color);
        }
        else if(!currentword.hasImage())
        {
            imageview.setVisibility(View.INVISIBLE);
        }


        /**
         * setting color to the background
         */
        View textcontainer =listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textcontainer.setBackgroundColor(color);
        return listItemView;
    }
}
