package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * GNS Android Game Application
 * DisplayDifficultyPageActivity.java
 * Purpose: Contains the logic of the select difficulty Page.
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/12/2017
 */

public class DisplayDifficultyPageActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_display_difficulty_page);
    }

    /**
     * Navigate to Random game when the user click on Random/predetermined button
     *
     * @return None
     * @params view
     */
    public void randomGameNavigate(View view) {
        if (MusicManager.gamePlayer != null) {
            MusicManager.gamePlayer.release();
            MusicManager.gamePlayer = null;
        }
        MusicManager.GamePlayer(this);
        MusicManager.clickPlayer.start();
        MusicManager.gamePlayer.start();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("id", 1);
        startActivity(intent);
    }
    /**
     * Navigate to Random game when the user click on Random/predetermined button
     *
     * @return None
     * @params view
     */
    public void predeterminedGameNavigate(View view) {
        if (MusicManager.gamePlayer != null) {
            MusicManager.gamePlayer.release();
            MusicManager.gamePlayer = null;
        }
        MusicManager.GamePlayer(this);
        MusicManager.clickPlayer.start();
        MusicManager.gamePlayer.start();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }

    public void closedDifficulty (View view){
        finish();
    }
    @Override
    public  void onBackPressed(){

    }
}