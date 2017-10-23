package mcgill.ecse456.grandnapoleonsolitairegame;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import static java.lang.Math.abs;


public class DragDrop {
    public static float dx, dy, x , y, initialX, initialY;
    public static float[] rowXCoordinates = new float[11];
    public static float[] columnYCoordinates = new float[5];
    public static Card[] cards;
    public static Stack[] stacks;
    public static void main(Card[] c, Stack[] s) {
        cards = c;
        stacks = s;
        String d = "";
        for (int i = 0; i < rowXCoordinates.length; i++) {
            rowXCoordinates[i] = stacks[(i*4)].getLeftSideLocation();
//            d = d + rowXCoordinates[i] + ", ";
        }
        for (int i = 0; i < columnYCoordinates.length; i++) {
            columnYCoordinates[i] = stacks[(i+40)].getTopSideLocation();
            d = d + columnYCoordinates[i] + ", ";
        }
        Log.d("", d);
        // TODO: Only let outside cards move. All cards can be moved right now.
        cards[0].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[0], stacks);
            }
        });
        cards[1].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[1], stacks);
            }
        });
        cards[2].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[2], stacks);
            }
        });
        cards[3].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[3], stacks);
            }
        });
        cards[4].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[4], stacks);
            }
        });
        cards[5].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[5], stacks);
            }
        });
        cards[6].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[6], stacks);
            }
        });
        cards[7].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[7], stacks);
            }
        });
        cards[8].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[8], stacks);
            }
        });
        cards[9].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[9], stacks);
            }
        });
        cards[10].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[10], stacks);
            }
        });
        cards[11].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[11], stacks);
            }
        });
        cards[12].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[12], stacks);
            }
        });
        cards[13].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[13], stacks);
            }
        });
        cards[14].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[14], stacks);
            }
        });
        cards[15].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[15], stacks);
            }
        });
        cards[16].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[16], stacks);
            }
        });
        cards[17].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[17], stacks);
            }
        });
        cards[18].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[18], stacks);
            }
        });
        cards[19].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[19], stacks);
            }
        });
