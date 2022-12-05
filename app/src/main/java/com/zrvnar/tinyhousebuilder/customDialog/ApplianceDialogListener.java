package com.zrvnar.tinyhousebuilder.customDialog;

import android.content.DialogInterface;

import androidx.fragment.app.DialogFragment;

/**
 * Interface for receiving events from the dialog.
 */
public interface ApplianceDialogListener {
    void onDialogPositiveClick(DialogFragment dialog);

    void onDialogNegativeClick(DialogFragment dialog);

    void onDismiss(DialogInterface dialog);


}
