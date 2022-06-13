package com.example.newsx;

import com.example.newsx.Models.NewsHeadLines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {

    void onFetchData(List<NewsHeadLines> list, String message);
    void onError(String message);


}
