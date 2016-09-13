package com.sample.foo.usingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.foo.usingrecyclerview.databinding.ClickListItemBinding;

import java.util.List;

/**
 * Created by Obaro on 11/09/2016.
 */
public class ClickAdapter extends RecyclerView.Adapter<ClickAdapter.ClickViewHolder> {

    private List<Person> mPeople;

    public static class ClickViewHolder extends RecyclerView.ViewHolder {

        private ClickListItemBinding listItemBinding;

        public ClickViewHolder(View v) {
            super(v);
            listItemBinding = DataBindingUtil.bind(v);
        }

        public ClickListItemBinding getBinding(){
            return listItemBinding;
        }
    }

    public ClickAdapter(List<Person> people){
        mPeople = people;
    }

    @Override
    public ClickViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.click_list_item, parent, false);
        ClickViewHolder holder = new ClickViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ClickViewHolder holder, final int position) {
        final Person person = mPeople.get(holder.getAdapterPosition());
        holder.getBinding().setVariable(BR.person, person);
        holder.getBinding().executePendingBindings();

        holder.getBinding().exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("CLICK",
                        String.format("position = %d, holder.getAdapterPosition() = %d, size = %d",
                                position, holder.getAdapterPosition(), getItemCount()));
                mPeople.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPeople.size();
    }

    public void addPerson(Person person) {
        mPeople.add(0, person);
        notifyItemInserted(0);
    }
}
