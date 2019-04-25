package com.ns.totp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.AccessController;

//class Application
//{
//
//}


public class Client_List extends AppCompatActivity {

    ListView listView;
    String client_list_arr[]={"Google","Facebook"};;
    ArrayAdapter adapter;
    Intent i;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client__list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit(); // commit changes
            }
        });




        adapter = new ArrayAdapter<String>(this,
                R.layout.list_layout, client_list_arr);

        listView = (ListView) findViewById(R.id.client_list);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub


                if(!retrieval(client_list_arr[position]))
                {
                    i=new Intent(view.getContext(),MainActivity.class);


                    editor.putBoolean(client_list_arr[position], true);
                    editor.apply();

//                    Log.i("INSIDE INTENT","INSIDE INTENT");
//


//                    showAddItemDialog(Client_List.this);


                    i.putExtra("Application",client_list_arr[position]+"");
                    i.putExtra("OTP","12345678");

                    startActivity(i);

//                    final EditText taskEditText = new EditText(Client_List.this);
//
//
//
//                    taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//
//
//
//
//                    AlertDialog dialog = new AlertDialog.Builder(Client_List.this)
//                            .setTitle("Enter the key")
////                          .setMessage("M")
//                            .setView(taskEditText)
//                            .setPositiveButton("Done!", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    String task = String.valueOf(taskEditText.getText());
//
//
//                                    //send_back(task);
//
//    //                        Intent i;
//    //                        View view;
//    //                        i=new Intent(view.getContext(),MainActivity.class);
//
//
//
//                                }
//                            })
//                            .setNegativeButton("Cancel", null)
//                            .create();
//                            dialog.show();


                }
                else
                {
                    Toast.makeText(Client_List.this,"Client Already registered", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }



    void storage(String input,boolean value,View view)
    {

        Log.i("INSIDE STORAGE",input+"-->"+value);

        editor.putBoolean(input, true); // Storing boolean - true/false
//        editor.putString("key_name", "string value"); // Storing string
//        editor.putInt("key_name", "int value"); // Storing integer
//        editor.putFloat("key_name", "float value"); // Storing float
//        editor.putLong("key_name", "long value"); // Storing long

        Log.i("INSIDE STORAGE 2",input+"-->"+value);


//        editor.putBoolean(client_list_arr[0],false);
//        editor.putBoolean(client_list_arr[1],false);
        editor.apply();
    }
//
    boolean retrieval(String input)
    {

        Log.i("RETRIEVE",input);
        Log.i("RETRIEVE",pref.contains(input)+"");


        if(pref.contains(input))
            return pref.getBoolean(input, false); // getting boolean
        else
            return false;
    }

    void clear()
    {

        editor.clear();
        editor.commit(); // commit changes

    }

//    private void showAddItemDialog(Context c) {
//        final EditText taskEditText = new EditText(c);
//
//
//
//        taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//
//        AlertDialog dialog = new AlertDialog.Builder(c)
//                .setTitle("Enter the key")
////                .setMessage("M")
//                .setView(taskEditText)
//                .setPositiveButton("Done!", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        String task = String.valueOf(taskEditText.getText());
//
//
//                        send_back(task);
//
////                        Intent i;
////                        View view;
////                        i=new Intent(view.getContext(),MainActivity.class);
//
//
//
//                    }
//                })
//                .setNegativeButton("Cancel", null)
//                .create();
//        dialog.show();
//
//
//    }

//
//    void send_back(String Str)
//    {
//        Intent i;
//
//        i=new Intent(view.getContext(),MainActivity.class);
//        Log.i("INSIDE INTENT","INSIDE INTENT");
//        i.putExtra("Application",client_list_arr[position]+"");
//        i.putExtra("OTP","12345678");
//    }

}



//class CallAPI extends AsyncTask<String, String, String> {
//
//    public CallAPI(){
//        //set context variables if required
//    }
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }
//
//    @Override
//    protected String doInBackground(String... params) {
//        String urlString = "http://totpnetsec-env.bmec7xepkp.ap-south-1.elasticbeanstalk.com/test"; // URL to call
//        String data = "DUMMY"; //data to post
//        OutputStream out = null;
//
//        try {
//            URL url = new URL("http://totpnetsec-env.bmec7xepkp.ap-south-1.elasticbeanstalk.com/test");
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            out = new BufferedOutputStream(urlConnection.getOutputStream());
//
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
//            writer.write(data);
//            writer.flush();
//            writer.close();
//            out.close();
//
//            urlConnection.connect();
//
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        String responseCode = HttpURLConnection.getResponseMessage();
//
//
//
//
//        return "success";
//    }
//}
