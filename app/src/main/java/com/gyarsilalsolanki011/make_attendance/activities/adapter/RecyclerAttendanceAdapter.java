package com.gyarsilalsolanki011.make_attendance.activities.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.gyarsilalsolanki011.make_attendance.R;
import com.gyarsilalsolanki011.make_attendance.activities.modal.AttendanceModal;

import java.util.ArrayList;

public class RecyclerAttendanceAdapter extends RecyclerView.Adapter<RecyclerAttendanceAdapter.ViewHolder>{

    Context context;
    boolean clickedBtn;
    int count;
    ArrayList<AttendanceModal> arrAttends;

    public RecyclerAttendanceAdapter(Context context, ArrayList<AttendanceModal> arrAttends) {
        this.context = context;
        this.arrAttends = arrAttends;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.attendance_raw, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AttendanceModal modal = (AttendanceModal) arrAttends.get(position);
        clickedBtn = false;

        holder.fullName.setText(modal.getFullName());
        holder.present.setText(modal.getPresent().toString());
        holder.absent.setText(modal.getAbsent().toString());
        holder.percentage.setText(modal.getPercentage().toString());

        holder.presentBtn.setOnClickListener(
                v -> {
                    clickedBtn = true;
                    count = 1;
                    updatePresentData(modal);
                    holder.present.setText(modal.present.toString());
                    holder.absent.setText(modal.absent.toString());
                    updatePercentageData(modal);
                    holder.percentage.setText(modal.percentage.toString());
                }

        );

        holder.absentBtn.setOnClickListener(
                v -> {
                    clickedBtn = true;
                    count = 0;
                    updateAbsentData(modal);
                    holder.present.setText(modal.present.toString());
                    holder.absent.setText(modal.absent.toString());
                    updatePercentageData(modal);
                    holder.percentage.setText(modal.percentage.toString());
                }
        );

        if (clickedBtn) {
            holder.relativelay.setOnLongClickListener(
                    v -> {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                                .setTitle("Retake Attendance")
                                .setMessage("Are you sure you want to retake")
                                .setIcon(R.drawable.baseline_delete_24)
                                .setPositiveButton("Yes", (dialog, which) -> {
                                    if (count == 1) {
                                        modal.present -= 1;
                                    } else {
                                        modal.absent -= 1;
                                    }
                                    updatePercentageData(modal);
                                    holder.present.setText(modal.present.toString());
                                    holder.absent.setText(modal.absent.toString());
                                    holder.percentage.setText(modal.percentage.toString());
                                })
                                .setNegativeButton("No", (dialog, which) -> {

                                });
                        builder.show();
                        clickedBtn = false;
                        return false;
                    }
            );

        }
    }

    @Override
    public int getItemCount() {
        return arrAttends.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fullName, percentage, present, absent;
        FloatingActionButton presentBtn, absentBtn;
        RelativeLayout relativelay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.student_name);
            percentage = itemView.findViewById(R.id.percentage);
            present = itemView.findViewById(R.id.present);
            absent = itemView.findViewById(R.id.absent);

            presentBtn = itemView.findViewById(R.id.button_mark);
            absentBtn = itemView.findViewById(R.id.button_cancel);
            relativelay = itemView.findViewById(R.id.relativeLay);
        }
    }

    private void updatePresentData(AttendanceModal modal) {
        modal.present += 1;
    }

    private void updateAbsentData(AttendanceModal modal) {
        modal.absent += 1;
    }

    private void updatePercentageData(AttendanceModal modal) {

        modal.percentage = (modal.present / (modal.present + modal.absent)) * 100;

    }
}
