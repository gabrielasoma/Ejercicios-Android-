package com.example.final1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class TabHost1 extends AppCompatActivity {
    private TabHost th;
    private TabHost.TabSpec spec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host1);

        th=(TabHost)findViewById(R.id.tabHost);
        th.setup();

        spec=th.newTabSpec("UNO");
        spec.setContent(R.id.Pestana1);
        spec.setIndicator("PESTAÑA 1");
        th.addTab(spec);

        spec=th.newTabSpec("DOS");
        spec.setContent(R.id.Pestana2);
        spec.setIndicator("PESTAÑA 2");
        th.addTab(spec);

        spec=th.newTabSpec("TRES");
        spec.setContent(R.id.Pestana3);
        spec.setIndicator("PESTAÑA 3");
        th.addTab(spec);
    }

}