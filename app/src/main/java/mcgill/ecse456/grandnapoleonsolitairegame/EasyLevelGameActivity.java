package mcgill.ecse456.grandnapoleonsolitairegame;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.content.Context;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;

/**
 * GNS Android Game Application
 * EasyLevelGameActivity.java
 * Purpose: Contains the logic of the game page features.
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/15/2017
 */
public class EasyLevelGameActivity extends AppCompatActivity {
    String msg;
    private float dx, dy, x , y, initialX, initialY;
    private int stackHeight, stackWidth;
    //    private int[] stackX = new int[2], stackY = new int[2];
    private int[] location = new int[2], locationCard = new int[2], location2 = new int[2];
    Stack[] stacks = new Stack[53];
    ArrayList<Stack> stackslist = new ArrayList<>();
    Card[] cards = new Card[52];
    final Context context = this;
    private Button pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_page);

        final Chronometer timer = (Chronometer) findViewById(R.id.chronometer1); // initiate a chronometer
        timer.start(); // Start the time counter

        // When Pause button trigger
        pauseButton = (Button) findViewById(R.id.pause);
        Pause pause = new Pause(context, pauseButton);
        pause.popUp();

        Log.d("ELGActivity", "onCreate was called");
        // Create 53 stacks
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack(i);
        }

        // Randomly pick a number for base, and fill base with those cards in alternating suit color.
        Random rand = new Random();
        int numb = 0;
        while (numb == 0) {
            numb = rand.nextInt(14);
        }
        Log.d("", "Number generated is " + numb);
        int suit = 1;
        for (int i = 20; i < 24; i++) {
            cards[i] = new Card(suit, numb);
            suit++;
        }
//        Log.d("", "Card 20 = " + cards[20].convertToString());
//        Log.d("", "Card 21 = " + cards[21].convertToString());
//        Log.d("", "Card 22 = " + cards[22].convertToString());
//        Log.d("", "Card 23 = " + cards[23].convertToString());

        // Fill stacks with cards except cellar
        int index = 0;
        int bound = 14;
        if (numb == 13) {
            bound = numb;
        }
        for (suit = 1; suit < 5; suit++) {
            for (int num = 1; num < bound; num++) {
                if (num == numb) {
                    num++;
                }
                if (index == 20) {
                    index = index+4;
                }
                cards[index] = new Card(suit, num);
                index++;
            }
        }

        // Shuffle Cards
        for (int i = 0; i < cards.length; i++) {
            // Skip base cards
            if (i == 20) {
                i = i + 4;
            }
            // Generate random number
            Random r = new Random();
            int randomCard = r.nextInt(cards.length);
            // Skip base cards
            while (randomCard > 19 && randomCard < 24) {
                randomCard = r.nextInt(cards.length);
            }
            Log.d("RandomNumberGenerator: ", "" + randomCard);
            // Swap the two selected cards
            Card tempCard = cards[i];
            cards[i] = cards[randomCard];
            cards[randomCard] = tempCard;
        }

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

