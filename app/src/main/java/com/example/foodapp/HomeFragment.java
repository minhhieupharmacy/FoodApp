package com.example.foodapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Home> homes;
    HomeAdapter homeAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rvContact);
        homes = new ArrayList<>();
        homes.add(new Home("Circle K","40 Hung Vuong",R.drawable.ic_circlek));
        homes.add(new Home("Highland Coffee","30 Nguyen Van Cu",R.drawable.ic_highland));
        homes.add(new Home("Ministop","70 Ly Thai To",R.drawable.ic_ministop));
        homes.add(new Home("7 Elevent","82 Nguyen Thi Minh Khai",R.drawable.ic_seveneleven));
        homes.add(new Home("Vinmart","1 Nguyen Van Cuu",R.drawable.ic_vinmart));
        homeAdapter = new HomeAdapter(getContext(),homes);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(getContext(),
                        LinearLayoutManager.VERTICAL,
                        false);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getContext(),
                        ((LinearLayoutManager) layoutManager).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
