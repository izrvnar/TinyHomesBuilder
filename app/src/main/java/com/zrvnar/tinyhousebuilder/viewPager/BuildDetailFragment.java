package com.zrvnar.tinyhousebuilder.viewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zrvnar.tinyhousebuilder.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuildDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuildDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int ARG_PARAM3 = 0;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mParam3;

    public BuildDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuildDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuildDetailFragment newInstance(String param1, String param2, int mParam3) {
        BuildDetailFragment fragment = new BuildDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt("index", mParam3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt("index", ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_build_detail, container, false);

        if(mParam1 != null){
            TextView textView = view.findViewById(R.id.build_title);
            textView.setText(mParam1);
        }

        if(mParam2 != null){
            TextView textView = view.findViewById(R.id.build_detial);
            textView.setText(mParam2);
        }

        ImageView imageView = view.findViewById(R.id.build_image);
        imageView.setImageResource(mParam3);


        return view;
    }
}