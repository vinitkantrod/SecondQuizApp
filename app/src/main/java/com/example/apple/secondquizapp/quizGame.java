package com.example.apple.secondquizapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.apple.secondquizapp.R.id.progessCount;

/**
 * Created by vinit on 20/09/17.
 */

public class quizGame extends AppCompatActivity {

    private questionLibrary mQuestionLibrary = new questionLibrary();
    private TextView mQuestionView;
    private RadioGroup mRadioGroup;
    private TextView progressCount;
    private RadioButton mButtonChoice1;
    private RadioButton mButtonChoice2;
    private RadioButton mButtonChoice3;
    private RadioButton mButtonChoice4;
    private Button mSubmitButton;
    private ProgressBar progressBar;
    private int mQuestionLength;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumer = 0;
    private TextView questionNumberView;

    String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_list);
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");

        mQuestionView = (TextView) findViewById(R.id.questionTextView);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mButtonChoice1 = (RadioButton) findViewById(R.id.radio1);
        mButtonChoice2 = (RadioButton) findViewById(R.id.radio2);
        mButtonChoice3 = (RadioButton) findViewById(R.id.radio3);
        mButtonChoice4 = (RadioButton) findViewById(R.id.radio4);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mQuestionLength = mQuestionLibrary.getQuestionLength();
        questionNumberView = (TextView) findViewById(R.id.questionNumberView);
        questionNumberView.setText(String.valueOf(mQuestionNumer+1));
        progressCount = (TextView) findViewById(R.id.progessCount);
        progressCount.setText("Progress : " + String.valueOf(mQuestionNumer) + "/" + String.valueOf(mQuestionLength));
        progressBar = (ProgressBar) findViewById(R.id.progressBarView);
        progressBar.setMax(mQuestionLength);
        progressBar.setProgress(mScore);
        updateQuestion();
    }

    public void updateQuestion() {

        mRadioGroup.clearCheck();
        mQuestionView.setText(mQuestionLibrary.getQuestions(mQuestionNumer));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumer));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumer));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumer));
        mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumer));
        questionNumberView = (TextView) findViewById(R.id.questionNumberView);
        questionNumberView.setText(String.valueOf(mQuestionNumer+1));
        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumer);
        mQuestionNumer++;
        mSubmitButton.setText("Next");
        if (mQuestionNumer == mQuestionLength) {
            mSubmitButton.setText("Finish and Submit");
        }
        progressCount.setText("Correct Answer : " + String.valueOf(mScore) + "/" + String.valueOf(mQuestionLength));
        progressBar.setProgress(mScore);
    };

    public void checkAnswer(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        if (radioGroup.getCheckedRadioButtonId() != -1) {
            int id = radioGroup.getCheckedRadioButtonId();
            View radioButton = radioGroup.findViewById(id);
            int radioId = radioGroup.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) radioGroup.getChildAt(radioId);
            String mGetAnswer = btn.getText().toString();
            Log.i("Check answer : ", mGetAnswer);
            if (mGetAnswer == mAnswer) {
                mScore += 1;
            } else {
                mScore += 0;
            }
            if (mQuestionNumer >= 11) {
                String scoreCard;
                double avgNumber = mQuestionLength / 2.0;
                if (mScore > avgNumber) {
                    scoreCard = "You have passed the test and scored above average marks.";
                } else {
                    scoreCard = "You should try to improve this score further.";
                }
                String text = "Hi " + name + "\n";
                text += "Congratulation for Solving Tech StartUp Quiz. You Scored " + mScore + " points out of " + mQuestionLength + "\n";
                text += scoreCard + "\n\n";
                text += "All the best and keep spreading Knowledge :-)\n";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Congratulation, Quiz App Result for " + name + " is declared");
                intent.putExtra(Intent.EXTRA_TEXT, text);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
            updateQuestion();
        }
    }

}
