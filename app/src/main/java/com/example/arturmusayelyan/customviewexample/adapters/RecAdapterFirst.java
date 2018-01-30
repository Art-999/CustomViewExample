package com.example.arturmusayelyan.customviewexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arturmusayelyan.customviewexample.R;
import com.example.arturmusayelyan.customviewexample.interfaces.RecycleClick;
import com.example.arturmusayelyan.customviewexample.model.Student;
import com.example.arturmusayelyan.customviewexample.views.ItemRow;

import java.util.ArrayList;

/**
 * Created by artur.musayelyan on 30/01/2018.
 */

public class RecAdapterFirst extends RecyclerView.Adapter<RecAdapterFirst.MyViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Student> studentsList;
    private RecycleClick recycleClick;

    public RecAdapterFirst(Context context, ArrayList<Student> personsList) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.studentsList = personsList;
    }

    public void setRecycleClick(RecycleClick recycleClick) {
        this.recycleClick = recycleClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student currentStudent = studentsList.get(position);
        holder.textView.setText(currentStudent.getName());
        if (currentStudent.getName() == "Vahag") {
            ItemRow itemRow = new ItemRow(context);
            itemRow.idSetText(currentStudent.getId());
            itemRow.salarySetText(currentStudent.getCount());
            itemRow.idSetClickListener();
            holder.customViewContainer.addView(itemRow);
//            holder.customViewContainer.addView(itemRow);
//            holder.customViewContainer.addView(itemRow);
//            holder.customViewContainer.addView(itemRow);

        }
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private LinearLayout customViewContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.custom_rom_text);
            customViewContainer = itemView.findViewById(R.id.container_for_item);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recycleClick.click(v, getAdapterPosition());
        }
    }
}
