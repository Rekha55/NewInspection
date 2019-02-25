package com.example.newinspection;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableAdapterGeneral extends BaseExpandableListAdapter {

    private List<String> listGeneralTitle;
    private Context context;
    private HashMap<String,List<String>> listGeneralDetail;

    public CustomExpandableAdapterGeneral(Context context, List<String> listCTBTitle,
                                      HashMap<String, List<String>> listCTBDetail) {
        this.context = context;
        this.listGeneralTitle = listCTBTitle;
        this.listGeneralDetail = listCTBDetail;
    }

    public Object getChild(int listPosition, int expandedListPosition) {
        return this.listGeneralDetail.get(this.listGeneralTitle.get(listPosition))
                .get(expandedListPosition);
    }


    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText1 = (String) getChild(listPosition, expandedListPosition);


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_general, null);
        }
        TextView listGenerealText = (TextView) convertView .findViewById(R.id.generalTextId);
        //   TextView listCtbValue2 = (TextView) convertView .findViewById(R.id.ctbValue2Id);
        listGenerealText.setText (expandedListText1);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


    public int getChildrenCount(int listPosition) {
        return this.listGeneralDetail.get(this.listGeneralTitle.get(listPosition))
                .size();
    }


    public Object getGroup(int listPosition) {
        return this.listGeneralTitle.get(listPosition);
    }


    public int getGroupCount() {
        return this.listGeneralTitle.size();
    }


    public long getGroupId(int listPosition) {
        return listPosition;
    }


    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listGroupId);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }


    public boolean hasStableIds() {
        return false;
    }


}
