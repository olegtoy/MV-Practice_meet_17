package com.practice.olegtojgildin.mvpractice_meet_17.databinding;

public class AppDataBindingComponent implements android.databinding.DataBindingComponent {
    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();
    }
}
