package pe.cgonzales.hmsdemoapp;

import android.content.Intent;
import android.util.Log;

import com.huawei.hms.push.HmsMessageService;

/**
 * @author by cgonzales.
 */
public class MyPushService extends HmsMessageService {
    private static final String TAG = "PushDemoLog";
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.i(TAG, "receive token:" + token);
        sendTokenToDisplay(token);
    }

    private void sendTokenToDisplay(String token) {
        Intent intent = new Intent("pe.cgonzales.hmsdemoapp.ON_NEW_TOKEN");
        intent.putExtra("token", token);
        sendBroadcast(intent);
    }
}