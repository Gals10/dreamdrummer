package com.example.dreamdrummer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TriviaActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView countlabel;
    private TextView questionlabel;
    Button fiftyHelp;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private TextView textviewScores;
    private String rightAnswer;
    int useFifty;
    private int rightAnswerCount=0;
    private int quizCount=1;
    int scores;
    static final private int QUIZ_COUNT=3;
    TextView drumLeft;
    ArrayList<ArrayList<String>> quizArray=new ArrayList<>();
    String quizData[][];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);
        countlabel=(TextView)findViewById(R.id.countLabel);
        fiftyHelp=(Button)findViewById(R.id.helpFifty);
        questionlabel=(TextView)findViewById(R.id.questionLabel);
        answerBtn1=(Button)findViewById(R.id.answerBtn1);
        answerBtn2=(Button)findViewById(R.id.answerBtn2);
        answerBtn3=(Button)findViewById(R.id.answerBtn3);
        answerBtn4=(Button)findViewById(R.id.answerBtn4);
        textviewScores=(TextView)findViewById(R.id.scoreTrivia);

        fiftyHelp.setOnClickListener(this);

//match country with questions
        Intent intent=getIntent();
        String generatedDrum=intent.getStringExtra("generatedDrum");
        //show and update the game scores

        //countries left to find in the game
        int left=intent.getExtras().getInt("left");
        //i set the scores at line 82
         scores=intent.getExtras().getInt("scores");

        if(intent.getIntExtra("useFifty",0)==1)
        {
            fiftyHelp.setVisibility(View.GONE);
            useFifty=1;
        }

        // pass array to check if drums left

        String[] drums=intent.getStringArrayExtra("checkleftDrum");
        textviewScores.setText(String.valueOf(scores));


        if(generatedDrum.equals("רייד"))
        {
            quizData=Questions.getraid();
        }
        else if(generatedDrum.equals("טמטם"))
        {
            quizData=Questions.gettamtam();
        }
        else if(generatedDrum.equals("קראש"))
        {
            quizData=Questions.getcrash();
        }
        else if(generatedDrum.equals("הייט"))
        {
            quizData=Questions.gethayet();
        }
        else if(generatedDrum.equals("סנייר"))
        {
            quizData=Questions.getsnare();
        }
        else
            quizData=Questions.getbas();

        //create quizArray from quizData
        for(int i=0;i<quizData.length;i++)
        {
            //prepare array.
            ArrayList<String> tmpArray=new ArrayList<>();
            tmpArray.add(quizData[i][0]); //question
            tmpArray.add(quizData[i][1]); //Right answer
            tmpArray.add(quizData[i][2]); //choice 1
            tmpArray.add(quizData[i][3]); //choice 2
            tmpArray.add(quizData[i][4]); //choice 3

            //Add tmpArray to quizArray
            quizArray.add(tmpArray);

        }
        showNextQuiz();
    }
    public void showNextQuiz()
    {
        answerBtn1.setVisibility(View.VISIBLE);
        answerBtn2.setVisibility(View.VISIBLE);
        answerBtn3.setVisibility(View.VISIBLE);
        answerBtn4.setVisibility(View.VISIBLE);

        //Update quizCountLabel
        countlabel.setText("שאלה " + quizCount);
        //Generate random number between 0 to 14(quizArray's size - 1)
        Random random=new Random();
        int randomNum=random.nextInt(quizArray.size());
        //pick one quiz set
        ArrayList<String> quiz=quizArray.get(randomNum);
        //set question and right answer
        questionlabel.setText(quiz.get(0));
        rightAnswer=quiz.get(1);
        // remove question from quiz and shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));
        //Remove this quiz from quizArray
        quizArray.remove(randomNum);
    }



    public void checkAnswer(View view)
    {
        Intent intent=getIntent();
        int scores =intent.getExtras().getInt("scores");
        //get pushed button.
        Button answerBtn=(Button)findViewById(view.getId());
        String btnText=answerBtn.getText().toString();
        String alertTitle;
        if(btnText.equals(rightAnswer))
        {
            //correct!
            scores=Integer.parseInt(textviewScores.getText().toString());
            scores=scores+1;
            textviewScores.setText(String.valueOf(scores));
            alertTitle="Correct!";
            rightAnswerCount++;

        }
        else
        {
            //wrong...
            alertTitle="Wrong...";
        }
        //create dialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer : " + rightAnswer);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount==QUIZ_COUNT)
                {
                    //show result
                    checkIfLeft();
                    passDataBack();
                }
                else
                {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
    @Override
    public void onBackPressed()
    {

    }
    //בדיקת כמה תופים נשארו
    public void checkIfLeft()//אם לא נגמרו התופים, ממשיכים לשורה הבאה שהיא מסירת האינטנטים בחזרה לgameActivity
    {
        Intent intent=getIntent();
        int left=intent.getExtras().getInt("left");
        if(left==1)
        {
            int scores=Integer.parseInt(textviewScores.getText().toString());
            Intent toGameOver=new Intent(this,GameOver.class);
            toGameOver.putExtra("finalScores",scores);
            startActivity(toGameOver);
        }
    }
    public void passDataBack()
    {
        Intent intent=getIntent();
        String[] drums=intent.getStringArrayExtra("checkleftDrum");
        int left=intent.getExtras().getInt("left");
        Intent resultIntent=new Intent();
        int scores=Integer.parseInt(textviewScores.getText().toString());
        Intent toGame=new Intent(this,GameActivity.class);
        toGame.putExtra("finalScores",scores);
        resultIntent.putExtra("checkleftDrumAfterInTrivia",drums);
        resultIntent.putExtra("scoreAfterInTrivia",scores);
        resultIntent.putExtra("leftAfterTrivia",left-1);
        resultIntent.putExtra("useFifty",useFifty);
        setResult(RESULT_OK,resultIntent);
        finish();
    }


    @Override
    public void onClick(View v)
    {
        Button help=(Button)findViewById(v.getId());
        String btnText=help.getText().toString();
        Intent intent=getIntent();

        if(btnText.equals("50/50")&&useFifty==0)
        {
            useFifty=1;
            if (rightAnswer.equals(answerBtn1.getText().toString()))
            {
                ArrayList<Button> toInvisible=new ArrayList<>();
                toInvisible.add(answerBtn2);
                toInvisible.add(answerBtn3);
                toInvisible.add(answerBtn4);
                Random random=new Random();
                int randomNum1=random.nextInt(toInvisible.size());
                int randomNum2=random.nextInt(toInvisible.size());
                while(randomNum2==randomNum1)
                    randomNum2=random.nextInt(toInvisible.size());
                if(randomNum1==0||randomNum2==0)
                    answerBtn2.setVisibility(View.GONE);
                if(randomNum1==1||randomNum2==1)
                    answerBtn3.setVisibility(View.GONE);
                if(randomNum1==2||randomNum2==2)
                    answerBtn4.setVisibility(View.GONE);
                fiftyHelp.setVisibility(View.GONE);
            }
            else if (rightAnswer.equals(answerBtn2.getText().toString()))
            {
                ArrayList<Button> toInvisible=new ArrayList<>();
                toInvisible.add(answerBtn1);
                toInvisible.add(answerBtn3);
                toInvisible.add(answerBtn4);
                Random random=new Random();
                int randomNum1=random.nextInt(toInvisible.size());
                int randomNum2=random.nextInt(toInvisible.size());
                while(randomNum2==randomNum1)
                    randomNum2=random.nextInt(toInvisible.size());
                if(randomNum1==0||randomNum2==0)
                    answerBtn1.setVisibility(View.GONE);
                if(randomNum1==1||randomNum2==1)
                    answerBtn3.setVisibility(View.GONE);
                if(randomNum1==2||randomNum2==2)
                    answerBtn4.setVisibility(View.GONE);
                fiftyHelp.setVisibility(View.GONE);
            }
            else if (rightAnswer.equals(answerBtn3.getText().toString()))
            {
                ArrayList<Button> toInvisible=new ArrayList<>();
                toInvisible.add(answerBtn1);
                toInvisible.add(answerBtn2);
                toInvisible.add(answerBtn4);
                Random random=new Random();
                int randomNum1=random.nextInt(toInvisible.size());
                int randomNum2=random.nextInt(toInvisible.size());
                while(randomNum2==randomNum1)
                    randomNum2=random.nextInt(toInvisible.size());
                if(randomNum1==0||randomNum2==0)
                    answerBtn1.setVisibility(View.GONE);
                if(randomNum1==1||randomNum2==1)
                    answerBtn2.setVisibility(View.GONE);
                if(randomNum1==2||randomNum2==2)
                    answerBtn4.setVisibility(View.GONE);
                fiftyHelp.setVisibility(View.GONE);
            }
            else if (rightAnswer.equals(answerBtn4.getText().toString()))
            {
                ArrayList<Button> toInvisible=new ArrayList<>();
                toInvisible.add(answerBtn1);
                toInvisible.add(answerBtn2);
                toInvisible.add(answerBtn3);
                Random random=new Random();
                int randomNum1=random.nextInt(toInvisible.size());
                int randomNum2=random.nextInt(toInvisible.size());
                while(randomNum2==randomNum1)
                    randomNum2=random.nextInt(toInvisible.size());
                if(randomNum1==0||randomNum2==0)
                    answerBtn1.setVisibility(View.GONE);
                if(randomNum1==1||randomNum2==1)
                    answerBtn2.setVisibility(View.GONE);
                if(randomNum1==2||randomNum2==2)
                    answerBtn3.setVisibility(View.GONE);
                fiftyHelp.setVisibility(View.GONE);

            }

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_aboutme:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent me = new Intent(TriviaActivity.this, AboutMe.class);
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(TriviaActivity.this, AboutAPP.class);
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                onBackPressedd();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressedd()
    {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

}

