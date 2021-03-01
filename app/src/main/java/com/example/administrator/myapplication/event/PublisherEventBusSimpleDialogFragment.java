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

public class PublisherEventBusSimpleDialogFragment extends DialogFragment {
    private static final String TAG = "PublisherDialogFragment";

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
                        {
                            final Intent intent = new Intent();
                            intent.setAction(EventLocalListenerActivity.HANDLE_EVENT_ACTION);
                            intent.putExtra(EventLocalListenerActivity.STATUS_KEY,true);
                            LocalBroadcastManager.getInstance(getActivity())
                                    .sendBroadcast(intent);
                        }
                        break;
                    case 1:
                        // failure
                    {
                        final Intent intent = new Intent();
                        intent.setAction(EventLocalListenerActivity.HANDLE_EVENT_ACTION);
                        intent.putExtra(EventLocalListenerActivity.STATUS_KEY,false);
                        LocalBroadcastManager.getInstance(getActivity())
                                .sendBroadcast(intent);
                    }
                        break;
                }
            }
        });
        return builder.create();
    }

    private void postAsyncEvent() {
    }

    private void postBackgroundEvent() {
    }

    private void postMainOrderedEvent() {

    }

}
