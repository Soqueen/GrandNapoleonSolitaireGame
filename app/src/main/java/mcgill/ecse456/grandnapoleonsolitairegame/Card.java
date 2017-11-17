package mcgill.ecse456.grandnapoleonsolitairegame;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import static mcgill.ecse456.grandnapoleonsolitairegame.R.drawable.*;

/**
 * GNS Android Game Application
 * Card
 * Purpose: Contains everything related to cards. it uses a picture view for drawable,
 * like loading or saving cards orientation and setting the drawable files
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/25/2017
 */
public class Card {
    private int suit;       // 1 for Diamonds, 2 for Clubs, 3 for Hearts, 4 for Spades
    private int number;     // 1 for Ace, 2 for Two, ... , 11 for Jack, 12 for Queen, 13 for King
    private int[] drawables;// values for the image of the card
    private ImageView view;
    private int currentStackID = 0;
    private boolean canMove;
    public int style = 0;
    private float xPosition;
    private float yPosition;

    // constants for retrieving the image of diamond cards
    public final static int[] drawablesDiamonds = {
            R.drawable.abstract_diamonds_1, R.drawable.abstract_diamonds_2, R.drawable.abstract_diamonds_3, R.drawable.abstract_diamonds_4, R.drawable.abstract_diamonds_5,
            R.drawable.abstract_diamonds_6, R.drawable.abstract_diamonds_7, R.drawable.abstract_diamonds_8, R.drawable.abstract_diamonds_9, R.drawable.abstract_diamonds_10,
            R.drawable.abstract_diamonds_11, R.drawable.abstract_diamonds_12, R.drawable.abstract_diamonds_13,
    };
    // constants for retrieving the image of club cards
    public final static int[] drawablesClubs = {
            R.drawable.abstract_clubs_1, R.drawable.abstract_clubs_2, R.drawable.abstract_clubs_3, R.drawable.abstract_clubs_4, R.drawable.abstract_clubs_5,
            R.drawable.abstract_clubs_6, R.drawable.abstract_clubs_7, R.drawable.abstract_clubs_8, R.drawable.abstract_clubs_9, R.drawable.abstract_clubs_10,
            R.drawable.abstract_clubs_11, R.drawable.abstract_clubs_12, R.drawable.abstract_clubs_13,
    };
    // constants for retrieving the image of heart cards
    public final static int[] drawablesHearts = {
            R.drawable.abstract_hearts_1, R.drawable.abstract_hearts_2, R.drawable.abstract_hearts_3, R.drawable.abstract_hearts_4, R.drawable.abstract_hearts_5,
            R.drawable.abstract_hearts_6, R.drawable.abstract_hearts_7, R.drawable.abstract_hearts_8, R.drawable.abstract_hearts_9, R.drawable.abstract_hearts_10,
            R.drawable.abstract_hearts_11, R.drawable.abstract_hearts_12, R.drawable.abstract_hearts_13,
    };
    // constants for retrieving the image of spade cards
    public final static int[] drawablesSpades = {
            R.drawable.abstract_spades_1, R.drawable.abstract_spades_2, R.drawable.abstract_spades_3, R.drawable.abstract_spades_4, R.drawable.abstract_spades_5,
            R.drawable.abstract_spades_6, R.drawable.abstract_spades_7, R.drawable.abstract_spades_8, R.drawable.abstract_spades_9, R.drawable.abstract_spades_10,
            R.drawable.abstract_spades_11, R.drawable.abstract_spades_12, R.drawable.abstract_spades_13,
    };

