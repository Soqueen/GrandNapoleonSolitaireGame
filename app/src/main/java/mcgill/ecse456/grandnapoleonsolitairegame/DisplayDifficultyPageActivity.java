package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.media.MediaPlayer;
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
        MusicManager.GamePlayer(this);
        setContentView(R.layout.activity_display_difficulty_page);
    }

    /**
     * Navigate to Random game when the user click on Random/predetermined button
     *
     * @return None
     * @params view
     */
    public void randomGameNavigate(View view) {
        MusicManager.clickPlayer.start();
        if (MusicManager.gamePlayer.isPlaying()){
            MusicManager.gamePlayer.stop();
        }
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
        MusicManager.clickPlayer.start();
        if (MusicManager.gamePlayer.isPlaying()){
            MusicManager.gamePlayer.stop();
        }
        MusicManager.gamePlayer.start();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }

}