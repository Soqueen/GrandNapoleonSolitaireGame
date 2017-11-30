package mcgill.ecse456.grandnapoleonsolitairegame;

import android.app.AlertDialog;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Math.abs;


public class DragDrop {
    private static float dx, dy, x , y, initialX, initialY;
    private static Card[] cards;
    private static Stack[] stacks;
    public static TextView stepCounter;
    public static int numSteps = 0;
    private static float stackHeight;
    private static float stackWidth;
    private static boolean baseStackOrder = false;
    private static Button undoButton;

    // Variables for Undo
    public static float previousX, previousY;
    public static Card previousCard;
    public static int previousStack;
    public static boolean previousCanMove;

    public static void main(Card[] c, Stack[] s, TextView counter, Button undo) {
        // Assignment for variables used in Drag and Drop
        cards = c;
        stacks = s;
        stepCounter = counter;
        stackHeight = stacks[0].getHeight();    // Set stack height
        stackWidth = stacks[0].getWidth();      // Set stack width
        numSteps = 0;   // Reset numSteps to 0
        baseStackOrder = false;
        undoButton = undo;
        setUpUndo();
        // Empty string for debug
        String d = "";

        // Enable touch for cards
        enableTouch();

        for (int i = 0; i < s.length; i++) {
            s[i].setStackingOrder(1);
        }
    }

    private static void actionDown(View v, MotionEvent event, Card c) {
        ImageView i = c.getImageView();
        initialX = i.getX();
        initialY = i.getY();
        x = event.getRawX();
        y = event.getRawY();
        dx = x - i.getX();
        dy = y - i.getY();
        stacks[c.getCurrentStackID()].removeCardFromStack(c);
    }

    private static void actionMove(ImageView i) {
        i.setX(x-dx);
        i.setY(y-dy);
    }

