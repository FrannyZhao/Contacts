package com.microsoft.contacts.UI.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zhaofengyi on 2018/12/8.
 */

public class PersonalInformationPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mlist;
    public PersonalInformationPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mlist = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        if (mlist == null) {
            return 0;
        }
        return mlist.size();
    }
}
