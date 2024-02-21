package com.example.lkcare1;

import android.os.Parcel;
import android.os.Parcelable;

public class Member implements Parcelable {

    private String name;

    private String cin;
    private String phoneNumber;
    private String dateOfBirth;
    private String dateEntry;

    public Member() {
    }

    public Member( String name,  String cin, String phoneNumber, String dateOfBirth, String dateEntry) {
        this.name = name;
        this.cin = cin;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateEntry = dateEntry;
    }

    protected Member(Parcel in) {
        name = in.readString();
        cin = in.readString();
        phoneNumber = in.readString();
        dateOfBirth = in.readString();
        dateEntry = in.readString();
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel in) {
            return new Member(in);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };
    public String getName() {
        return name;
    }

    public String getCin() {
        return cin;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public String getDateEntry() {
        return dateEntry;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(cin);
        dest.writeString(phoneNumber);
        dest.writeString(dateOfBirth);
        dest.writeString(dateEntry);
    }
}
