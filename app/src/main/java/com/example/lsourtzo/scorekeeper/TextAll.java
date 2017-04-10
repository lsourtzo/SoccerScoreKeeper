package com.example.lsourtzo.scorekeeper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextAll extends TextView {
    public TextAll(Context context) {
        super(context);
        setFont();
    }
    public TextAll(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public TextAll(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/ACOdinLight.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
