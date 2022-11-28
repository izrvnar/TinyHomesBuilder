package com.zrvnar.tinyhousebuilder.viewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zrvnar.tinyhousebuilder.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuildDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuildDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "title";
    private static final String ARG_PARAM2 = "description";
    private static final int ARG_PARAM3 = 0;
    private static final String ARG_PARAM4 = "phoneNumber";
    private static final String ARG_PARAM5 = "email";
    private static final String ARG_PARAM6 = "website";
    private static final String ARG_PARAM7 = "type";




    // TODO: Rename and change types of parameters
    private String title;
    private String description;
    private int builderImage;
    private String phoneNumber;
    private String email;
    private String website;
    private String type;

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
    public static BuildDetailFragment newInstance(String param1, String param2, int builderImage, String phoneNumber,
                                                  String email, String website, String type) {
        BuildDetailFragment fragment = new BuildDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM4, phoneNumber);
        args.putString(ARG_PARAM5, email);
        args.putString(ARG_PARAM6, website);
        args.putInt("index", builderImage);
        args.putString(ARG_PARAM7, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            description = getArguments().getString(ARG_PARAM2);
            builderImage = getArguments().getInt("index", ARG_PARAM3);
            phoneNumber = getArguments().getString(ARG_PARAM4);
            email = getArguments().getString(ARG_PARAM5);
            website = getArguments().getString(ARG_PARAM6);
            type = getArguments().getString(ARG_PARAM7);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_build_detail, container, false);

        if(title != null){
            TextView textView = view.findViewById(R.id.build_title);
            textView.setText(title);
        }

        if(description != null){
            TextView textView = view.findViewById(R.id.build_detial);
            textView.setText(description);
        }

        ImageView imageView = view.findViewById(R.id.build_image);
        imageView.setImageResource(builderImage);

        // intents
        Button callButton = view.findViewById(R.id.call_button);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                System.out.println(phoneNumber);

                if(i.resolveActivity(getActivity().getPackageManager())!= null){
                    startActivity(i);
                }else{
                    Toast.makeText(getContext(), "No valid application", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button emailButton = view.findViewById(R.id.email_button);
        emailButton.setOnClickListener(v -> {
            String[] emailAddress = {email};
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"));
            i.putExtra(Intent.EXTRA_EMAIL, emailAddress);
            i.putExtra(Intent.EXTRA_SUBJECT, "Hello Im looking to hire a " + type);
            i.putExtra(Intent.EXTRA_TEXT, "Hello I am trying to find a "+ type +" to help build my tiny house ");

            if(i.resolveActivity(getActivity().getPackageManager())!= null){
                startActivity(i);
            }else{
                Toast.makeText(getContext(), "No valid application", Toast.LENGTH_SHORT).show();
            }


        });

        Button websiteButton = view.findViewById(R.id.website_Button);
        websiteButton.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(website));

            if(i.resolveActivity(getActivity().getPackageManager())!= null){
                startActivity(i);
            }else{
                Toast.makeText(getContext(), "No valid application", Toast.LENGTH_SHORT).show();
            }



        });


        return view;
    }
}