package com.microsoft.contacts.UI.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.microsoft.contacts.R;
import com.microsoft.contacts.models.PersonalInformation;

/**
 * Created by zhaofengyi on 2018/12/8.
 */

public class PersonalInformationBaseFragment extends Fragment {
    private PersonalInformation mPersonalInformation;
    private TextView firstNameTv;
    private TextView lastNameTv;
    private TextView titleTv;
    private TextView introductionTv;

    public void setData(PersonalInformation personalInformation) {
        mPersonalInformation = personalInformation;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_information_layout, null);
        firstNameTv = view.findViewById(R.id.firstName_tv);
        lastNameTv = view.findViewById(R.id.lastName_tv);
        titleTv = view.findViewById(R.id.title_tv);
        introductionTv = view.findViewById(R.id.introduction_detail_tv);
        firstNameTv.setText(mPersonalInformation.getFirstName());
        lastNameTv.setText(mPersonalInformation.getLastName());
        titleTv.setText(mPersonalInformation.getTitle());
        introductionTv.setText(mPersonalInformation.getIntroduction());
        return view;
    }


}
