package com.example.mareu.service;

import com.example.mareu.models.Meeting;
import com.example.mareu.models.Member;
import com.example.mareu.models.Room;

import java.util.List;

public class DummyApiService implements ApiService {

    // FIELDS --------------------------------------------------------------------------------------

    private List<Meeting> mMeetings = DummyGenerator.generatorOfDummyMeetings();
    private List<Room> mRooms = DummyGenerator.generatorOfDummyRooms();
    private List<Member> mMembers = DummyGenerator.generatorOfDummyMembers();

    // METHODS -------------------------------------------------------------------------------------

    @Override
    public List<Meeting> getMeetings() {
        return this.mMeetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        this.mMeetings.remove(meeting);
    }

    @Override
    public void addMeeting(Meeting meeting) {
        this.mMeetings.add(meeting);
    }

    @Override
    public List<Member> getMembers() {
        return this.mMembers;
    }

    @Override
    public List<Room> getRooms() {
        return this.mRooms;
    }
}
