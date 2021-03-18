package com.merchpandas.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.merchpandas.tourguide.databinding.ActivityTouristVisitBinding;


public class TouristVisit extends AppCompatActivity {
    ActivityTouristVisitBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTouristVisitBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        binding.imageView.setImageResource(intent.getIntExtra(getString(R.string.img), R.drawable.tajmahal));
        binding.places.setText(intent.getStringExtra(getString(R.string.title)));
        final String location = intent.getStringExtra(getString(R.string.location));
        if (location == null) {
            binding.openMaps.setVisibility(View.GONE);
        }


        binding.openMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri gmUri = Uri.parse(getString(R.string.geo) + location);
                Intent i = new Intent(Intent.ACTION_VIEW, gmUri);
                i.setPackage(getString(R.string.maps_package));
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }


            }
        });

    }
}