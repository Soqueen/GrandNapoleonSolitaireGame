package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.os.SystemClock;

/**
 * GNS Android Game Application
 * Pause.java
 * Purpose: Contains the logic of the pause page features.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/15/2017
 */

public class Pause extends AppCompatActivity {
    private Context context;
    private Button pauseButton;
    private Chronometer timer;
    private long timeDiff;

    public Pause() {
        this.timeDiff = 0;
    }

    public Pause(Context context, Button pauseButton, Chronometer timer) {
        this.context = context;
        this.pauseButton = pauseButton;
        this.timer = timer;
        this.timeDiff = 0;
    }

    // This funciton is called in game page when the pause button is triggered. This pop up the pause dialog page.
    public void popUp() {
        this.pauseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final Dialog dialog = new Dialog(context);
                // Stopping the background music of game page
                MusicManager.gamePlayer.stop();

                dialog.setContentView(R.layout.pause_dialog);
                // Set the touch false when it clicked outside the pause dialog - avoid pause dialog closed if closed button isn't clicked
                dialog.setCanceledOnTouchOutside(false);
                // Initializing all the buttons of pause dialog
                Button resumeButton = (Button) dialog.findViewById(R.id.resume_button);
                Button quitButton = (Button) dialog.findViewById(R.id.quit_button);
                Button settingButton = (Button) dialog.findViewById(R.id.setting_button);
                Button instructionButton = (Button) dialog.findViewById(R.id.instruction_button);

                // Saving the current time before pause dialog appear
                timeDiff = timer.getBase() - SystemClock.elapsedRealtime();
                // Stopping the timer
                timer.stop();
                // Displaying the pause dialog
                dialog.show();

                // Checking if the resume button is clicked
                resumeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Resume the timer
                        timer.setBase(SystemClock.elapsedRealtime() + timeDiff);
                        timer.start();
                        // Checking if music is not null
                        // Starting the music before closed pause dialog
                        if (MusicManager.gamePlayer != null) {
                            MusicManager.gamePlayer.release();
                            MusicManager.gamePlayer = null;
                        }
                        MusicManager.GamePlayer(context);
                        MusicManager.clickPlayer.start();
                        MusicManager.gamePlayer.start();
                        // Close the pause dialog
                        dialog.dismiss();
                    }
                });


                // Check if the quit button is clicked, it return to level page
                quitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Forcing the game to quit and go back to difficult page
                        MusicManager.clickPlayer.start();
                        finish();
                        android.os.Process.killProcess(android.os.Process.myPid());
                        Pause.super.onDestroy();
                    }
                });

                // Check if the setting menu button is clicked
                settingButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        // Calling setting page activity
                        Intent intent = new Intent(context, SettingActivity.class);
                        context.startActivity(intent);
                    }
                });

                // Check if the instruction menu button is clicked
                instructionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        // Calling instruction page activity
                        Intent intent = new Intent(context, Instruction.class);
                        context.startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {

    }
}
