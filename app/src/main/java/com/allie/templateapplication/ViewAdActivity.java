package com.allie.templateapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.allie.templateapplication.model.Advertisement;

/**
 * Created by tcox on 11/1/17.
 */

public class ViewAdActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewholder_ad);
        Intent i = getIntent();
        Advertisement advertisement = i.getParcelableExtra("AdvertisementParcel");

        View view =  (View) findViewById(R.id.ad_view);
        view.setBackgroundColor(Color.parseColor(advertisement.getColor()));
        view.setVisibility(View.VISIBLE);

    }
}
