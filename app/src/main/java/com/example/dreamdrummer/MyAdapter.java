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

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    String data1[], data2[];
    int[] images;
    Context context;
    public MyAdapter (Context ct,String []s1, String s2[], int img[])
    {
        context=ct;
        data1=s1;
        data2=s2;
        images=img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.myT1.setText(data1[position]);
        holder.myT2.setText(data2[position]);
        holder.mI.setImageResource(images[position]);
        holder.setItemClickListener(new LessonClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(context,"click"+position, Toast.LENGTH_SHORT).show();
                if (position==0)
                {
                    Intent intent =  new Intent(context, Museups.class);
                    context.startActivity(intent);
                }
                if (position==1)
                {
                    Intent intent =  new Intent(context, SeeuAgain.class);
                    context.startActivity(intent);
                }
                if (position==2)
                {
                    Intent intent =  new Intent(context, Hallof.class);
                    context.startActivity(intent);
                }
                if (position==3)
                {
                    Intent intent =  new Intent(context, Friends.class);
                    context.startActivity(intent);
                }
                if (position==4)
                {
                    Intent intent =  new Intent(context, Countingstars.class);
                    context.startActivity(intent);
                }
                if (position==5)
                {
                    Intent intent =  new Intent(context, Magic.class);
                    context.startActivity(intent);
                }
                if (position==6)
                {
                    Intent intent =  new Intent(context, Whatilike.class);
                    context.startActivity(intent);
                }
                if (position==7)
                {
                    Intent intent =  new Intent(context, Animals.class);
                    context.startActivity(intent);
                }
                if (position==8)
                {
                    Intent intent =  new Intent(context, Believer.class);
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public interface LessonClickListener {
        void onClick (View view, int position);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        TextView  myT1, myT2;
        ImageView mI;
        private LessonClickListener lessonClickListener;
        public MyViewHolder (@NonNull View itemView)
        {
            super(itemView);
            myT1=itemView.findViewById(R.id.tv_lesson);
            myT2=itemView.findViewById(R.id.tv_desc);
            mI=itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener((View.OnClickListener) this);
        }
        public void setItemClickListener (LessonClickListener lessonClickListener){
            this.lessonClickListener=lessonClickListener;
        }

        @Override
        public void onClick(View v) {
            lessonClickListener.onClick(v,getAdapterPosition());
        }
    }


}
