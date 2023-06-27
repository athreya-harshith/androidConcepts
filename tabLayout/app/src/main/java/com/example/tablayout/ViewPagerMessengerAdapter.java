package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {

    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            return  new chatFragment();
        }
        else if (position == 1)
            return  new statusFragment();
        else
            return  new callsFragment();
    }

    @Override
    public int getCount() {
        return 3;//this is number of tabs (as tabs are associated to number of fragments)
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)//names in tabs
    {
        if(position == 0)
        {
            return  "Chats";
        }
        else if (position == 1)
            return  "Status";
        else
            return  "Calls";
    }
}
