package hoangnhm.walletguard.Account;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vantuegia on 9/29/2015.
 */
public class AccountContent {

    public static ArrayList<AccountItem> ITEMS = new ArrayList<AccountItem>();

    @SuppressLint("UseSparseArrays")
    public static Map<Integer, AccountItem> ITEM_MAP = new HashMap<Integer, AccountItem>();

    static {
        addItem(new AccountItem(1, 100, "29/09/2015", 1));
        addItem(new AccountItem(2, 1000, "29/09/2015", 2));
        addItem(new AccountItem(3, 10000, "29/09/2015", 3));
    }

    public static void addItem(AccountItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.mId, item);
    }

    public static class AccountItem {
        public int mId;
        public int mAmount;
        public String mTime;
        public int mType;

        public AccountItem(int mId, int mAmount, String mTime, int mType) {
            this.mId = mId;
            this.mAmount = mAmount;
            this.mTime = mTime;
            this.mType = mType;
        }
    }
}
