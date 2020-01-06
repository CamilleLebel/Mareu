package com.example.mareu.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mareu.presenter.FragmentPresenter;
import com.example.mareu.presenter.Presenter;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements com.example.mareu.View.FragmentView {

    // INTERFACES ----------------------------------------------------------------------------------

    public interface FragmentListener {

        void onClickFromFragment(String message);

    }

    // FIELDS --------------------------------------------------------------------------------------

    protected FragmentListener mCallback;
    protected Presenter.FragmentPresenterInterface mFragmentPresenter;


    // CONSTRUCTORS --------------------------------------------------------------------------------

    public BaseFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    protected abstract int getFragmentLayout();
    protected abstract void configureDesign();

    // FRAGMENT ************************************************************************************


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // Configures the callback to the parent activity
        this.configureCallbackToParentActivity(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(this.getFragmentLayout(), container, false);
        ButterKnife.bind(this, view);

        this.configurePresenter();

        this.configureDesign();

        return view;
    }

    @Override
    public void onDetach() {
//        // To prevent memory leaks
//        this.mCallback = null;
//        this.mFragmentPresenter.onDetach();
        super.onDetach();
    }

    // CALLBACK OF ACTIVITY ************************************************************************

    /**
     * Configures {@link FragmentListener}(callbacks) to the parent activity
     * @param context a {@link Context} which contains the {@link Fragment}
     */
    private void configureCallbackToParentActivity(Context context) {
        // Initializes the callback field
        try {
            this.mCallback = (FragmentListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(e.toString() + " must implement FragmentListener");
        }
    }

    // PRESENTER ***********************************************************************************

    /**
     * Configures the Presenter
     */
    private void configurePresenter() {
        this.mFragmentPresenter = new FragmentPresenter(this);
    }
}
