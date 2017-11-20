package mcgill.ecse456.grandnapoleonsolitairegame;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class SettingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        CheckBox enableMusic, enableUndo, enableHint;

        enableHint = (CheckBox)findViewById(R.id.enable_hint);
        enableHint.setChecked(getFromSP("enableHint"));
        enableHint.setOnCheckedChangeListener(this);
        enableUndo = (CheckBox)findViewById(R.id.enable_undo);
        enableUndo.setChecked(getFromSP("enableUndo"));
        enableUndo.setOnCheckedChangeListener(this);
        enableMusic = (CheckBox)findViewById(R.id.enable_music);
        enableMusic.setChecked(getFromSP("enableMusic"));
        enableMusic.setOnCheckedChangeListener(this);
    }
    public void closedSetting (View view){
        MusicManager.clickPlayer.start();
        finish();
    }

    private boolean getFromSP(String key){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("GNS_GAME", android.content.Context.MODE_PRIVATE);
        return preferences.getBoolean(key, false);
    }
    private void saveInSp(String key,boolean value){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("GNS_GAME", android.content.Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch(buttonView.getId()){
            case R.id.enable_hint:
                saveInSp("enableHint",isChecked);
                break;
            case R.id.enable_undo:
                saveInSp("enableUndo",isChecked);
                break;

            case R.id.enable_music:
                if (isChecked)
                    MusicManager.mute();
                else
                    MusicManager.unMute();
                saveInSp("enableMusic",isChecked);
                break;
        }

    }
}
