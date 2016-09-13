package com.sample.foo.usingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sample.foo.usingrecyclerview.databinding.ActivitySimpleListBinding;

import java.util.ArrayList;
import java.util.List;

public class SimpleListActivity extends AppCompatActivity {

    private ActivitySimpleListBinding mSimpleListBinding;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Simple List");
        mSimpleListBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_simple_list);

        mSimpleListBinding.recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mSimpleListBinding.recyclerView.setLayoutManager(mLayoutManager);

        List<Person> people = Util.getPeopleList(this);
        mAdapter = new SimpleListAdapter(people);
        mSimpleListBinding.recyclerView.setAdapter(mAdapter);
    }
}
