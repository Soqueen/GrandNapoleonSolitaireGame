package mcgill.ecse456.grandnapoleonsolitairegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by sokhenglim on 3/15/17.
 */

public class EasyLevelGameActivity extends AppCompatActivity{
    ImageView img, img2, img3, img4, img5, img6, img7, img8, img9;
    String msg;
    private float dx;
    private float dy;
    private float x;
    private float y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game_page);
        Log.d("ELGActivity", "onCreate was called");
        img = (ImageView)findViewById(R.id.imageView1);
        img2 = (ImageView)findViewById(R.id.imageView2);
        img3 = (ImageView)findViewById(R.id.imageView3);
        img4 = (ImageView)findViewById(R.id.imageView4);
        img5 = (ImageView)findViewById(R.id.imageView5);
        img6 = (ImageView)findViewById(R.id.imageView6);
        img7 = (ImageView)findViewById(R.id.imageView7);
        img8 = (ImageView)findViewById(R.id.imageView8);
        img9 = (ImageView)findViewById(R.id.imageView9);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img.setX(event.getRawX() - dx);
                        img.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img2.setX(event.getRawX() - dx);
                        img2.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img3.setX(event.getRawX() - dx);
                        img3.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img4.setX(event.getRawX() - dx);
                        img4.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img5.setX(event.getRawX() - dx);
                        img5.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img6.setX(event.getRawX() - dx);
                        img6.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img7.setX(event.getRawX() - dx);
                        img7.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img8.setX(event.getRawX() - dx);
                        img8.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        img9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                x = event.getRawX();
                y = event.getRawY();
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img9.setX(event.getRawX() - dx);
                        img9.setY(event.getRawY() - (dy+200));
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
    }
}
