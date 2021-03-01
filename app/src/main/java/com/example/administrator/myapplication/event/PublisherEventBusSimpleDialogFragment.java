package com.example.administrator.myapplication.event;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;

import org.greenrobot.eventbus.EventBus;

public class PublisherEventBusSimpleDialogFragment extends DialogFragment {
    private static final String TAG = "PublisherEventBusSimpleDialogFragment";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("PublisherSimple");
        final String[] items = {"Success", "Failure",
                "Posting", "Main", "MainOrdered", "Background", "Async"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        // success
                        postSuccessEvent();
                        break;
                    case 1:
                        // failure
                        postFailureEvent();
                        break;
                }
            }
        });
        return builder.create();
    }

    private void postFailureEvent() {
        EventBus.getDefault().post(new FailureEvent());
    }

    private void postSuccessEvent() {
        EventBus.getDefault().post(new SuccessEvent());
    }

}
