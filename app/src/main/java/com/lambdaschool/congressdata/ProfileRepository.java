package com.lambdaschool.congressdata;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.lambdaschool.congressdataapiaccess.CongressDao;

public class ProfileRepository {
    public static LiveData<CongresspersonProfile> getProfile(final String id) {
        Log.i("Repository", "Retreiving Data");
        final MutableLiveData<CongresspersonProfile> profileLiveData = new MutableLiveData<>();

        CongresspersonProfile profile = new CongresspersonProfile(CongressDao.getMemberDetails(id));
        //commented out for performance improvement
        profile.setImage(CongressDao.getImage(profile.getId()));
        profileLiveData.setValue(profile);

        return profileLiveData;
    }
}
