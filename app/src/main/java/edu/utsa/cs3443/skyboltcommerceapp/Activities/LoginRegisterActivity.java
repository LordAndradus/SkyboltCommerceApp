package edu.utsa.cs3443.skyboltcommerceapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import edu.utsa.cs3443.skyboltcommerceapp.R;

public class LoginRegisterActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Log.d("Main Activity", "Starting up application");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
    }
}