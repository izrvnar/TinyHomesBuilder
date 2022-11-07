package com.zrvnar.tinyhousebuilder.customDialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.zrvnar.tinyhousebuilder.R;
import com.zrvnar.tinyhousebuilder.pojo.Appliance;

import java.util.ArrayList;

public class ApplianceDialog extends DialogFragment {
    ArrayList applianceArrayList =  new ArrayList<Appliance>();
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null))
                .setPositiveButton(R.string.saveButtonText, (dialog, which) -> {
                    //TODO: Create a appliance object and save it here
                    Appliance userInput = new Appliance("Test Appliance",35,1);
                   applianceArrayList.add(userInput);
                    System.out.println(applianceArrayList.size());



                })
                .setNegativeButton(R.string.cancelButtonText, (dialog, which) -> {
                    ApplianceDialog.this.getDialog().cancel();
                })
                .setIcon(R.drawable.energy_icon)
                .setTitle("Create Appliance");




        return builder.create();
    }
}