    private static void actionUp(Card card, float x, float y) {
        ImageView cardImage = card.getImageView();
        int cardID = card.getCurrentStackID();
        float xSpaceStack = Math.abs(stacks[0].getLeftSideLocation() + stacks[0].getWidth() - stacks[4].getLeftSideLocation());
        float ySpaceStack = Math.abs(stacks[0].getTopSideLocation() + stacks[0].getHeight() - stacks[1].getTopSideLocation());
        int whichStack = -1;
        float tempX = 0;    // Variable for stack left side location
        float tempY = 0;    // Variable for stack top side location

        // Check which stack is the card being dropped at
        for (int i = 0; i < stacks.length; i++) {
            tempX = stacks[i].getLeftSideLocation();
            tempY = stacks[i].getTopSideLocation();
            if (x > tempX && x < tempX + stackWidth) {
                if (y > tempY && y < tempY + stackHeight) {
                    whichStack = i;
                    break;
                }
            }
        }

        //Log.d("", "tempX " + tempX + " tempY " + tempY + " whichStack " + whichStack);
        boolean validStack = canStack(whichStack, card.getCurrentStackID());   // Check if the stack can be stacked.
        float xToSet = 0;
        float yToSet = 0;
        // Check if target stack is valid for putting cards on
        if (validStack) {
            if (whichStack == 48 && stacks[whichStack].getCurrentCards().size() == 0) {
                previousCard = card;
                previousX = card.getXPosition();
                previousY = card.getYPosition();
                previousStack = card.getCurrentStackID();
                previousCanMove = card.getCanMove();
                stacks[whichStack].addCardToStack(card);
                xToSet = stacks[whichStack].getLeftSideLocation();
                yToSet = stacks[whichStack].getTopSideLocation();
                cardImage.setX(xToSet);
                cardImage.setY(yToSet);
                card.setXYPositions(xToSet, yToSet);
                numSteps++;
                stepCounter.setText(numSteps + " steps");
                cardMoveCheck(previousStack);
                card.setCanMove(false);
            } else if (((whichStack >= 16 && whichStack < 20) || (whichStack >= 24 && whichStack < 28)) && stacks[whichStack].getCurrentCards().size() == 0) {
                Log.d("", "Is it here?");
                previousCard = card;
                previousX = card.getXPosition();
                previousY = card.getYPosition();
                previousStack = card.getCurrentStackID();
                previousCanMove = card.getCanMove();
                stacks[whichStack].addCardToStack(card);
                xToSet = stacks[whichStack].getLeftSideLocation();
                yToSet = stacks[whichStack].getTopSideLocation();
                cardImage.setX(xToSet);
                cardImage.setY(yToSet);
                card.setXYPositions(xToSet, yToSet);
                numSteps++;
                stepCounter.setText(numSteps + " steps");
                cardMoveCheck(previousStack);
            } else {
                Card stackCard = stacks[whichStack].getLastCard();
                Log.d("", "Stack is valid");
                if (compareCards(stackCard, card)) {
                    Log.d("", "Two cards can be stacked");
                    previousCard = card;
                    previousX = card.getXPosition();
                    previousY = card.getYPosition();
                    previousStack = card.getCurrentStackID();
                    previousCanMove = card.getCanMove();
                    if (stacks[whichStack].getCurrentCards().size() == 0) {
                        xToSet = stacks[whichStack].getLeftSideLocation();
                        yToSet = stacks[whichStack].getTopSideLocation();
                    } else {
                        if (whichStack < 20) {
                            xToSet = stacks[whichStack].getLeftSideLocation() - xSpaceStack;
                            yToSet = stacks[whichStack].getTopSideLocation();
                        } else if (whichStack < 24) {
                            int difference = stackCard.getNumber() - card.getNumber();
                            if (!baseStackOrder) {
                                if (difference == -12 || difference == 1) {
                                    stacks[20].setStackingOrder(0);
                                    stacks[21].setStackingOrder(0);
                                    stacks[22].setStackingOrder(0);
                                    stacks[23].setStackingOrder(0);
                                } else if (difference == 12 || difference == -1) {
                                    stacks[20].setStackingOrder(2);
                                    stacks[21].setStackingOrder(2);
                                    stacks[22].setStackingOrder(2);
                                    stacks[23].setStackingOrder(2);
                                }
                                baseStackOrder = true;
                            }
                            if ((difference == -12) || (difference == 1) && stacks[whichStack].getStackingOrder() == 0) {
                                xToSet = stacks[whichStack].getLeftSideLocation();
                                yToSet = stacks[whichStack].getTopSideLocation() + ySpaceStack;
                            } else if ((difference == 12) || (difference == -1) && stacks[whichStack].getStackingOrder() == 2) {
                                xToSet = stacks[whichStack].getLeftSideLocation();
                                yToSet = stacks[whichStack].getTopSideLocation() + ySpaceStack;
                            } else {
                                xToSet = card.getXPosition();
                                yToSet = card.getYPosition();
                            }
                        } else if (whichStack < 44) {
                            xToSet = stacks[whichStack].getLeftSideLocation() + xSpaceStack;
                            yToSet = stacks[whichStack].getTopSideLocation();
                        }
                    }
                    stacks[whichStack].addCardToStack(card);
                    cardImage.setX(xToSet);
                    cardImage.setY(yToSet);
                    Log.d("", "X and Y are set to " + xToSet + " " + yToSet);
                    card.setXYPositions(xToSet, yToSet);
                    Log.d("", "Card position is " + card.getXPosition() + " " + card.getYPosition());
                    Log.d("", "Previous position " + previousX + " " + previousY);
                    numSteps++;
                    stepCounter.setText(numSteps + " steps");
                    cardMoveCheck(previousStack);
                } else {
                    stacks[card.getCurrentStackID()].addCardToStack(card);
                    cardImage.setX(card.getXPosition());
                    cardImage.setY(card.getYPosition());
                }
            }
        } else {
            xToSet = card.getXPosition();
            yToSet = card.getYPosition();
            stacks[cardID].addCardToStack(card);
            cardImage.setX(xToSet);
            cardImage.setY(yToSet);
        }
        if (winConditionCheck()) {
            // Popup message
            Log.d("","Done");
        } else {
            int cardMissing = 0;
            for (int i = 20; i < 24; i++) {
                cardMissing += stacks[i].getCurrentCards().size();
            }
            Log.d("", "Missing " + Math.abs(cardMissing - 52));
        }
//        for (int i = 0; i < stacks.length; i++) {
//            Log.d("", "Stack " + i + " has " + stacks[i].getListOfCards());
//        }
//        Log.d("", "Target stack " + whichStack + " has " + stacks[whichStack].getListOfCards());
//        Log.d("", "Last stack " + previousStack + " has " + stacks[previousStack].getListOfCards());
//        Log.d("", "Current stack " + card.getCurrentStackID() + " has " + stacks[card.getCurrentStackID()].getListOfCards());
    }

