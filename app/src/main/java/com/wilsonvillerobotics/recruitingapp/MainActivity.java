package com.wilsonvillerobotics.recruitingapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private boolean colorIsBlack = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(getResources().getIdentifier("clear_button", "id", getPackageName()) != 0)
            (findViewById(getResources().getIdentifier("clear_button", "id", getPackageName()))).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        String messageToDisplay = getString(R.string.message_to_display); //This is where you make changes
        EditText nameTextField;
        TextView outputTextField;

        if(getResources().getIdentifier("clear_button", "id", getPackageName()) == 0) {
            switch (viewId) {
                case(R.id.submit_button):
                    nameTextField = findViewById(R.id.name_entry_field);
                    outputTextField = findViewById(R.id.user_message_field);

                    String name = nameTextField.getText().toString();
                    String messageWithName = messageToDisplay + " " + name;
                    outputTextField.setText(messageWithName);
                    break;
                default:
                    break;
            }
        } else {
            if (viewId == getResources().getIdentifier("submit_button", "id", getPackageName())) {
                    nameTextField = findViewById(R.id.name_entry_field);
                outputTextField = findViewById(R.id.user_message_field);

                String name = nameTextField.getText().toString();
                String messageWithName = messageToDisplay + " " + name;
                outputTextField.setText(messageWithName);
            } else if (viewId == getResources().getIdentifier("clear_button", "id", getPackageName())) {
                nameTextField = findViewById(R.id.name_entry_field);
                outputTextField = findViewById(R.id.user_message_field);

                if (colorIsBlack) {
                   outputTextField.setTextColor(Color.BLUE);
                    colorIsBlack = false;
                }
                else {
                    outputTextField.setTextColor(Color.BLACK);
                    colorIsBlack = true;
                }
            }
        }
    }

}

