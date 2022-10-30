package com.zrvnar.tinyhousebuilder.listView;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zrvnar.tinyhousebuilder.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataTypeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DataTypeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DataTypeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DataTypeFragment newInstance(String param1, String param2) {
        DataTypeFragment fragment = new DataTypeFragment();
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
        View view = inflater.inflate(R.layout.fragment_data_type, container, false);

        // importing the settings
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isChecked = preferences.getBoolean("listViewSwitch",false);

        // populating list view
        ListView listView = view.findViewById(R.id.dataTypeListView);
        ArrayList<DataType> dataTypes = new ArrayList<>();
        dataTypes.add(new DataType("Jims Landscaping", "Landscaper", "Colorado"));
        dataTypes.add(new DataType("Clean Painters","Painter","Louisiana"));
        dataTypes.add(new DataType("ACE Masonry","Cement Mason","Pennsylvania"));
        dataTypes.add(new DataType("First Choice","Plumber","Connecticut"));
        dataTypes.add(new DataType("Cielza Stucco","Stucco Mason","New York"));
        dataTypes.add(new DataType("Honey","Electrician","Texas"));
        dataTypes.add(new DataType("Anchor","Doors, Frames & Hardware","California"));
        dataTypes.add(new DataType("Dan Whitmore","Drywall & Acoustical (FED)","Minnesota"));
        dataTypes.add(new DataType("Handy Bros","HVAC","South Carolina"));
        dataTypes.add(new DataType("Windmill","Kitchen","Ohio"));



        //Adding the custom list view adapters to the view
        CustomViewListAdapter customViewListAdapter = new CustomViewListAdapter(getContext(), dataTypes);
        CustomViewListAdapter2 customViewListAdapter2 = new CustomViewListAdapter2(getContext(), dataTypes);
        listView.setAdapter(customViewListAdapter);

        if (isChecked){
            listView.setAdapter(customViewListAdapter2);
        }

        return view;
    }
}