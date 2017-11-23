package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;

import java.util.ArrayList;


/**
 * GNS Android Game Application
 * MainPageActivity.java
 * Purpose: Contains the logic of the Main page features.
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/10/2017
 */
public class MainPageActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("GNS_GAME", android.content.Context.MODE_PRIVATE);
        boolean is_Mute = preferences.getBoolean("enableMusic", false);
        Log.d("----oncreate--", ""+(is_Mute));
        MusicManager.GamePlayer(this);
        Log.d("----oncreateMusic--", ""+(MusicManager.isMute));
        setContentView(R.layout.activity_main_page);
    }

    /**
     * Navigate to difficulty page when the user click on start button
     *
     * @return None
     * @params view
     */
    public void difficultyPageNavigate(View view) {
        MusicManager.clickPlayer.start();
        Intent intent = new Intent(this, DisplayDifficultyPageActivity.class);
        startActivity(intent);
    }

    /**
     * Navigate to Instruction page when the user click on Instruction button
     *
     * @return None
     * @params view
     */
    public void instructionNavigate(View view) {
        MusicManager.clickPlayer.start();
        Intent intent = new Intent(this, Instruction.class);
        startActivity(intent);
    }

    /**
     * Navigate to about page when the user click on about button
     *
     * @return None
     * @params view
     */
    public void displayAbout(View view) {
        MusicManager.clickPlayer.start();
        Intent intent = new Intent(this, AboutPageActivity.class);
        startActivity(intent);
    }

    public void settingNavigate(View view) {
        MusicManager.clickPlayer.start();
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

    public void scoreTableNavigate(View view) {
        MusicManager.clickPlayer.start();
        DatabaseHelper dbHandler = new DatabaseHelper(this, null,null, 1);
        Cursor data = dbHandler.getData();
        // Populate database in the arraylist for each column
        ArrayList<String> listName = new ArrayList<>();
        ArrayList<String> listTime = new ArrayList<>();
        ArrayList<String> listStep = new ArrayList<>();
        while(data.moveToNext()){
            listName.add(data.getString(1)); // Name column
            listTime.add(data.getString(2)); // Time column
            listStep.add(data.getString(3)); // Counter step column
        }
        Intent intent = new Intent(this, ScoreTableActivity.class);
        intent.putExtra("name", listName);
        intent.putExtra("time", listTime);
        intent.putExtra("step", listStep);
        startActivity(intent);
    }

    /* Closed GNS app when the user click on closed button */
    public void closedApp (View view){
        finish();
    }
    @Override
    protected void onResume(){
        super.onResume();
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("GNS_GAME", android.content.Context.MODE_PRIVATE);
        boolean is_Mute = preferences.getBoolean("enableMusic", false);
        Log.d("----onRESUME--", ""+(is_Mute));
        Log.d("MainPageActivity", "onResume was called");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("MainPageActivity", "onStart was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainPageActivity", "onRestart was called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("MainPageActivity", "onPause was called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("MainPageActivity", "onStop was called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("MainPageActivity", "onDestroy was called");
    }
}