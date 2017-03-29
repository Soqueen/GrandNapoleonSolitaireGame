package mcgill.ecse456.grandnapoleonsolitairegame;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AL on 3/25/2017.
 */

public class Stack {

    public ImageView view;
    public ArrayList<Card> currentCards = new ArrayList<Card>();    // First index of the list = bottom card, Last index of the list = top card

    public void addCardToStack(Card card) {
        currentCards.add(card);
    }
    public void removeCardFromStack(Card card) {
        currentCards.remove(currentCards.indexOf(card));
    }

    public void setImageView(ImageView i) {
        this.view = i;
    }

    public ImageView getImageView() {
        return this.view;
    }

    public Card getFirstCard() {
        return currentCards.get(0);
    }

    public Card getLastCard() {
        if (currentCards.size() == 0) {
            return null;
        }
        else {
            return currentCards.get(currentCards.size()-1   );
        }
    }

    public String getListOfCards() {
        String list = "The list of cards are: ";
        for (int i = 0; i < this.currentCards.size(); i++) {
            if (i == this.currentCards.size() - 1) {
                list = list + "and " + currentCards.get(i).convertToString();
            }
            else {
                list = list + currentCards.get(i).convertToString() + ", ";
            }
        }
        return list;
    }
}