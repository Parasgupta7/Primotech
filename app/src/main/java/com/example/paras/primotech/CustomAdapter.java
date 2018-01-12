package com.example.paras.primotech;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by anmol on 1/12/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {



    private Context context;
    private List<MyData> my_data;



    public CustomAdapter(Context context, List<MyData> my_data) {
        this.context = context;
        this.my_data = my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position){


        holder.Description.setText(my_data.get(position).getDescription());
        holder.Title.setText(my_data.get(position).getTitle());
        Picasso.with(context).load(my_data.get(position).getImage()).into(holder.Image);
        //Glide.with(context).load(my_data.get(position).getImage()).into(holder.Image);
        /*holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"clicked at"+holder.getAdapterPosition(),Toast.LENGTH_LONG).show();

                if(my_data.get(position).getId()==(int)my_data.get(position).getId()){
                    Toast.makeText(view.getContext(),"clicked at"+holder.getAdapterPosition(), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(view.getContext(),Aditi.class);
                    i.putExtra("desc",my_data.get(position).getDescription());
                    view.getContext().startActivity(i);

                }
            }
        });*/




    }

    @Override
    public int getItemCount() {
        return my_data.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView Description;
        public ImageView Image;
        public TextView Title;


        public ViewHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.title);
            Description = (TextView) itemView.findViewById(R.id.description);
            Image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
