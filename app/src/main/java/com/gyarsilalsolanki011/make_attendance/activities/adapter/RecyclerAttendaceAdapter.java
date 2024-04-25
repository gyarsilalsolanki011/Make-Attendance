package com.gyarsilalsolanki011.make_attendance.activities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceModal;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class RecyclerAttendaceAdapter extends RecyclerView.Adapter<RecyclerAttendaceAdapter.ViewHolder>{

    Context context;
    ArrayList<AttendanceModal> arrAttends;
    public RecyclerAttendaceAdapter(Context context, ArrayList<AttendanceModal> arrAttends) {
        this.context = context;
        this.arrAttends = arrAttends;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.attendance_raw, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AttendanceModal modal = arrAttends.get(position);

        holder.fullName.setText(modal.fullName);
        holder.present.setText(modal.present);
        holder.absent.setText(modal.absent);
        holder.percentage.setText(modal.percentage);

    }

    @Override
    public int getItemCount() {
        return arrAttends.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fullName, percentage, present, absent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.student_name);
            percentage = itemView.findViewById(R.id.percentage);
            present = itemView.findViewById(R.id.present);
            absent = itemView.findViewById(R.id.absent);
        }
    }
}
