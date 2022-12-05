package com.zrvnar.tinyhousebuilder.recyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zrvnar.tinyhousebuilder.R;
import com.zrvnar.tinyhousebuilder.customDialog.ApplianceDialog;
import com.zrvnar.tinyhousebuilder.customDialog.ApplianceDialogListener;
import com.zrvnar.tinyhousebuilder.pojo.Appliance;
import com.zrvnar.tinyhousebuilder.pojo.ApplianceSingleton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EnergyCalcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnergyCalcFragment extends Fragment implements ApplianceDialogListener {
    ApplianceRecycleViewAdapterGrid adapterGrid;
    ApplianceDialog applianceDialog;
    TextView kwhTotal;
    TextView solarTotal;
    int totalKwh;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EnergyCalcFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EnergyCalcFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EnergyCalcFragment newInstance(String param1, String param2) {
        EnergyCalcFragment fragment = new EnergyCalcFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume() {
        kwhTotal.setText(String.valueOf(totalKwh()));
        solarTotal.setText(String.valueOf(solarPanelsNeeded()));
        adapterGrid.notifyDataSetChanged();

        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy_calc, container, false);

        // preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isChecked = preferences.getBoolean("gridViewSwitch", false);


        ArrayList<Appliance> applianceArrayList = ApplianceSingleton.getInstance().getApplianceArrayList();
        RecyclerView recyclerView = view.findViewById(R.id.recycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ApplianceRecycleViewAdapter(applianceArrayList));
        adapterGrid = new ApplianceRecycleViewAdapterGrid(applianceArrayList);

        //toggle for grid view
        if (isChecked) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setAdapter(adapterGrid);
        }

        // changing the text for calculator
        kwhTotal = view.findViewById(R.id.kwhTotal);

        solarTotal = view.findViewById(R.id.solarTotalText);

        Button addAppliance = view.findViewById(R.id.addButton);
        addAppliance.setOnClickListener(v -> {

            applianceDialog = new ApplianceDialog();
            applianceDialog.show(getFragmentManager(), "ApplianceDialog");
        });




        return view;
    }

    public int totalKwh(){
        ArrayList<Appliance> applianceArrayList = ApplianceSingleton.getInstance().getApplianceArrayList();
        for (Appliance appliance: applianceArrayList) {
            System.out.println(appliance);
            totalKwh += appliance.getKwh();
        }
        System.out.println(totalKwh);
        return totalKwh;
    }

    public int solarPanelsNeeded(){
        int solarPanel = 0;
        solarPanel = totalKwh / 370;
        return solarPanel;
    }

    // refreshes the fragment
    public void refreshFragment(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    @Override
    public void onYesClick() {
        refreshFragment();

    }

    @Override
    public void onNoClick() {

    }
}