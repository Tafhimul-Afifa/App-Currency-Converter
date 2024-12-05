package com.icwd.convert;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.icwd.convert.databinding.ActivityMainBinding;
import com.icwd.convert.databinding.ActivityViewBindingExampleBinding;

public class ViewBindingExample extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewBindingExampleBinding viewBindingclass  =ActivityViewBindingExampleBinding.inflate(getLayoutInflater());
        setContentView(viewBindingclass.getRoot());

        viewBindingclass.ViewBindingClickButton.setOnClickListener(view->{

            Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show();
        } );




    }
}