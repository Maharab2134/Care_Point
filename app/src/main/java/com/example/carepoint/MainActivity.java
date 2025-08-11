package com.example.carepoint;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.carepoint.Activity.AmbulanceListActivity;
import com.example.carepoint.Activity.DoctorListActivity;
import com.example.carepoint.Activity.MedicineListActivity;
import com.example.carepoint.Activity.MyProfileShow;
import com.example.carepoint.Adapter.ImageSliderAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvUsername;
    private ViewPager2 viewPagerSlider;
    private CardView cardDoctorList, cardMedicineList, cardAmbulanceList, cardLogout;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private Handler sliderHandler;
    private Runnable sliderRunnable;

    private String stableUsername = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerSlider = findViewById(R.id.viewPagerSlider);
        tvUsername = findViewById(R.id.tvUsername);
        cardDoctorList = findViewById(R.id.cardDoctorList);
        cardMedicineList = findViewById(R.id.cardMedicineList);
        cardAmbulanceList = findViewById(R.id.cardAmbulanceList);
        cardLogout = findViewById(R.id.cardLogout);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        if (currentUser != null) {
            String userId = currentUser.getUid();
            fetchUsername(userId);
        } else {
            stableUsername = "Guest";
            tvUsername.setText(stableUsername);
        }

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.d1);
        imageList.add(R.drawable.m1);
        imageList.add(R.drawable.a3);
        imageList.add(R.drawable.d2);
        imageList.add(R.drawable.a1);
        imageList.add(R.drawable.d3);
        imageList.add(R.drawable.a2);
        imageList.add(R.drawable.d4);
        imageList.add(R.drawable.m3);
        imageList.add(R.drawable.d5);

        ImageSliderAdapter adapter = new ImageSliderAdapter(this, imageList);
        viewPagerSlider.setAdapter(adapter);

        viewPagerSlider.setOffscreenPageLimit(1);
        viewPagerSlider.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        sliderHandler = new Handler(Looper.getMainLooper());
        sliderRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPagerSlider.getCurrentItem();
                int nextItem = (currentItem + 1) % imageList.size();
                viewPagerSlider.setCurrentItem(nextItem, true);
                sliderHandler.postDelayed(this, 3000);
            }
        };
        sliderHandler.postDelayed(sliderRunnable, 3000);

        viewPagerSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });

        cardDoctorList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DoctorListActivity.class);
            startActivity(intent);
            finish();
        });
        cardMedicineList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MedicineListActivity.class);
            startActivity(intent);
            finish();
        });
        cardAmbulanceList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AmbulanceListActivity.class);
            startActivity(intent);
            finish();
        });

        cardLogout.setOnClickListener(v -> showExitDialog());

        bottomNavigationView.setOnNavigationItemReselectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                Intent intent = new Intent();
            }
            if (item.getItemId() == R.id.profile) {
                Intent intent = new Intent(MainActivity.this, MyProfileShow.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Application");
        builder.setMessage("Are you sure you want to exit?");

        builder.setPositiveButton("Yes", (dialog, which) -> {
            finishAffinity();
            System.exit(0);
        });

        builder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());

        AlertDialog exitDialog = builder.create();
        exitDialog.show();
    }
    private void fetchUsername(String userId) {
        databaseReference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String name = snapshot.child("name").getValue(String.class);
                    if (name != null && !name.isEmpty() && !name.equals(stableUsername)) {
                        stableUsername = name;
                        tvUsername.setText(stableUsername);
                    } else if (stableUsername == null) {
                        stableUsername = "User";
                        tvUsername.setText(stableUsername);
                    }
                } else if (stableUsername == null) {
                    stableUsername = "User";
                    tvUsername.setText(stableUsername);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                if (stableUsername == null) {
                    stableUsername = "Error";
                    tvUsername.setText(stableUsername);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        showExitDialog();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

}
