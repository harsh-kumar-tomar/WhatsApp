package com.example.javaappversion13.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaappversion13.R;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class messageAdapter extends RecyclerView.Adapter<messageAdapter.customViewHolder> {

    List<String> messages ;

    public messageAdapter(List<String> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public customViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sender_message_view, parent , false);
        customViewHolder v = new customViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull customViewHolder holder, int position) {

//        holder.bind(messages.get(position));
//        holder.data_time_TV.setText(getCurrentTime());


    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class customViewHolder extends RecyclerView.ViewHolder {
        TextView messagetxtView ;
        TextView data_time_TV ;
        public customViewHolder( View itemView) {
            super(itemView);
//            messagetxtView = itemView.findViewById(R.id.messagetxtView);
//            data_time_TV = itemView.findViewById(R.id.data_time_TV);

        }
        public void bind(String message)
        {
            messagetxtView.setText(message);
        }
    }

    private String getCurrentTime() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int amPm = calendar.get(Calendar.AM_PM);

        // Convert to 12-hour format
        String amPmString = (amPm == Calendar.AM) ? "AM" : "PM";

        // Adjust the hour to be in the range of 1 to 12 for 12-hour format
        if (hour == 0) {
            hour = 12;
        }

        // Format the time as "hh:mm AM/PM"

        // Now, formattedTime contains the current time in 12-hour format (hh:mm AM/PM)
        // You can use it as needed

        return String.format(Locale.getDefault(), "%02d:%02d %s", hour, minute, amPmString);
    }
}
