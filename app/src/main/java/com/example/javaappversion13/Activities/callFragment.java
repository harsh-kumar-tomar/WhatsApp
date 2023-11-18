package com.example.javaappversion13.Activities;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javaappversion13.Adapters.callsAdapter;
import com.example.javaappversion13.Domain.structCallsView;
import com.example.javaappversion13.R;

import java.util.ArrayList;


public class callFragment extends Fragment {


    public callFragment() {
        // Required empty public constructor
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_call, container, false);
        ArrayList<structCallsView> datalist = new ArrayList<>() ;
        RecyclerView recyclerView = view.findViewById(R.id.CallsrecylerView);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext()) ;

        recyclerView.setLayoutManager(linearLayoutManager);
        callsAdapter adapter = new callsAdapter(datalist , requireContext());

        recyclerView.setAdapter(adapter);





        return view;





    }






}