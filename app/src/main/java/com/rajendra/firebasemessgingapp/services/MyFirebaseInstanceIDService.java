package com.rajendra.firebasemessgingapp.services;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by rajendraverma on 23-05-2016.
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
private String Tag = "MyFirebaseInstanceIDService";
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
//    Todo :: add code to save to server
    error("sendRegistrationToServer", "refreshTokenID : :"+refreshedToken);

    }

    private void error(String methodName, String msg) {
        Log.e(Tag,"Mehod Name "+methodName+" Message :"+msg);
    }


}
