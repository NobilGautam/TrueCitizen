package com.example.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.truecitizen.databinding.ActivityMainBinding;
import com.example.truecitizen.model.Questions;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Questions questionBank[] = new Questions[] {
                new Questions(R.string.father_of_nation, true),
                new Questions(R.string.year_of_independence, false),
                new Questions(R.string.republic_day, false),
                new Questions(R.string.oldest_civilization, false)
        };

        int curr = 0;
        binding.QuestionTextView.setText(questionBank[curr].getQuesId());


    }
}