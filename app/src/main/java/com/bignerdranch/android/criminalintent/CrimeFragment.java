package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import java.util.UUID;

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private TextView showName;
    private TextView showNumber;
    private TextView showEmail;
    private static final int REQUEST_DATE = 0;
    private static final int REQUEST_CONTACT = 1;
    // DatePickerFragment's tag:
    private static final String DIALOG_DATE = "DialogDate";
    private static final String ARG_CRIME_ID = "crime_id";


    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPause() {
        super.onPause();
        CrimeLab.get(getActivity()).updateCrime(mCrime);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View v = inflater.inflate(R.layout.crime_fragment, container, false);

        Toolbar toolbar = (Toolbar) v.findViewById(R.id.information_item);
        toolbar.inflateMenu(R.menu.menu_1);
        Menu menu = toolbar.getMenu();

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.delete_info:
                        CrimeLab.get(getActivity()).deleteCrime(mCrime);
                        getActivity().finish();
                        return true;
                    default:
                        return false;
                }
            }
        });

        showName = (TextView) v.findViewById(R.id.person_name);
        showName.setText(String.format("Name: %s", mCrime.getTitle()));
        showNumber = (TextView) v.findViewById(R.id.mobile_num);
        showNumber.setText(String.format("Phone: %s", mCrime.getNumber()));
        showEmail = (TextView) v.findViewById(R.id.person_email);
        showEmail.setText(String.format("E-mail: %s", mCrime.getEmail()));

        return v;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_1, menu);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.delete_info:
                CrimeLab.get(getActivity()).deleteCrime(mCrime);
                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
