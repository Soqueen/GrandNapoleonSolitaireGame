package mcgill.ecse456.grandnapoleonsolitairegame;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class Pause {
    private Context context;
    private Button pauseButton;
    public Pause(Context context, Button pauseButton) {
        this.context = context;
        this.pauseButton = pauseButton;
    }

    public void popUp() {
        this.pauseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.pause_dialog);
                dialog.setTitle("Pause");

                Button resumeButton = (Button) dialog.findViewById(R.id.resume_button);
                Button restartButton = (Button) dialog.findViewById(R.id.restart_button);
                Button quitButton = (Button) dialog.findViewById(R.id.quit_button);
                Button settingButton = (Button) dialog.findViewById(R.id.setting_button);
                Button instructionButton = (Button) dialog.findViewById(R.id.instruction_button);

                // if resume button is clicked, close the custom dialog
                resumeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        // TODO - Pause timer

                    }
                });
                // TODO - Restart , quit, setting, instruction
                dialog.show();
            }
        });
    }

}
