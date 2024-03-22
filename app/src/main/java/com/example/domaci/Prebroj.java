package com.example.domaci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Prebroj extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.izbroj);

        Intent intent = getIntent();
        String sentence = intent.getStringExtra("sentence");

        int count = countNonStartUpper(sentence);

        TextView countTextView = findViewById(R.id.brojac);
        countTextView.setText("Recenica ima " + count + " velikih slova koja nisu na pocetku recenice.");

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int countNonStartUpper(String sentence) {
        int count = 0;
        boolean newSentence = true;

        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    if (!newSentence) {
                        count++;
                    }
                }
                newSentence = false;
            } else if (c == '.' || c == '?' || c == '!') {
                newSentence = true;
            }
        }
        return count;
    }
}
