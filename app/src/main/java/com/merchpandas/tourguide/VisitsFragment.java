package com.merchpandas.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.merchpandas.tourguide.databinding.ActivityVisitsfragmentBinding;

import java.util.ArrayList;

public class VisitsFragment extends Fragment {
    ActivityVisitsfragmentBinding binding;
    LinearLayoutManager linearLayoutManager;
    ArrayList<VisitItem> visitItems;
    public VisitsFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityVisitsfragmentBinding.inflate(getLayoutInflater());

        prepareListData();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.visitsLists.setLayoutManager(linearLayoutManager);

        VistsListAdapter adapter = new VistsListAdapter(visitItems,getActivity());
        binding.visitsLists.setAdapter(adapter);

    }

    private void prepareListData() {
        visitItems = new ArrayList<>();
        visitItems.add(new VisitItem(getString(R.string.tajmahal),R.drawable.tajmahal, getString(R.string.taj_loction)));
        visitItems.add(new VisitItem(getString(R.string.qutubminar),R.drawable.qutub_minar,getString(R.string.qm_loction)));
        visitItems.add(new VisitItem(getString(R.string.gateway),R.drawable.gate_way,getString(R.string.gt_loction)));
        visitItems.add(new VisitItem(getString(R.string.redfort),R.drawable.redfort,getString(R.string.red_loction)));
        visitItems.add(new VisitItem(getString(R.string.goldentemple),R.drawable.goldentemple,getString(R.string.golden_loction)));
        visitItems.add(new VisitItem(getString(R.string.lotustemple),R.drawable.lotustemple,getString(R.string.lotus_loction)));
        visitItems.add(new VisitItem(getString(R.string.tomb),R.drawable.humayun_tomb,getString(R.string.tomb_loction)));
        visitItems.add(new VisitItem(getString(R.string.ellora),R.drawable.ellora,getString(R.string.ellora_loction)));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return binding.getRoot();
    }
}
