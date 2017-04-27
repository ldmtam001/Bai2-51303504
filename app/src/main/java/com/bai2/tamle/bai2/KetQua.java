package com.bai2.tamle.bai2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class KetQua extends AppCompatActivity {

    private ListView lv;
    ArrayList dateList, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        lv = (ListView) findViewById(R.id.list2);
        dateList = new ArrayList<>();
        list = new ArrayList<>();


        Intent intent = getIntent();
        String jsonString = intent.getStringExtra("data");

        try {
            JSONObject JObj = new JSONObject(jsonString);
            Iterator<String> iter = JObj.keys();

            while (iter.hasNext()) {
                String key = iter.next();
                HashMap<String, Object> date = new HashMap<>();

                try {
                    Object value = JObj.get(key);
                    date.put("name", key);
                    dateList.add(date);
                    list.add(value);
                } catch (JSONException e) {

                }
            }

        } catch (JSONException e) {

        }

        ListAdapter adapter = new SimpleAdapter(KetQua.this, dateList,
                R.layout.list_item2, new String[]{"name"}, new int[]{R.id.listitem2});

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KetQua.this, KetQua2.class);
                String value =  list.get(position).toString();
                intent.putExtra("data", value);
                startActivity(intent);
            }
        });
    }
}
