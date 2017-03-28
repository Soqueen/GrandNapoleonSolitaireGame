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

public class EasyLevelGameActivity extends AppCompatActivity {
    ImageView img, img2, img3, img4, img5, img6, img7, img8, img9, cardStack;
    String msg;
    private float dx;
    private float dy;
    private float x;
    private float y;
    private int stackHeight, stackWidth, stackX, stackY;
    private int[] location = new int[2], locationCard = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game_page);
        Log.d("ELGActivity", "onCreate was called");
        img = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        img6 = (ImageView) findViewById(R.id.imageView6);
        img7 = (ImageView) findViewById(R.id.imageView7);
        img8 = (ImageView) findViewById(R.id.imageView8);
        img9 = (ImageView) findViewById(R.id.imageView9);
        cardStack = (ImageView) findViewById(R.id.stack);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img);
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
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img2, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img2);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img2);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img2);
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
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img3, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img3);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img3);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img3);
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
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img4, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img4);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img4);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img4);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }        });
        img5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img5, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img5);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img5);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img5);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }        });
        img6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img6, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img6);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img6);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img6);
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
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img7, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img7);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img7);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img7);
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
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img8, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img8);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img8);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img8);
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
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(img9, cardStack);
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, img9);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(img9);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        actionUp(img9);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
    }

    private void actionDown(View v, MotionEvent event, ImageView i) {
        x = event.getRawX();
        y = event.getRawY();
        dx = x - i.getX();
        dy = y - i.getY();
    }

    private void actionMove(ImageView i) {
        i.setX(x-dx);
        i.setY(y-dy);
    }

    private void actionUp(ImageView i) {
        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
            i.setX(stackX);
            i.setY(stackY);
        }
    }

    private void findStackLocation(ImageView i, ImageView c) {
        i.getLocationOnScreen(locationCard);
        c.getLocationOnScreen(location);
        stackHeight = c.getHeight();
        stackWidth = c.getWidth();
        stackX = c.getLeft();
        stackY = c.getTop();
    }
}