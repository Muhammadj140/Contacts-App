package com.bignerdranch.android.criminalintent;

/*
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mName;
    private String mNumber;
    private String mEmail;

    public Crime() {
        this(UUID.randomUUID());
    }
    public Crime(UUID id) {
        mId = id;
    }

    public UUID getId(){
        return mId;
    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }

    public String getNumber() {
        return mNumber;
    }

//    public void setNumber(long number) { mNumber = number; }
    public void setNumber(String number) { mNumber = number; }
    public void setEmail(String email) { mEmail = email; }
    public String getEmail() { return mEmail; }
}

*/

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private Date mDate;     // the date of the crime
    private String mTitle;
    private String number;
    private String mEmail;
    private boolean mSolved;// is the crime solved?

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId(){
        return mId;
    }
    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String n) {
        mTitle = n;
    }

    public String getNumber() {
        return number;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setNumber(String num)
    { number = num; }


    public void setSolved(boolean solved) {
        mSolved = solved;
    }
    public Date getDate() {
        return mDate;
    }

    public String getEmail()
    { return mEmail; }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setEmail(String email)
    { mEmail = email; }

}

