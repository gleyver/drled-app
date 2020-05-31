package com.example.drled;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraficoActivity extends AppCompatActivity {

    float rainfail[] = {98.8f, 123.8f, 161.6f, 24.2f, 52f, 68.2f, 35.4f, 13.8f, 78.4f, 203.4f, 240.2f, 159.7f};

    String monthNames[] = {"jan", "Fav", "Mar", "Abril", "Maio", "Jun", "Jul", "Ago", "Sem", "Out", "Nov", "Dez"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        setupPieChar();
    }

    private void setupPieChar() {
        List<PieEntry> pieEntries =  new ArrayList<>();
        for (int i = 0; i < rainfail.length; i++) {
            pieEntries.add(new PieEntry(rainfail[i], monthNames[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Vendas");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);

        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.invalidate();
    }
}
