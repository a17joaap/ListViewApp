package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Let the static raw data that you use in your ListView be created here as a
    // member variable to the MainActivity class.
    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        String [] mountains = {"Mt. Everest", "K2", "Kangchenjunga", "Lhotse", "Makalu", "Cho Oyu", "Dhaulagiri", "Manaslu", "Nanga Parbat", "Annapurna"};
        final String [] heights = {"8,848m", "8,611m", "8,586m", "8,516m", "8,485m", "8,201m", "8,167m", "8,163m", "8,126m", "8,091m"};

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item_textview, R.id.itemTextView, mountains);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String mountain = String.valueOf(adapterView.getItemAtPosition(i));
                        String height = heights[i];
                        String mountainHeight = mountain+" - "+height;
                        Toast.makeText(MainActivity.this, mountainHeight, Toast.LENGTH_LONG).show();
                    }
                }
        );
        // The onCreate method is run when the app is created.
        // Before you can implement this you need to create the layout xml files that
        // will hold/show your data created here. You need three create things:
        // * my_listview - the ID to the actual layout element that is our ListView.
        //                 This my_listview element is created in the activity_main.xml file
        // * list_item_textview - This is a new layout xml file that holds the layout for an
        //                        individual item in the ListView we are creating
        // * my_item_textview - This is the ID to the actual TextView that will contain the text for
        //                      an individual item in the ListView we are creating.
        // Here you should enter your code that fills the ListView
        // 1. Create an array
        // 2. Create a List object with your array from step 1 as in-data
        // 3. Create an ArrayAdapter object that connects
        //    * list_item_textview
        //    * my_item_textview
        //    * List object created in step 2
        // 4. Find the ListView layout element "my_listview" and create an object instance
        // 5. Connect the ArrayAdapter from step 3 with ListView object created in step 4
        // 6. Style the ListView items according to Material Design
        //    See: https://material.io/guidelines/components/lists.html#lists-specs
        //    Look for "singel line specs" for "text only" lists and modify the list_item_textview
        //    accordingly
    }
}
