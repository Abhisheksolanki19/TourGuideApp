package com.merchpandas.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.merchpandas.tourguide.databinding.ActivityFoodfragmentBinding;

import java.util.ArrayList;

public class FoodFragment extends Fragment {
    ActivityFoodfragmentBinding binding;

    LinearLayoutManager linearLayoutManager;
    ArrayList<VisitItem> visitItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodfragmentBinding.inflate(getLayoutInflater());

        prepareListData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.visitsLists.setLayoutManager(linearLayoutManager);

        VistsListAdapter adapter = new VistsListAdapter(visitItems, getActivity());
        binding.visitsLists.setAdapter(adapter);

    }

    private void prepareListData() {
        visitItems = new ArrayList<>();
        visitItems.add(new VisitItem(getString(R.string.rasgulla), R.drawable.rasgulla, null));
        visitItems.add(new VisitItem(getString(R.string.rasmalai), R.drawable.rasmalai, null));
        visitItems.add(new VisitItem(getString(R.string.idli), R.drawable.idli, null));
        visitItems.add(new VisitItem(getString(R.string.dosa), R.drawable.dosa, null));
        visitItems.add(new VisitItem(getString(R.string.biriyani), R.drawable.biriyani, null));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityFoodfragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    public FoodFragment() {
    }

}