package mobileclass.kylesblogviewer;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 9/2/2015.
 */
public class BlogListAdapter extends ArrayAdapter {
    Context mContext;

    public BlogListAdapter(Context context, List items){
        super(context, android.R.layout.simple_list_item_1, items);
        mContext = context;
    }

    public BlogListAdapter(Activity activity, int list, ArrayList<String> categories) {
        super(activity, list, categories);
    }

    private class ViewHolder{
        TextView titleText;
    }


}
