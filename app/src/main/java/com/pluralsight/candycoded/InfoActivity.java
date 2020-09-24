package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    public void createMapIntent(View view) {
      uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");

        Intent mapItent = new Intent(Intent.ACTION_VIEW, uri);

        mapItent.setPackage("com.google.android.apps.maps");

         if (mapItent.resolveActivity(getPackageManager()) != null) {
             startActivity(mapItent);
         }
    }

    public void createPhoneIntent(View view) {
        Intent actionIntent = new Intent(Intent.ACTION_DIAL);

        uri = Uri.parse("tel:0123456789");

        actionIntent.setData(uri);
        startActivity(actionIntent);
    }
}
