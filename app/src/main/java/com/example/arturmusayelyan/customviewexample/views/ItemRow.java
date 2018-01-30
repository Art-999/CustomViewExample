package com.example.arturmusayelyan.customviewexample.views;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arturmusayelyan.customviewexample.R;

/**
 * Created by artur.musayelyan on 30/01/2018.
 */

public class ItemRow extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private View view;
    private TextView idTv;
    private TextView salaryTv;

    public ItemRow(Context context) {
        super(context);
        this.context=context;
        init();
    }




    private void init() {
        view = inflate(context, R.layout.custom_row_item, this);
        idTv = view.findViewById(R.id.id_field);
        salaryTv = view.findViewById(R.id.salary_field);
    }

    public void idSetText(String text) {
        idTv.setText(text);
    }

    public void salarySetText(String text) {
        salaryTv.setText(text);
    }

    public void idSetClickListener() {
        idTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context,"id textView clicked ",Toast.LENGTH_SHORT).show();
    }
}
