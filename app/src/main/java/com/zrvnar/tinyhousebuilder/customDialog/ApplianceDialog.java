package com.zrvnar.tinyhousebuilder.customDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.zrvnar.tinyhousebuilder.R;
import com.zrvnar.tinyhousebuilder.pojo.Appliance;
import com.zrvnar.tinyhousebuilder.pojo.ApplianceSingleton;
import com.zrvnar.tinyhousebuilder.recyclerView.ApplianceRecycleViewAdapterGrid;
import com.zrvnar.tinyhousebuilder.recyclerView.EnergyCalcFragment;

import java.util.ArrayList;
//
public class ApplianceDialog extends DialogFragment  {

    int totalKwh;

    public interface onApplianceSelected{
        void sendTotalKwh(int totalKwh);
    }

    public onApplianceSelected applianceSelected;


    ArrayList<Appliance> applianceArrayList = ApplianceSingleton.getInstance().getApplianceArrayList();


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(view)
                .setIcon(R.drawable.energy_icon)
                .setTitle("Add Appliance");
                Button addApplianceButton = view.findViewById(R.id.addApplicanceButton);
                Button cancelButton = view.findViewById(R.id.cancelApplicanceButton);
                addApplianceButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditText appEditText = view.findViewById(R.id.appliance_name);
                        EditText kwhEditText = view.findViewById(R.id.kwh_number);
                        EditText quantityEditText = view.findViewById(R.id.quantity_number);

                        String name = appEditText.getText().toString();
                        int kwh = Integer.parseInt(kwhEditText.getText().toString());
                        System.out.println(kwh);
                        int quantity = Integer.parseInt(quantityEditText.getText().toString());
                        try{
                            Appliance userInput = new Appliance(name,kwh,quantity);
                            applianceArrayList.add(userInput);
                            Toast toast = Toast.makeText(getContext(), "Appliance Added!", Toast.LENGTH_LONG);
                            toast.show();
                            totalKwh = totalKwh();
                            applianceSelected.sendTotalKwh(totalKwh);
                            System.out.println(applianceArrayList.size());


                        }catch (Exception exception){
                            exception.printStackTrace();
                        }
                        getDialog().dismiss();

                    }
                });

                //Cancel button
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getDialog().dismiss();
                    }
                });



        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            applianceSelected = (onApplianceSelected) getTargetFragment();
    } catch (ClassCastException e) {
        throw new ClassCastException(e.getMessage());
    }
    }

    /**
     * This method calculates the total Kwh of all the appliances in the ArrayList
     * @return
     */

    public int totalKwh(){
        ArrayList<Appliance> applianceArrayList = ApplianceSingleton.getInstance().getApplianceArrayList();
        for (Appliance appliance: applianceArrayList) {
            System.out.println(appliance);
            totalKwh += appliance.getKwh() * appliance.getQuantity();
        }
        System.out.println(totalKwh);
        return totalKwh;
    }


}

