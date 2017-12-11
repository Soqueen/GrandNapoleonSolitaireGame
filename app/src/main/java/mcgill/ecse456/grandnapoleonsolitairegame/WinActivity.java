package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;

import java.util.ArrayList;

/**
 * GNS Android Game Application
 * WinActivity.java
 * Purpose: Contains the logic of the WinActivity page features.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/15/2017
 */

public class WinActivity extends AppCompatActivity {
    private Context context;
    ArrayList<String> listName, listTime;
    ArrayList<Integer> listStep;

    // Default constructor to avoid android error
    public WinActivity() {

    }
    // Main constructor
    public WinActivity(Context context, ArrayList<String> name, ArrayList<String> time, ArrayList<Integer> step) {
        this.context = context;
        this.listName = name;
        this.listStep = step;
        this.listTime = time;
    }

    // Win dialog popup when the game is finished (Win)
    public void popUp() {
        final Dialog dialog = new Dialog(context);
        MusicManager.gamePlayer.stop();
        dialog.setContentView(R.layout.win_dialog);
        // Set the touch false when it clicked outside the win dialog - avoid win dialog closed if closed button isn't clicked
        dialog.setCanceledOnTouchOutside(false);
        // Show the win dialog
        dialog.show();
        // Initialize the all button on win dialog
        Button replayGame = (Button) dialog.findViewById(R.id.replay);
        Button viewScore = (Button) dialog.findViewById(R.id.score_view);
        // Check if the instruction menu button is clicked
        viewScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                // Display on the score table activity
                Intent intent = new Intent(context, ScoreTableActivity.class);
                intent.putExtra("name", listName);
                intent.putExtra("time", listTime);
                intent.putExtra("step", listStep);
                context.startActivity(intent);
            }
        });
        // Check if the instruction menu button is clicked
        replayGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                // Navigate to the difficulty page
                Intent intent = new Intent(context, DisplayDifficultyPageActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}



