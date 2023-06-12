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
import com.example.juegodsarest3.models.FAQ;

public class AdaptadorFAQ extends RecyclerView.Adapter<AdaptadorFAQ.ViewHolder> {
    private List<FAQ> values;


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtPregunta;
        public TextView txtRespuesta;

        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtPregunta = (TextView) v.findViewById(R.id.pregunta);
            txtRespuesta = (TextView) v.findViewById(R.id.respuesta);


        }
    }

    public void setData(List<FAQ> myDataset) {
        values = myDataset;
        notifyDataSetChanged();
    }

    public void add(int position, FAQ item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public AdaptadorFAQ(){values = new ArrayList<>();}

    public AdaptadorFAQ(List<FAQ> myDataset) {
        values = myDataset;
    }


    @Override
    public AdaptadorFAQ.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.activity_row_layout_faq, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        FAQ f = values.get(position);
        final String pregunta = f.getPregunta();
        holder.txtPregunta.setText(pregunta);

        holder.txtPregunta.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove (holder.getAdapterPosition());
            }
        });

        holder.txtRespuesta.setText(f.getRespuesta());

    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}