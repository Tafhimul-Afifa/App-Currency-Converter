package com.icwd.convert;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.icwd.convert.databinding.ActivityMainBinding;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    double fromValue = 0.0;
    String fromUnit = "";

    double toValue = 0.0;

    String toUnit = "";


    private List<String> units= Arrays.asList(

            "USD", "BDT", "INR", "EUR", "CAD", "BTC","CNY", "PKR", "YEN", "WON", "ZAR"

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initComponents();

    }

    private void initComponents() {
        Collections.sort(units);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, units);
        binding.toUnit.setAdapter(arrayAdapter);
        binding.fromUnit.setAdapter(arrayAdapter);

        binding.convertButton.setOnClickListener(view -> {
//            get the values
            try {


                fromValue = Double.parseDouble(binding.fromValue.getText().toString());
                fromUnit = binding.fromUnit.getSelectedItem().toString();
                toUnit = binding.toUnit.getSelectedItem().toString();
                convertValue();


            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    //    contains the logic to convert the currencies

    private void convertValue() {
        try {
            if (fromUnit.equals(toUnit)) {
                toValue = fromValue; // No conversion needed if units are the same
            }
            // Conversion rates for BDT
            else if (fromUnit.equals("BDT") && toUnit.equals("USD")) toValue = fromValue / 120.0;
            else if (fromUnit.equals("BDT") && toUnit.equals("INR")) toValue = fromValue / 1.42;
            else if (fromUnit.equals("BDT") && toUnit.equals("EUR")) toValue = fromValue / 127.0;
            else if (fromUnit.equals("BDT") && toUnit.equals("CAD")) toValue = fromValue / 90.0;
            else if (fromUnit.equals("BDT") && toUnit.equals("CNY")) toValue = fromValue / 16.0;
            else if (fromUnit.equals("BDT") && toUnit.equals("PKR")) toValue = fromValue / 1.62;
            else if (fromUnit.equals("BDT") && toUnit.equals("YEN")) toValue = fromValue / 1.10;
            else if (fromUnit.equals("BDT") && toUnit.equals("WON")) toValue = fromValue / 0.09;
            else if (fromUnit.equals("BDT") && toUnit.equals("ZAR")) toValue = fromValue / 7.0;
            else if (fromUnit.equals("BDT") && toUnit.equals("BTC")) toValue = fromValue /0.00000011 ;

                // Conversion rates for USD
            else if (fromUnit.equals("USD") && toUnit.equals("BDT")) toValue = fromValue * 120.0;
            else if (fromUnit.equals("USD") && toUnit.equals("INR")) toValue = fromValue * 83.22;
            else if (fromUnit.equals("USD") && toUnit.equals("EUR")) toValue = fromValue / 1.1;
            else if (fromUnit.equals("USD") && toUnit.equals("CAD")) toValue = fromValue * 0.75;
            else if (fromUnit.equals("USD") && toUnit.equals("CNY")) toValue = fromValue * 7.0;
            else if (fromUnit.equals("USD") && toUnit.equals("PKR")) toValue = fromValue * 280.0;
            else if (fromUnit.equals("USD") && toUnit.equals("YEN")) toValue = fromValue * 145.0;
            else if (fromUnit.equals("USD") && toUnit.equals("WON")) toValue = fromValue * 1300.0;
            else if (fromUnit.equals("USD") && toUnit.equals("ZAR")) toValue = fromValue * 18.0;

                // Conversion rates for INR
            else if (fromUnit.equals("INR") && toUnit.equals("BDT")) toValue = fromValue * 1.42;
            else if (fromUnit.equals("INR") && toUnit.equals("USD")) toValue = fromValue / 83.22;
            else if (fromUnit.equals("INR") && toUnit.equals("EUR")) toValue = fromValue / 90.0;
            else if (fromUnit.equals("INR") && toUnit.equals("CAD")) toValue = fromValue / 60.0;
            else if (fromUnit.equals("INR") && toUnit.equals("CNY")) toValue = fromValue / 12.0;
            else if (fromUnit.equals("INR") && toUnit.equals("PKR")) toValue = fromValue * 3.5;
            else if (fromUnit.equals("INR") && toUnit.equals("YEN")) toValue = fromValue * 1.75;
            else if (fromUnit.equals("INR") && toUnit.equals("WON")) toValue = fromValue * 16.5;
            else if (fromUnit.equals("INR") && toUnit.equals("ZAR")) toValue = fromValue * 0.22;

                // Conversion rates for EUR
            else if (fromUnit.equals("EUR") && toUnit.equals("BDT")) toValue = fromValue * 127.0;
            else if (fromUnit.equals("EUR") && toUnit.equals("USD")) toValue = fromValue * 1.1;
            else if (fromUnit.equals("EUR") && toUnit.equals("INR")) toValue = fromValue * 90.0;
            else if (fromUnit.equals("EUR") && toUnit.equals("CAD")) toValue = fromValue * 1.45;
            else if (fromUnit.equals("EUR") && toUnit.equals("CNY")) toValue = fromValue * 7.8;
            else if (fromUnit.equals("EUR") && toUnit.equals("PKR")) toValue = fromValue * 300.0;
            else if (fromUnit.equals("EUR") && toUnit.equals("YEN")) toValue = fromValue * 150.0;
            else if (fromUnit.equals("EUR") && toUnit.equals("WON")) toValue = fromValue * 1350.0;
            else if (fromUnit.equals("EUR") && toUnit.equals("ZAR")) toValue = fromValue * 19.0;

                // Conversion rates for CAD
            else if (fromUnit.equals("CAD") && toUnit.equals("BDT")) toValue = fromValue * 90.0;
            else if (fromUnit.equals("CAD") && toUnit.equals("USD")) toValue = fromValue / 0.75;
            else if (fromUnit.equals("CAD") && toUnit.equals("INR")) toValue = fromValue * 60.0;
            else if (fromUnit.equals("CAD") && toUnit.equals("EUR")) toValue = fromValue / 1.45;
            else if (fromUnit.equals("CAD") && toUnit.equals("CNY")) toValue = fromValue * 5.4;
            else if (fromUnit.equals("CAD") && toUnit.equals("PKR")) toValue = fromValue * 220.0;
            else if (fromUnit.equals("CAD") && toUnit.equals("YEN")) toValue = fromValue * 110.0;
            else if (fromUnit.equals("CAD") && toUnit.equals("WON")) toValue = fromValue * 980.0;
            else if (fromUnit.equals("CAD") && toUnit.equals("ZAR")) toValue = fromValue * 13.1;

                // Conversion rates for CNY
            else if (fromUnit.equals("CNY") && toUnit.equals("BDT")) toValue = fromValue * 16.0;
            else if (fromUnit.equals("CNY") && toUnit.equals("USD")) toValue = fromValue / 7.0;
            else if (fromUnit.equals("CNY") && toUnit.equals("INR")) toValue = fromValue * 12.0;
            else if (fromUnit.equals("CNY") && toUnit.equals("EUR")) toValue = fromValue / 7.8;
            else if (fromUnit.equals("CNY") && toUnit.equals("CAD")) toValue = fromValue / 5.4;
            else if (fromUnit.equals("CNY") && toUnit.equals("PKR")) toValue = fromValue * 32.0;
            else if (fromUnit.equals("CNY") && toUnit.equals("YEN")) toValue = fromValue * 18.5;
            else if (fromUnit.equals("CNY") && toUnit.equals("WON")) toValue = fromValue * 192.0;
            else if (fromUnit.equals("CNY") && toUnit.equals("ZAR")) toValue = fromValue * 2.4;

                // Conversion rates for PKR
            else if (fromUnit.equals("PKR") && toUnit.equals("BDT")) toValue = fromValue * 1.62;
            else if (fromUnit.equals("PKR") && toUnit.equals("USD")) toValue = fromValue / 280.0;
            else if (fromUnit.equals("PKR") && toUnit.equals("INR")) toValue = fromValue / 3.5;
            else if (fromUnit.equals("PKR") && toUnit.equals("EUR")) toValue = fromValue / 300.0;
            else if (fromUnit.equals("PKR") && toUnit.equals("CAD")) toValue = fromValue / 220.0;
            else if (fromUnit.equals("PKR") && toUnit.equals("CNY")) toValue = fromValue / 32.0;
            else if (fromUnit.equals("PKR") && toUnit.equals("YEN")) toValue = fromValue / 1.9;
            else if (fromUnit.equals("PKR") && toUnit.equals("WON")) toValue = fromValue / 3.5;
            else if (fromUnit.equals("PKR") && toUnit.equals("ZAR")) toValue = fromValue / 18.0;

                // Conversion rates for YEN
            else if (fromUnit.equals("YEN") && toUnit.equals("BDT")) toValue = fromValue * 1.10;
            else if (fromUnit.equals("YEN") && toUnit.equals("USD")) toValue = fromValue / 145.0;
            else if (fromUnit.equals("YEN") && toUnit.equals("INR")) toValue = fromValue / 1.75;
            else if (fromUnit.equals("YEN") && toUnit.equals("EUR")) toValue = fromValue / 150.0;
            else if (fromUnit.equals("YEN") && toUnit.equals("CAD")) toValue = fromValue / 110.0;
            else if (fromUnit.equals("YEN") && toUnit.equals("CNY")) toValue = fromValue / 18.5;
            else if (fromUnit.equals("YEN") && toUnit.equals("PKR")) toValue = fromValue * 1.9;
            else if (fromUnit.equals("YEN") && toUnit.equals("WON")) toValue = fromValue * 10.0;
            else if (fromUnit.equals("YEN") && toUnit.equals("ZAR")) toValue = fromValue * 0.13;

                // Conversion rates for WON
            else if (fromUnit.equals("WON") && toUnit.equals("BDT")) toValue = fromValue * 0.09;
            else if (fromUnit.equals("WON") && toUnit.equals("USD")) toValue = fromValue / 1300.0;
            else if (fromUnit.equals("WON") && toUnit.equals("INR")) toValue = fromValue / 16.5;
            else if (fromUnit.equals("WON") && toUnit.equals("EUR")) toValue = fromValue / 1350.0;
            else if (fromUnit.equals("WON") && toUnit.equals("CAD")) toValue = fromValue / 980.0;
            else if (fromUnit.equals("WON") && toUnit.equals("CNY")) toValue = fromValue / 192.0;
            else if (fromUnit.equals("WON") && toUnit.equals("PKR")) toValue = fromValue * 3.5;
            else if (fromUnit.equals("WON") && toUnit.equals("YEN")) toValue = fromValue / 10.0;
            else if (fromUnit.equals("WON") && toUnit.equals("ZAR")) toValue = fromValue / 13.0;

                // Conversion rates for ZAR
            else if (fromUnit.equals("ZAR") && toUnit.equals("BDT")) toValue = fromValue * 7.0;
            else if (fromUnit.equals("ZAR") && toUnit.equals("USD")) toValue = fromValue / 18.0;
            else if (fromUnit.equals("ZAR") && toUnit.equals("INR")) toValue = fromValue * 4.5;
            else if (fromUnit.equals("ZAR") && toUnit.equals("EUR")) toValue = fromValue / 19.0;
            else if (fromUnit.equals("ZAR") && toUnit.equals("CAD")) toValue = fromValue / 13.1;
            else if (fromUnit.equals("ZAR") && toUnit.equals("CNY")) toValue = fromValue / 2.4;
            else if (fromUnit.equals("ZAR") && toUnit.equals("PKR")) toValue = fromValue * 18.0;
            else if (fromUnit.equals("ZAR") && toUnit.equals("YEN")) toValue = fromValue / 0.13;
            else if (fromUnit.equals("ZAR") && toUnit.equals("WON")) toValue = fromValue * 13.0;








            binding.toValue.setText(String.valueOf(toValue));
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    }
