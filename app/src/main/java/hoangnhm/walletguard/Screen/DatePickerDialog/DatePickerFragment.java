package hoangnhm.walletguard.Screen.DatePickerDialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by vantuegia on 9/30/2015.
 */
public class DatePickerFragment extends DialogFragment {

    private DatePickerDialog.OnDateSetListener mListener;

    public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener onDateSetListener) {
        DatePickerFragment fm = new DatePickerFragment();
        fm.setOnPickerListener(onDateSetListener);
        return fm;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int date = c.get(Calendar.DATE);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        return new DatePickerDialog(getActivity(), mListener, year, month, date);
    }

    private void setOnPickerListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mListener = onDateSetListener;
    }

}
