package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Log.d("MainPageActivity", "onCreate was called");
    }
    /* Navigate to difficulty page when the user click on start button */
    public void difficultyPageNavigate(View view) {
        Intent intent = new Intent(this, DisplayDifficultyPageActivity.class);
        startActivity(intent);
    }

    /* Closed GNS app when the user click on closed button */
    public void closedApp (View view){
        finish();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("MainPageActivity", "onResume was called");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("MainPageActivity", "onStart was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainPageActivity", "onRestart was called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("MainPageActivity", "onPause was called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("MainPageActivity", "onStop was called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("MainPageActivity", "onDestroy was called");
    }
}
