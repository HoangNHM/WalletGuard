package hoangnhm.walletguard;

import android.app.ActionBar;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import hoangnhm.walletguard.Screen.AddFragment;
import hoangnhm.walletguard.Screen.HomeFragment;
import hoangnhm.walletguard.Screen.HistoryFragment;

public class MainActivity extends AppCompatActivity
implements HomeFragment.OnHomeFmInteractionListener,
        HistoryFragment.OnListFmInteractionListener,
        AddFragment.OnInputFmInteractionListener{

    public static final String TAG = MainActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Hide the status bar.
//        hideStatusBar();
        // Show Home Page
        showHomePage();
    }

    /**
     * Hide status and notification bar
     */
    private void hideStatusBar() {
        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        if (Build.VERSION.SDK_INT < 16) {
            Log.i(TAG, "<16");
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            Log.i(TAG, ">=16");
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            ActionBar actionBar = getActionBar();
            if (null != actionBar) {
                Log.i(TAG, "hide actionbar");
                actionBar.hide();
            }
        }
    }

    /**
     * Show Home Page
     */
    private void showHomePage() {
        HomeFragment homeFragment = new HomeFragment();
        // Add the fragment to the 'fragment_container' FrameLayout
        getSupportFragmentManager().beginTransaction()
                .add(R.id.mFmContainer, homeFragment).commit();
    }
    @Override
    public void onHomeFmInteraction(int btnId) {
        Fragment newFragment = null;

        switch (btnId) {
            case R.id.mBtnInput:
                newFragment = new AddFragment();
                break;
            case R.id.mBtnList:
                newFragment = new HistoryFragment();
                break;
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this newFragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.mFmContainer, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onListFmInteraction(Uri uri) {

    }

    @Override
    public void onInputFmInteraction(Uri uri) {

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
