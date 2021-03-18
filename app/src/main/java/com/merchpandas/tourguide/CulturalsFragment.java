package com.merchpandas.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.merchpandas.tourguide.databinding.ActivityCulturalsfragmentBinding;

import java.util.ArrayList;

public class CulturalsFragment extends Fragment {
    ActivityCulturalsfragmentBinding binding;
    LinearLayoutManager linearLayoutManager;
    ArrayList<VisitItem> visitItems;

    public CulturalsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCulturalsfragmentBinding.inflate(getLayoutInflater());
        prepareListData();

    }

    private void prepareListData() {
        visitItems = new ArrayList<>();
        visitItems.add(new VisitItem(getString(R.string.mewarfest), R.drawable.mewarfest, getString(R.string.mewar_loction)));
        visitItems.add(new VisitItem(getString(R.string.mallculture), R.drawable.mallculture, getString(R.string.mall_loction)));
        visitItems.add(new VisitItem(getString(R.string.shilpgram), R.drawable.shilpgram, getString(R.string.shilpgram_loction)));
        visitItems.add(new VisitItem(getString(R.string.gumar), R.drawable.gumar, getString(R.string.gumar_loction)));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.visitsLists.setLayoutManager(linearLayoutManager);

        VistsListAdapter adapter = new VistsListAdapter(visitItems, getActivity());
        binding.visitsLists.setAdapter(adapter);

    }
}