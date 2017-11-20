package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        setContentView(R.layout.activity_display_difficulty_page);
    }

    /**
     * Navigate to Random game when the user click on Random/predetermined button
     *
     * @return None
     * @params view
     */
    public void randomGameNavigate(View view) {
        boolean isMute = false;
        if (MusicManager.gamePlayer != null) {
            isMute = MusicManager.isMute;
            MusicManager.gamePlayer.release();
            MusicManager.gamePlayer = null;
        }
        MusicManager.isMute = isMute;
        Log.d("___music state", ""+isMute);
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

//        boolean isMute = false;
        if (MusicManager.gamePlayer != null) {
//            isMute = MusicManager.isMute;
            MusicManager.gamePlayer.release();
            MusicManager.gamePlayer = null;
        }
//        MusicManager.isMute = isMute;
        MusicManager.clickPlayer.start();
        MusicManager.gamePlayer.start();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }

    public void closedDifficulty (View view){
        finish();
    }

}