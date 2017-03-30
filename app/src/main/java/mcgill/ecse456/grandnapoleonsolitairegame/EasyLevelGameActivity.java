package mcgill.ecse456.grandnapoleonsolitairegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

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
    Stack[] stacks = new Stack[53];
    Card[] cards = new Card[52];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_game_page);
        Log.d("ELGActivity", "onCreate was called");

        // Create 53 stacks
        for (int index=0; index<stacks.length; index++){
            stacks[index] = new Stack(index);
        }
        // create 52 cards
        int index =0;
        for (int suit = 1; suit < 5; suit++) {
            for (int num = 1; num < 14; num++) {
                cards[index] = new Card(suit, num);
                index ++;
            }
        }
        // Shuffle Cards
        for (int i=0; i<cards.length; i++){
            // Generate random number
            Random r = new Random();
            int randomCard = r.nextInt(cards.length);
            Log.d("RandomNumberGenerator: ", ""+randomCard);
            // Swap the cards
            Card tempCard = cards[i];
            cards[i] = cards[randomCard];
            cards[randomCard] = tempCard;
        }

        // Set stacks to stacks views
        stacks[0].setImageView((ImageView) findViewById(R.id.stack0));
        stacks[1].setImageView((ImageView) findViewById(R.id.stack1));
        stacks[2].setImageView((ImageView) findViewById(R.id.stack2));
        stacks[3].setImageView((ImageView) findViewById(R.id.stack3));
        stacks[4].setImageView((ImageView) findViewById(R.id.stack4));
        stacks[5].setImageView((ImageView) findViewById(R.id.stack5));
        stacks[6].setImageView((ImageView) findViewById(R.id.stack6));
        stacks[7].setImageView((ImageView) findViewById(R.id.stack7));
        stacks[8].setImageView((ImageView) findViewById(R.id.stack8));
        stacks[9].setImageView((ImageView) findViewById(R.id.stack9));
        stacks[10].setImageView((ImageView) findViewById(R.id.stack10));
        stacks[11].setImageView((ImageView) findViewById(R.id.stack11));
        stacks[12].setImageView((ImageView) findViewById(R.id.stack12));
        stacks[13].setImageView((ImageView) findViewById(R.id.stack13));
        stacks[14].setImageView((ImageView) findViewById(R.id.stack14));
        stacks[15].setImageView((ImageView) findViewById(R.id.stack15));
        stacks[16].setImageView((ImageView) findViewById(R.id.stack16));
        stacks[17].setImageView((ImageView) findViewById(R.id.stack17));
        stacks[18].setImageView((ImageView) findViewById(R.id.stack18));
        stacks[19].setImageView((ImageView) findViewById(R.id.stack19));
        stacks[20].setImageView((ImageView) findViewById(R.id.stack20));
        stacks[21].setImageView((ImageView) findViewById(R.id.stack21));
        stacks[22].setImageView((ImageView) findViewById(R.id.stack22));
        stacks[23].setImageView((ImageView) findViewById(R.id.stack23));
        stacks[24].setImageView((ImageView) findViewById(R.id.stack24));
        stacks[25].setImageView((ImageView) findViewById(R.id.stack25));
        stacks[26].setImageView((ImageView) findViewById(R.id.stack26));
        stacks[27].setImageView((ImageView) findViewById(R.id.stack27));
        stacks[28].setImageView((ImageView) findViewById(R.id.stack28));
        stacks[29].setImageView((ImageView) findViewById(R.id.stack29));
        stacks[30].setImageView((ImageView) findViewById(R.id.stack30));
        stacks[31].setImageView((ImageView) findViewById(R.id.stack31));
        stacks[32].setImageView((ImageView) findViewById(R.id.stack32));
        stacks[33].setImageView((ImageView) findViewById(R.id.stack33));
        stacks[34].setImageView((ImageView) findViewById(R.id.stack34));
        stacks[35].setImageView((ImageView) findViewById(R.id.stack35));
        stacks[36].setImageView((ImageView) findViewById(R.id.stack36));
        stacks[37].setImageView((ImageView) findViewById(R.id.stack37));
        stacks[38].setImageView((ImageView) findViewById(R.id.stack38));
        stacks[39].setImageView((ImageView) findViewById(R.id.stack39));
        stacks[40].setImageView((ImageView) findViewById(R.id.stack40));
        stacks[41].setImageView((ImageView) findViewById(R.id.stack41));
        stacks[42].setImageView((ImageView) findViewById(R.id.stack42));
        stacks[43].setImageView((ImageView) findViewById(R.id.stack43));
        stacks[44].setImageView((ImageView) findViewById(R.id.stack44));
        stacks[45].setImageView((ImageView) findViewById(R.id.stack45));
        stacks[46].setImageView((ImageView) findViewById(R.id.stack46));
        stacks[47].setImageView((ImageView) findViewById(R.id.stack47));
        stacks[48].setImageView((ImageView) findViewById(R.id.stack48));
        stacks[49].setImageView((ImageView) findViewById(R.id.stack49));
        stacks[50].setImageView((ImageView) findViewById(R.id.stack50));
        stacks[51].setImageView((ImageView) findViewById(R.id.stack51));
        // Cella place at stack52
        stacks[52].setImageView((ImageView) findViewById(R.id.stack52));


        // Add display cards to stacks
        // TODO- Should we add display card to stack?
        //stacks[0].addCardToStack(cards[0]);


        // Display cards  over the stacks
        cards[0].setImageView((ImageView) findViewById(R.id.stack0));
        cards[1].setImageView((ImageView) findViewById(R.id.stack1));
        cards[2].setImageView((ImageView) findViewById(R.id.stack2));
        cards[3].setImageView((ImageView) findViewById(R.id.stack3));
        cards[4].setImageView((ImageView) findViewById(R.id.stack4));
        cards[5].setImageView((ImageView) findViewById(R.id.stack5));
        cards[6].setImageView((ImageView) findViewById(R.id.stack6));
        cards[7].setImageView((ImageView) findViewById(R.id.stack7));
        cards[8].setImageView((ImageView) findViewById(R.id.stack8));
        cards[9].setImageView((ImageView) findViewById(R.id.stack9));
        cards[10].setImageView((ImageView) findViewById(R.id.stack10));
        cards[11].setImageView((ImageView) findViewById(R.id.stack11));
        cards[12].setImageView((ImageView) findViewById(R.id.stack12));
        cards[13].setImageView((ImageView) findViewById(R.id.stack13));
        cards[14].setImageView((ImageView) findViewById(R.id.stack14));
        cards[15].setImageView((ImageView) findViewById(R.id.stack15));
        cards[16].setImageView((ImageView) findViewById(R.id.stack16));
        cards[17].setImageView((ImageView) findViewById(R.id.stack17));
        cards[18].setImageView((ImageView) findViewById(R.id.stack18));
        cards[19].setImageView((ImageView) findViewById(R.id.stack19));
        cards[20].setImageView((ImageView) findViewById(R.id.stack20));
        cards[21].setImageView((ImageView) findViewById(R.id.stack21));
        cards[22].setImageView((ImageView) findViewById(R.id.stack22));
        cards[23].setImageView((ImageView) findViewById(R.id.stack23));
        cards[24].setImageView((ImageView) findViewById(R.id.stack24));
        cards[25].setImageView((ImageView) findViewById(R.id.stack25));
        cards[26].setImageView((ImageView) findViewById(R.id.stack26));
        cards[27].setImageView((ImageView) findViewById(R.id.stack27));
        cards[28].setImageView((ImageView) findViewById(R.id.stack28));
        cards[29].setImageView((ImageView) findViewById(R.id.stack29));
        cards[30].setImageView((ImageView) findViewById(R.id.stack30));
        cards[31].setImageView((ImageView) findViewById(R.id.stack31));
        cards[32].setImageView((ImageView) findViewById(R.id.stack32));
        cards[33].setImageView((ImageView) findViewById(R.id.stack33));
        cards[34].setImageView((ImageView) findViewById(R.id.stack34));
        cards[35].setImageView((ImageView) findViewById(R.id.stack35));
        cards[36].setImageView((ImageView) findViewById(R.id.stack36));
        cards[37].setImageView((ImageView) findViewById(R.id.stack37));
        cards[38].setImageView((ImageView) findViewById(R.id.stack38));
        cards[39].setImageView((ImageView) findViewById(R.id.stack39));
        cards[40].setImageView((ImageView) findViewById(R.id.stack40));
        cards[41].setImageView((ImageView) findViewById(R.id.stack41));
        cards[42].setImageView((ImageView) findViewById(R.id.stack42));
        cards[43].setImageView((ImageView) findViewById(R.id.stack43));
        cards[44].setImageView((ImageView) findViewById(R.id.stack44));
        cards[45].setImageView((ImageView) findViewById(R.id.stack45));
        cards[46].setImageView((ImageView) findViewById(R.id.stack46));
        cards[47].setImageView((ImageView) findViewById(R.id.stack47));
        cards[48].setImageView((ImageView) findViewById(R.id.stack48));
        cards[49].setImageView((ImageView) findViewById(R.id.stack49));
        cards[50].setImageView((ImageView) findViewById(R.id.stack50));
        cards[51].setImageView((ImageView) findViewById(R.id.stack51));


        // Detect touch motion
        // TODO - MORE FOR THE 50 MORE CARDS
        cards[0].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[0], stacks[0], stacks[1]);
            }
        });

        cards[1].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[1], stacks[0], stacks[1]);
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