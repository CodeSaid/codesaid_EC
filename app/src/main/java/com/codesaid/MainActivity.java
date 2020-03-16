package com.codesaid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.codesaid.lib_core.app.CodeSaid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(CodeSaid.getApplication(), "success context", Toast.LENGTH_SHORT).show();
    }
}
