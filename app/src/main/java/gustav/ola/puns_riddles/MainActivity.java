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
        riddleView.setText("Gåta");
        answerView.setText("");
        isPun = false;
        isRiddle = true;
    }

    //Get answer, if answer already exist --> get new question
    public void getAnswer(View view){
        final TextView answerView = findViewById(R.id.answer);
        if(answerView.getText().equals("")){
            answerView.setText("Svar");
        }else{
            if(isRiddle == true && isPun == false){
                getRiddle(view);
            }else{
                getPun(view);
            }
        }
    }
}
