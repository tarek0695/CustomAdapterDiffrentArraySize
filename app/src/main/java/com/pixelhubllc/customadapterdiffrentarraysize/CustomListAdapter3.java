package com.pixelhubllc.customadapterdiffrentarraysize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter3 extends BaseAdapter {


    private List<String> titleData1 = null;
    private List<String> description1 = null;

    private List<String> titleData2 = null;
    private List<String> description2 = null;
    private LayoutInflater mInflater;


    public CustomListAdapter3(Context context, List<String> title1, List<String> description1,
                              List<String> title2, List<String> description2) {
        this.titleData1 = title1;
        this.description1 = description1;
        this.titleData2 = title2;
        this.description2 = description2;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {


        return titleData1.size();
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
            convertView = mInflater.inflate(R.layout.custom_dialouge, null);

            // Creates a ViewHolder and store references to the two children views
            // we want to bind data to.
            holder = new ViewHolder();

            holder.titleTv1 = (TextView) convertView.findViewById(R.id.dialouge_tv1);
            holder.descriptionTv1 = (TextView) convertView.findViewById(R.id.translation_tv1);
            holder.titleTv2 = (TextView) convertView.findViewById(R.id.dialouge_tv2);
            holder.descriptionTv2 = (TextView) convertView.findViewById(R.id.translation_tv2);
            holder.speakerRight = (ImageView) convertView.findViewById(R.id.speaker_right);
            holder.pepople2 = (ImageView) convertView.findViewById(R.id.pepole2);

            // Bind the data efficiently with the holder.

            convertView.setTag(holder);

        } else {
            // Get the ViewHolder back to get fast access to the TextView
            // and the ImageView.
            holder = (ViewHolder) convertView.getTag();
        }


        holder.titleTv1.setText(titleData1.get(position));
        holder.descriptionTv1.setText(description1.get(position));

        if (position < titleData2.size()) {
            holder.titleTv2.setText(titleData2.get(position));
            holder.descriptionTv2.setText(description2.get(position));
        } else {
            holder.titleTv2.setVisibility(View.GONE);
            holder.descriptionTv2.setVisibility(View.GONE);
            holder.speakerRight.setVisibility(View.GONE);
            holder.pepople2.setVisibility(View.GONE);
        }


//        if(position<description.size()){
//            holder.descriptionTv.setText(description.get(position));
//        } else{
//            holder.descriptionTv.setVisibility(View.GONE);
//        }


        // If weren't re-ordering this you could rely on what you set last time


        return convertView;
    }

    static class ViewHolder {
        TextView titleTv1;
        TextView titleTv2;
        TextView descriptionTv1;
        TextView descriptionTv2;
        ImageView speakerRight;
        ImageView pepople2;
    }

}