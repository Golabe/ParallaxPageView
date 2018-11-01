package top.golabe.kotlin.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import top.golabe.kotlin.library.R;

public class ParallaxPageContainer extends RelativeLayout {



    public ParallaxPageContainer(Context context) {
        this(context, null);
    }

    public ParallaxPageContainer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParallaxPageContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new ContainerLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {

        ContainerLayoutParams lp = (ContainerLayoutParams) params;

        if (isAddLayoutParams(lp)) {

            WrapContentView view = new WrapContentView(getContext());
            view.setAlphaIn(lp.alphaIn);
            view.setAlphaOut(lp.alphaOut);
            view.setxIn(lp.xIn);
            view.setxOut(lp.xOut);
            view.setyOut(lp.yOut);
            view.setyIn(lp.yIn);
            view.addView(child);
            super.addView(view, index, params);

        } else {
            super.addView(child, index, params);

        }

    }

    private boolean isAddLayoutParams(ContainerLayoutParams lp) {
        return lp.alphaOut != -1 || lp.alphaIn != -1 || lp.xOut != -1 || lp.xIn != -1 || lp.yOut != -1 || lp.yIn != -1;
    }


    private static class ContainerLayoutParams extends LayoutParams {
        private float alphaIn;
        private float alphaOut;
        private float xIn;
        private float xOut;
        private float yIn;
        private float yOut;

        ContainerLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);

            if (attrs != null) {
                TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ParallaxPageContainer);
                alphaIn = a.getFloat(R.styleable.ParallaxPageContainer_a_in, -1F);
                alphaOut = a.getFloat(R.styleable.ParallaxPageContainer_a_out, -1F);
                xIn = a.getFloat(R.styleable.ParallaxPageContainer_x_in, -1F);
                xOut = a.getFloat(R.styleable.ParallaxPageContainer_x_out, -1F);
                yIn = a.getFloat(R.styleable.ParallaxPageContainer_y_in, -1F);
                yOut = a.getFloat(R.styleable.ParallaxPageContainer_y_out, -1F);
                a.recycle();
            }


        }
    }
}