//        Log.d("", "Stack 0 " + stacks[0].getLeftSideLocation() + " " + stacks[0].getTopSideLocation());
//        ImageView im = (ImageView) findViewById(R.id.stack0);
//        im.getLocationOnScreen(location);
//        int top = location[1];
//        int left = location[0];
//        top = im.getTop();
//        left = im.getLeft();
//        Log.d("", "Stack directly " + top + " " + left);
//        Stack stack0 = new Stack(0);
//        stackslist.add(stack0);
//
//        stackslist.get(0).setImageView((ImageView) findViewById(R.id.stack0));
//        stackslist.get(0).getImageView().getLocationOnScreen(location);
////        int top = stackslist.get(0).getImageView().getTop();
////        int left = stackslist.get(0).getImageView().getLeft();
//        top = location[1];
//        left = location[0];
//        Log.d("", "Stack from ArrayList " + top + " " + left);
//
//        int[] location = new int[2];
//        stacks[0].getImageView().getLocationOnScreen(location);
//        int x = stacks[0].getImageView().getTop();
//        int y = stacks[0].getImageView().getLeft();
//        stacks[0].setXYCoordinates(x, y);
//        Log.d("", "Stack 0 " + stacks[0].getLeftSideLocation() + " " + stacks[0].getTopSideLocation());
//
//        Log.d("", "Stack 0 " + stacks[0].getLeftSideLocation() + " " + stacks[0].getTopSideLocation());

        cards[0].setImageView((ImageView) findViewById(R.id.card0));
        cards[1].setImageView((ImageView) findViewById(R.id.card1));
        cards[2].setImageView((ImageView) findViewById(R.id.card2));
        cards[3].setImageView((ImageView) findViewById(R.id.card3));
        cards[4].setImageView((ImageView) findViewById(R.id.card4));
        cards[5].setImageView((ImageView) findViewById(R.id.card5));
        cards[6].setImageView((ImageView) findViewById(R.id.card6));
        cards[7].setImageView((ImageView) findViewById(R.id.card7));
        cards[8].setImageView((ImageView) findViewById(R.id.card8));
        cards[9].setImageView((ImageView) findViewById(R.id.card9));
        cards[10].setImageView((ImageView) findViewById(R.id.card10));
        cards[11].setImageView((ImageView) findViewById(R.id.card11));
        cards[12].setImageView((ImageView) findViewById(R.id.card12));
        cards[13].setImageView((ImageView) findViewById(R.id.card13));
        cards[14].setImageView((ImageView) findViewById(R.id.card14));
        cards[15].setImageView((ImageView) findViewById(R.id.card15));
        cards[16].setImageView((ImageView) findViewById(R.id.card16));
        cards[17].setImageView((ImageView) findViewById(R.id.card17));
        cards[18].setImageView((ImageView) findViewById(R.id.card18));
        cards[19].setImageView((ImageView) findViewById(R.id.card19));
        cards[20].setImageView((ImageView) findViewById(R.id.card20));
        cards[21].setImageView((ImageView) findViewById(R.id.card21));
        cards[22].setImageView((ImageView) findViewById(R.id.card22));
        cards[23].setImageView((ImageView) findViewById(R.id.card23));
        cards[24].setImageView((ImageView) findViewById(R.id.card24));
        cards[25].setImageView((ImageView) findViewById(R.id.card25));
        cards[26].setImageView((ImageView) findViewById(R.id.card26));
        cards[27].setImageView((ImageView) findViewById(R.id.card27));
        cards[28].setImageView((ImageView) findViewById(R.id.card28));
        cards[29].setImageView((ImageView) findViewById(R.id.card29));
        cards[30].setImageView((ImageView) findViewById(R.id.card30));
        cards[31].setImageView((ImageView) findViewById(R.id.card31));
        cards[32].setImageView((ImageView) findViewById(R.id.card32));
        cards[33].setImageView((ImageView) findViewById(R.id.card33));
        cards[34].setImageView((ImageView) findViewById(R.id.card34));
        cards[35].setImageView((ImageView) findViewById(R.id.card35));
        cards[36].setImageView((ImageView) findViewById(R.id.card36));
        cards[37].setImageView((ImageView) findViewById(R.id.card37));
        cards[38].setImageView((ImageView) findViewById(R.id.card38));
        cards[39].setImageView((ImageView) findViewById(R.id.card39));
        cards[40].setImageView((ImageView) findViewById(R.id.card40));
        cards[41].setImageView((ImageView) findViewById(R.id.card41));
        cards[42].setImageView((ImageView) findViewById(R.id.card42));
        cards[43].setImageView((ImageView) findViewById(R.id.card43));
        cards[44].setImageView((ImageView) findViewById(R.id.card44));
        cards[45].setImageView((ImageView) findViewById(R.id.card45));
        cards[46].setImageView((ImageView) findViewById(R.id.card46));
        cards[47].setImageView((ImageView) findViewById(R.id.card47));
        cards[48].setImageView((ImageView) findViewById(R.id.card48));
        cards[49].setImageView((ImageView) findViewById(R.id.card49));
        cards[50].setImageView((ImageView) findViewById(R.id.card50));
        cards[51].setImageView((ImageView) findViewById(R.id.card51));
        for (int i = 0; i < cards.length; i++) {
            if (i < 48) {
                stacks[i].addCardToStack(cards[i]);
            }
            else {
                stacks[i+1].addCardToStack(cards[i]);
            }
            Log.d("", "Card number " + i + " has StackID " + cards[i].getCurrentStackID());
        }

        for (int i = 0; i < stacks.length; i++) {
            Log.d("", "Stack number " + i + " has " + stacks[i].getListOfCards());
        }
    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        findLocation((ImageView) findViewById(R.id.card0));
