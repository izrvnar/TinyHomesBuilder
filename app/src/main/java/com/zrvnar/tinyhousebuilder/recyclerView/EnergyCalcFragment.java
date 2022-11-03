package com.zrvnar.tinyhousebuilder.recyclerView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zrvnar.tinyhousebuilder.R;
import com.zrvnar.tinyhousebuilder.pojo.Appliance;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EnergyCalcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnergyCalcFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energy_calc, container, false);
        ArrayList<Appliance> applianceArrayList = new ArrayList<>();
        applianceArrayList.add(new Appliance("LightBulb", 35,1));
        applianceArrayList.add(new Appliance("TV", 100,2));
        applianceArrayList.add(new Appliance("LightBulb", 35,1));
        applianceArrayList.add(new Appliance("LightBulb", 35,1));
        applianceArrayList.add(new Appliance("LightBulb", 35,1));
        applianceArrayList.add(new Appliance("LightBulb", 35,1));
        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ApplianceRecycleViewAdapter(applianceArrayList));
        return view;
    }
}