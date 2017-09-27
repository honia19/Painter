package com.vladislav.canvaswc;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

import Viewer.DrawLine;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener
{
    DrawLine dr;
    Button c_green,c_blue, c_pastel, c_pink, c_lavanda, c_orange, c_black, c_red;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dr = (DrawLine) findViewById(R.id.drwLine);

        c_green = (Button) findViewById(R.id.c_green);
        c_blue = (Button) findViewById(R.id.c_blue);
        c_pastel = (Button) findViewById(R.id.c_pastel);
        c_pink = (Button) findViewById(R.id.c_pink);
        c_lavanda = (Button) findViewById(R.id.c_lavanda);
        c_orange = (Button) findViewById(R.id.c_orange);
        c_black = (Button) findViewById(R.id.c_black);
        c_red = (Button) findViewById(R.id.c_red);
        spinner = (Spinner) findViewById(R.id.spinner);



        c_green.setOnClickListener(this);
        c_blue.setOnClickListener(this);
        c_pastel.setOnClickListener(this);
        c_pink.setOnClickListener(this);
        c_lavanda.setOnClickListener(this);
        c_orange.setOnClickListener(this);
        c_black.setOnClickListener(this);
        c_red.setOnClickListener(this);



        ArrayList<String> width = new ArrayList<>();
        width.add("5");
        width.add("10");
        width.add("15");
        width.add("30");
        width.add("50");
        width.add("70");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, width);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.menu_save: dr.saveImage();
                Toast.makeText(this,"Image saved",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_load: dr.loadImage();
                break;
            default:
                Toast.makeText(this,"Error",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.c_green:
                dr.changeColor(Color.rgb(156, 204, 101));
                break;
            case R.id.c_blue:
                dr.changeColor(Color.rgb(63, 81, 181));
                break;
            case R.id.c_pastel:
                dr.changeColor(Color.rgb(229, 57, 53));
                break;
            case R.id.c_pink:
                dr.changeColor(Color.rgb(213, 0, 249));
                break;
            case R.id.c_lavanda:
                dr.changeColor(Color.rgb(126, 87, 194));
                break;
            case R.id.c_orange:
                dr.changeColor(Color.rgb(255, 87, 34));
                break;
            case R.id.c_black:
                dr.changeColor(Color.rgb(0, 0, 0));
                break;
            case R.id.c_red:
                dr.changeColor(Color.rgb(204, 24, 18));
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l)
    {
        String item = adapterView.getItemAtPosition(pos).toString();
                switch (item) {
                    case "5":
                        dr.changeWidth(5f);
                        break;
                    case "10":
                        dr.changeWidth(10f);
                        break;
                    case "15":
                        dr.changeWidth(15f);
                        break;
                    case "30":
                        dr.changeWidth(30f);
                        break;
                    case "50":
                        dr.changeWidth(50f);
                        break;
                    case "70":
                        dr.changeWidth(70f);
                        break;
                    default:
                        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                        break;
                }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}



