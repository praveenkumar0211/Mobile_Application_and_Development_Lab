package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView simpleview = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        TextView disp = (TextView)findViewById(R.id.textView2);

        simpleview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                System.out.println(item);
                if(item.equals("Java"))
                {
                    disp.setText("Java is a high-level, class-based, object-oriented programming language first released by Sun Microsystems in 1995.\n\nThe latest version of Java is Java 17 or JDK 17 released on September, 14th 2021.");

                }
                else if(item.equals("CPP"))
                {
                    disp.setText("C++ is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language.\n\nThe latest version is C++20 published in December 2020");

                }
                else if(item.equals("Python"))
                {
                    disp.setText("Python is an interpreted high-level general-purpose programming language.\n\nIts design philosophy emphasizes code readability with its use of significant indentation.\n\nPython 3.9.0 is the current version released in October 2020 ");
                }
            }

        });
        String arr[] = getResources().getStringArray(R.array.programming_languages);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.dropdown_item, arr);
        simpleview.setAdapter(arrayAdapter);
    }



}