package top.golabe.kotlin.library.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import top.golabe.kotlin.library.interfaces.IWrapContainer;

public class WrapContentView extends FrameLayout implements IWrapContainer {
    private static final String TAG = "WrapContentView";
    private float alphaIn;
    private float alphaOut;
    private float xIn;
    private float xOut;
    private float yIn;
    private float yOut;


    public void setAlphaIn(float alphaIn) {
        this.alphaIn = alphaIn;
    }


    public void setAlphaOut(float alphaOut) {
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

        if (xIn != -1) {
            setTranslationX(xIn * x);
        }


    }

    @Override
    public void onTranslationInY(float y) {
        if (yIn != -1) {
            setTranslationY(yIn * y);
        }
    }

    @Override
    public void onTranslationOutX(float x) {
        if (xOut != -1) {
            setTranslationX(xOut * x);
        }
    }

    @Override
    public void onTranslationOutY(float y) {
        if (yOut != -1) {
            setTranslationY(yOut * y);
        }
    }

    @Override
    public void onAlphaIn(float a) {
//        if (alphaIn != -1) {
//            setAlpha(a * alphaIn);
//            Log.d(TAG, "onAlphaIn: "+a*alphaIn);
//        }
    }
    @Override
    public void onAlphaOut(float a) {
//        if (alphaOut != -1) {
//            Log.d(TAG, "onAlphaOut: "+a*alphaOut);
//            setAlpha(a * alphaOut);
//        }
    }
}
