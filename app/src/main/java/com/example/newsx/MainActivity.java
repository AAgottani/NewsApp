package com.example.newsx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.example.newsx.Models.NewsApiResponse;
import com.example.newsx.Models.NewsHeadLines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{

    //https://www.youtube.com/watch?v=Csx7ve8DF_U
    //1:02:00
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog= new ProgressDialog(this);
        dialog.setTitle("Fetching news Articles");
        dialog.show();

        RequestManager manager = new RequestManager(this);
        manager.getNewsHeadlines(listener, "general", null);
    }

    private final OnFetchDataListener<NewsApiResponse> listener =
            new OnFetchDataListener<NewsApiResponse>() {
                @Override
                public void onFetchData(List<NewsHeadLines> list, String message) {
                    showNews(list);
                    dialog.dismiss();
                }

                @Override
                public void onError(String message) {

                }
            };

    private void showNews(List<NewsHeadLines> list) {
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(NewsHeadLines headlines) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
                .putExtra("data", headlines));
    }
}