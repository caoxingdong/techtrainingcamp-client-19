package com.example.bulletinboard2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class paraAdapter extends BaseAdapter {

    private Context mContext;
    private String[] pList;

    public paraAdapter(Context mContext, String[] pList) {
        this.mContext = mContext;
        this.pList = pList;
    }

    @Override
    public int getCount() {
        return pList.length;
    }

    @Override
    public Object getItem(int position) {
        return pList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String allText = pList[position];
        View v;
        boolean b1 = (allText.length() >= 2 && allText.charAt(0) == '#' && allText.charAt(1) == '#');
        boolean b2 = (allText.length() >= 3 && allText.charAt(1) == '#' && allText.charAt(2) == '#');
        if (b1 || b2) {
            v = View.inflate(mContext, R.layout.two_hashtag, null);
            TextView two_hashtag = v.findViewById(R.id.two_hashtag);
            if (b1) {
                two_hashtag.setText(allText.substring(2));
            }
            if (b2) {
                two_hashtag.setText(allText.substring(3));
            }
        }
        else if (allText.length() >= 1 && allText.charAt(0) == '#') {
            v = View.inflate(mContext, R.layout.one_hashtag, null);
            TextView one_hashtag = v.findViewById(R.id.one_hashtag);
            one_hashtag.setText(allText.substring(1));
        }
        else if (allText.length() >= 1 && allText.charAt(0) == '-') {
            v = View.inflate(mContext, R.layout.item, null);
            TextView item = v.findViewById(R.id.item);
            item.setText(allText);
        }
        else if (allText.equals("    ![](tancheng.jpg)")) {
            v = View.inflate(mContext, R.layout.img, null);
            ImageView img = v.findViewById(R.id.img);
            img.setImageResource(R.drawable.tancheng);
        }
        else if (allText.equals("![cover](teamBuilding_04.png)")) {
            v = View.inflate(mContext, R.layout.img, null);
            ImageView img = v.findViewById(R.id.img);
            img.setImageResource(R.drawable.team_building_04);
        }
        else {
            v = View.inflate(mContext, R.layout.para_layout, null);
            TextView para = v.findViewById(R.id.para);
            para.setText(allText);
        }
        return v;
    }
}
