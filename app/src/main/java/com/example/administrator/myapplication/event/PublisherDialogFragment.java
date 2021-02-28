package com.example.administrator.myapplication.event;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class PublisherDialogFragment extends DialogFragment {
    private static final String TAG = "PublisherDialogFragment";
    private OnEventListener onEventListener;

    //定义监听接口
    public interface OnEventListener {
        void onSuccess();

        void onFailure();
    }


    //注入实现方法
    public void setEventListener(OnEventListener listener) {
        onEventListener = listener;
    }

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
                        if(onEventListener != null){
                            onEventListener.onSuccess();
                        }
                        break;
                    case 1:
                        // failure
                        if(onEventListener != null){
                            onEventListener.onFailure();
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
