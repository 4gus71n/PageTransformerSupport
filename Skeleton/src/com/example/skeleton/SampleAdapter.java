package com.example.skeleton;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SampleAdapter extends FragmentStatePagerAdapter {
    Context ctxt = null;

    public SampleAdapter(Context ctxt, FragmentManager mgr) {
        super(mgr);
        this.ctxt = ctxt;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
        case 0:
            return new SimpleFragment("Hi");
        case 1:
            return new SimpleFragment("There");
        case 2:
            return new SimpleFragment("Fella");
        }
        return null;
    }

    @Override
    public String getPageTitle(int position) {
        switch (position) {
        case 0:
            return "First Tab";
        case 1:
            return "Second Tab";
        case 2:
            return "Third Tab";
        }
        return null;
    }
}