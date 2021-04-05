package com.kss.AudioRecordUploaderCMCK.network.callback;

import android.os.Bundle;

public interface NetworkCallback {
    void onSuccess(Bundle msg);

    void onFailure(Bundle msg);
}
