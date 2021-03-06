package com.allie.templateapplication.viewholders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.allie.templateapplication.R;
import com.allie.templateapplication.ViewAdActivity;
import com.allie.templateapplication.interfaces.IListener;
import com.allie.templateapplication.model.Advertisement;

/**
 * Created by tcox on 10/19/17.
 */

public class AdViewHolder extends RecyclerView.ViewHolder{

    private TextView mAdViewLayout;
    private Context mContext;


    public AdViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mAdViewLayout = (TextView) itemView.findViewById(R.id.ad_color);


    }

    public void bind(Advertisement advertisement, IListener adListener){
        mAdViewLayout.setBackgroundColor(Color.parseColor(advertisement.getColor()));
        mAdViewLayout.setVisibility(View.VISIBLE);
        mAdViewLayout.setText(advertisement.getColor());
        mAdViewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adListener.onAdListener(advertisement);
            }
        });


    }


}
