package gustav.ola.puns_riddles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity {
    boolean isPun = false;
    boolean isRiddle = false;
    int counter = 0;                                    //Keep track of which question
    int temp = 0;                                       //A variable to store counter in

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
        punView.setText("Ordvits");
        answerView.setText("");
        isPun = true;
        isRiddle = false;
    }

    //Get riddle question and reset answer
    public void getRiddle(View view){
        final TextView riddleView = findViewById(R.id.question);
        final TextView answerView = findViewById(R.id.answer);
        riddleView.setText(setQuestion(0));                             //Get question
        answerView.setText("");
        isPun = false;
        isRiddle = true;
    }

    //Get answer, if answer already exist --> get new question
    public void getAnswer(View view){
        final TextView answerView = findViewById(R.id.answer);
        if(answerView.getText().equals("")){
            if (isRiddle == true) {
                answerView.setText(setQuestion(1));
            }else if(isPun == true){
                answerView.setText("Svar");
            }
        }else{
            if(isRiddle == true && isPun == false){
                getRiddle(view);
            }else{
                getPun(view);
            }
        }
    }

    //Return question or answer
    public String setQuestion(int index){           //Index 0 = question 1 = answer

        int columns = 3;        //Questions
        int rows = 2;           //Answers

        String[][] riddles = new String[columns][rows];

        riddles[0][0] = "På vilken väg går man tillbaka, men kommer ändå närmare målet?";
        riddles[0][1] = "Hemvägen";

        riddles[1][0] = "Vilka tanter är mest populära?";
        riddles[1][1] = "Kontanter";

        riddles[2][0] = "Om du har den, så vill du dela med dig av den. Men om du delar med dig av den, så har du den inte. Vad är det?";
        riddles[2][1] = "En hemlighet";

        if(counter < columns && index == 0){
            temp = counter;
        }else if(counter < columns - index && index == 1){
            temp = counter;
            counter++;
        }else{
            counter = 0;
        }

        return riddles[temp][index];
    }
}
