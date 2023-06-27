package com.example.fragments1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentC extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private  static  final String Arg1 = "argument1",Arg2="argument2";
    public fragmentC() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentC.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentC newInstance(String param1, String param2) {
        fragmentC fragment = new fragmentC();
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

    public  static fragmentC getInstance(String value1,int value2)
    {
        fragmentC obj = new fragmentC();
        Bundle bundle = new Bundle();
        bundle.putString(Arg1,value1);
        bundle.putInt(Arg2,value2);

        obj.setArguments(bundle);
        return  obj;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(getArguments() != null)
        {
            String arg1 = getArguments().getString(Arg1);
            int arg2 = getArguments().getInt(Arg2);

            Log.d("Values from MainActivity in fragmentC ","The Arg1 "+arg1+"The Arg2 is "+arg2);
        }
        return inflater.inflate(R.layout.fragment_c, container, false);
    }
}