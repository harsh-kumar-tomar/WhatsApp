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

        datalist.add(new structCallsView(R.drawable.profile1 , "Aries" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile1 , "Raj" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile2 , "Rohan" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile3 , "Charles" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile4 , "Wolverine" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile5 , "Steeve" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile6 , "Saali" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile7 , "Gost rider" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile8 , "Atomics X" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile1 , "Hydra" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile2 , "Mr. Oak" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile3 , "Dr. Strange" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile4 , "Mrs. Marvel" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile5 , "Falcon" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile6 , "Ant man" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile7 , "Aquaman" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile8 , "Alfred" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile1 , "Baap" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile3 , "Okarine" , "22 August, 4:20 pm"));
        datalist.add(new structCallsView(R.drawable.profile4 , "Makise" , "22 August, 4:20 pm"));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext()) ;

        recyclerView.setLayoutManager(linearLayoutManager);
        callsAdapter adapter = new callsAdapter(datalist , requireContext());

        recyclerView.setAdapter(adapter);





        return view;





    }






}