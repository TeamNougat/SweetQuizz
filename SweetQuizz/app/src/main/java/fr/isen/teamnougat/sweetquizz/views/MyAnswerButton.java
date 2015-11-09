package fr.isen.teamnougat.sweetquizz.views;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Nathan on 06/11/2015.
 */
public class MyAnswerButton extends Button implements View.OnClickListener{

    private boolean isCheck;

    public MyAnswerButton(Context context) {
        super(context);
        isCheck = false;;
    }


    public boolean isChecked() {
        return isCheck;
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        //ImageButton imageButton = (ImageButton) this.getTag();
        if(v.isPressed()) {
            if(!isCheck) {
                isCheck = true;
                setBackgroundColor(Color.GREEN);
                //imageButton.setVisibility(VISIBLE);
            }else {
                isCheck = false;
                setBackgroundColor(Color.WHITE);
                //imageButton.setVisibility(INVISIBLE);
            }
        }

    }
}