    public static boolean myTouch(View v, MotionEvent e, Card c) {
        v.bringToFront();
        x = e.getRawX();
        y = e.getRawY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (c.getCanMove()) {
                    actionDown(v, e, c);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (c.getCanMove()) {
                    actionMove(c.getImageView());
                }
                break;
            case MotionEvent.ACTION_UP:
                if (c.getCanMove()) {
                    actionUp(c, x, y);
                }
                break;
            default:
                return false;
        }
        return true;
    }

    private static boolean canStack(int whichStack, int stackID) {
        Log.d("", "" + whichStack);
        if (whichStack == stackID) {
            return false;
        }
        // whichStack = -1 means invalid
        if (whichStack < 0) {
//            Log.d("", "Invalid stack" );
            return false;
        }
        boolean haveCards;
        if (stacks[whichStack].getCurrentCards().size() == 0) {
            haveCards = false;
        } else {
            haveCards = true;
        }
        if (whichStack < 4) {
//            Log.d("", "Stack < 4" );
            if (haveCards) {
//                Log.d("", "Stack < 4, have cards" );
                return true;
            } else {
//                Log.d("", "Stack < 4, no cards" );
                return false;
            }
        } else if (whichStack < 16) {
//            Log.d("", "Stack < 16" );
            if (haveCards) {
//                Log.d("", "Stack < 16, have cards" );
                for (int i = 1; i <= whichStack / 4; i++) {
                    if (stacks[(whichStack - 4 * i)].getCurrentCards().size() != 0) {
//                        Log.d("", "Stack < 16, stacks to left have cards" );
                        return false;
                    }
                }
//                Log.d("", "Stack < 16, stacks to left no cards" );
                return true;
            } else {
//                Log.d("", "Stack < 16, no cards" );
                return false;
            }
        } else if (whichStack < 20) {
//            Log.d("", "Stack < 20");
            for (int i = 1; i <= whichStack / 4; i++) {
                if (stacks[(whichStack - 4 * i)].getCurrentCards().size() != 0) {
//                    Log.d("", "Stack < 20, stacks to left have cards" );
                    return false;
                }
            }
//            Log.d("", "Stack < 20, stacks to left no cards" );
            return true;
        } else if (whichStack < 24) {
            return true;
        } else if (whichStack < 28) {
            for (int i = 1; i <= whichStack / 4; i++) {
                if (stacks[(whichStack + 4 * i)].getCurrentCards().size() != 0) {
//                    Log.d("", "Stack < 28, stacks to right have cards" );
                    return false;
                }
            }
//            Log.d("", "Stack < 28, stacks to right no cards" );
            return true;
        } else if (whichStack < 40) {
//            Log.d("", "Stack < 40" );
            if (haveCards) {
//                Log.d("", "Stack < 40, have cards" );
                for (int i = 1; i <= whichStack / 4; i++) {
                    if (whichStack + 4 * i < 44) {
                        if (stacks[(whichStack + 4 * i)].getCurrentCards().size() != 0) {
                            Log.d("", "Stack < 40, stacks to right have cards" );
                            return false;
                        }
                    }
                }
                Log.d("", "Stack < 40, stacks to right no cards" );
                return true;
            } else {
//                Log.d("", "Stack < 40, no cards" );
                return false;
            }
        } else if (whichStack < 44) {
//            Log.d("", "Stack < 44" );
            if (haveCards) {
//                Log.d("", "Stack < 44, have cards" );
                return true;
            } else {
//                Log.d("", "Stack < 44, No cards" );
                return false;
            }
        } else {
            if (whichStack == 48) {
                if (haveCards) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
    }

    private static void cardMoveCheck(int stackID) {
        if (stackID < 16) {
            for (int i = 0; i < stacks[stackID + 4].getCurrentCards().size(); i++) {
                stacks[stackID + 4].getCurrentCards().get(i).setCanMove(true);
            }
        } else if (stackID >= 24 && stackID < 44) {
            for (int i = 0; i < stacks[stackID - 4].getCurrentCards().size(); i++) {
                stacks[stackID - 4].getCurrentCards().get(i).setCanMove(true);
            }
        } else if (stackID >= 44 && stackID < 48 ) {
            for (int i = 0; i < stacks[stackID + 1].getCurrentCards().size(); i++) {
                stacks[stackID + 1].getCurrentCards().get(i).setCanMove(true);
            }
        } else if (stackID > 48) {
            for (int i = 0; i < stacks[stackID - 1].getCurrentCards().size(); i++) {
                stacks[stackID - 1].getCurrentCards().get(i).setCanMove(true);
            }
        }
    }

    private static boolean winConditionCheck() {
        for (int i = 20; i < 24; i++) {
            if (stacks[i].getCurrentCards().size() != 13) {
                return false;
            }
        }
        return true;
    }
    private static boolean compareCards(Card c1, Card c2) {
        if (c1.getSuit() == c2.getSuit()) {
            if ((Math.abs(c1.getNumber() - c2.getNumber()) == 1) || (Math.abs(c1.getNumber() - c2.getNumber()) == 12)) {
                return true;
            }
        }
        return false;
    }

    private static void setUpUndo() {
        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (previousCard != null) {
                    if (previousCard.getXPosition() != previousX && previousCard.getYPosition() != previousY && previousCard.getCurrentStackID() != previousStack) {
                        Log.d("", "Undo-ing");
                        stacks[previousCard.getCurrentStackID()].removeCardFromStack(previousCard);
                        stacks[previousStack].addCardToStack(previousCard);
                        previousCard.setXYPositions(previousX, previousY);
                        previousCard.getImageView().setX(previousX);
                        previousCard.getImageView().setY(previousY);
                        previousCard.setCanMove(previousCanMove);
                        numSteps--;
                        stepCounter.setText(numSteps + " steps");
                        previousCard = null;
                    }
                } else {
                    Log.d("", "Cannot undo");
                }
            }
        });
    }
    /**
     * Set up touch for all cards
     * @parem none
     * @return none
     */
    private static void enableTouch() {
        // TODO: Only let outside cards move. All cards can be moved right now.
        cards[0].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[0]);
            }
        });
        cards[1].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[1]);
            }
        });
        cards[2].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[2]);
            }
        });
        cards[3].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[3]);
            }
        });
        cards[4].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[4]);
            }
        });
        cards[5].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[5]);
            }
        });
        cards[6].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[6]);
            }
        });
        cards[7].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[7]);
            }
        });
        cards[8].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[8]);
            }
        });
        cards[9].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[9]);
            }
        });
        cards[10].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[10]);
            }
        });
        cards[11].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[11]);
            }
        });
        cards[12].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[12]);
            }
        });
        cards[13].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[13]);
            }
        });
        cards[14].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[14]);
            }
        });
        cards[15].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[15]);
            }
        });
        cards[16].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[16]);
            }
        });
        cards[17].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[17]);
            }
        });
        cards[18].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[18]);
            }
        });
        cards[19].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[19]);
            }
        });
