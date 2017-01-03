package org.crazyit.ui;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final ExpandableListAdapter adapter = new BaseExpandableListAdapter() {

            int[] logos = new int[]{
                    R.drawable.p,
                    R.drawable.z,
                    R.drawable.t
            };
            private String[] armTypes = new String[]{
                    "神族兵种",
                    "虫族兵种",
                    "人族兵种"
            };

            private String[][] arms = new String[][]{
                    {"狂战士", "龙骑士", "黑暗殿", "电兵"},
                    {"小狗", "刺蛇", "飞龙", "自爆飞机",},
                    {"机枪兵", "护士MM", "幽灵"}
            };

            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return armTypes[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }
            private TextView getTextView()
            {
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,64  );
                TextView textView = new TextView(MainActivity.this);
                textView.setLayoutParams(layoutParams);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(30,0,0,0);
                textView.setTextSize(20);
                return  textView;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout  linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(0);
                ImageView logo = new ImageView(MainActivity.this);
                logo.setImageResource(logos[i]);
                linearLayout.addView(logo);

                TextView textView = getTextView();
                textView.setText(getGroup(i).toString());
                linearLayout.addView(textView);
                return linearLayout;
            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView = getTextView();
                textView.setText(getChild(i,i1).toString());
                textView.setPadding(80,0,0,0);
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return false;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int i) {

            }

            @Override
            public void onGroupCollapsed(int i) {

            }

            @Override
            public long getCombinedChildId(long l, long l1) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long l) {
                return 0;
            }
        };

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
        expandableListView.setAdapter(adapter);
    }
}
