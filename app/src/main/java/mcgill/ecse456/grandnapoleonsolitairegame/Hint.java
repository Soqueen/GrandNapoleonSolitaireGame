package mcgill.ecse456.grandnapoleonsolitairegame;

import android.view.View;
import android.widget.Button;

/**
 * GNS Android Game Application
 * GameActivity.java
 * Purpose: Contains the logic of the game page features.
 *
 * @author Andrew Lin
 * @version 1.0 11/03/2017
 */

// There is no logic for hint feature yet. This is just a dummy pagae after hint button detected on game page.
// TODO - Implement the logic of hint.
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

            }
        });
    }
}
