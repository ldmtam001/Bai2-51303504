package com.bai2.tamle.bai2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private ListView lv;
    ArrayList cityList, list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        lv = (ListView) findViewById(R.id.list);
        cityList = new ArrayList<>();
        list = new ArrayList<>();

        Intent intent = getIntent();
        String jsonString = intent.getStringExtra("jsonString");
        //Toast.makeText(getApplication().getBaseContext(), jsonString, Toast.LENGTH_SHORT).show();
        try {
            JSONObject JObj = new JSONObject(jsonString);
            Iterator<String> iter = JObj.keys();
            while (iter.hasNext()) {
                String key = iter.next();
                HashMap<String, Object> city = new HashMap<>();
                try {
                    Object value = JObj.get(key);
                    city.put("name", key);
                    cityList.add(city);
                    list.add(value);
                } catch (JSONException e) {

                }
            }

            ListAdapter adapter = new SimpleAdapter(
                    DetailActivity.this, cityList,
                    R.layout.list_item, new String[]{"name"}, new int[]{R.id.name}
            );
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(DetailActivity.this, KetQua.class);
                    String value =  list.get(position).toString();
                    intent.putExtra("data", value);
                    startActivity(intent);
                }
            });

        } catch (JSONException e) {
            Log.e("MYAPP", "Loi parse json");
        }

    }
}
