package org.crazyit.ui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by joris.tian on 2017/1/3.
 */

public class DummyFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView textView = new TextView(getActivity());
        textView.setGravity(Gravity.CENTER_HORIZONTAL);

        Bundle args = getArguments();

        textView.setText(args.getInt(ARG_SECTION_NUMBER) + "");
        textView.setTextSize(30);
        return textView;

    }
}
