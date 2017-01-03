package org.crazyit.ui;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by joris.tian on 2016/12/30.
 */

public class DummyFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceStatue) {

        TextView textView = new TextView(getActivity());

        textView.setGravity(Gravity.CENTER_HORIZONTAL);

        Bundle args = getArguments();

        textView.setText(args.getInt(ARG_SECTION_NUMBER) + "");
        textView.setTextSize(30);
        textView.setBackgroundColor(Color.GREEN);
        textView.setTextColor(Color.BLUE);
        return textView;
    }
}
