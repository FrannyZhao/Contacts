package com.microsoft.contacts.UI.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.microsoft.contacts.R;
import com.microsoft.contacts.UI.adapter.AvatarAdapter;
import com.microsoft.contacts.UI.adapter.PersonalInformationPagerAdapter;
import com.microsoft.contacts.UI.view.AutoLocateHorizontalView;
import com.microsoft.contacts.UI.view.VerticalViewPager;

public class ContactsActivity extends AppCompatActivity {
    private static final String TAG = ContactsActivity.class.getSimpleName();
    private static final int AVARTAR_COUNT = 5;
    private ContactsPresenter contactsPresenter;
    private AvatarAdapter mAvatarAdaper;
    private PersonalInformationPagerAdapter mPersonalInformationPagerAdapter;
    private VerticalViewPager mViewPager;
    private AutoLocateHorizontalView mAvatarHSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        mAvatarHSV = findViewById(R.id.avatar_hsv);
        mViewPager = findViewById(R.id.myViewPager);
        contactsPresenter = new ContactsPresenter();
        init();
    }

    private void init() {
        mPersonalInformationPagerAdapter = new PersonalInformationPagerAdapter(
                getSupportFragmentManager(), contactsPresenter.initFragments());
        mViewPager.setAdapter(mPersonalInformationPagerAdapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(2);
        mAvatarAdaper = new AvatarAdapter(this, contactsPresenter.getPersonalInformations());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mAvatarHSV.setLayoutManager(linearLayoutManager);
        mAvatarHSV.setItemCount(AVARTAR_COUNT);
        mAvatarHSV.setInitPos(0);
        mAvatarHSV.setAdapter(mAvatarAdaper);
        mAvatarHSV.moveToPosition(0);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d(TAG, "onPageScrolled position:" + position + ",positionOffset:"
//                        + positionOffset + ",positionOffsetPixels:" + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected position:" + position);
                mAvatarHSV.moveToPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//                Log.d(TAG, "onPageScrollStateChanged state:" + state);
            }
        });

        mAvatarHSV.setOnSelectedPositionChangedListener(
                new AutoLocateHorizontalView.OnSelectedPositionChangedListener() {
            @Override
            public void selectedPositionChanged(int newPosition) {
                Log.d(TAG, "mAvatarHSV selectedPositionChanged " + newPosition);
                mViewPager.setCurrentItem(newPosition, true);
            }
        });

        mAvatarAdaper.setOnItemClickedListener(new AvatarAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(int position) {
                Log.d(TAG, "mAvatarHSV onItemClicked " + position);
                mAvatarHSV.moveToPosition(position);
                mViewPager.setCurrentItem(position, true);
            }
        });
    }
}
