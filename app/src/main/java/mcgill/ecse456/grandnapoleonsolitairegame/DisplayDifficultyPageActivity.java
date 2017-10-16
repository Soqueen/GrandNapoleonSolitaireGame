package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;

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
     * Navigate to Easy game when the user click on Easy button
     *
     * @return None
     * @params view
     */
    public void easyGameNavigate(View view) {
        Intent intent = new Intent(this, EasyLevelGameActivity.class);
        startActivity(intent);
    }
}