// These cards are the base. Not supposed to be moved.
//        cards[20].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[20], stacks);
//            }
//        });
//        cards[21].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[21], stacks);
//            }
//        });
//
//        cards[22].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[22], stacks);
//            }
//        });
//
//        cards[23].getImageView().setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return myTouch(v, event, cards[23], stacks);
//            }
//        });
        cards[24].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[24], stacks);
            }
        });
        cards[25].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[25], stacks);
            }
        });
        cards[26].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[26], stacks);
            }
        });
        cards[27].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[27], stacks);
            }
        });
        cards[28].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[28], stacks);
            }
        });
        cards[29].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[29], stacks);
            }
        });
        cards[30].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[30], stacks);
            }
        });
        cards[31].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[31], stacks);
            }
        });
        cards[32].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[32], stacks);
            }
        });
        cards[33].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[33], stacks);
            }
        });
        cards[34].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[34], stacks);
            }
        });
        cards[35].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[35], stacks);
            }
        });
        cards[36].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[36], stacks);
            }
        });
        cards[37].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[37], stacks);
            }
        });
        cards[38].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[38], stacks);
            }
        });
        cards[39].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[39], stacks);
            }
        });
        cards[40].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[40], stacks);
            }
        });
        cards[41].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[41], stacks);
            }
        });
        cards[42].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[42], stacks);
            }
        });
        cards[43].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[43], stacks);
            }
        });
        cards[44].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[44], stacks);
            }
        });
        cards[45].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[45], stacks);
            }
        });
        cards[46].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[46], stacks);
            }
        });
        cards[47].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[47], stacks);
            }
        });
        cards[48].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[48], stacks);
            }
        });
        cards[49].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[49], stacks);
            }
        });
        cards[50].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[50], stacks);
            }
        });
        cards[51].getImageView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return myTouch(v, event, cards[51], stacks);
            }
        });
    }

    private static void actionDown(View v, MotionEvent event, ImageView i) {
        initialX = i.getX();
        initialY = i.getY();
        x = event.getRawX();
        y = event.getRawY();
        dx = x - i.getX();
        dy = y - i.getY();
    }

    private static void actionMove(ImageView i) {
        i.setX(x-dx);
        i.setY(y-dy);
    }

    private static void actionUp(Card card, float x, float y) {
        int row = 0, column = 0;
        // Hardcoded width and height for now. TODO: Make height and width accessible in this class
        for (int i = 0; i < rowXCoordinates.length; i++) {
            if (x > rowXCoordinates[i] && x < rowXCoordinates[i] + 70) {
                column = i;
                break;
            }
        }
        for (int i = 0; i < columnYCoordinates.length; i++) {
            if (y > columnYCoordinates[i] && y < columnYCoordinates[i] + 100) {
                row = i;
                break;
            }
        }
        int whichStack = -1;
        if (row == 4) {
            whichStack = 43 + column;
        }
        else {
            whichStack = column*4 + row;
        }
//        Log.d("", "x is " + x + " y is " + y + ", touch stack number " + whichStack + " Stacks array length is " + stacks.length + " Card moving is from stack " + card.getCurrentStackID() + " and the card is " + card.convertToString());
        if (card.getCurrentStackID() != whichStack) {
            if (stacks[whichStack].getCurrentCards().size()==0) {
                stacks[whichStack].addCardToStack(card);
            }
            if (card.getSuit() == stacks[whichStack].getLastCard().getSuit()) {
                if (abs(card.getNumber() - stacks[whichStack].getLastCard().getNumber()) == 1) {
                    stacks[card.getCurrentStackID()].removeCardFromStack(card);
                    stacks[whichStack].addCardToStack(card);
                    card.getImageView().setX(rowXCoordinates[column]);
                    card.getImageView().setY(columnYCoordinates[row]-88); //TODO: Fix this line. Y coordinate not aligned due to top bar.
                    Log.d("", "Setting X as " + rowXCoordinates[column] + " and Y as " + columnYCoordinates[row]);
                }
            }
        }
//        switch(column) {
//            case 0:
//                if (row < 4) {
//                    whichStack = row;
//                }
//                break;
//            case 1:
//                if (row < 4) {
//                    whichStack = 4*column + row;
//                }
//                else {
//                    whichStack = 44;
//                }
//                break;
//            case 2:
//
//
//        }
//        // check if the card is being dragged to stack
//        if ((x > location[0]+ 15 && x < location[0]+stackWidth) && (y > location[1] && y < location[1]+stackHeight)) {
//
//            // check if the card is on the current stack
//            if (card.getCurrentStackID() != stack.getStackID()) {
//                if (card.getCurrentStackID() == 2) {
//                    stack2.removeCardFromStack(card);
//                }
//                if (stack.getLastCard() == null) {
//                    stack.addCardToStack(card);
//                    card.getImageView().setX(stackX[0]);
//                    card.getImageView().setY(stackY[0]);
//                }
//                // check if same suit
//                else if (stack.getLastCard().getSuit() == card.getSuit()) {
//
//                    // check if consecutive
//                    if (stack.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
//                        stack.addCardToStack(card);
//                        card.getImageView().setX(stackX[0]);
//                        card.getImageView().setY(stackY[0]);
//                    }
//                    else if (stack.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
//                        stack.addCardToStack(card);
//                        card.getImageView().setX(stackX[0]);
//                        card.getImageView().setY(stackY[0]);
//                    }
//                    else if (Math.abs(card.getNumber() - stack.getLastCard().getNumber()) == 1) {
//                        stack.addCardToStack(card);
//                        card.getImageView().setX(stackX[0]);
//                        card.getImageView().setY(stackY[0]);
//                    }
//                    else {
//                        Log.d(msg, "Cannot stack cards");
//                        card.getImageView().setX(initialX);
//                        card.getImageView().setY(initialY);
//                    }
//                }
//                else {
//                    Log.d(msg, "Cannot stack cards");
//                    card.getImageView().setX(initialX);
//                    card.getImageView().setY(initialY);
//                }
//            }
//            String a = "The first card of the stack is the " + stack.getFirstCard().convertToString();
//            Log.d(msg, a);
//            Log.d(msg, stack.getListOfCards());
//            Log.d(msg, ""+card.getCurrentStackID());
//        }
//        else if ((x > location2[0]+ 15 && x < location2[0]+stackWidth) && (y > location2[1] && y < location2[1]+stackHeight) && card.getCurrentStackID() != stack2.getStackID() ) {
//            if (card.getCurrentStackID() != stack2.getStackID()) {
//                if (card.getCurrentStackID() == 1) {
//                    stack.removeCardFromStack(card);
//                }
//                if (stack2.getLastCard() == null) {
//                    stack2.addCardToStack(card);
//                    card.getImageView().setX(stackX[1]);
//                    card.getImageView().setY(stackY[1]);
//                }
//                else if (stack2.getLastCard().getSuit() == card.getSuit()) {
//                    if (stack2.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
//                        stack2.addCardToStack(card);
//                        card.getImageView().setX(stackX[1]);
//                        card.getImageView().setY(stackY[1]);
//                    }
//                    else if (stack2.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
//                        stack2.addCardToStack(card);
//                        card.getImageView().setX(stackX[1]);
//                        card.getImageView().setY(stackY[1]);
//                    }
//                    else if (Math.abs(card.getNumber() - stack2.getLastCard().getNumber()) == 1) {
//                        stack2.addCardToStack(card);
//                        card.getImageView().setX(stackX[1]);
//                        card.getImageView().setY(stackY[1]);
//                    }
//                    else {
//                        Log.d(msg, "Cannot stack cards");
//                        card.getImageView().setX(initialX);
//                        card.getImageView().setY(initialY);
//                    }
//                }
//                else {
//                    Log.d(msg, "Cannot stack cards");
//                    card.getImageView().setX(initialX);
//                    card.getImageView().setY(initialY);
//                }
//            }
//
//            String a = "The first card of the stack is the " + stack2.getFirstCard().convertToString();
//            Log.d(msg, a);
//            Log.d(msg, stack2.getListOfCards());
//            Log.d(msg, ""+card.getCurrentStackID());
//        }
//        else {
//            if (card.getCurrentStackID() != 0) {
//                card.getImageView().setX(stackX[card.getCurrentStackID()-1]);
//                card.getImageView().setY(stackY[card.getCurrentStackID()-1]);
//            }
    }
    //    }
    public static boolean myTouch(View v, MotionEvent e, Card c, Stack[] stacks) {
        v.bringToFront();
        x = e.getRawX();
        y = e.getRawY();
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
                actionUp(c, x, y);
                break;
            default:
                Log.d("", "Default");
                return false;
        }
        return true;
    }
}
