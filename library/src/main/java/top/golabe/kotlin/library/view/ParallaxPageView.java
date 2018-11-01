package top.golabe.kotlin.library.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import top.golabe.kotlin.library.R;
import top.golabe.kotlin.library.adapter.ParallaxPageAdapter;
import top.golabe.kotlin.library.interfaces.IWrapContainer;

public class ParallaxPageView extends ViewPager {
    private static final String TAG = "ParallaxPageView";
    private List<ParallaxFragment> mFragments;
    private ParallaxPageAdapter mParallaxPageAdapter;
    private int containerWidth;

    public ParallaxPageView(@NonNull Context context) {
        super(context);
    }

    public ParallaxPageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setup(int... ids) {
        mFragments = new ArrayList<>();
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                ParallaxFragment pf = new ParallaxFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("layoutId", ids[i]);
                pf.setArguments(bundle);
                mFragments.add(pf);
            }
        }

        mParallaxPageAdapter = new ParallaxPageAdapter(((FragmentActivity) getContext()).getSupportFragmentManager(), mFragments);
        setId(R.id.parallax_pager);
        setAdapter(mParallaxPageAdapter);
        addOnPageChangeListener(onPageChangeListener);
    }


    private OnPageChangeListener onPageChangeListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
            containerWidth=getWidth();

            ParallaxFragment inFragment = null;
            try {
                inFragment = mFragments.get(position -1);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ParallaxFragment outFragment = null;
            try {
                outFragment = mFragments.get(position);
            } catch (Exception e) {
                e.printStackTrace();
            }

            inFragment(positionOffsetPixels, inFragment);

            outFragment(positionOffsetPixels, outFragment);

        }

        @Override
        public void onPageSelected(int i) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    private void outFragment(int positionOffsetPixels, ParallaxFragment outFragment) {
        if(outFragment != null){

            List<View > outViews = outFragment.getParallaxViews();
            if (outViews != null) {
                for (View view : outViews) {
                    if (!(view instanceof ParallaxPageContainer)){
                        continue;
                    }

                    for (int i = 0; i < ((ParallaxPageContainer) view).getChildCount(); i++) {
                        View childView = ((ParallaxPageContainer) view).getChildAt(i);
                        IWrapContainer container = (IWrapContainer) childView;
                        if (container!=null){
                            container.onTranslationOutY(0 - positionOffsetPixels);
                            container.onTranslationOutX(0 - positionOffsetPixels);
                            container.onAlphaOut(positionOffsetPixels/(float)containerWidth);
                        }
                    }

                }
            }
        }
    }

    private void inFragment(int positionOffsetPixels, ParallaxFragment inFragment) {
        if (inFragment != null) {
            List<View> inViews = inFragment.getParallaxViews();
            if (inViews != null) {
                for (View view : inViews) {
                     if (!(view instanceof ParallaxPageContainer)){
                         continue;
                     }

                    for (int i = 0; i < ((ParallaxPageContainer) view).getChildCount(); i++) {
                        View childView = ((ParallaxPageContainer) view).getChildAt(i);
                        IWrapContainer container = (IWrapContainer) childView;
                        if (container!=null){
                            container.onTranslationInY(containerWidth - positionOffsetPixels);
                            container.onTranslationInX(containerWidth - positionOffsetPixels);
                            container.onAlphaIn(positionOffsetPixels/(float)containerWidth);
                        }
                    }

                }
            }
        }
    }


}
