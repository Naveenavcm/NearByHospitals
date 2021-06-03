package com.example.helpinghands_is;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
//<ArrayAdapter>
public class ListDisplay extends AppCompatActivity {
    TextView listView;
    StringBuffer s = new StringBuffer("LIST \n");
//ArrayAdapter arrayAdapter;

    String reviews="{l 9:00 pm\"}, {\"name\": \"Ponmani service centre\", \"address\": \"No.32, 29, Jeenis Rd\", \"phone\": \"\", \"rating\": \"4.7\", \"status\": \"\\\\u00b7\"}, {\"name\": \"LAKSHMI HYUNDAI SERVICE CENTER\", \"address\": \"14\", \"phone\": \"\", \"rating\": \"5.0\", \"status\": \"Open until 9:30 pm\"}, {\"name\": \"Chandarns Auto Works\", \"address\": \"152, Mount Road, Saidapet, Saidapet\", \"phone\": \"\", \"rating\": \"4.0\", \"status\": \"\"}, {\"name\": \"Vijayalakshmi Service Centre\", \"address\": \"No. 30/33, Dharamaraja Koil Street, Saidapet\", \"phone\": \"\", \"rating\": \"1.0\", \"status\": \"\"}, {\"name\": \"Highway Auto Service\", \"address\": \"398, Anna Road, Nandanam, Nandanam\", \"phone\": \"\", \"rating\": \"4.8\", \"status\": \"\"}, {\"name\": \"Babu Electrical And Service Centre\", \"address\": \"Shop No. 44, Old No. 14, New No. 40, Reddy Kuppam Rd\", \"phone\": \"098401 96720\", \"rating\": \"5.0\", \"status\": \"\"}, {\"name\": \"Sri Sankar Auto Services\", \"address\": \"Ts 87, Thiru-via-ka-industrial Estate, Ekkatuthangal, Ekkatuthangal\", \"phone\": \"\", \"rating\": \"5.0\", \"status\": \"\"}, {\"name\": \"Krsa Auto Care\", \"address\": \"Np 3/b Guindy Industrial Estateekkaduthangal Chennai 600032\", \"phone\": \"098412 30430\", \"rating\": \"4.5\", \"status\": \"\"}, {\"name\": \"VJ CARS\", \"address\": \"62, Jeenis Rd, opp. Post Office\", \"phone\": \"\", \"rating\": \"5.0\", \"status\": \"\"}, {\"name\": \"Bala Automobiles Service\", \"address\": \"No.8, Old No.10, Chinnah Garden 2nd Street, E Jones Rd\", \"phone\": \"044 2433 0043\", \"rating\": \"1.0\", \"status\": \"Open until 5:00 pm\"}]";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arraylist=new ArrayList<>();
        ArrayAdapter arrayAdapter;
        listView = (TextView) findViewById(R.id.oxygen);
        arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, R.id.oxygen);
        //TextView.setAdapter(arrayAdapter);
        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET,
                "http://ec2-18-191-243-9.us-east-2.compute.amazonaws.com:8080/oxygendetails/patta",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try { if(response != null) {
                            try { Log.d("inside response","got response");
                                JSONArray list = response.getJSONArray("area");
                                //TextView post_response_t=findViewById(R.id.post_respone_data);
                                //post_response_t.setText("details:");
                                for (int i = 0; i < list.length(); i++) {
                                    JSONObject obj = list.getJSONObject(i);
                                    String oxyshopname = obj.getString("name");
                                    s.append(oxyshopname);
                                    s.append("\n");
                                    Log.d("shop",oxyshopname);
                                    //Log.d("sop",shopname);
                                    String oxyshopaddress = obj.getString("address");
                                    Log.d("shopadd",oxyshopaddress);
                                    s.append(oxyshopaddress);
                                    s.append("\n");
                                    String phone = obj.getString("phone");
                                    Log.d("shopphone",phone);
                                    s.append(phone);
                                    s.append("\n");
                                    String shopstatus = obj.getString("status");
                                    Log.d("shopstatus",shopstatus);
                                    s.append(shopstatus);
                                    s.append("\n");

                                    s.append("******************************************\n");
                                    arraylist.add(oxyshopname + "\n" + oxyshopaddress + "\n" + phone + "\n" + shopstatus + "\n");
                                }
                                Log.d("name",s.toString());
                                listView.setText(s.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            arrayAdapter.clear();
                            arrayAdapter.addAll(arraylist);
                            arrayAdapter.notifyDataSetChanged();
                        }


                        }

                        finally {

                        }

                    }

                    // ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.textView, animalList);

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volly Error", error.toString());

                        Log.d("areas", "Something went wrong");
                        //TextView post_response_text=findViewById(R.id.post_respone_data);

                        try{JSONObject jsonObject=new JSONObject(reviews);
                            String name;
                            JSONArray  jsonArray=jsonObject.getJSONArray("mech");
                        }
                        catch(JSONException e){

                        }

                        // post_response_text.setText("reviews :'[{\"name\": \"Vijayalakshmi Services Centre\", \"address\": \"No. 18/41, Potters St\", \"phone\": \"044 2435 7714\", \"rating\": \"4.4\", \"status\": \"Open until 9:00 pm\"}, {\"name\": \"Ponmani service centre\", \"address\": \"No.32, 29, Jeenis Rd\", \"phone\": \"\", \"rating\": \"4.7\", \"status\": \"\\\\u00b7\"}, {\"name\": \"LAKSHMI HYUNDAI SERVICE CENTER\", \"address\": \"14\", \"phone\": \"\", \"rating\": \"5.0\", \"status\": \"Open until 9:30 pm\"}, {\"name\": \"Chandarns Auto Works\", \"address\": \"152, Mount Road, Saidapet, Saidapet\", \"phone\": \"\", \"rating\": \"4.0\", \"status\": \"\"}, {\"name\": \"Vijayalakshmi Service Centre\", \"address\": \"No. 30/33, Dharamaraja Koil Street, Saidapet\", \"phone\": \"\", \"rating\": \"1.0\", \"status\": \"\"}, {\"name\": \"Highway Auto Service\", \"address\": \"398, Anna Road, Nandanam, Nandanam\", \"phone\": \"\", \"rating\": \"4.8\", \"status\": \"\"}, {\"name\": \"Babu Electrical And Service Centre\", \"address\": \"Shop No. 44, Old No. 14, New No. 40, Reddy Kuppam Rd\", \"phone\": \"098401 96720\", \"rating\": \"5.0\", \"status\": \"\"}, {\"name\": \"Sri Sankar Auto Services\", \"address\": \"Ts 87, Thiru-via-ka-industrial Estate, Ekkatuthangal, Ekkatuthangal\", \"phone\": \"\", \"rating\": \"5.0\", \"status\": \"\"}, {\"name\": \"Krsa Auto Care\", \"address\": \"Np 3/b Guindy Industrial Estateekkaduthangal Chennai 600032\", \"phone\": \"098412 30430\", \"rating\": \"4.5\", \"status\": \"\"}, {\"name\": \"VJ CARS\", \"address\": \"62, Jeenis Rd, opp. Post Office\", \"phone\": \"\", \"rating\": \"5.0\", \"status\": \"\"}, {\"name\": \"Bala Automobiles Service\", \"address\": \"No.8, Old No.10, Chinnah Garden 2nd Street, E Jones Rd\", \"phone\": \"044 2433 0043\", \"rating\": \"1.0\", \"status\": \"Open until 5:00 pm\"}]' " );
                        Toast.makeText(ListDisplay.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

                    }
                });

        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(jsonArrayRequest);
        listView.setText(s);
        //ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,R.layout.activity_list_view,arraylist);

    }
}
                        /*
                        Log.d("areas", "onResponse: Title is: " +
                                obj.getString("name") + " and address is " + obj.getString("address") + " and phone number is " + obj.getString("phone"));
                         */