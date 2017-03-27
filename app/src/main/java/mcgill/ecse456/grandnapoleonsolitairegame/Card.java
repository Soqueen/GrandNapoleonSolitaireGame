package mcgill.ecse456.grandnapoleonsolitairegame;

import android.widget.ImageView;

/**
 * Created by AL on 3/25/2017.
 */

public class Card {
    private int suit;
    private int number;
    private ImageView view;
    private int drawable;

    public void Card(int suit, int number, ImageView view, int drawable) {
        this.suit = suit;
        this.number = number;
        this.view = view;
        this.drawable = drawable;
    }

    public int getSuit() {
        return this.suit;
    }

    public int getNumber() {
        return this.number;
    }

    public ImageView getImageView() {
        return this.getImageView();
    }

    public int getDrawable() {
        return this.drawable;
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
