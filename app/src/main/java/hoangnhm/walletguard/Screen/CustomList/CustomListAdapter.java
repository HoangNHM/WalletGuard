package hoangnhm.walletguard.Screen.CustomList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hoangnhm.walletguard.Account.AccountContent;
import hoangnhm.walletguard.R;

/**
 * Created by vantuegia on 9/29/2015.
 */
public class CustomListAdapter extends ArrayAdapter<AccountContent.AccountItem> {

    Activity mActivity;
    ArrayList<AccountContent.AccountItem> mItemArrayList;

    public CustomListAdapter(Activity activity, ArrayList<AccountContent.AccountItem> itemArrayList) {
        super(activity, R.layout.account_item_layout, itemArrayList);
        this.mActivity = activity;
        this.mItemArrayList = itemArrayList;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = mActivity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.account_item_layout, null);

        TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
        tvId.setText(mItemArrayList.get(position).mId + "asdf");
        return convertView;
    }
}
