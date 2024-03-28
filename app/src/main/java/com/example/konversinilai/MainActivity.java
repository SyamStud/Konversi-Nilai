package com.example.konversinilai;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText namaInput, nimInput, kelasInput, matkulInput, utsInput, uasInput, lainInput;

    RadioButton lakiLaki, perempuan;
    TextView nimResult, namaResult, jnsResult, matkulResult, nilaiResult, gradeResult;

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

        namaInput = findViewById(R.id.inputNama);
        nimInput = findViewById(R.id.inputNim);
        kelasInput = findViewById(R.id.inputKelas);
        matkulInput = findViewById(R.id.inputMatkul);

        lakiLaki = findViewById(R.id.lakiLaki);
        perempuan = findViewById(R.id.perempuan);

        utsInput = findViewById(R.id.inputUts);
        uasInput = findViewById(R.id.inputUas);
        lainInput = findViewById(R.id.inputLainnya);
    }

    public void result(View view) {
        setContentView(R.layout.result);

        nimResult = findViewById(R.id.hasilNIM);
        namaResult = findViewById(R.id.hasilNama);
        jnsResult = findViewById(R.id.hasilJns);
        matkulResult = findViewById(R.id.hasilMatkul);
        nilaiResult = findViewById(R.id.hasilNilai);
        gradeResult = findViewById(R.id.hasilGrade);

        Double nilai = nilai();
        String grade = grade(nilai);

        nimResult.setText(nimInput.getText());
        matkulResult.setText(matkulInput.getText());
        nilaiResult.setText(String.valueOf(nilai));
        gradeResult.setText(grade);

        if (lakiLaki.isChecked()) {
            jnsResult.setText("Laki - laki");
            namaResult.setText("Mas " + namaInput.getText());
        } else {
            jnsResult.setText("Perempuan");
            namaResult.setText("Mba " + namaInput.getText());
        }
    }

    public Double nilai() {
        Double uts, uas, lainnya;

        uts = Double.parseDouble(String.valueOf(utsInput.getText()));
        uas = Double.parseDouble(String.valueOf(uasInput.getText()));
        lainnya = Double.parseDouble(String.valueOf(lainInput.getText()));

        return (uts * (30.0/100)) + (uas * (40.0/100)) + (lainnya * (30.0/100));
    }

    public String grade(Double nilai) {
        String grade;

        if (nilai >= 80) {
            grade = "A";
        } else if (nilai >= 70) {
            grade = "AB";
        } else if (nilai >= 60) {
            grade = "B";
        } else if (nilai >= 50) {
            grade = "BC";
        } else if (nilai >= 40) {
            grade = "C";
        } else if (nilai >= 30) {
            grade = "D";
        } else {
            grade = "E";
        }

        return grade;
    }

    public void selesai(View view) {
        finish();
    }
}