package com.merchpandas.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.merchpandas.tourguide.databinding.ActivityPlacesfragmentBinding;

import java.util.ArrayList;

public class PlacesFragment extends Fragment {
    ActivityPlacesfragmentBinding binding;
    LinearLayoutManager linearLayoutManager;
    ArrayList<VisitItem> visitItems;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlacesfragmentBinding.inflate(getLayoutInflater());

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
        visitItems.add(new VisitItem(getString(R.string.jagmandir), R.drawable.jagmandir, getString(R.string.jag_loction)));
        visitItems.add(new VisitItem(getString(R.string.kumbhalgarhfort), R.drawable.kumbhalgarhfort, getString(R.string.kum_loction)));
        visitItems.add(new VisitItem(getString(R.string.citypalace), R.drawable.citypalace, getString(R.string.city_loction)));
        visitItems.add(new VisitItem(getString(R.string.fatehsagarlake), R.drawable.fatehsagarlake, getString(R.string.fateh_loction)));
        visitItems.add(new VisitItem(getString(R.string.ambraiamethaveli), R.drawable.ambraiamethaveli, getString(R.string.ambrai_loction)));
        visitItems.add(new VisitItem(getString(R.string.lakepalace), R.drawable.lakepalace, getString(R.string.lake_loction)));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityPlacesfragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    public PlacesFragment() {
    }
}