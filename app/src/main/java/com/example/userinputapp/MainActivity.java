package com.example.userinputapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.userinputapp.NAME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    anytime a method is to be called from a button click, it MUST HAVE a specific type of method
    signature. If you don't use the right signature, your button will NOT be allowed to call
    this method.
    ex:
    public void methodName(View v) {
    }

    View is a class that you need to import and you will be prompted to do so. View is "generic"
    and applies to the view of the screen where the button was located.

     */
    public void makeName(View v)
        {
            EditText firstNameET = findViewById(R.id.firstNameEditText);
            EditText lastNameET = findViewById(R.id.lastNameEditText);

            String firstName = firstNameET.getText().toString();
            String lastName = lastNameET.getText().toString();

            String fullName = firstName + " " + lastName;
            TextView fullNameTextView = findViewById(R.id.completeNameTextView);
            fullNameTextView.setText(fullName);
        }
        //This method is an example of taking text from an EditText on one screen
        // and displaying it on a DIFFERENT SCREEN. We are using Intents to switch
        // activities.

    public void sendMessage(View v)
        {
            //this creates the intent that will go from this current Activity to
            //DisplayWelcomeActivity
            Intent intent  = new Intent(this, DisplayWelcomeActivity.class);
            EditText firstNameET = findViewById(R.id.firstNameEditText);
            EditText lastNameET = findViewById(R.id.lastNameEditText);

            String firstName = firstNameET.getText().toString();
            String lastName = lastNameET.getText().toString();

            String fullName = firstName + " " + lastName;

            //attaching the full name String to the intent so we can send it alone to the new
            //Activity
            intent.putExtra(EXTRA_NAME, fullName);

            //this method will start the new Activity
            startActivity(intent);
        }

}