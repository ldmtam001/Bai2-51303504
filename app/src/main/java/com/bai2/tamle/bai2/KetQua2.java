package com.bai2.tamle.bai2;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class KetQua2 extends AppCompatActivity{
    public static String data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String jsonString = intent.getStringExtra("data");
        data = jsonString;

        setContentView(R.layout.activity_ket_qua2);

        myFragment frag = new myFragment();
    }

}
