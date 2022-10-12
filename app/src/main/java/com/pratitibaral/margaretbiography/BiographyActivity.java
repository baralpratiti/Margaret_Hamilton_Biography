package com.pratitibaral.margaretbiography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pratitibaral.margaretbiography.databinding.ActivityBiographyBinding;

public class BiographyActivity extends AppCompatActivity {

    private ActivityBiographyBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBiographyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent myIntent = getIntent();
    }
}

