package com.example.mareu.presenter;

import com.example.mareu.models.Meeting;

import java.util.List;

public interface Presenter {

    // INTERFACES ----------------------------------------------------------------------------------
    interface FragmentPresenterInterface {

        // MEETINGS ********************************************************************************

        List<Meeting> getMeetings();

        /**
         * Deletes the {@link Meeting} in argument
         * @param meeting a {@link Meeting}
         * @param isFilter a boolean [True: Filter mode] and [False: Normal mode]
         */
        void deleteMeeting(Meeting meeting, boolean isFilter);

        /**
         * Adds a {@link Meeting} in argument
         * @param topic a{@link String} that contains the topic
         * @param hour a{@link String} that contains the hour
         * @param room a{@link String} that contains the room
         * @param member a{@link String} that contains the members
         * @return a {@link String} that contains the topic of the {@link Meeting}
         */
        String addMeeting(String topic, String hour, String room, String member);

        List<Meeting> getFilteredMeetings();
    }
}
