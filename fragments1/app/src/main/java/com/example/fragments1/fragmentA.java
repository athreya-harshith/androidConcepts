package com.example.fragments1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentA extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentA newInstance(String param1, String param2) {
        fragmentA fragment = new fragmentA();
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
        // Inflate the layout for this fragment
        if(getArguments() != null)
        {
            String Arg1 = getArguments().getString("Argu1");
            int arg2 = getArguments().getInt("Argu2");

            Log.d("Values from MainActivity ","The Argu1 "+Arg1+"The Argu2 is "+arg2);
        }
//        calling the method in the MainActivity
        ((MainActivity)getActivity()).callFromFragment();//used iff this activity is called from mainActivity only
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}