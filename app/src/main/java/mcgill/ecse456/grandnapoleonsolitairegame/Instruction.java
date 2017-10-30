package mcgill.ecse456.grandnapoleonsolitairegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * GNS Android Game Application
 * Instruction.java
 * Purpose: Display the instructions of the games.
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/12/2017
 */

public class Instruction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruction_page1);
        recursiveNavigate();
    }
    public void recursiveNavigate (){
        Button[] b = initButton();
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page2);
                recursive1();
            }
        });
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
    public void recursive1(){
        Button[] b = initButton();
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page3);
                Button[] b = initButton();
                b[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page2);
                        recursive1();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page4);
                        recursive2();
                    }
                });
            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page1);
                recursiveNavigate();
            }
        });
    }
    public void recursive2(){
        Button[] b = initButton();
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page5);
                Button[] b = initButton();
                b[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page4);
                        recursive2();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page6);
                        recursive3();
                    }
                });
            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page3);
                Button[] b = initButton();
                b[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page2);
                        recursive1();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page4);
                        recursive2();
                    }
                });
            }
        });
    }

    public void recursive3(){
        Button[] b = initButton();
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page7);
                Button[] b = initButton();
                b[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page6);
                        recursive3();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page8);
                        recursive4();
                    }
                });
            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page4);
                recursive2();
            }
        });
    }

    public void recursive4(){
        Button[] b = initButton();
        b[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        b[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page9);
                Button[] b = initButton();
                b[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page8);
                        recursive4();
                    }
                });

            }
        });
        b[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page7);
                Button[] b = initButton();
                b[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                b[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page6);
                        recursive3();
                    }
                });
                b[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page8);
                        recursive4();
                    }
                });
            }
        });
    }

    public Button[] initButton(){
        Button[] b = new Button[3];
        Button closed = (Button) findViewById(R.id.inst_closed);
        Button prev = (Button) findViewById(R.id.inst_prev);
        Button next = (Button) findViewById(R.id.inst_next);
        b[0] = prev;
        b[1] = next;
        b[2] = closed;
        return b;
    }


}