package top.golabe.kotlin.library.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import top.golabe.kotlin.library.view.ParallaxFragment;

public class ParallaxPageAdapter extends FragmentPagerAdapter {

	private List<ParallaxFragment> fragments;

	public ParallaxPageAdapter(FragmentManager fm, List<ParallaxFragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

}
