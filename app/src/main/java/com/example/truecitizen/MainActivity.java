package com.example.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.truecitizen.databinding.ActivityMainBinding;
import com.example.truecitizen.model.Questions;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    int curr = 0;
    Questions questionBank[] = new Questions[] {
            new Questions(R.string.father_of_nation, true),
            new Questions(R.string.year_of_independence, false),
            new Questions(R.string.republic_day, false),
            new Questions(R.string.oldest_civilization, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);




        binding.QuestionTextView.setText(questionBank[curr].getQuesId());

        binding.NextButton.setOnClickListener(v -> {
            curr = (curr + 1) % questionBank.length;
            binding.QuestionTextView.setText(questionBank[curr].getQuesId());
        });

        binding.PrevButton.setOnClickListener(v -> {
            curr--;
            if (curr == 0) {
                curr = questionBank.length;
            }
            binding.QuestionTextView.setText(questionBank[curr].getQuesId());
        });

    }
}