package com.example.dreamdrummer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterLess extends RecyclerView.Adapter<MyAdapterLess.MyViewHolder>
{
    String data1[], data2[];
    int[] images;
    Context context;
    public MyAdapterLess (Context ct,String []s1, String s2[], int img[])
    {
        context=ct;
        data1=s1;
        data2=s2;
        images=img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_rowsongs, parent, false);
        return new MyAdapterLess.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
    {
        holder.myT1.setText(data1[position]);
        holder.myT2.setText(data2[position]);
        holder.mI.setImageResource(images[position]);
        holder.setSongsClickListener(new SongsClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(context,"click"+position, Toast.LENGTH_SHORT).show();
                if (position==0)
                {
                    Intent intent =  new Intent(context, Lessone.class);
                    context.startActivity(intent);
                }
                if (position==1)
                {
                    Intent intent =  new Intent(context, Lesstwo.class);
                    context.startActivity(intent);
                }
                if (position==2)
                {
                    Intent intent =  new Intent(context, Lessthree.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public interface SongsClickListener {
        void onClick (View view, int position);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView  myT1, myT2;
        ImageView mI;
        private SongsClickListener songsClickListener;
        public MyViewHolder (@NonNull View itemView)
        {
            super(itemView);
            myT1=itemView.findViewById(R.id.tv_lesson);
            myT2=itemView.findViewById(R.id.tv_desc);
            mI=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener((View.OnClickListener) this);
        }
        public void setSongsClickListener (SongsClickListener songsClickListener){
            this.songsClickListener=songsClickListener;
        }

        @Override
        public void onClick(View v) {
            songsClickListener.onClick(v,getAdapterPosition());
        }
    }

}

