package com.example.mareu.presenter;

import androidx.annotation.VisibleForTesting;

import com.example.mareu.View;
import com.example.mareu.di.DI;
import com.example.mareu.models.Meeting;
import com.example.mareu.models.Member;
import com.example.mareu.service.ApiService;

import java.util.ArrayList;
import java.util.List;

public class FragmentPresenter implements Presenter.FragmentPresenterInterface {

    // FIELDS --------------------------------------------------------------------------------------

    private ApiService mService;
    private View.FragmentView mView;
    private List<Member> mSelectedMembers;

    private static List<Meeting> mFilteredMeetings = new ArrayList<>();

    // CONSTRUCTORS --------------------------------------------------------------------------------

    /**
     * Constructor
     * @param view a {@link View.FragmentView} interface that contains the View
     */
    public FragmentPresenter(View.FragmentView view) {
        this.mService = DI.getApiService();
        this.mView = view;
        this.mSelectedMembers = new ArrayList<>();
    }

    /**
     * Constructor
     * Useful for tests, so we ensure the context is clean.
     * @param view a {@link View.FragmentView} interface that contains the View
     * @param apiService  a {@link ApiService}
     */
    @VisibleForTesting
    public FragmentPresenter(View.FragmentView view, ApiService apiService) {
        this.mService = apiService;
        this.mView = view;
        this.mSelectedMembers = new ArrayList<>();
    }

    // METHODS -------------------------------------------------------------------------------------

    // MEETINGS ************************************************************************************

    @Override
    public List<Meeting> getMeetings() {
        return this.mService.getMeetings();
    }

    @Override
    public void deleteMeeting(Meeting meeting, boolean isFilter) {
        if (isFilter) {
            mFilteredMeetings.remove(meeting);
        }

        this.mService.deleteMeeting(meeting);

        // Callback to the View (Normal Mode)
        this.mView.updateRecyclerView(isFilter);
    }

    @Override
    public String addMeeting(String topic, String hour, String room, String member) {
        Meeting meeting = new Meeting(this.mService.getMeetings().size() + 1,
                topic,
                hour,
                room,
                member);

        this.mService.addMeeting(meeting);

        return topic;
    }

    @Override
    public List<Meeting> getFilteredMeetings() {
        return mFilteredMeetings;
    }

}
