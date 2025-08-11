package com.example.carepoint.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carepoint.Activity.AmbulanceListActivity;
import com.example.carepoint.Model.Ambulance;
import com.example.carepoint.R;

import java.util.List;

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.AmbulanceViewHolder> {

    private List<Ambulance> ambulanceList;
    private Context context;

    public AmbulanceAdapter(Context context, List<Ambulance> ambulanceList) {
        this.context = context;
        this.ambulanceList = ambulanceList;
    }

    @NonNull
    @Override
    public AmbulanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ambulance, parent, false);
        return new AmbulanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmbulanceViewHolder holder, int position) {
        Ambulance ambulance = ambulanceList.get(position);

        holder.ambulanceImage.setImageResource(ambulance.getImageResId());
        holder.ambulanceName.setText(ambulance.getName());
        holder.ambulanceServiceArea.setText(ambulance.getServiceArea());
        holder.ambulancePhone.setText(ambulance.getPhoneNumber());
        holder.ambulanceAvailability.setText(ambulance.getAvailability());

        // Set up click listener for the call button
        holder.callAmbulance.setOnClickListener(v -> makePhoneCall(ambulance.getPhoneNumber()));
    }

    @Override
    public int getItemCount() {
        return ambulanceList.size();
    }

    static class AmbulanceViewHolder extends RecyclerView.ViewHolder {

        ImageView ambulanceImage, callAmbulance;
        TextView ambulanceName, ambulanceServiceArea, ambulancePhone, ambulanceAvailability;

        public AmbulanceViewHolder(@NonNull View itemView) {
            super(itemView);
            ambulanceImage = itemView.findViewById(R.id.imageAmbulance);
            ambulanceName = itemView.findViewById(R.id.textAmbulanceName);
            ambulanceServiceArea = itemView.findViewById(R.id.textServiceArea);
            ambulancePhone = itemView.findViewById(R.id.textPhoneNumber);
            ambulanceAvailability = itemView.findViewById(R.id.textAvailability);
            callAmbulance = itemView.findViewById(R.id.callAmbulance);
        }
    }

    // Method to make the phone call
    private void makePhoneCall(String phoneNumber) {
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Request permission to make a phone call if not granted
            ActivityCompat.requestPermissions((AmbulanceListActivity) context,
                    new String[]{android.Manifest.permission.CALL_PHONE}, 1);
            return;
        }
        // Initiate the phone call if permission is granted
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        context.startActivity(callIntent);
    }
}
