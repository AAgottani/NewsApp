package com.example.newsx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.newsx.Models.NewsHeadLines;

public class DetailsActivity extends AppCompatActivity {

    NewsHeadLines headLines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        headLines = (NewsHeadLines) getIntent().getSerializableExtra("data");
    }
}