package com.pixelhubllc.customadapterdiffrentarraysize;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {


    private List<String> titleData = null;
    private List<String> description = null;
    private LayoutInflater mInflater;


    public CustomListAdapter(Context context, List<String> title, List<String> description) {
        this.titleData = title;
        this.description = description;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {


        return titleData.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // A ViewHolder keeps references to children views to avoid unnecessary calls
        // to findViewById() on each row.
        ViewHolder holder;

        // When convertView is not null, we can reuse it directly, there is no need
        // to reinflate it. We only inflate a new View when the convertView supplied
        // by ListView is null.
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.layout_list_view_row_items, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();

            holder.titleTv = (TextView) convertView.findViewById(R.id.text_view_item_name);
            holder.descriptionTv = (TextView) convertView.findViewById(R.id.text_view_item_description);

            // Bind the data efficiently with the holder.

            convertView.setTag(holder);

        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }


        holder.titleTv.setText(titleData.get(position));
        if(position<description.size()){
            holder.descriptionTv.setText(description.get(position));
        } else{
            holder.descriptionTv.setVisibility(View.GONE);
        }


//        holder.titleTv.setText(titleData.get(position));
//        if (position <= description.size()){
//            holder.descriptionTv.setText(description.get(position));
//        }


//        }
//
//        for (int i=0; i<description.size(); i++){
//            if (position <= description.size(){
//                holder.descriptionTv.setText(description.get(position));
//            }
//            holder.descriptionTv.setText("empty");
//        }

//
//
//        if (titleData.size() > description.size()) {
//                holder.descriptionTv.setText("empty");
//            } else {
//                holder.titleTv.setText(titleData.get(position));
//                holder.descriptionTv.setText(description.get(position));
//            }


        // If weren't re-ordering this you could rely on what you set last time


        return convertView;
    }

    static class ViewHolder {
        TextView titleTv;
        TextView descriptionTv;
    }

}