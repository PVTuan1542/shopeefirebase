package com.shopee;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CustomSheet extends BottomSheetDialogFragment {
    int layout;

    public CustomSheet(int layout) {
        this.layout = layout;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog=(BottomSheetDialog)super.onCreateDialog(savedInstanceState);
        bottomSheetDialog.setOnShowListener(dialog -> {
            BottomSheetDialog dialogc = (BottomSheetDialog) dialog;
            // When using AndroidX the resource can be found at com.google.android.material.R.id.design_bottom_sheet
            FrameLayout bottomSheet =  dialogc.findViewById(R.id.design_bottom_sheet);

            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
            bottomSheetBehavior.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        });
        return bottomSheetDialog;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View view = View.inflate(getContext(),layout, null);
        dialog.setContentView(view);
    }
}
