package mcgill.ecse456.grandnapoleonsolitairegame;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by AL on 10/29/2017.
 */

public class Hint {
    private Button b;
    private Card[] cards;
    private Stack[] stacks;

    public Hint(Button hintButton, Card[] c, Stack[] s) {
        this.b = hintButton;
        this.cards = c;
        this.stacks = s;
    }

    public void clicked() {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stacks[0].getLastCard().getImageView().setColorFilter(Color.argb(0, 255, 0, 0));
                stacks[48].getImageView().setColorFilter(Color.argb(100, 255, 255, 255));
//                ArrayList<Card> temp = new ArrayList<Card>();
//                for (int i = 0; i < stacks.length; i++) {
//                    if (stacks[i].getCurrentCards().size() >  0) {
//                        if ((i >= 0 && i < 4) || (i >= 19 && i < 24) || (i >= 40 && i < 44)) {
//                            for (int j = 0; j < stacks[i].getCurrentCards().size(); j++) {
//                                temp.add(stacks[i].getCurrentCards().get(j));
//                            }
//                        }
//                    }
//                }
//                int first = 0;
//                int second = 0;
//                boolean a = false;
//                for (int i = 0; i < temp.size(); i++) {
//                    for (int j = i; j < temp.size(); j++) {
//                        if ((Math.abs(temp.get(i).getNumber() - temp.get(j).getNumber()) == 1) || Math.abs(temp.get(i).getNumber() - temp.get(j).getNumber()) == 12) {
//                            if (temp.get(i).getSuit() == temp.get(j).getSuit()) {
//                                first = i;
//                                second = j;
//                                a = true;
//                                break;
//                            }
//                        }
//                    }
//                }
//                if (a) {
//                    cards[first].getImageView().setColorFilter(Color.argb(100, 128, 0, 0));
//                    cards[second].getImageView().setColorFilter(Color.argb(100, 128, 0, 0));
//                } else {
//
//                }

            }
        });
    }

}
