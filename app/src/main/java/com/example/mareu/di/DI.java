package com.example.mareu.di;

import androidx.annotation.VisibleForTesting;

import com.example.mareu.service.ApiService;
import com.example.mareu.service.DummyApiService;

public abstract class DI {

    // FIELDS --------------------------------------------------------------------------------------

    private static ApiService mService = new DummyApiService();

    // METHODS -------------------------------------------------------------------------------------

    /**
     * Returns the only instance of {@link ApiService}
     * @return the only instance of {@link ApiService}
     */
    public static ApiService getApiService() {
        return mService;
    }

    /**
     * Returns always a new instance on {@link ApiService}.
     * Useful for tests, so we ensure the context is clean.
     * @return a {@link ApiService}
     */
    @VisibleForTesting
    public static ApiService getNewInstanceApiService() {
        return new DummyApiService();
    }
}
