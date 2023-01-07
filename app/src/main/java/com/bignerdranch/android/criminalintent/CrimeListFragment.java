package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class CrimeListFragment extends Fragment {

    private RecyclerView mCrimeRecyclerView;
  //   private CrimeAdapter mAdapter;
    private static final String show_1 = "CrimelabFragment";
    private boolean mSubTitleVisible;
    private Button viewInformation;
    private Button addInformation;
    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";
    private static final int request = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start,container,false);
        viewInformation = (Button) view.findViewById(R.id.view_information);
        viewInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), CrimePagerActivity.class);
                startActivity(intent);
            }
        });

        addInformation = (Button) view.findViewById(R.id.add_information);
        addInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager var = getParentFragmentManager();
                DisplayFunction dialog = new DisplayFunction();
                dialog.setTargetFragment(CrimeListFragment.this, request);
                dialog.show(var, SAVED_SUBTITLE_VISIBLE);
            }
        });
        return view;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) return;
        if (requestCode == request) {
            Crime crime = new Crime();
            String name = data.getStringExtra(DisplayFunction.name_info);
            String number = data.getStringExtra(DisplayFunction.number_info);
            String email = data.getStringExtra(DisplayFunction.email_info);
            crime.setTitle(name);
            crime.setNumber(number);
            crime.setEmail(email);

            Log.d(show_1, name + ", " + number + ", " + email);

            CrimeLab.get(getActivity()).addCrime(crime);
        }
    }
}
