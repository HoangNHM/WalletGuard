package hoangnhm.walletguard.Screen.custom;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hoangnhm.walletguard.Account.AccountContent;
import hoangnhm.walletguard.R;
import hoangnhm.walletguard.Screen.datePickerDlg.DatePickerFragment;

/**
 * Created by vantuegia on 10/7/2015.
 */
public class AddAdapter extends ArrayAdapter<AccountContent.AccountItem> {

    Activity mActivity;
    ArrayList<AccountContent.AccountItem> mArr;
    private FragmentManager mFragmentManager;
    private String mNumero;

    public AddAdapter(Activity activity, FragmentManager fragmentManager, ArrayList<AccountContent.AccountItem> arr) {
        super(activity, R.layout.item_add, arr);
        this.mActivity = activity;
        this.mFragmentManager = fragmentManager;
        this.mArr = arr;
        this.mNumero = this.mActivity.getResources().getText(R.string.Numero).toString();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == view) {
            LayoutInflater inflater = mActivity.getLayoutInflater();
            view = inflater.inflate(R.layout.item_add, null);
        }

        setContaintView(position, view);
        return view;
    }

    private void setContaintView(final int position, View view) {
        // Numero
        TextView tvNumero = (TextView) view.findViewById(R.id.tvNumero);
        tvNumero.setText(mNumero + (position + 1) + " | " + (mArr.get(position).mType == 1 ? "Thu" : "Chi"));

        // Button Del
        Button btnDel = (Button) view.findViewById(R.id.btnDel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // remove item, change listView
                mArr.remove(position);
                notifyDataSetChanged();
            }
        });

        // Button DatePicker
        final Button btnDatePicker = (Button) view.findViewById(R.id.btnDatePicker);
        btnDatePicker.setText(mArr.get(position).mTime);
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dlg = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnDatePicker.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                });
                dlg.show(AddAdapter.this.mFragmentManager, "DatePicker");
            }
        });

        // TODO Amount
        EditText etAmount = (EditText) view.findViewById(R.id.etAmount);
        etAmount.setText(mArr.get(position).mAmount + "");

        // btn Radio
        RadioGroup rgCollectSpend = (RadioGroup) view.findViewById(R.id.rgCollectSpend);
        rgCollectSpend.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                notifyDataSetChanged();
            }
        });

        final RadioButton rbCollect = (RadioButton) view.findViewById(R.id.rbCollect);
        rbCollect.setChecked(mArr.get(position).mType == 1);
        rbCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbCollect.setChecked(true);
                mArr.get(position).mType = 1;
            }
        });

        final RadioButton rbSpend = (RadioButton) view.findViewById(R.id.rbSpend);
        rbSpend.setChecked(mArr.get(position).mType == 0);
        rbSpend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbSpend.setChecked(true);
                mArr.get(position).mType = 0;
            }
        });
    }
}