//    }
//    private void actionDown(View v, MotionEvent event, ImageView i) {
//        initialX = i.getX();
//        initialY = i.getY();
//        x = event.getRawX();
//        y = event.getRawY();
//        dx = x - i.getX();
//        dy = y - i.getY();
//    }
//
//    private void actionMove(ImageView i) {
//        i.setX(x-dx);
//        i.setY(y-dy);
//    }
//
//    private void actionUp(Card card) {
//
////        // check if the card is being dragged to stack
////        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
////
////            // check if the card is on the current stack
////            if (card.getCurrentStackID() != stack.getStackID()) {
////                if (card.getCurrentStackID() == 2) {
////                    stack2.removeCardFromStack(card);
////                }
////                if (stack.getLastCard() == null) {
////                    stack.addCardToStack(card);
////                    card.getImageView().setX(stackX[0]);
////                    card.getImageView().setY(stackY[0]);
////                }
////                // check if same suit
////                else if (stack.getLastCard().getSuit() == card.getSuit()) {
////
////                    // check if consecutive
////                    if (stack.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
////                        stack.addCardToStack(card);
////                        card.getImageView().setX(stackX[0]);
////                        card.getImageView().setY(stackY[0]);
////                    }
////                    else if (stack.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
////                        stack.addCardToStack(card);
////                        card.getImageView().setX(stackX[0]);
////                        card.getImageView().setY(stackY[0]);
////                    }
////                    else if (Math.abs(card.getNumber() - stack.getLastCard().getNumber()) == 1) {
////                        stack.addCardToStack(card);
////                        card.getImageView().setX(stackX[0]);
////                        card.getImageView().setY(stackY[0]);
////                    }
////                    else {
////                        Log.d(msg, "Cannot stack cards");
////                        card.getImageView().setX(initialX);
////                        card.getImageView().setY(initialY);
////                    }
////                }
////                else {
////                    Log.d(msg, "Cannot stack cards");
////                    card.getImageView().setX(initialX);
////                    card.getImageView().setY(initialY);
////                }
////            }
////            String a = "The first card of the stack is the " + stack.getFirstCard().convertToString();
////            Log.d(msg, a);
////            Log.d(msg, stack.getListOfCards());
////            Log.d(msg, ""+card.getCurrentStackID());
////        }
////        else if ((x > location2[0]+ 15 && x < location2[0]+stackWidth) && (y > location2[1] && y < location2[1]+stackHeight) && card.getCurrentStackID() != stack2.getStackID() ) {
////            if (card.getCurrentStackID() != stack2.getStackID()) {
////                if (card.getCurrentStackID() == 1) {
////                    stack.removeCardFromStack(card);
////                }
////                if (stack2.getLastCard() == null) {
////                    stack2.addCardToStack(card);
////                    card.getImageView().setX(stackX[1]);
////                    card.getImageView().setY(stackY[1]);
////                }
////                else if (stack2.getLastCard().getSuit() == card.getSuit()) {
////                    if (stack2.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
////                        stack2.addCardToStack(card);
////                        card.getImageView().setX(stackX[1]);
////                        card.getImageView().setY(stackY[1]);
////                    }
////                    else if (stack2.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
////                        stack2.addCardToStack(card);
////                        card.getImageView().setX(stackX[1]);
////                        card.getImageView().setY(stackY[1]);
////                    }
////                    else if (Math.abs(card.getNumber() - stack2.getLastCard().getNumber()) == 1) {
////                        stack2.addCardToStack(card);
////                        card.getImageView().setX(stackX[1]);
////                        card.getImageView().setY(stackY[1]);
////                    }
////                    else {
////                        Log.d(msg, "Cannot stack cards");
////                        card.getImageView().setX(initialX);
////                        card.getImageView().setY(initialY);
////                    }
////                }
////                else {
////                    Log.d(msg, "Cannot stack cards");
////                    card.getImageView().setX(initialX);
////                    card.getImageView().setY(initialY);
////                }
////            }
////
////            String a = "The first card of the stack is the " + stack2.getFirstCard().convertToString();
////            Log.d(msg, a);
////            Log.d(msg, stack2.getListOfCards());
////            Log.d(msg, ""+card.getCurrentStackID());
////        }
////        else {
////            if (card.getCurrentStackID() != 0) {
////                card.getImageView().setX(stackX[card.getCurrentStackID()-1]);
////                card.getImageView().setY(stackY[card.getCurrentStackID()-1]);
////            }
//        }
////    }
//    private void findLocation(ImageView stack) {
//        // Return weird values? Investigate later
//        int top = stack.getTop();
//        int left = stack.getLeft();
//        Log.d("", "Method gets " + top + " " + left);
//
//        //  Return real values
//        stack.getLocationOnScreen(location);
//        top = location[0];
//        left = location[1];
//        Log.d("", "Method gets " + top + " " + left);
//    }
//    private void findStackLocation(ImageView i, ImageView s, ImageView s2) {
//        i.getLocationOnScreen(locationCard);
//        s.getLocationOnScreen(location);
//        s2.getLocationOnScreen(location2);
//        stackHeight = s.getHeight();
//        stackWidth = s.getWidth();
////        stackX[0] = s.getLeft();
////        stackY[0] = s.getTop();
////        stackX[1] = s2.getLeft();
////        stackY[1] = s2.getTop();
//    }
//
//    private boolean myTouch(View v, MotionEvent e, Card c, Stack[] stacks) {
//        v.bringToFront();
//        x = e.getRawX();
//        y = e.getRawY();
//        setStacksLocation(stacks);
//        switch (e.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                actionDown(v, e, c.getImageView());
////                        Log.d(msg, ""+event.getRawX());
////                        Log.d(msg, ""+event.getRawY());
////                        Log.d(msg, ""+card1.getImageView().getX());
////                        Log.d(msg, ""+card1.getImageView().getY());
//                break;
//            case MotionEvent.ACTION_MOVE:
//                actionMove(c.getImageView());
//                break;
//            case MotionEvent.ACTION_UP:
////                        Log.d(msg, "Action Up");
//                actionUp(c);
//                break;
//            default:
//                Log.d(msg, "Default");
//                return false;
//        }
//        return true;
//    }

    // Method works, but need to put it somewhere after onCreate(), or it won't work.
    private void setStacksLocation(Stack[] s) {
        for (int i = 0; i < s.length; i++) {
            s[i].getImageView().getLocationOnScreen(location);
            s[i].setSize(s[i].getImageView().getWidth(), s[i].getImageView().getHeight());
            s[i].setXYCoordinates(location[0], location[1]);
//            Log.d("", "Stack " + i + " is at " + s[i].getLeftSideLocation() + " " + s[i].getTopSideLocation());
//            Log.d("", "Stack " + i + " has height " + s[i].getHeight() + ", and width " + s[i].getWidth());
            DragDrop.main(cards, stacks);
        }
    }

    // Temporary solution to actually finding location of ImageViews.
    @Override
    public void onWindowFocusChanged (boolean hasFocus) {
        setStacksLocation(stacks);
    }


}