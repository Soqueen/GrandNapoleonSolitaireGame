package mcgill.ecse456.grandnapoleonsolitairegame;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Math.abs;


public class DragDrop {
    private static float dx, dy, x , y, initialX, initialY;
    private static Card[] cards;
    private static Stack[] stacks;
    public static TextView stepCounter;
    public static int numSteps = 0;
    private static int statusBar;
    private static float stackHeight;
    private static float stackWidth;
    private static boolean baseStackOrder = false;
    public static void main(Card[] c, Stack[] s, TextView counter, int statusBarHeight) {
        // Assignment for variables used in Drag and Drop
        cards = c;
        stacks = s;
        stepCounter = counter;
        statusBar = statusBarHeight;
        stackHeight = stacks[0].getHeight();    // Set stack height
        stackWidth = stacks[0].getWidth();      // Set stack width
        numSteps = 0;   // Reset numSteps to 0

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
        boolean validStack = canStack(whichStack);   // Check if the stack can be stacked.
        if (validStack) {
            if (card.getCurrentStackID() != whichStack) {
                if (stacks[whichStack].getCurrentCards().size() == 0) {
                    stacks[whichStack].addCardToStack(card);
                    card.getImageView().setX(tempX);
                    card.getImageView().setY(tempY-statusBar);
                    numSteps++;
                    stepCounter.setText(numSteps + " steps");
                    Log.d("", "Setting X as " + tempX + " and Y as " + tempY);
                } else if (card.getSuit() == stacks[whichStack].getLastCard().getSuit() && ((abs(card.getNumber() - stacks[whichStack].getLastCard().getNumber()) == 1) || (abs(card.getNumber() - stacks[whichStack].getLastCard().getNumber()) == 12))) {
                    // First time stacking base cards, set the stacking orders for all bases.
                    if (whichStack >= 20 && whichStack < 24 && !baseStackOrder) {
                        baseStackOrder = true;
                        if (card.getNumber() - stacks[whichStack].getLastCard().getNumber() > 0) {
                            stacks[20].setStackingOrder(2);
                            stacks[21].setStackingOrder(2);
                            stacks[22].setStackingOrder(2);
                            stacks[23].setStackingOrder(2);
                        } else {
                            stacks[20].setStackingOrder(0);
                            stacks[21].setStackingOrder(0);
                            stacks[22].setStackingOrder(0);
                            stacks[23].setStackingOrder(0);
                        }
                    } else if (whichStack >= 20 && whichStack < 24) {
                        int stackOrder = card.getNumber() - stacks[whichStack].getLastCard().getNumber();
                        if ((stackOrder == 1 || stackOrder == -12) && stacks[whichStack].getStackingOrder() == 2) {
                            validStack = true;
                        } else if ((stackOrder == -1 || stackOrder == 12) && stacks[whichStack].getStackingOrder() == 0) {
                            validStack = true;
                        } else {
                            validStack = false;
                        }
                        if (validStack) {
                            stacks[whichStack].addCardToStack(card);
                            card.getImageView().setX(tempX);
                            card.getImageView().setY(tempY-statusBar);
                            numSteps++;
                            stepCounter.setText(numSteps + " steps");
                            Log.d("", "Setting X as " + tempX + " and Y as " + tempY);
                        } else {
                            card.getImageView().setX(stacks[card.getCurrentStackID()].getLeftSideLocation());
                            card.getImageView().setY(stacks[card.getCurrentStackID()].getTopSideLocation()-statusBar);
                        }
                    }
                } else {
                    card.getImageView().setX(stacks[card.getCurrentStackID()].getLeftSideLocation());
                    card.getImageView().setY(stacks[card.getCurrentStackID()].getTopSideLocation()-statusBar);
                }
            } else {
                card.getImageView().setX(stacks[card.getCurrentStackID()].getLeftSideLocation());
                card.getImageView().setY(stacks[card.getCurrentStackID()].getTopSideLocation()-statusBar);
            }
        } else {
            card.getImageView().setX(stacks[card.getCurrentStackID()].getLeftSideLocation());
            card.getImageView().setY(stacks[card.getCurrentStackID()].getTopSideLocation()-statusBar);
            Log.d("", "Cannot stack");
        }
    }

    public static boolean myTouch(View v, MotionEvent e, Card c) {
        if (c.getCanMove()) {
            v.bringToFront();
            x = e.getRawX();
            y = e.getRawY();
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    actionDown(v, e, c);
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionMove(c.getImageView());
                    break;
                case MotionEvent.ACTION_UP:
                    actionUp(c, x, y);
                    break;
                default:
                    return false;
            }
            return true;
        } else {
            return true;
        }
    }

    private static boolean canStack(int whichStack) {
        Log.d("", "" + whichStack);
        // whichStack = -1 means invalid
        if (whichStack < 0) {
            return false;
        } else if (whichStack >= 0 && whichStack < 20) {
            if (whichStack < 4) {   // First column, can stack freely as long it satisfies stacking conditions
                return true;
            } else {    // Otherwise, check for stacks to the left of this one by recursion.
                if (stacks[whichStack - 4].getCurrentCards().size() == 0) {
                    return canStack(whichStack - 4);
                } else {
                    return false;
                }
            }
        } else if (whichStack >= 24 && whichStack < 44) {
            if (whichStack > 39) {  // Last column, can stack freely as long it satisfies stacking conditions
                return true;
            } else {
                if (stacks[whichStack+4].getCurrentCards().size() == 0) {
                    return canStack(whichStack + 4);
                } else {
                    return false;
                }
            }
        } else if (whichStack >= 20 && whichStack < 24) {   // Base cards column, can stack freely as long it satisfies stacking condition
            return true;
        } else if (whichStack == 48) {  // Special case, can only have 1 card in the cellar
            if (stacks[whichStack].getCurrentCards().size() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
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
