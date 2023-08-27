package com.example.roomlib_ii;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.id.setText(String.valueOf(data.get(position).getId()));
        holder.fName.setText(data.get(position).getfName());
        holder.lName.setText(data.get(position).getlName());
        holder.Grade.setText(data.get(position).getGrade());


        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, holder.option);
                popupMenu.inflate(R.menu.my_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        int id = menuItem.getItemId();
                        if (id == R.id.update){
                            Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show();
                            return true;

                        } else if (id == R.id.delete) {
                            db = DBHelper.getDB(context);
                            db.dao().deleteById(data.get(position).getId());

                            data.remove(position);
                            notifyDataSetChanged();
                            return true;


                        }
                        return false;
                    }

                });
                popupMenu.show();


            }
        });

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
