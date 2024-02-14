package com.example.mealrater;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

class RatingActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button saveButton;
    private TextView ratingDisplayTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar = findViewById(R.id.ratingBar);
        saveButton = findViewById(R.id.saveButton);
        ratingDisplayTextView = findViewById(R.id.ratingDisplayTextView);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                ratingDisplayTextView.setText("Rating: " + rating);
                // Optionally, you can pass the rating back to the MainActivity
            }
        });
    }
}

