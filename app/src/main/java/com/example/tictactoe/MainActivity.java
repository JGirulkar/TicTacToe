package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    boolean isActive = true;
    int[] state = {2,2,2,2,2,2,2,2,2};
    int[][] winState = {{0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {2,5,8},
            {0,4,8},
            {2,4,6}
    };



    public void tap(View view){
        ImageView img = (ImageView) view;
        int tappedCol = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.textView2);

        if(!isActive){
            reset(view);
        }

        if(state[tappedCol] == 2 && isActive){
            state[tappedCol] = activePlayer;
            img.setTranslationY(-1000f);

            if(activePlayer == 0){
                img.setImageResource(R.drawable.red_o);
                activePlayer = 1;
//                TextView status = findViewById(R.id.status);
                status.setText("X's turn");
            }else{
                img.setImageResource(R.drawable.green_x);
                activePlayer = 0;
//                TextView status = findViewById(R.id.status);
                status.setText("O's turn");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] val : winState){
            if(state[val[0]] == state[val[1]] && state[val[1]] == state[val[2]] && state[val[0]] != 2){
                String winner;
                isActive = false;
                if(activePlayer == 0){
                    winner = "X wins";
//                    status.setText(winner);
                }else{
                    winner = "O wins";
//                    status.setText(winner);
                }
                status.setText(winner);
//                reset(view);
            }
        }
//        isDraw();
        if(isDraw()){
            isActive = false;
            status.setText("It's a draw");
        }

    }

    public boolean isDraw() {
        for(int i=0; i<state.length; i++){
            if(state[i]==2){
                return false;
            }
        }
        return true;
    }

    public void reset(View view){
        isActive = true;
        activePlayer = 0;
        for(int i= 0; i<state.length; i++){
            state[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);

        TextView status = findViewById(R.id.textView2);
        status.setText("Tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}