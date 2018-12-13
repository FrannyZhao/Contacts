package com.microsoft.contacts.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhaofengyi on 2018/12/8.
 */

public class PersonalInformation implements Parcelable {
    private String firstName;
    private String lastName;
    private String avatarFileName;
    private String title;
    private String introduction;

    public PersonalInformation() {

    }

    protected PersonalInformation(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.avatarFileName = in.readString();
        this.title = in.readString();
        this.introduction = in.readString();
    }

    public static final Creator<PersonalInformation> CREATOR = new Creator<PersonalInformation>() {
        @Override
        public PersonalInformation createFromParcel(Parcel in) {
            return new PersonalInformation(in);
        }

        @Override
        public PersonalInformation[] newArray(int size) {
            return new PersonalInformation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.avatarFileName);
        dest.writeString(this.title);
        dest.writeString(this.introduction);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatarFileName() {
        return avatarFileName;
    }

    public void setAvatarFileName(String avatarFileName) {
        this.avatarFileName = avatarFileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalInformation that = (PersonalInformation) o;

        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
            return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avatarFileName='" + avatarFileName + '\'' +
                ", title='" + title + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
