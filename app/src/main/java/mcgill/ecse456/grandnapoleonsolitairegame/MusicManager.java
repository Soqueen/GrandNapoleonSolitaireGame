package mcgill.ecse456.grandnapoleonsolitairegame;

import android.media.FaceDetector;
import android.media.MediaPlayer;
import android.content.Context;

/**
 * GNS Android Game Application
 * GameActivity.java
 * Purpose: Contains the logic of the game page features.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/15/2017
 */

public class MusicManager {
    public static MediaPlayer clickPlayer;
    public static MediaPlayer gamePlayer;
    public static Context context;
    public static boolean isMute = false;

    public static void GamePlayer(Context ctx){
        context = ctx;
        // Initialized background music for game page
        gamePlayer = MediaPlayer.create(ctx, R.raw.game);
        gamePlayer.setLooping(true); // Set looping
        gamePlayer.setVolume(100, 100);
        // Initialized click sound on button clicked
        clickPlayer = MediaPlayer.create(ctx,R.raw.click);
        clickPlayer.setLooping(false); // Set looping
        if (isMute)
            clickPlayer.setVolume(0, 0);
        else
            clickPlayer.setVolume(100, 100);
    }

    // Mute can be controlled thru setting feature
    public static void mute() {
        gamePlayer.setVolume(0,0);
        clickPlayer.setVolume(0,0);
        isMute = true;
    }

    // Unmute can be controlled thru setting feature.
    public static void unMute() {
        gamePlayer.setVolume(100,100);
        clickPlayer.setVolume(100,100);
        isMute = false;
    }




}
