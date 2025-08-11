package com.example.carepoint.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.carepoint.Adapter.AmbulanceAdapter;
import com.example.carepoint.MainActivity;
import com.example.carepoint.Model.Ambulance;
import com.example.carepoint.R;
import java.util.ArrayList;
import java.util.List;

public class AmbulanceListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AmbulanceAdapter ambulanceAdapter;
    private List<Ambulance> ambulanceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_list);

        recyclerView = findViewById(R.id.recyclerViewAmbulance);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ambulanceList = new ArrayList<>();
        ambulanceList.add(new Ambulance("Ambulance 1", "Dhaka", "01712345678", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 2", "Chittagong", "01723456789", "Unavailable", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 3", "Rajshahi", "01734567890", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 4", "Sylhet", "01745678901", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 5", "Khulna", "01756789012", "Unavailable", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 6", "Barisal", "01767890123", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 7", "Comilla", "01778901234", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 8", "Mymensingh", "01789012345", "Unavailable", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 9", "Narayanganj", "01790123456", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 10", "Tangail", "01701234567", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 11", "Jessore", "01712345679", "Unavailable", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 12", "Pabna", "01723456780", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 13", "Narsingdi", "01734567881", "Available", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 14", "Kishoreganj", "01745678902", "Unavailable", R.drawable.ambulance));
        ambulanceList.add(new Ambulance("Ambulance 15", "Rajbari", "01756789013", "Available", R.drawable.ambulance));


        ambulanceAdapter = new AmbulanceAdapter(this, ambulanceList);
        recyclerView.setAdapter(ambulanceAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AmbulanceListActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
