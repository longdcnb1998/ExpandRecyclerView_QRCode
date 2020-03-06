package com.example.expandrecyclerview_qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expandrecyclerview_qrcode.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ItemAdapter adapter;
    ArrayList<Lesson> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        initData();

        adapter = new ItemAdapter(this,list);
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.setHasFixedSize(true);

        final Intent intent = new Intent(this,QrCodeActivity.class);

        binding.btnQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new Lesson("Long Dinh","Lop 12B",0,"07:00","09:00",false));
        list.add(new Lesson("Tran Ha","Lop 12B",0,"07:00","09:00",false));
        list.add(new Lesson("Vu Ha","Lop 12B",0,"07:00","09:00",false));
        list.add(new Lesson("GG","Lop 12B",0,"07:00","09:00",false));
        list.add(new Lesson("Wveg","Lop 12B",0,"07:00","09:00",false));
    }
}
