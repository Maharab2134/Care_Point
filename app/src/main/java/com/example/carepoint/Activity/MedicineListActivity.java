package com.example.carepoint.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carepoint.Adapter.MedicineAdapter;
import com.example.carepoint.MainActivity;
import com.example.carepoint.Model.Medicine;
import com.example.carepoint.R;

import java.util.ArrayList;
import java.util.List;

public class MedicineListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MedicineAdapter medicineAdapter;
    private List<Medicine> medicineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list);

        recyclerView = findViewById(R.id.recyclerViewMedicines);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        medicineList = new ArrayList<>();
        medicineList.add(new Medicine("Paracetamol", "Brand A", "Fever", "500mg", 10.50, R.drawable.d));
        medicineList.add(new Medicine("Aspirin", "Brand B", "Headache", "300mg", 12.00, R.drawable.d));
        medicineList.add(new Medicine("Amoxicillin", "Brand C", "Infection", "250mg", 15.75, R.drawable.d));
        medicineList.add(new Medicine("Ibuprofen", "Brand D", "Pain Relief", "400mg", 18.00, R.drawable.d));
        medicineList.add(new Medicine("Loratadine", "Brand E", "Allergy", "10mg", 8.50, R.drawable.d));
        medicineList.add(new Medicine("Ciprofloxacin", "Brand F", "Bacterial Infection", "500mg", 22.00, R.drawable.d));
        medicineList.add(new Medicine("Metformin", "Brand G", "Diabetes", "500mg", 20.00, R.drawable.d));
        medicineList.add(new Medicine("Cetirizine", "Brand H", "Allergy", "10mg", 9.50, R.drawable.d));
        medicineList.add(new Medicine("Simvastatin", "Brand I", "Cholesterol", "10mg", 30.00, R.drawable.d));
        medicineList.add(new Medicine("Losartan", "Brand J", "Hypertension", "50mg", 25.00, R.drawable.d));
        medicineList.add(new Medicine("Omeprazole", "Brand K", "Acid Reflux", "20mg", 14.50, R.drawable.d));
        medicineList.add(new Medicine("Clindamycin", "Brand L", "Infection", "300mg", 17.00, R.drawable.d));
        medicineList.add(new Medicine("Tamsulosin", "Brand M", "Benign Prostatic Hyperplasia", "0.4mg", 21.00, R.drawable.d));
        medicineList.add(new Medicine("Prednisolone", "Brand N", "Inflammation", "5mg", 11.00, R.drawable.d));
        medicineList.add(new Medicine("Levothyroxine", "Brand O", "Hypothyroidism", "50mcg", 19.00, R.drawable.d));
        medicineList.add(new Medicine("Sertraline", "Brand P", "Depression", "50mg", 23.50, R.drawable.d));


        medicineAdapter = new MedicineAdapter(this, medicineList);
        recyclerView.setAdapter(medicineAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MedicineListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
