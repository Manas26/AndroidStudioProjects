package com.example.android.lesson5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void makeCookie(View view) {

        ImageView img =  (ImageView) findViewById(R.id.android_cookie_image_view);
        img.setImageResource(R.drawable.before_cookie);

        TextView text = (TextView) findViewById(R.id.status_text_view);
        text.setText("I am so Hungry");
        // TODO: Find a reference to the ImageView in the layout. Change the image.

        // TODO: Find a reference to the TextView in the layout. Change the text.

    }


    public void eatCookie(View view) {

        ImageView img =  (ImageView) findViewById(R.id.android_cookie_image_view);
        img.setImageResource(R.drawable.after_cookie);

        TextView text = (TextView) findViewById(R.id.status_text_view);
        text.setText("I am so Full");
        // TODO: Find a reference to the ImageView in the layout. Change the image.

        // TODO: Find a reference to the TextView in the layout. Change the text.

    }
}