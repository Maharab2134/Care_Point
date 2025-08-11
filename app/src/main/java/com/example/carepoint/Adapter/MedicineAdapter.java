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

import com.example.carepoint.Activity.MedicineViewActivity;
import com.example.carepoint.Model.Medicine;
import com.example.carepoint.R;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {

    private List<Medicine> medicineList;
    private Context context;

    public MedicineAdapter(Context context, List<Medicine> medicineList) {
        this.context = context;
        this.medicineList = medicineList;
    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicine, parent, false);
        return new MedicineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        Medicine medicine = medicineList.get(position);

        holder.medicineImage.setImageResource(medicine.getImageResId());
        holder.medicineName.setText(medicine.getName());
        holder.medicineBrand.setText(medicine.getBrand());
        holder.medicineUsage.setText(medicine.getUsage());
        holder.medicineDosage.setText(medicine.getDosage());
        holder.medicinePrice.setText(String.format("Price: %.2f", medicine.getPrice()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, MedicineViewActivity.class);
            intent.putExtra("name", medicine.getName());
            intent.putExtra("brand", medicine.getBrand());
            intent.putExtra("usage", medicine.getUsage());
            intent.putExtra("dosage", medicine.getDosage());
            intent.putExtra("price", medicine.getPrice());
            intent.putExtra("imageResId", medicine.getImageResId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }

    static class MedicineViewHolder extends RecyclerView.ViewHolder {

        ImageView medicineImage;
        TextView medicineName, medicineBrand, medicineUsage, medicineDosage, medicinePrice;

        public MedicineViewHolder(@NonNull View itemView) {
            super(itemView);
            medicineImage = itemView.findViewById(R.id.imageMedicine);
            medicineName = itemView.findViewById(R.id.textMedicineName);
            medicineBrand = itemView.findViewById(R.id.textBrand);
            medicineUsage = itemView.findViewById(R.id.textUsage);
            medicineDosage = itemView.findViewById(R.id.textDosage);
            medicinePrice = itemView.findViewById(R.id.textPrice);
        }
    }
}
