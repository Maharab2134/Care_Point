package com.example.carepoint.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carepoint.R;

public class DoctorViewActivity extends AppCompatActivity {

    private ImageView doctorImageView;
    private Button bookAppointmentButton;
    private TextView doctorName, doctorSpecialization, doctorHospital, doctorQualification, doctorBMDC, doctorExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view);

        doctorImageView = findViewById(R.id.doctorImageView);
        doctorName = findViewById(R.id.doctorName);
        doctorSpecialization = findViewById(R.id.doctorSpecialization);
        doctorHospital = findViewById(R.id.doctorHospital);
        doctorQualification = findViewById(R.id.doctorQualification);
        doctorBMDC = findViewById(R.id.doctorBMDC);
        doctorExperience = findViewById(R.id.doctorExperience);
        bookAppointmentButton = findViewById(R.id.bookAppointmentButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            doctorImageView.setImageResource(extras.getInt("imageResId"));
            doctorName.setText(extras.getString("name"));
            doctorSpecialization.setText(extras.getString("specialization"));
            doctorHospital.setText(extras.getString("hospital"));
            doctorQualification.setText(extras.getString("qualification"));
            doctorBMDC.setText("BMDC Reg: " + extras.getString("bmdc"));
            doctorExperience.setText(extras.getString("experience"));
        }

        bookAppointmentButton.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"));
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                startActivity(callIntent);
            } else {
                Toast.makeText(this, "Permission to make calls is not granted!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
