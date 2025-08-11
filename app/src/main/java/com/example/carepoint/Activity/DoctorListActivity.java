package com.example.carepoint.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carepoint.Adapter.DoctorAdapter;
import com.example.carepoint.MainActivity;
import com.example.carepoint.Model.Doctor;
import com.example.carepoint.R;

import java.util.ArrayList;
import java.util.List;

public class DoctorListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DoctorAdapter doctorAdapter;
    private List<Doctor> doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        recyclerView = findViewById(R.id.recyclerViewDoctors);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        doctorList = new ArrayList<>();
        doctorList.add(new Doctor("Dr. Md. Abdul Kader", "Cardiologist", "Square Hospital", "MBBS, FCPS (Cardiology)", "BMDC-12345", "20 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Nafisa Anwar", "Dermatologist", "Apollo Hospital Dhaka", "MBBS, DDV", "BMDC-23456", "12 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Ahsan Habib", "Neurologist", "National Institute of Neurosciences", "MBBS, MD (Neurology)", "BMDC-34567", "15 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Fatima Rahman", "Pediatrician", "Dhaka Shishu Hospital", "MBBS, FCPS (Pediatrics)", "BMDC-45678", "10 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Kamal Hossain", "Orthopedic Surgeon", "United Hospital Limited", "MBBS, MS (Orthopedics)", "BMDC-56789", "18 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Sharmin Akhter", "Gynecologist", "Evercare Hospital", "MBBS, FCPS (Obstetrics and Gynecology)", "BMDC-67890", "14 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Tanvir Ahmed", "Psychiatrist", "National Institute of Mental Health", "MBBS, MD (Psychiatry)", "BMDC-78901", "10 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Tasnim Jahan", "ENT Specialist", "Ibrahim Cardiac Hospital", "MBBS, FCPS (ENT)", "BMDC-89012", "8 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Farhana Sultana", "Oncologist", "Ahsania Mission Cancer Hospital", "MBBS, MD (Oncology)", "BMDC-90123", "12 years experience", R.drawable.user));
        doctorList.add(new Doctor("Dr. Imran Hossain", "Urologist", "Bangabandhu Sheikh Mujib Medical University", "MBBS, MS (Urology)", "BMDC-01234", "7 years experience", R.drawable.user));

        doctorAdapter = new DoctorAdapter(this,doctorList);
        recyclerView.setAdapter(doctorAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DoctorListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