    // constants for retrieving the image of diamond cards
    public final static int[] simpleDiamonds = {
            R.drawable.simple_diamond_1, R.drawable.simple_diamond_2, R.drawable.simple_diamond_3, R.drawable.simple_diamond_4, R.drawable.simple_diamond_5,
            R.drawable.simple_diamond_6, R.drawable.simple_diamond_7, R.drawable.simple_diamond_8, R.drawable.simple_diamond_9, R.drawable.simple_diamond_10,
            R.drawable.simple_diamond_11, R.drawable.simple_diamond_12, R.drawable.simple_diamond_13,
    };
    // constants for retrieving the image of club cards
    public final static int[] simpleClubs = {
            R.drawable.simple_club_1, R.drawable.simple_club_2, R.drawable.simple_club_3, R.drawable.simple_club_4, R.drawable.simple_club_5,
            R.drawable.simple_club_6, R.drawable.simple_club_7, R.drawable.simple_club_8, R.drawable.simple_club_9, R.drawable.simple_club_10,
            R.drawable.simple_club_11, R.drawable.simple_club_12, R.drawable.simple_club_13,
    };
    // constants for retrieving the image of heart cards
    public final static int[] simpleHearts = {
            R.drawable.simple_heart_1, R.drawable.simple_heart_2, R.drawable.simple_heart_3, R.drawable.simple_heart_4, R.drawable.simple_heart_5,
            R.drawable.simple_heart_6, R.drawable.simple_heart_7, R.drawable.simple_heart_8, R.drawable.simple_heart_9, R.drawable.simple_heart_10,
            R.drawable.simple_heart_11, R.drawable.simple_heart_12, R.drawable.simple_heart_13,
    };
    // constants for retrieving the image of spade cards
    public final static int[] simpleSpades = {
            R.drawable.simple_spade_1, R.drawable.simple_spade_2, R.drawable.simple_spade_3, R.drawable.simple_spade_4, R.drawable.simple_spade_5,
            R.drawable.simple_spade_6, R.drawable.simple_spade_7, R.drawable.simple_spade_8, R.drawable.simple_spade_9, R.drawable.simple_spade_10,
            R.drawable.simple_spade_11, R.drawable.simple_spade_12, R.drawable.simple_spade_13,
    };

    /**
     * Public constructor Card to easily access by others.
     *
     * @params suit Integer suite defined range[1,4]
     * @params number Integer number of the card range [1,13]
     */
    public Card(int suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    /**
     * Get suit number of card.
     *
     * @return suit Integer suit number of card
     * @params args not used
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * Get number of card.
     *
     * @return number Integer number of card
     * @params args not used
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Get ImageView of card.
     *
     * @return view
     * @params args not used
     */
    public ImageView getImageView() {
        return this.view;
    }

    /**
     * Set ImageView for card.
     *
     * @return None
     * @params i ImageView
     */
    public void setImageView(ImageView i) {
        this.view = i;
        // case switch to set suit
        switch (suit) {
            case 1:
                if (style == 1) {
                    drawables = drawablesDiamonds;
                } else {
                   drawables = simpleDiamonds;
                }
                // select the correct image depending on the number
                switch (number) {
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
                if (style == 1) {
                    drawables = drawablesClubs;
                } else {
                    drawables = simpleClubs;
                }
                // select the correct image depending on the number
                switch (number) {
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
                if (style == 1) {
                    drawables = drawablesHearts;
                } else {
                    drawables = simpleHearts;
                }
                // select the correct image depending on the number
                switch (number) {
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
                if (style == 1) {
                    drawables = drawablesSpades;
                } else {
                    drawables = simpleSpades;
                }
                // select the correct image depending on the number
                switch (number) {
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

    /**
     * Mapping the complete card name with its suit and number
     *
     * @return cardName The suite and number of card
     * @params args not used
     */
    public String convertToString() {
        String cardName = numberToString() + " of " + this.suitToString();
        return cardName;
    }

    /**
     * Mapping integer number 1, 10, 12, 14 to string 'Ace', 'Jack', 'Queen' and 'King'.
     *
     * @return 'Ace' or 'Jack' or 'Queen' or 'king'
     * @params args not used
     */
    public String numberToString() {
        if (this.number == 1) {
            return "Ace";
        }
        if (this.number <= 10) {
            return "" + this.number;
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

    /**
     * Mapping integer suite number 1, 2, 3, 4 to string suite 'Diamonds', 'Clubs', 'Hearts' and 'Spades'
     *
     * @return 'Diamonds' or 'Clubs' or 'Hearts' or'Spades'
     * @params args not used
     */
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

    /**
     * Mapping integer suite number 1, 2, 3, 4 to string suite 'Diamonds', 'Clubs', 'Hearts' and 'Spades'
     *
     * @return 'Diamonds' or 'Clubs' or 'Hearts' or'Spades'
     * @params args not used
     */
    public int getCurrentStackID() {
        return this.currentStackID;
    }

    /**
     * Mapping integer suite number 1, 2, 3, 4 to string suite 'Diamonds', 'Clubs', 'Hearts' and 'Spades'
     *
     * @return 'Diamonds' or 'Clubs' or 'Hearts' or'Spades'
     * @params args not used
     */
    public void setCurrentStackID(int id) {
        this.currentStackID = id;
    }

    public boolean getCanMove() { return this.canMove; }

    public void setCanMove(boolean canMove) { this.canMove = canMove; }

    public void setXYPositions(float x, float y) {
        this.xPosition = x;
        this.yPosition = y;
    }
    public float getXPosition() { return xPosition; }
    public float getYPosition() {return yPosition; }
    public int getStyle() { return this.style; }
    public void setStyle(int style) { this.style = style; }
}