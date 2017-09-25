package com.example.apple.secondquizapp;

/**
 * Created by apple on 23/09/17.
 */

public class questionLibrary {

    private String mQuestions[] = {
            "Which is the first Indian start-up to get backed by Google capital?",
            "Which of the following Indian start-ups have a global presence over 20 countries?",
            "Which is the first Indian start-up to be selected for ‘Startupbootcamp Mobile’ global programme?",
            "Which is the first Indian start-up to win the prestigious Richard Ivey B-Plan competition?",
            "Which is the first Indian start-up to get the backing of YCombinator in (2015)?",
            "Which is the first Indian start-up to get acquired by twitter?",
            "Which is the first Indian start-up to get acquired by facebook?",
            "Which Indian start-up is acquired by the ibibo group?",
            "Which of the following is an Indian start-up in the digital advertising network industry?",
            "Big Basket still doesn’t have a presence in which of the following cities?",
            "Which of the following is a Bangalore based start-up that works as a furniture retailer?"
    };

    private String mChoices[][] = {
            {"ZipDial", "BoolPad", "FreshDesk", "PayTM"},
            {"Vizury", "Zovi", "Zomato", "Infibeam"},
            {"Zovi", "Skidos", "CommonFloor", "Quikr"},
            {"Flipkart", "Zomato", "Zostel", "Housing"},
            {"ZoomCar", "RazorPay", "TeaBox", "Grofers"},
            {"ZipDial", "InstaMojo", "Toppr", "Hike"},
            {"Little Eye Labs", "SilverPush", "HomeLane.com", "Skidos"},
            {"MakeMyTrip", "Yatra", "RedBus", "BookMyShow"},
            {"InMobi", "Sigmoid", "Zoom", "RazorPay"},
            {"Mumbai", "Kolkata", "Bangalore", "Hyderabad"},
            {"UrbanLadder", "TaskBob", "Furnikart", "Woodkid"}
    };

    private String mCorrectAnswers[] = {
            "FreshDesk",
            "Zomato",
            "Skidos",
            "Zostel",
            "RazorPay",
            "ZipDial",
            "Little Eye Labs",
            "RedBus",
            "InMobi",
            "Kolkata",
            "UrbanLadder"};

    public String getQuestions(int a) {
        String questions = mQuestions[a];
        return questions;
    };

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    };

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    };

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    };

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    };

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

    public int getQuestionLength(){
        return mQuestions.length;
    }


}
