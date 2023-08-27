package com.example.roomlib_ii;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<Entity> data;
    DBHelper db;

    public Adapter(Context context, List<Entity> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(data.get(position).getId()));
        holder.fName.setText(data.get(position).getfName());
        holder.lName.setText(data.get(position).getlName());
        holder.Grade.setText(data.get(position).getGrade());

        //to perform the delete operation via recycler view
       /* holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = DBHelper.getDB(context);
                db.dao().deleteById(data.get(position).getId());

                //to remove from the recycler view too
                data.remove(position);
                notifyDataSetChanged();

                Toast.makeText(context, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, fName, lName, Grade;
        ImageView option;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvID);
            fName = itemView.findViewById(R.id.tvFirstName);
            lName = itemView.findViewById(R.id.tvLastName);
            Grade = itemView.findViewById(R.id.tvGrade);
            option = itemView.findViewById(R.id.btnOption);

        }
    }
}
