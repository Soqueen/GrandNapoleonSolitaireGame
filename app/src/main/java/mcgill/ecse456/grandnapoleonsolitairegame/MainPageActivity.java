package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;



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
        MusicManager.GamePlayer(this);
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

    /* Closed GNS app when the user click on closed button */
    public void closedApp (View view){
        finish();
    }
    @Override
    protected void onResume(){
        super.onResume();
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