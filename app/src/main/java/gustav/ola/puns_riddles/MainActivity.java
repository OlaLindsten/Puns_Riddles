package gustav.ola.puns_riddles;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {
    boolean isPun = false;
    boolean isRiddle = false;
    int riddleCounter = 0;                                    //Keep track of which question
    int riddleTemp = 0;                                       //A variable to store counter in
    int punCounter = 0;
    int punTemp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Removes title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    //Get pun question and reset answer
    public void getPun(View view){
        final TextView punView = findViewById(R.id.question);
        final TextView answerView = findViewById(R.id.answer);

        setPunUnderline();
        removeRiddleUnderline();

        punView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
        punView.setText(setPunQuestion(0));
        answerView.setText("");
        isPun = true;
        isRiddle = false;
    }

    //Get riddle question and reset answer
    public void getRiddle(View view){
        final TextView riddleView = findViewById(R.id.question);
        final TextView answerView = findViewById(R.id.answer);

        setRiddleUnderline();
        removePunUnderline();

        riddleView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
        riddleView.setText(setRiddleQuestion(0));                             //Get question
        answerView.setText("");
        isPun = false;
        isRiddle = true;
    }

    //Get answer, if answer already exist --> get new question
    public void getAnswer(View view){
        final TextView answerView = findViewById(R.id.answer);
        if(answerView.getText().equals("")){
            answerView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
            if (isRiddle == true) {
                answerView.setText(setRiddleQuestion(1));
            }else if(isPun == true){
                answerView.setText(setPunQuestion(1));
            }
        }else{
            if(isRiddle == true && isPun == false){
                getRiddle(view);
            }else{
                getPun(view);
            }
        }
    }

    //Underline pun header
    public void setPunUnderline(){
        final TextView pun = findViewById(R.id.puns);
        pun.setPaintFlags(pun.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    //Remove underline from pun header
    public void removePunUnderline(){
        final TextView pun = findViewById(R.id.puns);
        pun.setPaintFlags(0);
    }

    //Underline riddle header
    public void setRiddleUnderline(){
        final TextView riddle = findViewById(R.id.riddles);
        riddle.setPaintFlags(riddle.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    //Remove underline from riddle header
    public void removeRiddleUnderline(){
        final TextView riddle = findViewById(R.id.riddles);
        riddle.setPaintFlags(0);
    }

    //Return question or answer for riddle
    public String setRiddleQuestion(int index){           //Index 0 = question 1 = answer

        int columns = 3;        //Questions
        int rows = 2;           //Answers

        String[][] riddles = new String[columns][rows];

        riddles[0][0] = "På vilken väg går man tillbaka, men kommer ändå närmare målet?";
        riddles[0][1] = "Hemvägen";

        riddles[1][0] = "Vilka tanter är mest populära?";
        riddles[1][1] = "Kontanter";

        riddles[2][0] = "Om du har den, så vill du dela med dig av den. Men om du delar med dig av den, så har du den inte. Vad är det?";
        riddles[2][1] = "En hemlighet";

        if(riddleCounter < columns && index == 0){
            riddleTemp = riddleCounter;
        }else if(riddleCounter < columns - index && index == 1){
            riddleTemp = riddleCounter;
            riddleCounter++;
        }else{
            riddleCounter = 0;
        }

        return riddles[riddleTemp][index];
    }

    public String setPunQuestion(int index){
        int columns = 7;        //Questions
        int rows = 2;           //Answers

        String[][] puns = new String[columns][rows];

        puns[0][0] = "Blir du inte trött av att spela schack?";
        puns[0][1] = "Jo, alldeles matt!";

        puns[1][0] = "Har du en pool hemma?";
        puns[1][1] = "Nä, men jag har damm under sängen.";

        puns[2][0] = "Vilken snygg fisk du har!";
        puns[2][1] = "Ja, det är en läcker-ål.";

        puns[3][0] = "Kalle Anka, Bamse och Fantomen har hittats döda.";
        puns[3][1] = "Polisen tror att en seriemördare går lös.";

        puns[4][0] = "Var det varmt i New York?";
        puns[4][1] = "Ja, rena Manhettan!";

        puns[5][0] = "Vad vill du ha för svamp?";
        puns[5][1] = "Hmm... Jag kan ta reller!";

        puns[6][0] = "Är du klar med julgodiset?";
        puns[6][1] = "Ja, men det tog nästan knäcken på mig!";


        if(punCounter < columns && index == 0){
            punTemp = punCounter;
        }else if(punCounter < columns - index && index == 1){
            punTemp = punCounter;
            punCounter++;
        }else{
            punCounter = 0;
        }

        return puns[punTemp][index];
    }
}
