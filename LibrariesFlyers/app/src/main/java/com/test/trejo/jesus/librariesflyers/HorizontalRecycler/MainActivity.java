package com.test.trejo.jesus.librariesflyers.HorizontalRecycler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;
import com.test.trejo.jesus.librariesflyers.LonelyEffect.LonelyEffectActivity;
import com.test.trejo.jesus.librariesflyers.R;
import com.test.trejo.jesus.librariesflyers.TopDraggable.TopDraggableActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private HorizontalAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<RecyclerObject> mdataSet;

    private Button draggableButton;
    private Button lonelyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerObject test = new RecyclerObject();
        mdataSet = new ArrayList<>();
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);
        mdataSet.add(test);

        draggableButton = (Button) findViewById(R.id.button);

        draggableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TopDraggableActivity.class);
                startActivity(intent);
            }
        });
        mAdapter = new HorizontalAdapter(mdataSet);

        RecyclerViewPager mRecyclerView = (RecyclerViewPager) findViewById(R.id.list);
        // setLayoutManager like normal RecyclerView, you do not need to change any thing.
        LinearLayoutManager layout = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(layout);
        mRecyclerView.setAdapter(mAdapter);

        lonelyButton = (Button) findViewById(R.id.button2);
        lonelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LonelyEffectActivity.class);
                startActivity(intent);
            }
        });


    }

}

