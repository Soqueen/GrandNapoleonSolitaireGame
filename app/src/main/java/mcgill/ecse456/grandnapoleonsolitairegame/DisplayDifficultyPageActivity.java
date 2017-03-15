package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DisplayDifficultyPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_difficulty_page);
        Log.d("DDPActivity", "onCreate was called");

    }
    /* Navigate to Easy game  when the user click on Easy button */
    public void easyGameNavigate(View view) {
        Intent intent = new Intent(this, EasyLevelGameActivity.class);
        startActivity(intent);
    }
}
