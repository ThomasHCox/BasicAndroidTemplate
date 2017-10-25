package com.allie.templateapplication.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.allie.templateapplication.R;
import com.allie.templateapplication.model.Advertisement;

/**
 * Created by tcox on 10/19/17.
 */

public class AdViewHolder extends RecyclerView.ViewHolder{

    private View mAdViewLayout;


    public AdViewHolder(View itemView) {
        super(itemView);
        mAdViewLayout = itemView.findViewById(R.id.ad_view);


    }

    public void bind(Advertisement advertisement){
        mAdViewLayout.setBackgroundColor(444);
    }


}
