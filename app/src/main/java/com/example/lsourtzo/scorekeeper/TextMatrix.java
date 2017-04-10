package com.example.lsourtzo.scorekeeper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextMatrix extends TextView {
    public TextMatrix(Context context) {
        super(context);
        setFont();
    }
    public TextMatrix(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public TextMatrix(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/AC-Everyday_unicode.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
