package com.example.mybmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btntinhBMI;
    EditText editTen, editCC, editCN, editBMI, editCD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btntinhBMI = (Button) findViewById(R.id.btntinhBMI);
        editTen = findViewById(R.id.editTen);
        editCC = findViewById(R.id.editCC);
        editCN = findViewById(R.id.editCN);
        editBMI = findViewById(R.id.editBMI);
        editCD = findViewById(R.id.editCD);

        btntinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H = Double.parseDouble(editCC.getText().toString());
                double W = Double.parseDouble(editCN.getText().toString());
                double BMI = W / Math.pow(H, 2);
                String chandoan = "";

                if (BMI < 18) {
                    chandoan = "Bạn gầy!";
                } else if (BMI <= 24.9) {
                    chandoan = "Bạn bình thường!";
                } else if (BMI <= 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI <= 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(String.valueOf(dcf.format(BMI)));
                editCD.setText(chandoan);
            }
        });
    }
}