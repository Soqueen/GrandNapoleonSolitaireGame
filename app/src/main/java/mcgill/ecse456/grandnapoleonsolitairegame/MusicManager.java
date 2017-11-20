package mcgill.ecse456.grandnapoleonsolitairegame;

import android.media.FaceDetector;
import android.media.MediaPlayer;
import android.content.Context;


public class MusicManager {
    public static MediaPlayer clickPlayer;
    public static MediaPlayer gamePlayer;
    public static Context context;
    public static boolean isMute = false;

    public static void GamePlayer(Context ctx){
        context = ctx;
        gamePlayer = MediaPlayer.create(ctx, R.raw.game);
        gamePlayer.setLooping(true); // Set looping
        if (isMute)
            gamePlayer.setVolume(0,0);
        else
            gamePlayer.setVolume(100, 100);

        clickPlayer = MediaPlayer.create(ctx,R.raw.click);
        clickPlayer.setLooping(false); // Set looping
        if (isMute)
            clickPlayer.setVolume(0, 0);
        else
            clickPlayer.setVolume(100, 100);
    }
    public static void mute() {
        gamePlayer.setVolume(0,0);
        clickPlayer.setVolume(0,0);
        isMute = true;
    }

    public static void unMute() {
        gamePlayer.setVolume(100,100);
        clickPlayer.setVolume(100,100);
        isMute = false;
    }




}
