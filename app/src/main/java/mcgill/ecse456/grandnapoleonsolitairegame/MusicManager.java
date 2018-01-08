package mcgill.ecse456.grandnapoleonsolitairegame;

import android.media.FaceDetector;
import android.media.MediaPlayer;
import android.content.Context;

/**
 * GNS Android Game Application
 * MusicManager.java
 * Purpose: Music manager object. It called once the game main page open.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/15/2017
 */

public class MusicManager {
    public static MediaPlayer clickPlayer;
    public static MediaPlayer gamePlayer;
    public static Context context;

    public static void GamePlayer(Context ctx) {
        context = ctx;
        // Initialized background music for game page
        gamePlayer = MediaPlayer.create(ctx, R.raw.game);
        gamePlayer.setLooping(true); // Set looping
        gamePlayer.setVolume(100, 100);
        // Initialized click sound on button clicked
        clickPlayer = MediaPlayer.create(ctx, R.raw.click);
        clickPlayer.setLooping(false); // Set looping
        clickPlayer.setVolume(100, 100);
    }

    // Mute can be controlled thru setting feature
    public static void mute() {
        gamePlayer.setVolume(0, 0);
        clickPlayer.setVolume(0, 0);
    }

    // Unmute can be controlled thru setting feature.
    public static void unMute() {
        gamePlayer.setVolume(100, 100);
        clickPlayer.setVolume(100, 100);
    }


}
