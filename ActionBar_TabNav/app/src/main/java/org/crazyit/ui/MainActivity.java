package org.crazyit.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements  ActionBar.TabListener      {

    private static final String SELECTED_ITEM = "selecte_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final ActionBar actionBar = getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("FirstTab").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("SecondTab").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("ThirdTab").setTabListener(this));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(SELECTED_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(SELECTED_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM,
                getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public  void  onTabUnselected(ActionBar.Tab tab,
                                  FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab,
                              FragmentTransaction fragmentTransaction) {

        Fragment fragment = new DummyFragment();

        Bundle args = new Bundle();

        args.putInt(DummyFragment.ARG_SECTION_NUMBER,
                tab.getPosition()+1);

        fragment.setArguments(args);

        FragmentTransaction ft = getFragmentManager().beginTransaction();

		ft.replace(R.id.container, fragment);
        ft.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab,
                                FragmentTransaction fragmentTransaction) {

    }
}
