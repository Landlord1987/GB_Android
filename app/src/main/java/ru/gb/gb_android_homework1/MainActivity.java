package ru.gb.gb_android_homework1;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.os.IResultReceiver;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText TextPersonName = findViewById(R.id.TextPersonName);
        TextPersonName.setInputType(InputType.TYPE_CLASS_TEXT);
        Button btn = findViewById(R.id.button);
        Button btn1 = findViewById(R.id.button1);
        Button btn2 = findViewById(R.id.button2);
        TextView tv = findViewById(R.id.textView);
        CheckBox checkBox = findViewById(R.id.checkBox);
        Switch switch1 = findViewById(R.id.switch1);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = TextPersonName.getText().toString();
                tv.setText("Приветствую тебя, " + str);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                OneMoreFragment oneMoreFragment = new OneMoreFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, oneMoreFragment).addToBackStack(null).commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                CalendarFragment calendarFragment = new CalendarFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, calendarFragment).addToBackStack(null).commit();
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) switch1.setBackgroundColor(Color.RED);
                else switch1.setBackgroundColor(Color.WHITE);
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    btn.setBackgroundColor(Color.RED);
                    btn.setTextColor(Color.WHITE);
                    checkBox.setEms(10);
                }
                else {
                    btn.setBackgroundColor(Color.YELLOW);
                    btn.setTextColor(Color.RED);
                    checkBox.setEms(5);
                }

            }
        });

    }

}