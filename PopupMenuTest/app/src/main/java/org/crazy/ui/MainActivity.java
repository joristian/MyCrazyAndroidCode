package org.crazy.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;


public class MainActivity extends Activity {

    PopupMenu popupMenu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onPopupButtonClick(View soure) {
        popupMenu = new PopupMenu(this, soure);

        getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.exit:
                                popupMenu.dismiss();
                                break;

                            default:
                                Toast.makeText(MainActivity.this, "Click" + menuItem.getItemId() + "menu",
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }

                        return true;
                    }

                }
        );

        popupMenu.show();
    }
}
