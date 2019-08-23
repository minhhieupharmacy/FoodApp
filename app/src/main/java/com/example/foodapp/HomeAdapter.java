package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeVH> {
    Context context;
    ArrayList<Home> homes;

    public HomeAdapter(Context context, ArrayList<Home> homes) {
        this.context = context;
        this.homes = homes;
    }

    @NonNull
    @Override
    public HomeVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View convertView = layoutInflater.inflate(R.layout.layout_item,null,false);
        return new HomeVH(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVH homeVH, int i) {
        Home home = homes.get(i);
        homeVH.txtAddress.setText(home.getAddress());
        homeVH.txtName.setText(home.getName());
        homeVH.imghome.setImageResource(home.getImages());


    }

    @Override
    public int getItemCount() {
        return homes.size();
    }

    class HomeVH extends RecyclerView.ViewHolder{
    ImageView imghome ;
    TextView txtName , txtAddress;

    public HomeVH(@NonNull View itemView) {
        super(itemView);
        imghome = itemView.findViewById(R.id.imgImages);
        txtName = itemView.findViewById(R.id.tvName);
        txtAddress = itemView.findViewById(R.id.tvAddress);
    }
}
}
