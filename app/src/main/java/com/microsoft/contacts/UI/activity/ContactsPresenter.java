package com.microsoft.contacts.UI.activity;

import android.support.v4.app.Fragment;

import com.microsoft.contacts.UI.adapter.PersonalInformationPagerAdapter;
import com.microsoft.contacts.UI.fragment.PersonalInformationBaseFragment;
import com.microsoft.contacts.models.PersonalInformation;
import com.microsoft.contacts.utilities.PersonalInformationParser;

import java.util.ArrayList;

/**
 * Created by zhaofengyi on 2018/12/13.
 */

public class ContactsPresenter {
    private static final String TAG = ContactsPresenter.class.getSimpleName();
    private PersonalInformationPagerAdapter mPersonalInformationPagerAdapter;
    private ArrayList<PersonalInformation> personalInformations;

    public ArrayList<PersonalInformation> getPersonalInformations() {
        return personalInformations;
    }

    public ArrayList<Fragment> initFragments() {
        PersonalInformationParser personalInformationParser = new PersonalInformationParser();
        personalInformations = personalInformationParser.parse();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < personalInformations.size(); i ++) {
            PersonalInformation personalInformation = personalInformations.get(i);
            PersonalInformationBaseFragment personalInformationBaseFragment = new PersonalInformationBaseFragment();
            personalInformationBaseFragment.setData(personalInformation);
            fragments.add(personalInformationBaseFragment);
        }
        return fragments;
    }
}
