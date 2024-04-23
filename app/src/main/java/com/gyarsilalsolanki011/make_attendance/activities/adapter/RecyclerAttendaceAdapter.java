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
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int Position = position;
        holder.txtName.setText(arrAttends.get(Position).name);
        holder.presentBtn.setBottom(arrAttends.get(Position).present);
        holder.absentBtn.setBottom(arrAttends.get(Position).absent);

    }

    @Override
    public int getItemCount() {
        return arrAttends.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        FloatingActionButton presentBtn, absentBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.student_name);
            presentBtn = itemView.findViewById(R.id.button_cancel);
            absentBtn = itemView.findViewById(R.id.button_cancel);

        }
    }
}
