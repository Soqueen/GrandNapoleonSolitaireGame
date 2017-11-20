package mcgill.ecse456.grandnapoleonsolitairegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class AboutPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }
    protected void closedAbout(View view) {
        MusicManager.clickPlayer.start();
        finish();
    }
}

