package mcgill.ecse456.grandnapoleonsolitairegame;

import android.util.Log;
import android.widget.Button;

/**
 * Created by AL on 11/20/2017.
 */

public class Undo {
    private Button b;
    public Undo(Button undoButton) {
        this.b = undoButton;
    }

    public void clicked() {
        Log.d("", "Undo");
    }
}
