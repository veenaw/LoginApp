package com.example.android.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void validateLogin(View view) {
        final EditText uname = (EditText) findViewById(R.id.username_text);
        final EditText passwd = (EditText) findViewById(R.id.password_text);

        final Button loginButton = (Button) findViewById(R.id.login_button);
        String error = "";

        assert uname != null;
        if (isValidUsername(uname.getText().toString(), error)) {
            assert passwd != null;
            if (checkPassword(uname.getText().toString(), passwd.getText().toString())) {
                // Create an explicit Intent for starting the WelcomeUser Activity
                Intent welcomeUserIntent = new Intent(MainActivity.this,
                        WelcomeUser.class);

                // Use the Intent to start the welcomeUser Activity
                startActivity(welcomeUserIntent);
            } else {
                uname.setText("");
                passwd.setText("");
                // display toast message username and password don't match
                String str1 = "usename:" + passwd.getText().toString() + "and password:" + uname.getText().toString() + "don't match";
                Toast.makeText(MainActivity.this, str1,
                        Toast.LENGTH_SHORT).show();
            }

        } else {
            uname.setText("");
            assert passwd != null;
            passwd.setText("");
            // display toast message "Invalid entry in Username"
            String str1 = "Invalid entry in Username";
            Toast.makeText(MainActivity.this, str1,
                    Toast.LENGTH_SHORT).show();

        }

    }

    public boolean isValidUsername(String username, String error) {
        int length = username.length();
        boolean isValid = true;
        if (length < 8) {
            error += "username length is less than 8";
            isValid = false;
        }

        if (length > 12) {
            error += "username length is greater than 12";
            isValid = false;
        }

        if (!username.matches("[a-zA-Z]*")) {
            error += "username has some special characters";
        }

        return isValid;
    }

    public boolean checkPassword(String uname, String password) {

        return uname.equals("BitsPilani") && password.equals("Wilp12345");
    }
}
