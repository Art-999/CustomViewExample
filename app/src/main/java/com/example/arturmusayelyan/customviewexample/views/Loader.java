package com.example.arturmusayelyan.customviewexample.views;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.arturmusayelyan.customviewexample.R;

/**
 * Created by artur.musayelyan on 30/01/2018.
 */

public class Loader extends RelativeLayout {
    private Context context;
    private ProgressBar progressBar;
    private View view;

    public Loader(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        view = inflate(context, R.layout.loader_view, this);
        progressBar = view.findViewById(R.id.progress_bar);
    }

    public void start() {
        progressBar.setVisibility(VISIBLE);
    }

    public void end() {
        progressBar.setVisibility(GONE);
        view.setVisibility(GONE);
    }
}
