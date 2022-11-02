package com.zrvnar.tinyhousebuilder.recyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrvnar.tinyhousebuilder.R;
import com.zrvnar.tinyhousebuilder.pojo.Appliance;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ApplianceRecycleViewAdapter extends RecyclerView.Adapter<ApplianceRecycleViewAdapter.CustomViewHolder> {
    ArrayList<Appliance> applianceArrayList;

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return applianceArrayList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected String name;
        protected int kwh;
        protected int quantity;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
