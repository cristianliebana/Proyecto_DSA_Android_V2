package com.example.juegodsarest3.activities;
import java.util.ArrayList;
import java.util.List;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.Mensaje;

public class AdaptadorMensaje extends RecyclerView.Adapter<AdaptadorMensaje.ViewHolder> {
    private List<Mensaje> values;


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtMensaje;

        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtMensaje = (TextView) v.findViewById(R.id.mensaje);


        }
    }

    public void setData(List<Mensaje> myDataset) {
        values = myDataset;
        notifyDataSetChanged();
    }

    public void add(int position, Mensaje item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public AdaptadorMensaje(){values = new ArrayList<>();}

    public AdaptadorMensaje(List<Mensaje> myDataset) {
        values = myDataset;
    }


    @Override
    public AdaptadorMensaje.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.activity_row_layout_mensaje, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Mensaje f = values.get(position);
        final String mensaje = f.getMensaje();
        holder.txtMensaje.setText(mensaje);

        holder.txtMensaje.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove (holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}