// These cards are the base. Not supposed to be moved.
//        cards[20].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[20]);
//            }
//        });
//        cards[21].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[21]);
//            }
//        });
//
//        cards[22].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[22]);
//            }
//        });
//
//        cards[23].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[23]);
//            }
//        });
        cards[24].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[24]);
            }
        });
        cards[25].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[25]);
            }
        });
        cards[26].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[26]);
            }
        });
        cards[27].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[27]);
            }
        });
        cards[28].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[28]);
            }
        });
        cards[29].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[29]);
            }
        });
        cards[30].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[30]);
            }
        });
        cards[31].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[31]);
            }
        });
        cards[32].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[32]);
            }
        });
        cards[33].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[33]);
            }
        });
        cards[34].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[34]);
            }
        });
        cards[35].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[35]);
            }
        });
        cards[36].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[36]);
            }
        });
        cards[37].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[37]);
            }
        });
        cards[38].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[38]);
            }
        });
        cards[39].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[39]);
            }
        });
        cards[40].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[40]);
            }
        });
        cards[41].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[41]);
            }
        });
        cards[42].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[42]);
            }
        });
        cards[43].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[43]);
            }
        });
        cards[44].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[44]);
            }
        });
        cards[45].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[45]);
            }
        });
        cards[46].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[46]);
            }
        });
        cards[47].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[47]);
            }
        });
        cards[48].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[48]);
            }
        });
        cards[49].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[49]);
            }
        });
        cards[50].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[50]);
            }
        });
        cards[51].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[51]);
            }
        });
        View.OnClickListener hintButton = new View.OnClickListener() {
            public void onClick(View v) {
                cards[0].getImageView().setColorFilter(Color.argb(50, 0, 0, 0));
            }
        };
    }
}
