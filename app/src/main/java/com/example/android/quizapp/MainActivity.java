package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    String finalMessage;
    String finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit (View view) {

        // Views and variables for first answer
        EditText firstAnswerView = (EditText) findViewById(R.id.first_answer);
        String firstAnswer = firstAnswerView.getText().toString();

        // Views and variables for second answer
        RadioButton secondAnswerView = (RadioButton) findViewById(R.id.second_question_option_2);
        boolean secondAnswer = secondAnswerView.isChecked();

        // Views and variables for third answer
        CheckBox thirdAnswerView1 = (CheckBox) findViewById(R.id.third_answer_option_1);
        CheckBox thirdAnswerView2 = (CheckBox) findViewById(R.id.third_answer_option_2);
        CheckBox thirdAnswerView3 = (CheckBox) findViewById(R.id.third_answer_option_3);
        boolean thirdAnswer1 = thirdAnswerView1.isChecked();
        boolean thirdAnswer2 = thirdAnswerView2.isChecked();
        boolean thirdAnswer3 = thirdAnswerView3.isChecked();

        // Views and variables for fourth answer
        RadioButton fourthAnswerView = (RadioButton) findViewById(R.id.fourth_answer_option_1);
        boolean fourthAnswer = fourthAnswerView.isChecked();

        // Views and variables for submit button
        Button submitButtonView = (Button) findViewById(R.id.submit_button);
        TextView finalMessageView = (TextView) findViewById(R.id.final_message);
        TextView finalScoreView = (TextView) findViewById(R.id.final_score);

        // Calls the reset function if the button is showing the text "Reset"
        if (submitButtonView.getText() == getString(R.string.reset_button)) {
            reset();
        }

        // Else it goes for checking the answers
        else {
            // Logic for checking above answers
            if (firstAnswer.equals(getString(R.string.first_answer))) {
                score = score + 1;
            }
            if (secondAnswer) {
                score = score + 1;
            }
            if (thirdAnswer1 && thirdAnswer2 && thirdAnswer3) {
                score = score + 1;
            }
            if (fourthAnswer) {
                score = score + 1;
            }

            finalScore = getString(R.string.final_score, score);

            // Declares messages based on the score
            if (score == 4) {
                finalMessage = getString(R.string.message_1);
            } else if (score == 3) {
                finalMessage = getString(R.string.message_2);
            } else if (score == 2) {
                finalMessage = getString(R.string.message_3);
            } else if (score == 1) {
                finalMessage = getString(R.string.message_4);
            } else {
                finalMessage = getString(R.string.message_5);
            }

            // Shows messages and final score
            submitButtonView.setText(getString(R.string.reset_button));
            finalMessageView.setText(finalMessage);
            finalScoreView.setText(finalScore);

            Toast.makeText(MainActivity.this, finalMessage + " " + finalScore,
                    Toast.LENGTH_LONG).show();
        }

    }

    public void reset () {

        // Views and variables
        EditText firstAnswerView = (EditText) findViewById(R.id.first_answer);
        Button submitButtonView = (Button) findViewById(R.id.submit_button);
        TextView finalMessageView = (TextView) findViewById(R.id.final_message);
        TextView finalScoreView = (TextView) findViewById(R.id.final_score);

        score = 0;
        finalMessage = "";
        finalScore = "";
        submitButtonView.setText(getString(R.string.submit_button));
        finalMessageView.setText("");
        finalScoreView.setText("");

        // Clears Text for First Question
        firstAnswerView.setText("");

        // Clears Checks for Second Question
        RadioGroup secondQuestionView = (RadioGroup)findViewById(R.id.second_question);
        secondQuestionView.clearCheck();

        // Clears Checks for Third Question
        CheckBox thirdAnswerView1 = (CheckBox) findViewById(R.id.third_answer_option_1);
        CheckBox thirdAnswerView2 = (CheckBox) findViewById(R.id.third_answer_option_2);
        CheckBox thirdAnswerView3 = (CheckBox) findViewById(R.id.third_answer_option_3);

        if (thirdAnswerView1.isChecked()) {
            thirdAnswerView1.setChecked(false);
        }
        if (thirdAnswerView2.isChecked()) {
            thirdAnswerView2.setChecked(false);
        }
        if (thirdAnswerView3.isChecked()) {
            thirdAnswerView3.setChecked(false);
        }

        // Clears Checks for Fourth Question
        RadioGroup fourthQuestionView = (RadioGroup)findViewById(R.id.fourth_question);
        fourthQuestionView.clearCheck();

    }
}
