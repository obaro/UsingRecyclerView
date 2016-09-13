package com.sample.foo.usingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.foo.usingrecyclerview.databinding.SimpleListItemBinding;

import java.util.List;

/**
 * Created by Obaro on 11/09/2016.
 */
public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.SimpleViewHolder> {

    private List<Person> mPeople;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        private SimpleListItemBinding listItemBinding;

        public SimpleViewHolder(View v) {
            super(v);
            listItemBinding = DataBindingUtil.bind(v);
        }

        public SimpleListItemBinding getBinding(){
            return listItemBinding;
        }
    }

    public SimpleListAdapter(List<Person> people){
        mPeople = people;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_list_item, parent, false);
        SimpleViewHolder holder = new SimpleViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        final Person person = mPeople.get(position);
        holder.getBinding().setVariable(BR.person, person);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mPeople.size();
    }
}
