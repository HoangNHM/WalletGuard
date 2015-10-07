package hoangnhm.walletguard.Screen.custom;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import hoangnhm.walletguard.Screen.datePickerDlg.DatePickerFragment;

/**
 * Created by vantuegia on 10/7/2015.
 */
public class BtnDatePicker extends Button {

    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private FragmentManager mFmManager;
    public BtnDatePicker(Context context,FragmentManager fmManager, DatePickerDialog.OnDateSetListener onDateSetListener) {
        super(context);
        this.mOnDateSetListener = onDateSetListener;
        this.mFmManager = fmManager;
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        super.setOnClickListener(l);
        DialogFragment dlgFm = DatePickerFragment.newInstance(this.mOnDateSetListener);
        dlgFm.show(this.mFmManager, "DatePicker");

    }
}
