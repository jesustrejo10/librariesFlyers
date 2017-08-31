package com.test.trejo.jesus.librariesflyers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;
import com.test.trejo.jesus.librariesflyers.HorizontalRecycler.MainViewActivity;
import com.test.trejo.jesus.librariesflyers.LonelyEffect.LonelyEffectActivity;

import com.test.trejo.jesus.librariesflyers.ToolbarEffect.ToolbarEffectActivity;
import com.test.trejo.jesus.librariesflyers.TabDraggable.TabActivityActionBar;
import com.test.trejo.jesus.librariesflyers.TopDraggable.TopDraggableActivity;

public class MainActivity extends AppCompatActivity {

    private Button draggableButton;
    private Button lonelyButton;
    private Button toolbarButton;
    private Button homeButton;
    private Button tabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lonelyButton = (Button) findViewById(R.id.button2);
        lonelyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LonelyEffectActivity.class);
                startActivity(intent);
            }
        });


        homeButton = (Button) findViewById(R.id.button3);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainViewActivity.class);
                startActivity(intent);
            }
        });


        toolbarButton = (Button) findViewById(R.id.button4);
        toolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ToolbarEffectActivity.class);
                startActivity(intent);
            }
        });

        draggableButton = (Button) findViewById(R.id.button);
        draggableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TopDraggableActivity.class);
                startActivity(intent);
            }
        });

        tabButton = (Button) findViewById(R.id.tab_activity);
        tabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TabActivityActionBar.class);
                startActivity(intent);
            }
        });


        manageRangeBar();
        Intent intent = new Intent(getBaseContext(), ToolbarEffectActivity.class);
        startActivity(intent);
    }

    private void manageRangeBar() {
        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar1);

        final TextView tvMin = (TextView) findViewById(R.id.minimo);
        final TextView tvMax = (TextView) findViewById(R.id.maximo);

        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText("Desde $"+String.valueOf(minValue));
                tvMax.setText("Hasta $"+String.valueOf(maxValue));
            }
        });

        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });
    }
}

