package edu.utsa.cs3443.skyboltcommerceapp.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import dagger.hilt.android.AndroidEntryPoint;
import edu.utsa.cs3443.skyboltcommerceapp.R;

@AndroidEntryPoint
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