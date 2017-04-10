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

    /**
     * Public constructor Stack to easily access by other classes.
     *
     * @params id Unique Identify of stack
     */
    public Stack(int id) {
        this.stackID = id;
    }

    /**
     * Add card to stack.
     *
     * @return None
     * @params card card that will be added to stack
     */
    public void addCardToStack(Card card) {
        currentCards.add(card);
        card.setCurrentStackID(this.stackID);
    }

    /**
     * Remove card from stack.
     *
     * @return None
     * @params card card that will be removed from the stack
     */
    public void removeCardFromStack(Card card) {
        currentCards.remove(currentCards.indexOf(card));
    }

    /**
     * Set Imageview for stack.
     *
     * @return None
     * @params i ImageView
     */
    public void setImageView(ImageView i) {
        this.view = i;
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
        for (int i = 0; i < this.currentCards.size(); i++) {
            if (i == this.currentCards.size() - 1) {
                list = list + "and " + currentCards.get(i).convertToString();
            } else {
                list = list + currentCards.get(i).convertToString() + ", ";
            }
        }
        return list;
    }

    /**
     * Get stack identify ID.
     *
     * @return stackID
     * @params args not used
     */
    public int getStackID() {
        return this.stackID;
    }
}

