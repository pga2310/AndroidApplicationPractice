package com.example.shreetech.tictactoe;

/*
* Created by: Pushpak Gandhi
* K ID: K00363211
* Date created: 04/03/2016*
*/


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends Activity implements OnClickListener {


    boolean turn = true;
    TextView t;
    int turn_count = 0;
    Button[] matrix = null;
    Button a1, a2, a3, b1, b2, b3, c1, c2, c3;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            t=(TextView)findViewById(R.id.textView3);

            a1 = (Button) findViewById(R.id.one);
            a2 = (Button) findViewById(R.id.two);
            a3 = (Button) findViewById(R.id.three);


            b1 = (Button) findViewById(R.id.four);
            b2 = (Button) findViewById(R.id.five);
            b3 = (Button) findViewById(R.id.six);


            c1 = (Button) findViewById(R.id.seven);
            c2 = (Button) findViewById(R.id.eight);
            c3 = (Button) findViewById(R.id.nine);

        matrix = new Button[] { a1, a2, a3, b1, b2, b3, c1, c2, c3 };
        for (Button b : matrix)
            b.setOnClickListener(this);

        Button newgame = (Button) findViewById(R.id.button);
        newgame.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                turn = true;
                turn_count = 0;
                readyState(true);
            }
        });
    }

    private void readyState(boolean enable) {
        for (Button b : matrix) {
            b.setText("");
            t.setText("");
            b.setClickable(enable);
        }
    }

    @Override
    public void onClick(View v) {
        buttonClicked(v);
    }

    private void buttonClicked(View v) {
        Button b = (Button) v;
        if (turn) {
            b.setText("X");

        } else {
            b.setText("O");
        }
        turn_count++;
        b.setClickable(false);
        turn = !turn;

        gameLogic();
    }

    private void gameLogic() {
        boolean winner = false;


        if (a1.getText() == a2.getText() && a2.getText() == a3.getText()
                && !a1.isClickable())
            winner = true;
        else if (b1.getText() == b2.getText() && b2.getText() == b3.getText()
                && !b1.isClickable())
            winner = true;
        else if (c1.getText() == c2.getText() && c2.getText() == c3.getText()
                && !c1.isClickable())
            winner = true;

        else if (a1.getText() == b1.getText() && b1.getText() == c1.getText()
                && !a1.isClickable())
            winner = true;
        else if (a2.getText() == b2.getText() && b2.getText() == c2.getText()
                && !b2.isClickable())
            winner = true;
        else if (a3.getText() == b3.getText() && b3.getText() == c3.getText()
                && !c3.isClickable())
            winner = true;


        else if (a1.getText() == b2.getText() && b2.getText() == c3.getText()
                && !a1.isClickable())
            winner = true;
        else if (a3.getText() == b2.getText() && b2.getText() == c1.getText()
                && !b2.isClickable())
            winner = true;

        if (winner) {
            if (!turn)
                message("X wins");
            else
                message("O wins");
            //readyState(false);
        } else if (turn_count == 9)
            message("Draw!");

    }

    private void message(String text) {
//        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT)
//                .show();
        t.setText(text);
    }
}