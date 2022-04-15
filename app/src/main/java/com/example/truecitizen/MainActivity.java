package com.example.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
            incrementCurr();
            binding.QuestionTextView.setText(questionBank[curr].getQuesId());
        });

        binding.PrevButton.setOnClickListener(v -> {
            decrementCurr();
            binding.QuestionTextView.setText(questionBank[curr].getQuesId());
        });

        binding.TrueButton.setOnClickListener(v -> {
            if (questionBank[curr].isAns() == true) {
                Toast.makeText(binding.QuestionTextView.getContext(), R.string.correct_answer, Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(binding.QuestionTextView.getContext(), R.string.wrong_answer, Toast.LENGTH_SHORT)
                        .show();
            }
            incrementCurr();
            binding.QuestionTextView.setText(questionBank[curr].getQuesId());
        });

        binding.FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionBank[curr].isAns() == false) {
                    Toast.makeText(binding.QuestionTextView.getContext(), R.string.correct_answer, Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(binding.QuestionTextView.getContext(), R.string.wrong_answer, Toast.LENGTH_SHORT)
                            .show();
                }
                incrementCurr();
                binding.QuestionTextView.setText(questionBank[curr].getQuesId());
            }
        });

    }

    private void decrementCurr() {
        if (curr == 0) {
            curr = questionBank.length-1;
        }else {
            curr--;
        }

    }

    private void incrementCurr() {
        curr = (curr + 1) % questionBank.length;
    }
}