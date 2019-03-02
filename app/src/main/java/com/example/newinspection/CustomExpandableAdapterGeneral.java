package com.example.newinspection;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
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
    ImageButton imgbtn;

    public CustomExpandableAdapterGeneral(Context context, List<String> listCTBTitle,
                                          HashMap<String, List<String>> listCTBDetail) {
        this.context = context;
        this.listGeneralTitle = listCTBTitle;
        this.listGeneralDetail = listCTBDetail;
    }

    public Object getChild(int listPosition, int expandedListPosition) {
        return this.listGeneralDetail.get (this.listGeneralTitle.get (listPosition))
                .get (expandedListPosition);
    }


    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public View getChildView(final int listPosition, final int expandedListPosition,
                             final boolean isLastChild, View convertView, ViewGroup parent) {
        View myConvertView = convertView;
        final List<String> item = new ArrayList<> ();
        ;
        final String expandedListText1 = (String) getChild (listPosition, expandedListPosition);
        if (convertView == null || !isLastChild || expandedListPosition ==this.listGeneralDetail.get(this.listGeneralTitle.get(listPosition))
                .size()-1) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate (R.layout.list_item_general, null);
        }
        imgbtn = (ImageButton) convertView.findViewById (R.id.imageButtonNewInspection);
        listGenerealText = (TextView) convertView.findViewById (R.id.generalTextId);
        listGeneralEditText = (EditText) convertView.findViewById (R.id.generalEditId);
        listGenerealText.setText (expandedListText1);
//        try{
//            Toast.makeText (context, listGeneralEditText.getText ().toString () + " ", Toast.LENGTH_SHORT).show ();
//
//        }catch(Exception e){
//            Toast.makeText (context, listGeneralEditText.getText ().toString () + "..." +e.getMessage (), Toast.LENGTH_SHORT).show ();
//
//        }

//        try {
//            imgbtn.setOnClickListener (new View.OnClickListener () {
//                @Override
//                public void onClick(View v) {
//                    int c = getChildrenCount (0);
//                    for (int i = 0; i < c; i++) {
//                        item.add (listGeneralEditText.getText ().toString ());
//                        Toast.makeText (context, listGeneralEditText.getText ().toString () + "...", Toast.LENGTH_SHORT).show ();
//                    }
//                }
//            });
//        } catch (Exception e) {
//            Toast.makeText (context, listGeneralEditText.getText ().toString () + " " + e.getMessage (), Toast.LENGTH_SHORT).show ();
//        }

//
//        listGeneralEditText.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//
//                listGeneralEditText.addTextChangedListener (new TextWatcher () {
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        // TODO Auto-generated method stub
//
//                    }
//
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count,
//                                                  int after) {
//                        // TODO Auto-generated method stub
//
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//                        // TODO Auto-generated method stub
//                        System.out.println ("Value : " + expandedListPosition + listGeneralEditText.getText ().toString ());
//                        Toast.makeText (context, listGeneralEditText.getText ().toString () + "...", Toast.LENGTH_SHORT).show ();
//                    }
//                });
//
//                listGeneralEditText.setOnTouchListener (new View.OnTouchListener () {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        v.getParent ().requestDisallowInterceptTouchEvent (true);
//                        switch (event.getAction () & MotionEvent.ACTION_MASK) {
//                            case MotionEvent.ACTION_UP:
//                                v.getParent ().requestDisallowInterceptTouchEvent (false);
//                                break;
//                        }
//                        return false;
//                    }
//                });
//                listGeneralEditText.addTextChangedListener (new TextWatcher () {
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        // TODO Auto-generated method stub
//
//                    }
//
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count,
//                                                  int after) {
//                        // TODO Auto-generated method stub
//
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//                        // TODO Auto-generated method stub
//                        System.out.println ("Value : " + expandedListPosition + listGeneralEditText.getText ().toString ());
//                        Toast.makeText (context, listGeneralEditText.getText ().toString () + "...", Toast.LENGTH_SHORT).show ();
//                    }
//                });
//
//            }
//
//        });
        return convertView;
    }

    @Override

    public boolean isChildSelectable(int glistPositiomroupPosition, int childPosition) {
        return true;
    }


    public int getChildrenCount(int listPosition) {
        return this.listGeneralDetail.get (this.listGeneralTitle.get (listPosition))
                .size ();
    }


    public Object getGroup(int listPosition) {
        return this.listGeneralTitle.get (listPosition);
    }


    public int getGroupCount() {
        return this.listGeneralTitle.size ();
    }


    public long getGroupId(int listPosition) {
        return listPosition;
    }


    public View getGroupView(int listPosition, boolean isExpanded, View convertView, ViewGroup
            parent) {
        String listTitle = (String) getGroup (listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate (R.layout.list_group, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById (R.id.listGroupId);
        listTitleTextView.setTypeface (null, Typeface.BOLD);
        listTitleTextView.setText (listTitle);
        return convertView;
    }


    public boolean hasStableIds() {
        return false;
    }

}
