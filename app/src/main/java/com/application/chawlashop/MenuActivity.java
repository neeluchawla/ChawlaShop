package com.application.chawlashop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    //a list to store all the products
    List<Salad> saladList;

    //the recyclerview
    RecyclerView recyclerView;
    public double total=0;
    SaladAdapter saladAdapter;
    public static TextView tv_total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        saladList = new ArrayList<>();


        //adding some items to our list
        saladList.add(
                new Salad(
                        1,
                        "SEARED TUNA SALAD",
                        "mixed greens, arugula, kale, avocado, cucumber, edamame, super slaw, apples, tempura onions, toasted sesame seeds, spicy togarashi seared tuna",
                        20.99,
                        R.drawable.sesame_salad));

        saladList.add(
                new Salad(
                        2,
                        "ASIAN SALAD",
                        "romaine lettuce, mixed greens, avocado, mandarin oranges, cherry tomatoes, shredded carrots, crunchy noodles, toasted sesame seeds",
                        11.49,
                        R.drawable.asian_salad));

        saladList.add(
                new Salad(
                        3,
                        "CAESAR SALAD",
                        "kale, romaine lettuce, baked pita chips, mozzarella, shaved parmesan, bacon, free run hard boiled egg",
                        14.49,
                        R.drawable.caesar_salad));
        saladList.add(
                new Salad(
                        4,
                        "HARVEST SALAD",
                        "romaine lettuce, mixed greens, cherry tomatoes, roasted sweet potato, dried cranberries, pecans, pumpkin seeds, goat cheese",
                        13.99,
                        R.drawable.harvest_salad));

        //creating recyclerview adapter
        SaladAdapter adapter = new SaladAdapter(this, saladList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        adapter.registerAdapterDataObserver(observer);

    }
    RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {

        @Override
        public void onChanged() {
            super.onChanged();
            calculateTotal();
        }
    };


    public void calculateTotal() {
        int i = 0;
        total=0;
        while(i < saladList.size()){
            if(saladList.get(i).getQuantity()>0) {
                total = total + (saladList.get(i).getPrice() * Integer.valueOf(saladList.get(i).getQuantity()));
            }
            i++;

        }
        tv_total =(TextView) findViewById(R.id.tv_total);
        tv_total.setText(""+total);
    }

    public void insertOrder(View view) {
    }
}
