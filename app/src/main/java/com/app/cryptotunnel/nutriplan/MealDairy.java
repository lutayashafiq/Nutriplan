package com.app.cryptotunnel.nutriplan;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MealDairy extends ActionBarActivity {


    private ListView mainListView;
    ListView listView;
    ArrayList<String> al = new ArrayList<String>();


    private ArrayAdapter<String> listAdapter;

//    String[] nutriArray={
//            "Daily plan",
//            "Nutri Calculator",
//            "Health tips",
//            "Meal dairy",
//            "About"
//    };

    String[] nutriArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_android_example);

        DatabaseHandler db = new DatabaseHandler(this);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[]{"Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
            al.add(log);
        }

        nutriArray = new String[al.size()];
        nutriArray = al.toArray(nutriArray);

//        nutriArray =new String[]{
//          al.get(0),al.get(1),al.get(2),al.get(3)
//        };


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, nutriArray);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                switch (itemPosition) {
                    case 0:
                        Toast.makeText(getApplicationContext(),
                                "clicked daily plan" + itemValue, Toast.LENGTH_LONG)
                                .show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),
                                "clicked nutri calculator", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        break;
                    case 4:
                        Toast.makeText(getApplicationContext(),
                                "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                                .show();
                        break;


                }

                // Show Alert
//                Toast.makeText(getApplicationContext(),
//                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
//                        .show();

            }

        });
    }
}

