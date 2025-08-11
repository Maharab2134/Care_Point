package com.example.carepoint.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carepoint.Activity.DoctorViewActivity;
import com.example.carepoint.Model.Doctor;
import com.example.carepoint.R;

import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    private List<Doctor> doctorList;
    private Context context;

    public DoctorAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Doctor doctor = doctorList.get(position);

        holder.doctorImage.setImageResource(doctor.getImageResId());
        holder.doctorName.setText(doctor.getName());
        holder.doctorSpecialization.setText(doctor.getSpecialization());
        holder.doctorHospital.setText(doctor.getHospitalName());
        holder.doctorQualification.setText(doctor.getQualification());
        holder.doctorBMDC.setText("BMDC Reg: " + doctor.getBmdcReg());
        holder.doctorExperience.setText(doctor.getExperience());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DoctorViewActivity.class);
            intent.putExtra("name", doctor.getName());
            intent.putExtra("specialization", doctor.getSpecialization());
            intent.putExtra("hospital", doctor.getHospitalName());
            intent.putExtra("qualification", doctor.getQualification());
            intent.putExtra("bmdc", doctor.getBmdcReg());
            intent.putExtra("experience", doctor.getExperience());
            intent.putExtra("imageResId", doctor.getImageResId());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    static class DoctorViewHolder extends RecyclerView.ViewHolder {

        ImageView doctorImage;
        TextView doctorName, doctorSpecialization, doctorHospital, doctorQualification, doctorBMDC, doctorExperience;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorImage = itemView.findViewById(R.id.imageDoctor);
            doctorName = itemView.findViewById(R.id.textDoctorName);
            doctorSpecialization = itemView.findViewById(R.id.textSpecialization);
            doctorHospital = itemView.findViewById(R.id.textHospitalName);
            doctorQualification = itemView.findViewById(R.id.textQualification);
            doctorBMDC = itemView.findViewById(R.id.textBMDCReg);
            doctorExperience = itemView.findViewById(R.id.textExperience);
        }
    }
}
