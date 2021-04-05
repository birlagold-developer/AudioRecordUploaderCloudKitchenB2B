package com.kss.AudioRecordUploaderCMCK.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;

import com.kss.AudioRecordUploaderCMCK.R;
import com.kss.AudioRecordUploaderCMCK.network.retrofit.RFClient;
import com.kss.AudioRecordUploaderCMCK.network.retrofit.RFInterface;


public class Utility {

    public static RFInterface getRetrofitInterface(String BASE_URL) {



        return RFClient.getClient(BASE_URL).create(RFInterface.class);
    }

    public static RFInterface getRetrofitInterfaceWithStringResponse(String BASE_URL) {
        return RFClient.getClientWithStringResponse(BASE_URL).create(RFInterface.class);
    }

    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.show();
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.progressdialog);

        return dialog;
    }

}
