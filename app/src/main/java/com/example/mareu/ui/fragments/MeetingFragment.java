package com.example.mareu.ui.fragments;

import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.ui.adapters.MeetingAdapter;
import com.example.mareu.ui.base.BaseFragment;

import butterknife.BindView;


public class MeetingFragment extends BaseFragment implements MeetingAdapter.MeetingAdapterListener {

    // FIELDS --------------------------------------------------------------------------------------

    @BindView(R.id.fragment_meeting_coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;
    @BindView(R.id.fragment_meeting_recycler_view)
    RecyclerView mRecyclerView;

    private MeetingAdapter mAdapter;
    private boolean mIsFilter;

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public MeetingFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_meeting;
    }

    @Override
    protected void configureDesign() {
        // Configures the RecyclerView
        this.configureRecyclerView();

        // Updates the list of the RecyclerView
        this.updateRecyclerView(false);
    }

    // INTERFACE FRAGMENT VIEW *********************************************************************

    @Override
    public void updateRecyclerView(boolean isFilter) {
        // RECYCLER VIEW
//        this.mAdapter.updateData(isFilter ? this.mFragmentPresenter.getFilteredMeetings() :
//                                            this.mFragmentPresenter.getMeetings());

        this.mAdapter.updateData(this.mFragmentPresenter.getMeetings());

//        // FILTER FAB
//        this.setVisibilityOfFilterFAB(isFilter);

        // FILTER
        this.mIsFilter = isFilter;
    }

    @Override
    public void setTextById(int id, String time) {

    }

    // INTERFACE MEETING ADAPTER LISTENER (CALLBACKS OF RECYCLER VIEW) *****************************

    @Override
    public void onClickDeleteButton(int position) {
        final String message = getString(R.string.information_delete_meeting, this.mAdapter.getMeeting(position).getTopic());

        this.mFragmentPresenter.deleteMeeting(this.mAdapter.getMeeting(position), this.mIsFilter);
    }

    @Override
    public void EmptyList(boolean isEmpty) {
//        this.mTextForNoData.setVisibility(isEmpty ? View.VISIBLE : View.GONE);

    }

    // INSTANCES ***********************************************************************************

    /**
     * Returns a {@link MeetingFragment}
     *
     * @return a {@link MeetingFragment}
     */
    public static MeetingFragment newInstance() {
        return new MeetingFragment();
    }

    // UI ******************************************************************************************

    /**
     * Configures {@link RecyclerView} with its {@link MeetingAdapter}
     */
    private void configureRecyclerView() {
        // Adapter
        this.mAdapter = new MeetingAdapter(this);

        // RecyclerView
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    // ERROR MESSAGES ******************************************************************************

//    /**
//     * Configures and show the error message
//     */
//    private void configureAndShowErrorMessage(final String message) {
//        // IDENTIFIER W600dp
//        if (getResources().getConfiguration().screenWidthDp >= getResources().getInteger(R.integer.identifier_w600dp)) {
//            this.mCallback.showMessageFromFragment(message);
//        } else {
//            ShowMessage.showMessageWithSnackbar(this.mCoordinatorLayout,
//                    message);
//        }
//    }
}
