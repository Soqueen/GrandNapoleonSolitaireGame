package mcgill.ecse456.grandnapoleonsolitairegame;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import static mcgill.ecse456.grandnapoleonsolitairegame.R.drawable.*;

/**
 * Created by AL on 3/25/2017.
 */

public class Card {
    private int suit;       // 1 for Diamonds, 2 for Clubs, 3 for Hearts, 4 for Spades
    private int number;     // 1 for Ace, 2 for Two, ... , 11 for Jack, 12 for Queen, 13 for King
    private int[] drawables;
    private ImageView view;

    public final static int[] drawablesDiamonds = {
            R.drawable.abstract_diamonds_1, R.drawable.abstract_diamonds_2, R.drawable.abstract_diamonds_3, R.drawable.abstract_diamonds_4, R.drawable.abstract_diamonds_5,
            R.drawable.abstract_diamonds_6, R.drawable.abstract_diamonds_7, R.drawable.abstract_diamonds_8, R.drawable.abstract_diamonds_9, R.drawable.abstract_diamonds_10,
            R.drawable.abstract_diamonds_11, R.drawable.abstract_diamonds_12, R.drawable.abstract_diamonds_13,
    };

    public final static int[] drawablesClubs = {
            R.drawable.abstract_clubs_1, R.drawable.abstract_clubs_2, R.drawable.abstract_clubs_3, R.drawable.abstract_clubs_4, R.drawable.abstract_clubs_5,
            R.drawable.abstract_clubs_6, R.drawable.abstract_clubs_7, R.drawable.abstract_clubs_8, R.drawable.abstract_clubs_9, R.drawable.abstract_clubs_10,
            R.drawable.abstract_clubs_11, R.drawable.abstract_clubs_12, R.drawable.abstract_clubs_13,
    };

    public final static int[] drawablesHearts = {
            R.drawable.abstract_hearts_1, R.drawable.abstract_hearts_2, R.drawable.abstract_hearts_3, R.drawable.abstract_hearts_4, R.drawable.abstract_hearts_5,
            R.drawable.abstract_hearts_6, R.drawable.abstract_hearts_7, R.drawable.abstract_hearts_8, R.drawable.abstract_hearts_9, R.drawable.abstract_hearts_10,
            R.drawable.abstract_hearts_11, R.drawable.abstract_hearts_12, R.drawable.abstract_hearts_13,
    };

    public final static int[] drawablesSpades = {
            R.drawable.abstract_spades_1, R.drawable.abstract_spades_2, R.drawable.abstract_spades_3, R.drawable.abstract_spades_4, R.drawable.abstract_spades_5,
            R.drawable.abstract_spades_6, R.drawable.abstract_spades_7, R.drawable.abstract_spades_8, R.drawable.abstract_spades_9, R.drawable.abstract_spades_10,
            R.drawable.abstract_spades_11, R.drawable.abstract_spades_12, R.drawable.abstract_spades_13,
    };

