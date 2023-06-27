package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCardAdapter extends RecyclerView.Adapter<RecyclerCardAdapter.ViewHolder> {

    Context context;
    ArrayList<cardModel> cards;


    public RecyclerCardAdapter(Context context, ArrayList<cardModel> cards)
    {
        this.context = context;

        this.cards = cards;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(cards.get(position).img);
        holder.cardTxt.setText(cards.get(position).cardTxt);
        holder.cardTxtDesc.setText(cards.get(position).cardTxtDesc);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.update_dialogue);

                EditText editname = dialog.findViewById(R.id.name);
                EditText editdesc = dialog.findViewById(R.id.desc);

                Button actionbtn = dialog.findViewById(R.id.okbtn);

                actionbtn.setText("Update");

                int im = cards.get(position).img;
                editname.setText(cards.get(position).cardTxt);
                editdesc.setText(cards.get(position).cardTxtDesc);

                actionbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", desc = "";
                        if (!editname.getText().toString().equals("")) {
                            name = editname.getText().toString();
                        } else {
                            Toast.makeText(context, "Enter the Name ", Toast.LENGTH_SHORT).show();
                        }

                        if (!editdesc.getText().toString().equals("")) {
                            desc = editdesc.getText().toString();
                        } else {
                            Toast.makeText(context, "Enter the Description ", Toast.LENGTH_SHORT).show();
                        }

                        cards.set(position, new cardModel(im,name, desc));
                        notifyItemChanged(position);

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Delete The Entry")
                                                .setMessage("Are you sure you want to delete ?")
                                                .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                cards.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();
                return true;//always true
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView cardTxt,cardTxtDesc;
        ImageView img;

        LinearLayout llRow;
        public ViewHolder(View itemView)
        {
            super(itemView);

            cardTxt = itemView.findViewById(R.id.cardTxt);
            cardTxtDesc = itemView.findViewById(R.id.cardTextDesc);
            img = itemView.findViewById(R.id.cardImg);
            llRow = itemView.findViewById(R.id.row);
        }
    }
}
