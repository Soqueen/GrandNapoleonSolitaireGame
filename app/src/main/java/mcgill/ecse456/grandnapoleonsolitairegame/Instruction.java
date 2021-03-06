package mcgill.ecse456.grandnapoleonsolitairegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * GNS Android Game Application
 * Instruction.java
 * Purpose: Display the 11 instructions pages of the games.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/02/2017
 */

// Feature is completed.
// TODO - Simplify/write another function to display instruction page.
public class Instruction extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruction_page1);
        recursiveNavigate();
    }

    public void recursiveNavigate() {
        Button[] b = initButton();
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page2);
                recursive1();
            }
        });
    }

    public void recursive1() {
        Button[] b = initButton();
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page3);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page2);
                        recursive1();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page4);
                        recursive2();
                    }
                });
            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page1);
                recursiveNavigate();
            }
        });
    }

    public void recursive2() {
        Button[] b = initButton();
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page5);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page4);
                        recursive2();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page6);
                        recursive3();
                    }
                });
            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page3);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page2);
                        recursive1();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page4);
                        recursive2();
                    }
                });
            }
        });
    }

    public void recursive3() {
        Button[] b = initButton();
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page7);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page6);
                        recursive3();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page8);
                        recursive4();
                    }
                });
            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page5);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page4);
                        recursive2();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page6);
                        recursive3();
                    }
                });
            }
        });
    }

    public void recursive4() {
        Button[] b = initButton();
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page9);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page8);
                        recursive4();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page10);
                        recursive5();
                    }
                });

            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page7);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page6);
                        recursive3();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page8);
                        recursive4();
                    }
                });
            }
        });
    }

    public void recursive5() {
        Button[] b = initButton();
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page11);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page10);
                        recursive5();
                    }
                });

            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MusicManager.clickPlayer.start();
                setContentView(R.layout.instruction_page9);
                Button[] b = initButton();
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page8);
                        recursive4();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MusicManager.clickPlayer.start();
                        setContentView(R.layout.instruction_page10);
                        recursive5();
                    }
                });
            }
        });
    }

    public Button[] initButton() {
        Button[] b = new Button[2];
        Button prev = (Button) findViewById(R.id.inst_prev);
        Button next = (Button) findViewById(R.id.inst_next);
        b[0] = prev;
        b[1] = next;
        return b;
    }

    // Called to close instruction page once the closed button is clicked.
    public void closedInstruction(View view) {
        MusicManager.clickPlayer.start();
        finish();
    }

    @Override
    public void onBackPressed() {

    }


}