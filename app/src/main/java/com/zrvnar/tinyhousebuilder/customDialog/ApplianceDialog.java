package com.zrvnar.tinyhousebuilder.customDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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

public class ApplianceDialog extends DialogFragment {
    ArrayList<Appliance> applianceArrayList = ApplianceSingleton.getInstance().getApplianceArrayList();
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);

        builder.setView(view)
                .setPositiveButton(R.string.saveButtonText, (dialog, which) -> {
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
                        System.out.println(applianceArrayList.size());


                    } catch (Exception exception){
                        exception.printStackTrace();
                    }

                })
                .setNegativeButton(R.string.cancelButtonText, (dialog, which) -> {
                    ApplianceDialog.this.getDialog().cancel();
                })
                .setIcon(R.drawable.energy_icon)
                .setTitle("Create Appliance");

        return builder.create();
    }




}
