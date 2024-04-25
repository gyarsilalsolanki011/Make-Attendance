package com.gyarsilalsolanki011.make_attendance.activities.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceViewModal;

import java.util.ArrayList;

public class RecyclerAttendanceViewAdapter extends RecyclerView.Adapter<RecyclerAttendanceViewAdapter.ViewHolder>{
    Context context;
    ArrayList<AttendanceViewModal> arrayListAttendance;

    public RecyclerAttendanceViewAdapter(Context context, ArrayList<AttendanceViewModal> arrayListAttendance) {
        this.context = context;
        this.arrayListAttendance = arrayListAttendance;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.attendance_view, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AttendanceViewModal modal = arrayListAttendance.get(position);

        holder.subject.setText(modal.subject);
        holder.classesConducted.setText(modal.classesConducted.toString());
        holder.classesAttended.setText(modal.classesAttended.toString());

    }
    @Override
    public int getItemCount() {
        return arrayListAttendance.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject, classesAttended, classesConducted;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.subject = itemView.findViewById(R.id.subjectTextView);
            this.classesAttended = itemView.findViewById(R.id.classes_attended);
            this.classesConducted = itemView.findViewById(R.id.classes_conducted);
        }
    }
}
