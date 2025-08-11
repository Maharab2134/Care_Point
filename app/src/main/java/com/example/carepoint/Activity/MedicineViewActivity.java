package com.example.carepoint.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carepoint.R;

public class MedicineViewActivity extends AppCompatActivity {

    private ImageView medicineImage;
    private TextView medicineName, medicineBrand, medicineUsage, medicineDosage, medicinePrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_view);

        medicineImage = findViewById(R.id.medicineImage);
        medicineName = findViewById(R.id.medicineName);
        medicineBrand = findViewById(R.id.medicineBrand);
        medicineUsage = findViewById(R.id.medicineUsage);
        medicineDosage = findViewById(R.id.medicineDosage);
        medicinePrice = findViewById(R.id.medicinePrice);

        String name = getIntent().getStringExtra("name");
        String brand = getIntent().getStringExtra("brand");
        String usage = getIntent().getStringExtra("usage");
        String dosage = getIntent().getStringExtra("dosage");
        double price = getIntent().getDoubleExtra("price", 0.0);
        int imageResId = getIntent().getIntExtra("imageResId", 0);

        medicineImage.setImageResource(imageResId);
        medicineName.setText(name);
        medicineBrand.setText(brand);
        medicineUsage.setText(usage);
        medicineDosage.setText(dosage);
        medicinePrice.setText(String.format("$%.2f", price));
    }
}
