package com.example.alert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDate, textViewTime;
    private Button buttonDate, buttonTime, buttonAlert, buttonCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDate = findViewById(R.id.textViewDate);
        textViewTime = findViewById(R.id.textViewTime);
        buttonDate = findViewById(R.id.buttonDate);
        buttonTime = findViewById(R.id.buttonTime);
        buttonAlert = findViewById(R.id.buttonAlert);
        buttonCustom = findViewById(R.id.buttonCustom);

        buttonDate.setOnClickListener(v -> showDatePickerDialog());
        buttonTime.setOnClickListener(v -> showTimePickerDialog());
        buttonAlert.setOnClickListener(v -> showAlertDiaglog());
        buttonCustom.setOnClickListener(v -> showCustomDialog());
    }

    private void showAlertDiaglog() {
        new AlertDialog.Builder(this)
                .setTitle("Подтверждение")
                .setMessage("Хотите ли вы выполнить это действие?")
                .setPositiveButton("Да", (dialog, which) -> {
                    Toast.makeText(MainActivity.this, "Вы выбрали Да", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Нет", null).show();
    }

    private void showDatePickerDialog() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, monthOfYear, dayOfMonth) -> textViewDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1),
                year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute1) -> textViewTime.setText(hourOfDay + ":" + minute1),
                hour, minute, false);
        timePickerDialog.show();
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);

        Button positiveButton = dialog.findViewById(R.id.positiveButton);
        Button negativeButton = dialog.findViewById(R.id.negativeButton);

        positiveButton.setOnClickListener(v -> {
            dialog.dismiss();
        });

        negativeButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}
