package mcgill.ecse456.grandnapoleonsolitairegame;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AL on 3/25/2017.
 */

public class Stack {

    public ImageView view;
    public int drawable;
    public ArrayList<Card> currentCards = new ArrayList<Card>();

    public void addCardToStack(Card card) {
        currentCards.add(card);
    }
    public void removeCardFromStack(Card card) {
        currentCards.remove(currentCards.indexOf(card));
    }

    public void refreshStack(){
        Card dummy = new Card();
        dummy = currentCards.get(currentCards.size()-1);
        drawable = dummy.getDrawable();
    }
}
