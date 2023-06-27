package com.example.juegodsarest3.activities;

import java.util.ArrayList;
import java.util.List;

//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.Insignia;
import com.squareup.picasso.Picasso;

public class AdaptadorInsignia extends RecyclerView.Adapter<AdaptadorInsignia.ViewHolder> {
    private List<Insignia> values;


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;

        public ImageView icon;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.txtnombreinsignia);
            icon = (ImageView) v.findViewById(R.id.iconinsignia);

        }
    }

    public void setData(List<Insignia> myDataset) {
        values = myDataset;
        notifyDataSetChanged();
    }

    public void add(int position, Insignia item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public AdaptadorInsignia(){values = new ArrayList<>();}

    public AdaptadorInsignia(List<Insignia> myDataset) {
        values = myDataset;
    }


    @Override
    public AdaptadorInsignia.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.activity_row_layout_insignias, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Insignia ra = values.get(position);
        final String name = ra.getNombreinsignia();
        holder.txtHeader.setText(name);

        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove (holder.getAdapterPosition());
            }
        });

        Picasso.get().load(ra.getAvatar()).into(holder.icon);

    }


    @Override
    public int getItemCount() {
        return values.size();
    }


}