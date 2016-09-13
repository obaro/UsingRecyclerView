package com.sample.foo.usingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.foo.usingrecyclerview.databinding.CardListItemBinding;

import java.util.List;

/**
 * Created by Obaro on 11/09/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private List<Person> mPeople;

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        private CardListItemBinding listItemBinding;

        public CardViewHolder(View v) {
            super(v);
            listItemBinding = DataBindingUtil.bind(v);
        }

        public CardListItemBinding getBinding(){
            return listItemBinding;
        }
    }

    public CardAdapter(List<Person> people){
        mPeople = people;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_item, parent, false);
        CardViewHolder holder = new CardViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        final Person person = mPeople.get(position);
        holder.getBinding().setVariable(BR.person, person);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mPeople.size();
    }
}
