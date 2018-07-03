package com.andoird.healofy.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andoird.healofy.R;
import com.andoird.healofy.adapter.PostAdapter;

public class MainActivity extends AppCompatActivity implements PostAdapter.onItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();
    }

    private void getWidgets() {
        RecyclerView mRecyclerView = findViewById(R.id.main_recyler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(new PostAdapter(this));
    }

    @Override
    public void onClick() {
        CommentsBottomSheet bottomSheetFragment = new CommentsBottomSheet();
        bottomSheetFragment.show(getSupportFragmentManager(), "bottom_fragment");

    }
}
