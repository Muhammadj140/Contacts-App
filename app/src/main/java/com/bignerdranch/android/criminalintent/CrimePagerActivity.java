package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;
public class CrimePagerActivity extends FragmentActivity {
    private ViewPager2 mViewPager;
    private FragmentStateAdapter mCrimeAdapter;
    private List<Crime> mCrimes;


    public static final String EXTRA_CONTACT_ID =
            "com.bignerdranch.android.criminalintent.crime_id";

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(this);
        List<Crime> crimes = crimeLab.getCrimes();
        if (mCrimeAdapter == null) {
            mCrimeAdapter = new CrimeAdapter(this);
            mViewPager.setAdapter(mCrimeAdapter);
        } else {
            mCrimeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);

        mViewPager = (ViewPager2) findViewById(R.id.crime_view_pager);
        mCrimes = CrimeLab.get(this).getCrimes();
        mCrimeAdapter = new CrimeAdapter(this);
        mViewPager.setAdapter(mCrimeAdapter);

        mViewPager.setCurrentItem(0);
    }

    private class CrimeAdapter extends FragmentStateAdapter {

        public CrimeAdapter(FragmentActivity var1) {
            super(var1);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Crime crime = mCrimes.get(position);
            CrimeFragment crimeFragment = CrimeFragment.newInstance(crime.getId());

            return crimeFragment;
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 0) {

            super.onBackPressed();
        }
        else {

            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
        }
    }
}
