package com.kss.AudioRecordUploaderCMCK.network;

import android.app.ProgressDialog;
import android.content.Context;

import com.kss.AudioRecordUploaderCMCK.network.callback.NetworkCallback;
import com.kss.AudioRecordUploaderCMCK.utils.Utility;


public abstract class NetworkOperations implements NetworkCallback {
    private ProgressDialog progressDialog;

    public void onStart(Context context, String msg) {
        progressDialog = Utility.createProgressDialog(context);
    }

    public void onComplete() {
        progressDialog.dismiss();
    }
}
