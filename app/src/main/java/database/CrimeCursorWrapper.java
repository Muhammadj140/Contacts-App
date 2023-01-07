/*
package database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.contactlist.Crime;

import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) { super(cursor); }

    public Crime getContact() {
        String uuidString = getString(getColumnIndex(ContactDbSchema.ContactTable.Cols.UUID));
        String contactName = getString(getColumnIndex(ContactDbSchema.ContactTable.Cols.CONTACTNAME));
        String number = getString(getColumnIndex(ContactDbSchema.ContactTable.Cols.NUMBER));
        String email = getString(getColumnIndex(ContactDbSchema.ContactTable.Cols.EMAIL));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setName(contactName);
        crime.setNumber(number);
        crime.setEmail(email);

        return crime;
    }
}


 */



package database;

        import android.database.Cursor;
        import android.database.CursorWrapper;

        import com.bignerdranch.android.criminalintent.Crime;

        import java.util.UUID;

public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) { super(cursor); }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.UUID));
        String contactName = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.PERSONNAME));
        String number = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.NUMBER));
        String email = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.DATE));
        String solved = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(contactName);
        crime.setNumber(number);
        crime.setEmail(email);

        return crime;
    }
}

