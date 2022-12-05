package com.zrvnar.tinyhousebuilder.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.zrvnar.tinyhousebuilder.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreditsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreditsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreditsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreditsFragment newInstance(String param1, String param2) {
        CreditsFragment fragment = new CreditsFragment();
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
        View view = inflater.inflate(R.layout.fragment_credits, container, false);
        Button iconButton = view.findViewById(R.id.iconButton);
        Button imageButton = view.findViewById(R.id.imageButton);
        Button docButton = view.findViewById(R.id.docButton);

        iconButton.setOnClickListener(v->{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.flaticon.com/authors/freepik"));

                    if(i.resolveActivity(getActivity().getPackageManager())!= null){
                        startActivity(i);
                    } else{
                        Toast.makeText(getActivity(), "No app found to open this link", Toast.LENGTH_SHORT).show();
                    }
        });

       imageButton.setOnClickListener(v->{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://pixabay.com/"));

            if(i.resolveActivity(getActivity().getPackageManager())!= null){
                startActivity(i);
            } else{
                Toast.makeText(getActivity(), "No app found to open this link", Toast.LENGTH_SHORT).show();
            }
        });

       docButton.setOnClickListener(v->{
           Intent i = new Intent(Intent.ACTION_VIEW);
           i.setData(Uri.parse("https://developer.android.com/docs"));

           if(i.resolveActivity(getActivity().getPackageManager())!= null){
               startActivity(i);
           } else{
               Toast.makeText(getActivity(), "No app found to open this link", Toast.LENGTH_SHORT).show();
           }
       });




        return view;
    }
}