package com.example.mareu.ui.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    // METHODS -------------------------------------------------------------------------------------

    protected abstract int getActivityLayout();
    protected abstract Toolbar getToolBar();
    protected abstract void configureDesign();

    // ACTIVITY ************************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associates the layout file to this class
        setContentView(this.getActivityLayout());

        // Using the ButterKnife library
        ButterKnife.bind(this);

        // Configures the design of the activity
        this.configureDesign();
    }


    // TOOL BAR ************************************************************************************

    /**
     * Configures the ToolBar field
     */
    protected void configureToolBar() {
        // If ToolBar exists
        if (this.getToolBar() != null) {
            setSupportActionBar(this.getToolBar());
        }
    }
    // FRAGMENT ************************************************************************************

    /**
     * Adds a {@link Fragment} to the {@link android.app.Activity}
     * @param idFrameLayout an integer that corresponds to the id of a {@link android.widget.FrameLayout}
     * @param fragment a instance of class which extends to {@link Fragment}
     * @param <T> a type parameter section
     */
    protected <T extends Fragment> void addFragment(int idFrameLayout, T fragment) {
        // Adds the transaction to create the fragment [FragmentManager -> FragmentTransaction -> int]
        getSupportFragmentManager().beginTransaction()
                .add(idFrameLayout, fragment)
                .commit();
    }



}
