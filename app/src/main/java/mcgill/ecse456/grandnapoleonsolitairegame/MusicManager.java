package mcgill.ecse456.grandnapoleonsolitairegame;

import android.media.MediaPlayer;
import android.content.Context;


public class MusicManager {
    public static MediaPlayer clickPlayer;
    public static MediaPlayer gamePlayer;
    public static Context context;

    public static void GamePlayer(Context ctx){
        context = ctx;
        gamePlayer = MediaPlayer.create(ctx, R.raw.game);
        gamePlayer.setLooping(false); // Set looping
        gamePlayer.setVolume(100, 100);

        clickPlayer = MediaPlayer.create(ctx,R.raw.click);
        clickPlayer.setLooping(false); // Set looping
        clickPlayer.setVolume(100, 100);
    }
    


}
