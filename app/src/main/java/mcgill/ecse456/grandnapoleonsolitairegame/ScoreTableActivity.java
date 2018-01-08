package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * GNS Android Game Application
 * ScoreTableActivity.java
 * Purpose: Contains the logic of the scoretable page features. It displays the winner score.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/15/2017
 */

public class ScoreTableActivity extends AppCompatActivity{
    private ArrayList<String> nameDB, timeDB;
    private ArrayList<Integer> stepDB;
    private Button clearButton;
    DatabaseHelper dbHandler;
    private boolean empty = false;
    // Initialize the table layout on score table page
    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText("   NO   ");
        tv0.setTextColor(Color.WHITE);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText("   PLAYER NAME   ");
        tv1.setTextColor(Color.WHITE);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText("   TIME   ");
        tv2.setTextColor(Color.WHITE);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText("  NUMBER OF STEP  ");
        tv3.setTextColor(Color.WHITE);
        tbrow0.addView(tv3);
        stk.addView(tbrow0);
        if (!empty){
            // Loop through the all the array list of name, timer and step counter to display in score table
            for (int i = 0; i < nameDB.size(); i++) { // take till the lenght of data save
                TableRow tbrow = new TableRow(this);
                TextView t1v = new TextView(this);
                t1v.setText("  " + (i+1));
                t1v.setTextColor(Color.WHITE);
                t1v.setGravity(Gravity.CENTER);
                tbrow.addView(t1v);
                TextView t2v = new TextView(this);
                t2v.setText("  " + nameDB.get(i)); // input from user
                t2v.setTextColor(Color.WHITE);
                t2v.setGravity(Gravity.CENTER);
                tbrow.addView(t2v);
                TextView t3v = new TextView(this);
                t3v.setText("  " + timeDB.get(i)); // input from time
                t3v.setTextColor(Color.WHITE);
                t3v.setGravity(Gravity.CENTER);
                tbrow.addView(t3v);
                TextView t4v = new TextView(this);
                t4v.setText("  "+ stepDB.get(i));
                t4v.setTextColor(Color.WHITE);
                t4v.setGravity(Gravity.CENTER);
                tbrow.addView(t4v);
                stk.addView(tbrow);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Stop the background music
        MusicManager.gamePlayer.stop();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.score_page);
        // Get the extra parameters passed from game page
        Bundle b = getIntent().getExtras();
        if(b != null) {
            this.nameDB = b.getStringArrayList("name");
            this.timeDB = b.getStringArrayList("time");
            this.stepDB = b.getIntegerArrayList("step");
            this.empty = false;
        }
        else {
            this.empty = true;
        }
        clearButton = (Button) findViewById(R.id.clear);
        dbHandler = new DatabaseHelper(this, null, null, 1);
        // Call init to display the table of score
        init();
    }
    // Called to close the score table when the closed button on the score table page is clicked
    public void closedScoreTable (View view){
        MusicManager.clickPlayer.start();
        finish();
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);

    }

    // Called to delete all score recorded in the table when the Clear button is clicked
    public void deleteScoreRecord(View view){
        MusicManager.clickPlayer.start();
        dbHandler.deleteScoreRecord(); // Remove the score saved in database
        Intent intent = new Intent(this, ScoreTableActivity.class);
        startActivity(intent);
    }
    @Override
    public  void onBackPressed(){

    }
}


