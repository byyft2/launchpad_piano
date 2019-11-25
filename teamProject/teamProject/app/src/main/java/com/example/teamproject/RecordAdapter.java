package com.example.teamproject;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {
    private ArrayList<String> mDataset;
    private Activity activity;

    public static class RecordViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public RecordViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public RecordAdapter(Activity activity, ArrayList<String>  myDataset) {
        mDataset = myDataset;
        this.activity = activity;
    }

    @Override
    public RecordAdapter.RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new RecordViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(final RecordViewHolder holder, int position) {

        CardView cardView = holder.cardView;
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("profilePath",mDataset.get(holder.getAdapterPosition()));
                activity.setResult(Activity.RESULT_OK,resultIntent);
                activity.finish();
//                finish라 뒤로가기 다시해줘야됨?
            }
        });
        TextView card_btn = cardView.findViewById(R.id.card_btn);
        card_btn.setText(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
