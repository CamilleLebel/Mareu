package com.example.mareu.models;

import java.util.Objects;

public class Member {

    // FIELDS --------------------------------------------------------------------------------------

    private int mId;
    private String mFirstName;
    private String mLastName;
    private String mEmail;

    /**
     * Constructor
     * @param id integer correspond to the id
     * @param firstName a string that contains the first name
     * @param lastName a string that contains the last name
     * @param email a string that contains the email
     */
    public Member(int id, String firstName, String lastName, String email) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return mId == member.mId &&
                Objects.equals(mFirstName, member.mFirstName) &&
                Objects.equals(mLastName, member.mLastName) &&
                mEmail.equals(member.mEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mFirstName, mLastName, mEmail);
    }
}
