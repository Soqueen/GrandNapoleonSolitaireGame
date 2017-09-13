package mcgill.ecse456.grandnapoleonsolitairegame;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * GNS Android Game Application
 * Stack
 * Purpose: Contains everything around a stack
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/25/2017
 */
public class Stack {

    private ImageView view;
    private ArrayList<Card> currentCards = new ArrayList<Card>();    // First index of the list = bottom card, Last index of the list = top card
    private int stackID;
    private int leftSideLocation, topSideLocation;
    private int[] location = new int[2];

    /**
     * Public constructor Stack to easily access by other classes.
     *
     * @params id Unique Identify of stack
     */
    public Stack(int id) {
        this.stackID = id;
    }

    public void addCardToStack(Card card) {
        card.setCurrentStackID(this.stackID);
        currentCards.add(card);
    }

    /**
     * Remove card from stack.
     *
     * @return None
     * @params card card that will be removed from the stack
     */
    public void removeCardFromStack(Card card) {
        if (currentCards.indexOf(card) >= 0) {
            currentCards.remove(currentCards.indexOf(card));
        }
    }

    public void setImageView(ImageView i) {
        this.view = i;
        view.getLocationOnScreen(location);
        this.leftSideLocation = location[0];
        this.topSideLocation = location[1];
    }

    public void setXYCoordinates(int x, int y) {
        this.leftSideLocation = x;
        this.topSideLocation = y;
    }

    /**
     * Get the ImageView.
     *
     * @return view
     * @params args not used
     */
    public ImageView getImageView() {
        return this.view;
    }

    /**
     * Get the first Cards from the stack.
     *
     * @return firstCard First card of the stack
     * @params args not used
     */
    public Card getFirstCard() {
        Card firstCard;
        if (this.currentCards.size() > 0) {
            firstCard = currentCards.get(0);
        } else {
            firstCard = null;
        }
        return firstCard;
    }

    /**
     * Get the last Cards from the stack.
     *
     * @return LastCard Last card of the stack
     * @params args not used
     */
    public Card getLastCard() {
        Card lastCard;
        if (currentCards.size() == 0) {
            lastCard = null;
        } else {
            lastCard = currentCards.get(currentCards.size() - 1);
        }
        return lastCard;
    }

    /**
     * Get the list of the cards.
     *
     * @return list list of cards
     * @params args not used
     */
    public String getListOfCards() {
        String list = "The list of cards are: ";

        if (this.currentCards.size() > 1) {
            for (int i = 0; i < this.currentCards.size(); i++) {
                if (i == this.currentCards.size() - 1) {
                    list = list + "and " + currentCards.get(i).convertToString();
                }
                else {
                    list = list + currentCards.get(i).convertToString() + ", ";
                }

            }
        }
        else if (this.currentCards.size() == 1){
            return (list + currentCards.get(0).convertToString());
        }
        else {
            return "Error, no cards";
        }
        return list;
    }


    public ArrayList<Card> getCurrentCards() {
        return this.currentCards;
    }
    public int getStackID() {
        return this.stackID;
    }

    public int getLeftSideLocation() {
        return this.leftSideLocation;
    }

    public int getTopSideLocation() {
        return this.topSideLocation;
    }
}

