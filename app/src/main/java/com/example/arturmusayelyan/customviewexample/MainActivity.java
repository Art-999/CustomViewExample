package com.example.arturmusayelyan.customviewexample;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.arturmusayelyan.customviewexample.adapters.RecAdapterFirst;
import com.example.arturmusayelyan.customviewexample.interfaces.RecycleClick;
import com.example.arturmusayelyan.customviewexample.model.Student;
import com.example.arturmusayelyan.customviewexample.views.Loader;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleClick {
    private RecyclerView recyclerView;
    private ArrayList<Student> studentsList;
    private RelativeLayout mainView;
    private Loader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_main);
        init();
        initRecAdapterFirst(studentsList);
    }

    private void init() {
        mainView = findViewById(R.id.main_view);
        recyclerView = findViewById(R.id.recycler_view);
        //ItemRow itemRow=findViewById(R.id.custom_row_example);
        studentsList = new ArrayList<>();
        studentsList.add(new Student("Artur", "1", "80000"));
        studentsList.add(new Student("Karen", "2", "40000"));
        studentsList.add(new Student("Vardan", "3", "70000"));
        studentsList.add(new Student("Vahag", "4", "80000"));
        studentsList.add(new Student("Gevorg", "5", "80000"));
        studentsList.add(new Student("Tamar", "6", "80000"));
        studentsList.add(new Student("Rubo", "7", "80000"));
        studentsList.add(new Student("Petros", "8", "80000"));
        studentsList.add(new Student("Yura", "9", "80000"));
        studentsList.add(new Student("Alex", "10", "80000"));
        studentsList.add(new Student("Manvel", "11", "80000"));
        studentsList.add(new Student("Mesrop", "12", "80000"));
        studentsList.add(new Student("Telo", "13", "80000"));
        studentsList.add(new Student("Omar", "14", "80000"));
        studentsList.add(new Student("Firdus", "15", "80000"));
        studentsList.add(new Student("Karlen", "16", "80000"));
        studentsList.add(new Student("Serjo", "17", "80000"));
        studentsList.add(new Student("Hakob", "18", "80000"));
        studentsList.add(new Student("Arman", "19", "80000"));
        studentsList.add(new Student("Ashot", "20", "80000"));
        studentsList.add(new Student("Axas", "21", "80000"));
    }

    private void initRecAdapterFirst(ArrayList<Student> studentsList) {
        if (studentsList != null && studentsList.size() > 0) {
            RecAdapterFirst adapterFirst = new RecAdapterFirst(this, studentsList);
            recyclerView.setAdapter(adapterFirst);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            adapterFirst.setRecycleClick(this);
        }
    }

    @Override
    public void click(View view, int position) {
        Toast.makeText(this, "Clicked at position " + position, Toast.LENGTH_SHORT).show();

        // add enq anum custom view
        loader = new Loader(this);
        mainView.addView(loader);
        loader.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                loader.post(new Runnable() {
                    @Override
                    public void run() {
                        loader.end();
                    }
                });
            }
        }).start();
    }
}
