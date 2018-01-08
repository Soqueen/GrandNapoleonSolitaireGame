package mcgill.ecse456.grandnapoleonsolitairegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * GNS Android Game Application
 * AboutPageActivity.java
 * Purpose: Contains the logic of the about page features.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/03/2017
 */

public class AboutPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.about);
    }

    // This called once the closed button on about activity page is clicked. It closed the about page.
    protected void closedAbout(View view) {
        MusicManager.clickPlayer.start();
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}