    public Card(int suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public int getSuit() {
        return this.suit;
    }

    public int getNumber() {
        return this.number;
    }

    public ImageView getImageView() {
        return this.view;
    }

    public void setImageView(ImageView i) {
        this.view = i;
        switch(suit) {
            case 1:
                drawables = drawablesDiamonds;
                switch(number) {
                    case 1:
                        i.setImageResource(drawables[0]);
                        break;
                    case 2:
                        i.setImageResource(drawables[1]);
                        break;
                    case 3:
                        i.setImageResource(drawables[2]);
                        break;
                    case 4:
                        i.setImageResource(drawables[3]);
                        break;
                    case 5:
                        i.setImageResource(drawables[4]);
                        break;
                    case 6:
                        i.setImageResource(drawables[5]);
                        break;
                    case 7:
                        i.setImageResource(drawables[6]);
                        break;
                    case 8:
                        i.setImageResource(drawables[7]);
                        break;
                    case 9:
                        i.setImageResource(drawables[8]);
                        break;
                    case 10:
                        i.setImageResource(drawables[9]);
                        break;
                    case 11:
                        i.setImageResource(drawables[10]);
                        break;
                    case 12:
                        i.setImageResource(drawables[11]);
                        break;
                    case 13:
                        i.setImageResource(drawables[12]);
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                drawables = drawablesClubs;
                switch(number) {
                    case 1:
                        i.setImageResource(drawables[0]);
                        break;
                    case 2:
                        i.setImageResource(drawables[1]);
                        break;
                    case 3:
                        i.setImageResource(drawables[2]);
                        break;
                    case 4:
                        i.setImageResource(drawables[3]);
                        break;
                    case 5:
                        i.setImageResource(drawables[4]);
                        break;
                    case 6:
                        i.setImageResource(drawables[5]);
                        break;
                    case 7:
                        i.setImageResource(drawables[6]);
                        break;
                    case 8:
                        i.setImageResource(drawables[7]);
                        break;
                    case 9:
                        i.setImageResource(drawables[8]);
                        break;
                    case 10:
                        i.setImageResource(drawables[9]);
                        break;
                    case 11:
                        i.setImageResource(drawables[10]);
                        break;
                    case 12:
                        i.setImageResource(drawables[11]);
                        break;
                    case 13:
                        i.setImageResource(drawables[12]);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                drawables = drawablesHearts;
                switch(number) {
                    case 1:
                        i.setImageResource(drawables[0]);
                        break;
                    case 2:
                        i.setImageResource(drawables[1]);
                        break;
                    case 3:
                        i.setImageResource(drawables[2]);
                        break;
                    case 4:
                        i.setImageResource(drawables[3]);
                        break;
                    case 5:
                        i.setImageResource(drawables[4]);
                        break;
                    case 6:
                        i.setImageResource(drawables[5]);
                        break;
                    case 7:
                        i.setImageResource(drawables[6]);
                        break;
                    case 8:
                        i.setImageResource(drawables[7]);
                        break;
                    case 9:
                        i.setImageResource(drawables[8]);
                        break;
                    case 10:
                        i.setImageResource(drawables[9]);
                        break;
                    case 11:
                        i.setImageResource(drawables[10]);
                        break;
                    case 12:
                        i.setImageResource(drawables[11]);
                        break;
                    case 13:
                        i.setImageResource(drawables[12]);
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                drawables = drawablesSpades;
                switch(number) {
                    case 1:
                        i.setImageResource(drawables[0]);
                        break;
                    case 2:
                        i.setImageResource(drawables[1]);
                        break;
                    case 3:
                        i.setImageResource(drawables[2]);
                        break;
                    case 4:
                        i.setImageResource(drawables[3]);
                        break;
                    case 5:
                        i.setImageResource(drawables[4]);
                        break;
                    case 6:
                        i.setImageResource(drawables[5]);
                        break;
                    case 7:
                        i.setImageResource(drawables[6]);
                        break;
                    case 8:
                        i.setImageResource(drawables[7]);
                        break;
                    case 9:
                        i.setImageResource(drawables[8]);
                        break;
                    case 10:
                        i.setImageResource(drawables[9]);
                        break;
                    case 11:
                        i.setImageResource(drawables[10]);
                        break;
                    case 12:
                        i.setImageResource(drawables[11]);
                        break;
                    case 13:
                        i.setImageResource(drawables[12]);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;

        }
    }

    public String convertToString() {
        return (numberToString() + " of " + this.suitToString());
    }

    public String numberToString() {
        if (this.number == 1) {
            return "Ace";
        }
        if (this.number <= 10) {
            return ""+this.number;
        }
        if (this.number == 11) {
            return "Jack";
        }
        if (this.number == 12) {
            return "Queen";
        }
        if (this.number == 13) {
            return "King";
        }
        return "Error with number";
    }
    public String suitToString() {
        if (this.suit == 1) {
            return "Diamonds";
        }
        if (this.suit == 2) {
            return "Clubs";
        }
        if (this.suit == 3) {
            return "Hearts";
        }
        if (this.suit == 4) {
            return "Spades";
        }
        return "Error with suit";
    }

//    public static int[] drawables;
//
//    public static void updateCardDrawable(){
//        drawables = new int[]{R.drawable.abstract_clubs_1, R.drawable.abstract_clubs_2, R.drawable.abstract_clubs_3,
//                R.drawable.abstract_clubs_4, R.drawable.abstract_clubs_5, R.drawable.abstract_clubs_6,
//                R.drawable.abstract_clubs_7, R.drawable.abstract_clubs_8, R.drawable.abstract_clubs_9,
//                R.drawable.abstract_clubs_10, R.drawable.abstract_clubs_11, R.drawable.abstract_clubs_12,
//                R.drawable.abstract_clubs_13};
//    }
}
