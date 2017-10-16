package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * GNS Android Game Application
 * MainPageActivity.java
 * Purpose: Contains the logic of the Main page features.
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/10/2017
 */
public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    /**
     * Navigate to difficulty page when the user click on start button
     *
     * @return None
     * @params view
     */
    public void difficultyPageNavigate(View view) {
        Intent intent = new Intent(this, DisplayDifficultyPageActivity.class);
        startActivity(intent);
    }
}
