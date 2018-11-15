package com.example.root.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*
Utilized the following tutorials when constructing this adapter and associated files:
//https://www.androidtutorialpoint.com/material-design/android-custom-gridview-example-image-text/#Working_of_Android_Custom_GridView
//https://www.codingdemos.com/android-cardview-example-with-gridlayout/
*/
public class OutfitHistoryAdapter extends RecyclerView.Adapter<OutfitViewHolder> {

    private List<Outfit> outfitHistory;
    private Context mContext;

    OutfitHistoryAdapter(Context context, List<Outfit> outfits) {
        this.mContext = context;
        this.outfitHistory = outfits;
    }

    @Override
    public OutfitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new OutfitViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final OutfitViewHolder holder, final int position) {
        holder.mDate.setText(outfitHistory.get(position).getDate());
        holder.mImage.setImageResource(outfitHistory.get(position).getImageFile());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, OutfitDetail.class);
                //intent.putExtra("Date", outfitHistory.get(holder.getAdapterPosition()).getDate());
                //intent.putExtra("Image", outfitHistory.get(holder.getAdapterPosition()).getImageFile());
                intent.putExtra("Position", position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return outfitHistory.size();
    }
}

class OutfitViewHolder extends RecyclerView.ViewHolder {
    ImageView mImage;
    TextView mDate;
    CardView mCardView;

    OutfitViewHolder(View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.outfitImage);
        mDate = itemView.findViewById(R.id.outfitDate);
        mCardView = itemView.findViewById(R.id.cardview);
    }
}