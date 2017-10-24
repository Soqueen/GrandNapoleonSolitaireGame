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
        Button next = (Button) findViewById(R.id.inst_next);
        Button closed = (Button) findViewById(R.id.inst_closed);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page2);
                anotherRecursive();
            }
        });
        closed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
    public void anotherRecursive(){
        Button next = (Button) findViewById(R.id.inst_next);
        Button closed = (Button) findViewById(R.id.inst_closed);
        Button prev = (Button) findViewById(R.id.inst_prev);
        closed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page3);
                Button closed = (Button) findViewById(R.id.inst_closed);
                Button prev = (Button) findViewById(R.id.inst_prev);
                closed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                prev.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.instruction_page2);
                        anotherRecursive();
                    }
                });
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.instruction_page1);
                recursiveNavigate();
            }
        });
    }
}