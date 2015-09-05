package mobileclass.kylesblogviewer;

import android.app.Activity;
import android.app.LauncherActivity;
import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 * <p/>
 * <p/>
 * interface.
 */
public class blogItemsFragment extends ListFragment {

    String[] numbers_text = new String[] { "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten", "eleven",
            "twelve", "thirteen", "fourteen", "fifteen" };
    String[] numbers_digits = new String[] { "1", "2", "3", "4", "5", "6", "7",
           "8", "9", "10", "11", "12", "13", "14", "15" };



        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                   inflater.getContext(), android.R.layout.simple_list_item_1,
                     numbers_text);
         setListAdapter(adapter);
          return super.onCreateView(inflater, container, savedInstanceState);
          }


}
