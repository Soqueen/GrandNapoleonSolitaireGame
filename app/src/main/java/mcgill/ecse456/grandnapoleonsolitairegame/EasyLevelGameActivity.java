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
    private float dx, dy, x , y, initialX, initialY;
    private int stackHeight, stackWidth;
    private int[] stackX = new int[2], stackY = new int[2];
    private int[] location = new int[2], locationCard = new int[2], location2 = new int[2];
    Card card1, card2, card3, card4, card5, card6, card7, card8, card9;
    Stack stack, stack2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game_page);
        Log.d("ELGActivity", "onCreate was called");
        stack = new Stack(1);
        stack2 = new Stack(2);
        stack.setImageView((ImageView) findViewById(R.id.stack));
        stack2.setImageView((ImageView) findViewById(R.id.stack2));
        card1 = new Card(1, 13);
        card2 = new Card(1, 12);
        card3 = new Card(1, 1);
        card4 = new Card(1, 2);
        card5 = new Card(1, 3);
        card6 = new Card(1, 4);
        card7 = new Card(2, 5);
        card8 = new Card(3, 5);
        card9 = new Card(4, 5);
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
                return myTouch(v, event, card1, stack, stack2);
            }
        });

        card2.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card2, stack, stack2);
            }
        });

        card3.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card3, stack, stack2);
            }
        });

        card4.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card4, stack, stack2);
            }
        });
        card5.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card5, stack, stack2);
            }
        });
        card6.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card6, stack, stack2);
            }
        });
        card7.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card7, stack, stack2);
            }
        });
        card8.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card8, stack, stack2);
            }
        });
        card9.getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, card9, stack, stack2);
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

    private void actionUp(Card card, Stack stack, Stack stack2) {
        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
            if (card.getCurrentStackID() != stack.getStackID()) {
                if (stack.getLastCard() == null) {
                    stack.addCardToStack(card);
                    card.getImageView().setX(stackX[0]);
                    card.getImageView().setY(stackY[0]);
                }
                else if (stack.getLastCard().getSuit() == card.getSuit()) {
                    if (stack.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
                        stack.addCardToStack(card);
                        card.getImageView().setX(stackX[0]);
                        card.getImageView().setY(stackY[0]);
                    }
                    else if (stack.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
                        stack.addCardToStack(card);
                        card.getImageView().setX(stackX[0]);
                        card.getImageView().setY(stackY[0]);
                    }
                    else if (Math.abs(card.getNumber() - stack.getLastCard().getNumber()) == 1) {
                        stack.addCardToStack(card);
                        card.getImageView().setX(stackX[0]);
                        card.getImageView().setY(stackY[0]);
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
            }

            String a = "The first card of the stack is the " + stack.getFirstCard().convertToString();
            Log.d(msg, a);
            Log.d(msg, stack.getListOfCards());
            Log.d(msg, ""+card.getCurrentStackID());
        }
        else if ((x > location2[0]+ 15 && x < location2[0]+stackWidth) && (y > location2[1] && y < location2[1]+stackHeight) && card.getCurrentStackID() != stack2.getStackID() ) {
            if (stack2.getLastCard() == null) {
                stack2.addCardToStack(card);
                card.getImageView().setX(stackX[1]);
                card.getImageView().setY(stackY[1]);
            }
            else if (stack2.getLastCard().getSuit() == card.getSuit()) {
                if (stack2.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
                    stack2.addCardToStack(card);
                    card.getImageView().setX(stackX[1]);
                    card.getImageView().setY(stackY[1]);
                }
                else if (stack2.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
                    stack2.addCardToStack(card);
                    card.getImageView().setX(stackX[1]);
                    card.getImageView().setY(stackY[1]);
                }
                else if (Math.abs(card.getNumber() - stack2.getLastCard().getNumber()) == 1) {
                    stack2.addCardToStack(card);
                    card.getImageView().setX(stackX[1]);
                    card.getImageView().setY(stackY[1]);
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
            String a = "The first card of the stack is the " + stack2.getFirstCard().convertToString();
            Log.d(msg, a);
            Log.d(msg, stack2.getListOfCards());
            Log.d(msg, ""+card.getCurrentStackID());
        }
        else {
            if (card.getCurrentStackID() != 0) {
                card.getImageView().setX(stackX[card.getCurrentStackID()-1]);
                card.getImageView().setY(stackY[card.getCurrentStackID()-1]);
            }
        }
    }

    private void findStackLocation(ImageView i, ImageView s, ImageView s2) {
        i.getLocationOnScreen(locationCard);
        s.getLocationOnScreen(location);
        s2.getLocationOnScreen(location2);
        stackHeight = s.getHeight();
        stackWidth = s.getWidth();
        stackX[0] = s.getLeft();
        stackY[0] = s.getTop();
        stackX[1] = s2.getLeft();
        stackY[1] = s2.getTop();
    }

    private boolean myTouch(View v, MotionEvent e, Card c, Stack s1, Stack s2) {
        v.bringToFront();
        x = e.getRawX();
        y = e.getRawY();
        findStackLocation(c.getImageView(), s1.getImageView(), s2.getImageView());
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                actionDown(v, e, c.getImageView());
//                        Log.d(msg, ""+event.getRawX());
//                        Log.d(msg, ""+event.getRawY());
//                        Log.d(msg, ""+card1.getImageView().getX());
//                        Log.d(msg, ""+card1.getImageView().getY());
                break;
            case MotionEvent.ACTION_MOVE:
                actionMove(c.getImageView());
                break;
            case MotionEvent.ACTION_UP:
//                        Log.d(msg, "Action Up");
                actionUp(c, s1, s2);
                break;
            default:
                Log.d(msg, "Default");
                return false;
        }
        return true;
    }
}