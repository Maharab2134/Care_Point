package com.example.carepoint.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carepoint.MainActivity;
import com.example.carepoint.Model.User;
import com.example.carepoint.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyProfileShow extends AppCompatActivity {

    private TextView tvName, tvPhoneNumber, tvEmail;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_show);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        tvName = findViewById(R.id.tvName);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber);
        tvEmail = findViewById(R.id.tvEmail);

        String userId = mAuth.getCurrentUser().getUid();

        databaseReference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user != null) {
                        tvName.setText(user.getName());
                        tvPhoneNumber.setText(user.getPhoneNumber());
                        tvEmail.setText(user.getEmail());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MyProfileShow.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MyProfileShow.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
