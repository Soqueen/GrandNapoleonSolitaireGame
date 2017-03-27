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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d(msg, "Action Down");
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img.setX(x - dx);
                        img.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
//                        Log.d(msg, ""+location[0]);
//                        Log.d(msg, ""+location[1]);
//                        Log.d(msg, ""+stackHeight);
//                        Log.d(msg, ""+stackWidth);
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img.setX(stackX);
                            img.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img2.setX(x - dx);
                        img2.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img2.setX(stackX);
                            img2.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img3.setX(x - dx);
                        img3.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img3.setX(stackX);
                            img3.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img4.setX(x - dx);
                        img4.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img4.setX(stackX);
                            img4.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img5.setX(x - dx);
                        img5.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img5.setX(stackX);
                            img5.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img6.setX(x - dx);
                        img6.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img6.setX(stackX);
                            img6.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img7.setX(x - dx);
                        img7.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img7.setX(stackX);
                            img7.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img8.setX(x - dx);
                        img8.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img8.setX(stackX);
                            img8.setY(stackY);
                        }
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
                int stackHeight, stackWidth, stackX, stackY;
                int[] location = new int[2];
                cardStack.getLocationOnScreen(location);
                stackHeight = cardStack.getHeight();
                stackWidth = cardStack.getWidth();
                stackX = cardStack.getLeft();
                stackY = cardStack.getTop();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        dy = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        img9.setX(x - dx);
                        img9.setY(y - (dy + 180));
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d(msg, "Action Up");
                        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
                            img9.setX(stackX);
                            img9.setY(stackY);
                        }
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