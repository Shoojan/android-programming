package com.example.sujansmiles.subjects;

import android.content.Context;
import android.graphics.Color;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class VolleyHelper {

    private Context context;
    private String URL = "https://jsonplaceholder.typicode.com/users";

    public VolleyHelper(Context context) {
        this.context = context;
    }

    public ArrayList<Subject> fetch(){
        ArrayList<Subject> list = new ArrayList<>();

        RequestQueue queue= Volley.newRequestQueue(this.context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                this.URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String name = jsonObject.getString("name");

                                Subject subject = new Subject(id, name, Color.GRAY);
                                list.add(subject);
                            }
                        }catch (Exception e){

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        queue.add(jsonArrayRequest);

        return list;
    }
}
