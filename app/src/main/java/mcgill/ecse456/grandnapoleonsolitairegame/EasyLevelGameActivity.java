package mcgill.ecse456.grandnapoleonsolitairegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import static mcgill.ecse456.grandnapoleonsolitairegame.R.drawable.abstract_clubs_1;

/**
 * Created by sokhenglim on 3/15/17.
 */

public class EasyLevelGameActivity extends AppCompatActivity {
    String msg;
    private float dx;
    private float dy;
    private float x;
    private float y;
    private int stackHeight, stackWidth, stackX, stackY;
    private float initialX, initialY;
    private int[] location = new int[2], locationCard = new int[2];
    Card card1, card2, card3, card4, card5, card6, card7, card8, card9;
    Stack stack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game_page);
        Log.d("ELGActivity", "onCreate was called");
        stack = new Stack();
        stack.setImageView((ImageView) findViewById(R.id.stack));
        card1 = new Card(1, 13);
        card2 = new Card(1, 12);
        card3 = new Card(1, 1);
        card4 = new Card(4, 1);
        card5 = new Card(2, 12);
        card6 = new Card(2, 11);
        card7 = new Card(3, 12);
        card8 = new Card(3, 11);
        card9 = new Card(4, 12);
        card1.setImageView((ImageView) findViewById(R.id.imageView1));
        card2.setImageView((ImageView) findViewById(R.id.imageView2));
        card3.setImageView((ImageView) findViewById(R.id.imageView3));
        card4.setImageView((ImageView) findViewById(R.id.imageView4));
        card5.setImageView((ImageView) findViewById(R.id.imageView5));
        card6.setImageView((ImageView) findViewById(R.id.imageView6));
        card7.setImageView((ImageView) findViewById(R.id.imageView7));
        card8.setImageView((ImageView) findViewById(R.id.imageView8));
        card9.setImageView((ImageView) findViewById(R.id.imageView9));
        card1.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card1.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card1.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card1.getImageView().getX());
//                        Log.d(msg, ""+card1.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card1.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card1, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });

        card2.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card2.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card2.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card2.getImageView().getX());
//                        Log.d(msg, ""+card2.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card2.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card2, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });

        card3.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card3.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card3.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card3.getImageView().getX());
//                        Log.d(msg, ""+card3.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card3.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card3, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });

        card4.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card4.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card4.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card4.getImageView().getX());
//                        Log.d(msg, ""+card4.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card4.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card4, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        card5.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card5.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card5.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card5.getImageView().getX());
//                        Log.d(msg, ""+card5.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card5.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card5, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        card6.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card6.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card6.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card6.getImageView().getX());
//                        Log.d(msg, ""+card6.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card6.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card6, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        card7.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card7.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card7.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card7.getImageView().getX());
//                        Log.d(msg, ""+card7.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card7.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card7, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        card8.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card8.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card8.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card8.getImageView().getX());
//                        Log.d(msg, ""+card8.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card8.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card8, stack);
                        break;
                    default:
                        Log.d(msg, "Default");
                        return false;
                }
                return true;
            }
        });
        card9.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.bringToFront();
                x = event.getRawX();
                y = event.getRawY();
                findStackLocation(card9.getImageView(), stack.getImageView());
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        actionDown(v, event, card9.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card9.getImageView().getX());
//                        Log.d(msg, ""+card9.getImageView().getY());
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionMove(card9.getImageView());
                        break;
                    case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                        actionUp(card9, stack);
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
        initialX = i.getX();
        initialY = i.getY();
        x = event.getRawX();
        y = event.getRawY();
        dx = x - i.getX();
        dy = y - i.getY();
    }

    private void actionMove(ImageView i) {
        i.setX(x-dx);
        i.setY(y-dy);
    }

    private void actionUp(Card card, Stack stack) {
        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
            if (stack.getLastCard() == null) {
                stack.addCardToStack(card);
                card.getImageView().setX(stackX);
                card.getImageView().setY(stackY);
            }
            else if (stack.getLastCard().getSuit() == card.getSuit()) {
                if (stack.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
                    stack.addCardToStack(card);
                    card.getImageView().setX(stackX);
                    card.getImageView().setY(stackY);
                }
                else if (stack.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
                    stack.addCardToStack(card);
                    card.getImageView().setX(stackX);
                    card.getImageView().setY(stackY);
                }
                else if (Math.abs(card.getNumber() - stack.getLastCard().getNumber()) == 1) {
                    stack.addCardToStack(card);
                    card.getImageView().setX(stackX);
                    card.getImageView().setY(stackY);
                }
                else {
                    Log.d(msg, "Cannot stack cards");
                    card.getImageView().setX(initialX);
                    card.getImageView().setY(initialY);
                }
            }
            else {
                Log.d(msg, "Cannot stack cards");
                card.getImageView().setX(initialX);
                card.getImageView().setY(initialY);
            }
            String a = "The first card of the stack is the " + stack.getFirstCard().convertToString();
            Log.d(msg, a);
            Log.d(msg, stack.getListOfCards());
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