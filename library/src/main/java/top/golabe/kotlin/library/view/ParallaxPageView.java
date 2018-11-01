package top.golabe.kotlin.library.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
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

            //在翻页的过程中，不断根据视图的标签中对应的动画参数，改变视图的位置或者透明度
            //获取到进入的页面
            ParallaxFragment inFragment = null;
            try {
                inFragment = mFragments.get(position - 1);
            } catch (Exception e) {}

            //获取到退出的页面
            ParallaxFragment outFragment = null;
            try {
                outFragment = mFragments.get(position);
            } catch (Exception e) {}

            if (inFragment != null) {
                //获取Fragment上所有的视图，实现动画效果

                List<View> inViews = inFragment.getParallaxViews();
                if (inViews != null) {
                    for (View view : inViews) {
                         if (!(view instanceof  ParallaxPageContainer)){
                             continue;
                         }

                        for (int i = 0; i < ((ParallaxPageContainer) view).getChildCount(); i++) {
                            View childView = ((ParallaxPageContainer) view).getChildAt(i);
                            IWrapContainer container = (IWrapContainer) childView;
                            if (container!=null){
                                container.onTranslationInY(containerWidth - positionOffsetPixels);
                                container.onTranslationInX(containerWidth - positionOffsetPixels);
                                container.onAlphaIn(containerWidth-positionOffsetPixels);
                            }
                        }

                    }
                }
            }

            if(outFragment != null){

                List<View >outViews = outFragment.getParallaxViews();
                if (outViews != null) {
                    for (View view : outViews) {
                        if (!(view instanceof  ParallaxPageContainer)){
                            continue;
                        }

                        for (int i = 0; i < ((ParallaxPageContainer) view).getChildCount(); i++) {
                            View childView = ((ParallaxPageContainer) view).getChildAt(i);
                            IWrapContainer container = (IWrapContainer) childView;
                            if (container!=null){
                                container.onTranslationOutY(0 - positionOffsetPixels);
                                container.onTranslationOutX(0 - positionOffsetPixels);
                                container.onAlphaOut(0-positionOffsetPixels);
                            }
                        }

                    }
                }
            }

        }

        @Override
        public void onPageSelected(int i) {

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


}
