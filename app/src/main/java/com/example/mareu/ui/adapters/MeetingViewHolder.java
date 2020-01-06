package com.example.mareu.ui.adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.models.Meeting;

import java.lang.ref.WeakReference;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

class MeetingViewHolder extends RecyclerView.ViewHolder {

    // FIELDS --------------------------------------------------------------------------------------

    @BindView(R.id.item_meeting_iv_image)
    ImageView mImage;
    @BindView(R.id.item_meeting_tv_topic_hour_room)
    TextView mTopicHourRoom;
    @BindView(R.id.item_meeting_tv_participants)
    TextView mParticipants;
    @BindView(R.id.item_meeting_iv_delete)
    ImageButton mDeleteButton;

    private WeakReference<MeetingAdapter.MeetingAdapterListener> mListenerWeakReference;
    private static Random sRandom = new Random();

    private int mRandomColor;

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public MeetingViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.generateRandomColor();
    }

    // METHODS -------------------------------------------------------------------------------------

    public static int getLayout(){
        return R.layout.item_meeting;
    }

    // ACTIONS *************************************************************************************

    @OnClick(R.id.item_meeting_iv_delete)
    public void onDeleteButtonClicked(){
        MeetingAdapter.MeetingAdapterListener callback = this.mListenerWeakReference.get();

        if (callback != null) {
            callback.onClickDeleteButton(getAdapterPosition());
        }
    }

    // COLORS **************************************************************************************

    private void generateRandomColor() {
        mRandomColor = Color.argb(
                sRandom.nextInt(255),
                sRandom.nextInt(255),
                sRandom.nextInt(255),
                sRandom.nextInt(255));

    }

    // UI ******************************************************************************************

    public void updateMeeting(Meeting meeting, MeetingAdapter.MeetingAdapterListener callback) {

        //Image
        switch (meeting.getRoom()) {
            case "Peach": {
                ((GradientDrawable) this.mImage.getBackground()).setColor(this.mRandomColor);
                break;
            }
            case "Mario": {
                ((GradientDrawable) this.mImage.getBackground()).setColor(this.mRandomColor);
                break;
            }
            case "Luigi": {
                ((GradientDrawable) this.mImage.getBackground()).setColor(this.mRandomColor);
                break;
            }
        }

        // TEXT VIEW
        final String topicHourRoom = meeting.getTopic() + " - " +
                                     meeting.getHour()  + " - " +
                                     meeting.getRoom();

        this.mTopicHourRoom.setText(topicHourRoom);

        this.mParticipants.setText(meeting.getMember());

        // LISTENER
        this.mListenerWeakReference = new WeakReference<>(callback);
    }


}
