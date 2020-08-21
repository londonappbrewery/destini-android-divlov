package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button top,bottom;
    TextView storyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        top=findViewById(R.id.buttonTop);
        bottom=findViewById(R.id.buttonBottom);
        storyTextView=findViewById(R.id.storyTextView);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(top.getText()==getResources().getString(R.string.T1_Ans1)||top.getText()==getResources().getString(R.string.T2_Ans1))
                    updateStory(3);
                else{
                    storyTextView.setText(R.string.T6_End);
                    clearButtons();
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottom.getText()==getResources().getString(R.string.T1_Ans2))
                    updateStory(2);
                else if(bottom.getText()==getResources().getString(R.string.T2_Ans2)){
                    storyTextView.setText(R.string.T4_End);
                    clearButtons();
                }
                else{
                    storyTextView.setText(R.string.T5_End);
                    clearButtons();
                }
            }
        });

    }

    private void clearButtons() {
//        ViewGroup layout = (ViewGroup) top.getParent();
//        if(null!=layout) { //for safety only  as you are doing onClick
//            layout.removeView(top);
//            layout.removeView(bottom);
//        }
        // shorter way
        top.setVisibility(View.GONE);
        bottom.setVisibility(View.GONE);
    }

    private void updateStory(int storyNumber){
        if(storyNumber==2){
            storyTextView.setText(R.string.T2_Story);
            top.setText(R.string.T2_Ans1);
            bottom.setText(R.string.T2_Ans2);
        }
        else{
            storyTextView.setText(R.string.T3_Story);
            top.setText(R.string.T3_Ans1);
            bottom.setText(R.string.T3_Ans2);
        }

    }
}
