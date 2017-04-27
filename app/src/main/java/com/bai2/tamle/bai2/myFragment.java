package com.bai2.tamle.bai2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by tamle on 4/27/17.
 */

public class myFragment extends Fragment {
    public myFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment1, container, false);

        String data = KetQua2.data;
        String result = "";

        try {
            JSONObject JObj = new JSONObject(data);
            Iterator<String> iter = JObj.keys();

            while (iter.hasNext()) {
                String key = iter.next();
                result += "Giải " + key + ": " ;

                JSONArray listGiai = JObj.getJSONArray(key);
                for (int i = 0; i < listGiai.length(); i++) {
                    result += listGiai.get(i) + "  ";

                }

                result += "\n";
            }

        } catch (JSONException e) {

        }

        TextView tv = (TextView) myInflatedView.findViewById(R.id.viewFrag);
        tv.setText(result);

        return myInflatedView;
    }


}
