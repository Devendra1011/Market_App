package com.example.marketapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {


    private List<ItemModel> itemModelList;

    public ItemAdapter(List<ItemModel> itemModelList) {

        this.itemModelList = itemModelList;
    }

    public ItemCLickListener cLickListener;

    public void setCLickListener(ItemCLickListener myListener) {
        this.cLickListener = myListener;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel itemModel = itemModelList.get(position);

        holder.itemName.setText(itemModel.getItemName());
        holder.itemDesc.setText(itemModel.getItemDescription());
        holder.itemImage.setImageResource(itemModel.getItemImage());


    }

    @Override
    public int getItemCount() {

        return itemModelList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView itemName;
        private TextView itemDesc;
        private ImageView itemImage;


        public ItemViewHolder(@NonNull View itemView) {

            super(itemView);
            this.itemName = itemView.findViewById(R.id.lil_tv_item_name);
            this.itemDesc = itemView.findViewById(R.id.lil_tv_item_desc);
            this.itemImage = itemView.findViewById(R.id.lil_iv_item_image);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (cLickListener != null) {
                cLickListener.onCLick(v, getAdapterPosition());
            }
        }
    }

}
