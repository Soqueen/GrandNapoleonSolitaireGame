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


public class WinActivity extends AppCompatActivity {
    private Context context;
    ArrayList<String> listName,  listTime;
    ArrayList<Integer> listStep;

    public WinActivity() {

    }

    public WinActivity(Context context,ArrayList<String> name, ArrayList<String> time, ArrayList<Integer> step) {
        this.context = context;
        this.listName = name;
        this.listStep = step;
        this.listTime = time;
    }


    public void popUp() {
        final Dialog dialog = new Dialog(context);
        MusicManager.gamePlayer.stop();
        dialog.setContentView(R.layout.win_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
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
            Intent intent = new Intent(context, DisplayDifficultyPageActivity.class);
            context.startActivity(intent);
            }
        });
    }
    @Override
    public  void onBackPressed(){

    }
}



