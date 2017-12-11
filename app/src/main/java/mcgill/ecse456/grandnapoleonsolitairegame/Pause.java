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
 * GameActivity.java
 * Purpose: Contains the logic of the game page features.
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


                // custom dialog
                final Dialog dialog = new Dialog(context);
                MusicManager.gamePlayer.stop();

                dialog.setContentView(R.layout.pause_dialog);
                dialog.setCanceledOnTouchOutside(false);
                Button resumeButton = (Button) dialog.findViewById(R.id.resume_button);
                Button quitButton = (Button) dialog.findViewById(R.id.quit_button);
                Button settingButton = (Button) dialog.findViewById(R.id.setting_button);
                Button instructionButton = (Button) dialog.findViewById(R.id.instruction_button);

                // Pause timer
                timeDiff = timer.getBase() - SystemClock.elapsedRealtime();
                timer.stop();

                dialog.show();

                // Check if the resume button is clicked
                resumeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //resume timer
                        timer.setBase(SystemClock.elapsedRealtime() + timeDiff);
                        timer.start();
                        if (MusicManager.gamePlayer != null) {
                            MusicManager.gamePlayer.release();
                            MusicManager.gamePlayer = null;
                        }
                        MusicManager.GamePlayer(context);
                        MusicManager.clickPlayer.start();
                        MusicManager.gamePlayer.start();
                        dialog.dismiss();
                    }
                });


                // Check if the quit button is clicked, it return to level page
                quitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // doesn't seem to save state here
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
                        Intent intent = new Intent(context, SettingActivity.class);
                        context.startActivity(intent);
                    }
                });

                // Check if the instruction menu button is clicked
                instructionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        Intent intent = new Intent(context, Instruction.class);
                        context.startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    public  void onBackPressed(){

    }
}
