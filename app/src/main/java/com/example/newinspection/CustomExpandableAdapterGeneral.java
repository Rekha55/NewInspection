package com.example.newinspection;

import android.content.Context;
import android.graphics.Typeface;
import android.icu.util.RangeValueIterator;
import android.os.Build;
import android.renderscript.Element;
import android.support.annotation.RequiresApi;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableAdapterGeneral extends BaseExpandableListAdapter {
    //    EditText purposeEditText, bankValuationforEditText, contractNoEditText, requestFormEditText, assetMakeEditText, assetModelEditText, yearOfMfgEditText, repoDateEditText, rcAndFitnessEditText,
//            hmrKmrEDitText, chassisNoEditText, engineNoEditText, rcNoEditText, inspectorEditText, locationEditText, rcStatusEditText, inspectionDateEditText, taxStatusEditText;
    String purposeText, bankValuationforText, contractNoText, requestFormText, assetMakeText, assetModelText, yearOfMfgText, repoDateText, rcAndFitnessText,
            hmrKmrText, chassisNoText, engineNoText, rcNoText, inspectorText, locationText, rcStatusText, inspectionDateText, taxStatusText;
    String text;
    View v;
    TextView listGenerealText;
    EditText listGeneralEditText;
    private List<String> listGeneralTitle;
    private Context context;
    private HashMap<String, List<String>> listGeneralDetail;

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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View getChildView(final int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String expandedListText1 = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_general, null);
        }
        listGenerealText = (TextView) convertView.findViewById(R.id.generalTextId);
        listGeneralEditText = (EditText) convertView.findViewById(R.id.generalEditId);
        listGenerealText.setText(expandedListText1);



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


    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup parent) {
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
