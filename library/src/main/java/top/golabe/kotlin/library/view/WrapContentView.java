package top.golabe.kotlin.library.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import top.golabe.kotlin.library.interfaces.IWrapContainer;

import static top.golabe.kotlin.library.view.ParallaxPageContainer.DEFAULT_VALUE;

public class WrapContentView extends FrameLayout implements IWrapContainer {
    private static final String TAG = "WrapContentView";
    private boolean alphaIn;
    private boolean alphaOut;
    private float xIn;
    private float xOut;
    private float yIn;
    private float yOut;


    public void setAlphaIn(boolean alphaIn) {
        this.alphaIn = alphaIn;
    }


    public void setAlphaOut(boolean alphaOut) {
        this.alphaOut = alphaOut;
    }


    public void setxIn(float xIn) {
        this.xIn = xIn;
    }


    public void setxOut(float xOut) {
        this.xOut = xOut;
    }


    public void setyIn(float yIn) {
        this.yIn = yIn;
    }


    public void setyOut(float yOut) {
        this.yOut = yOut;
    }


    public WrapContentView(Context context) {
        super(context);
    }

    public WrapContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }


    @Override
    public void onTranslationInX(float x) {

        if (xIn != DEFAULT_VALUE) {
            setTranslationX(xIn * x);
        }


    }

    @Override
    public void onTranslationInY(float y) {
        if (yIn != DEFAULT_VALUE) {
            setTranslationY(yIn * y);
        }
    }

    @Override
    public void onTranslationOutX(float x) {
        if (xOut != DEFAULT_VALUE) {
            setTranslationX(xOut * x);
        }
    }

    @Override
    public void onTranslationOutY(float y) {
        if (yOut != DEFAULT_VALUE) {
            setTranslationY(yOut * y);
        }
    }

    @Override
    public void onAlphaIn(float a) {
        if (alphaIn) {
            if (a<=1&&a>=0){
                setAlpha(a);
            }

        }
    }

    @Override
    public void onAlphaOut(float a) {
        if (alphaOut) {
            if (a <= 1 && a >= 0) {
                setAlpha(1 - a);
            }

        }
    }
}
