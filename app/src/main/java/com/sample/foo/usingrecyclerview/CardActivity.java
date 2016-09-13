package com.sample.foo.usingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sample.foo.usingrecyclerview.databinding.ActivityCardBinding;

import java.util.List;

public class CardActivity extends AppCompatActivity {

    private ActivityCardBinding mCardBinding;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Card Activity");
        mCardBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_card);

        mCardBinding.recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mCardBinding.recyclerView.setLayoutManager(mLayoutManager);

        List<Person> people = Util.getPeopleList(this);
        mAdapter = new CardAdapter(people);
        mCardBinding.recyclerView.setAdapter(mAdapter);
    }
}
