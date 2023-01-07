package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class DisplayFunction extends DialogFragment {
    private String nameInfo;
    public static final String name_info = "android.bignerdranch.criminalintent.name";
    private String numberInfo;
    public static final String number_info = "android.bignerdranch.criminalintent.number";
    private String emailInfo;
    public static final String email_info = "android.bignerdranch.criminalintent.email";

    @Override public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_add_crime, null);
        EditText nameField = (EditText) v.findViewById(R.id.person_name);
        EditText numberField = (EditText) v.findViewById(R.id.mobile_num);
        numberField.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        EditText emailField = (EditText) v.findViewById(R.id.person_email);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.add_information)
                .setPositiveButton(R.string.new_string, new DialogInterface.OnClickListener() {
              //  .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        nameInfo = nameField.getText().toString();
                        numberInfo = PhoneNumberUtils.formatNumber(numberField.getText().toString());
                        emailInfo = emailField.getText().toString();
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                })
                .create();

    }

    private void sendResult(int resultCode) {
        if(getTargetFragment() == null)
            return;

        Intent intent = new Intent();
        intent.putExtra(name_info, nameInfo);
        intent.putExtra(number_info, numberInfo);
        intent.putExtra(email_info, emailInfo);
        getTargetFragment().onActivityResult(
                getTargetRequestCode(), resultCode, intent);
    }
}



