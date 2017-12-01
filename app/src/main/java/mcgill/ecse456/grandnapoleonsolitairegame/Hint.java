package mcgill.ecse456.grandnapoleonsolitairegame;

import android.view.View;
import android.widget.Button;

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
