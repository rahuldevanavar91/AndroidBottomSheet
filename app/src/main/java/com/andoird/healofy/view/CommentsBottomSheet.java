package com.andoird.healofy.view;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andoird.healofy.R;
import com.andoird.healofy.adapter.PostAdapter;

/**
 * Created by Rahul D on 7/3/18.
 */
public class CommentsBottomSheet extends BottomSheetDialogFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_up_layout, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.comments_reycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new PostAdapter(null));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();

        if (dialog != null) {
            final View bottomSheet = dialog.findViewById(R.id.design_bottom_sheet);
            bottomSheet.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            final View view = getView();
            view.post(new Runnable() {
                @Override
                public void run() {
                    View parent = (View) view.getParent();
                    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) (parent).getLayoutParams();
                    CoordinatorLayout.Behavior behavior = params.getBehavior();
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) behavior;
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    parent.setBackgroundColor(Color.TRANSPARENT);

                }
            });
        }
    }
}