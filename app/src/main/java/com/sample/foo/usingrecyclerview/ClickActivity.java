package com.sample.foo.usingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sample.foo.usingrecyclerview.databinding.ActivityClickBinding;

import java.util.List;

public class ClickActivity extends AppCompatActivity {

    private ActivityClickBinding mClickBinding;
    private RecyclerView.LayoutManager mLayoutManager;
    private ClickAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add/Remove Items");
        mClickBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_click);

        mClickBinding.recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mClickBinding.recyclerView.setLayoutManager(mLayoutManager);

        List<Person> people = Util.getPeopleList(this);
        mAdapter = new ClickAdapter(people);
        mClickBinding.recyclerView.setAdapter(mAdapter);

        mClickBinding.insertFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.addPerson(Util.getRandomPerson(ClickActivity.this));
                ((LinearLayoutManager)mLayoutManager).scrollToPositionWithOffset(0, 0);
            }
        });
    }
}
