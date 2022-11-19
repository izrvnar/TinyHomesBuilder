package com.zrvnar.tinyhousebuilder.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrvnar.tinyhousebuilder.R;
import com.zrvnar.tinyhousebuilder.pojo.Appliance;
import com.zrvnar.tinyhousebuilder.pojo.ApplianceSingleton;

import java.util.ArrayList;

public class ApplianceRecycleViewAdapterGrid extends RecyclerView.Adapter<ApplianceRecycleViewAdapterGrid.CustomViewHolder> {
    ArrayList<Appliance> applianceArrayList = ApplianceSingleton.getInstance().getApplianceArrayList();

    public ApplianceRecycleViewAdapterGrid(ArrayList<Appliance> applianceArrayList){this.applianceArrayList = applianceArrayList;}

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycle_grid, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Appliance appliance = applianceArrayList.get(position);
        holder.name.setText(appliance.getName());
        holder.kwh.setText(String.valueOf(appliance.getKwh()));
        holder.quantity.setText(String.valueOf(appliance.getQuantity()));

    }

    @Override
    public int getItemCount() {
        return applianceArrayList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView kwh;
        protected TextView quantity;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.appGridText);
            this.kwh = itemView.findViewById(R.id.kwhGridText);
            this.quantity = itemView.findViewById(R.id.quantityGridText);
        }
    }
}
