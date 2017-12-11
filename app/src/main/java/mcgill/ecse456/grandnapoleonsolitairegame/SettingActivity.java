package mcgill.ecse456.grandnapoleonsolitairegame;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * GNS Android Game Application
 * Setting.java
 * Purpose: Contains the logic of the setting page features.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/15/2017
 */


// There is no logic for setting feature yet. This is just a dummy page after setting button detected on game page.
// TODO - Implement the logic of setting.
public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.setting);

    }

    // Closed the setting page when the closed button is clicked
    public void closedSetting(View view) {
        MusicManager.clickPlayer.start();
        finish();
    }

    @Override
    public void onBackPressed() {

    }


}
