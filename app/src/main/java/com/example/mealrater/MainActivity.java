package com.example.mealrater;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText restaurantEditText;
    private EditText dishEditText;
    private Button rateMealButton;
    private TextView ratingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurantEditText = findViewById(R.id.restaurantEditText);
        dishEditText = findViewById(R.id.dishEditText);
        rateMealButton = findViewById(R.id.rateButton);
        ratingTextView = findViewById(R.id.ratingDisplayTextView);

        rateMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRatingDialog();
            }
        });
    }

    private void showRatingDialog() {
        final Dialog ratingDialog = new Dialog(MainActivity.this);
        ratingDialog.setContentView(R.layout.activity_rating);
        ratingDialog.setCancelable(true);

        final RatingBar ratingBar = ratingDialog.findViewById(R.id.ratingBar);
        Button saveButton = ratingDialog.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                ratingTextView.setText(String.format(Locale.getDefault(), "Rating: %.1f", rating));
                ratingDialog.dismiss();
            }
        });

        ratingDialog.show();
    }
}
