package com.example.newinspection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListViewParameters, expandableListViewCTB, expandableListViewGeneral;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListAdapter expandableListAdapterCTB;
    ExpandableListAdapter expandableListAdapterGeneral;
    List<String> expandableListTitle, expandableListTitleCTB, expandableListTitleGeneral;
    HashMap<String, List<String>> expandableListDetail, expandableListDetailCTB, expandableListDetailGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ExpandableSetForGenerals();
        ExpandableSetForCTB();
        ExpandableSetForParameters();

    }

    public void OnSubmitNewInspection(View view){
       // Intent pass
    }

//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.activity_main, container, false);
//        expandableListViewCTB = (ExpandableListView) rootView.findViewById(R.id.expandableListViewCTB);
//
//        // preparing list data
//        expandableListTitleCTB = new ArrayList<String>();
//        expandableListDetailCTB = new HashMap<String, List<String>>();
//
//        // Adding child data
//        expandableListTitleCTB.add("Rider and Trainer Info");
//        expandableListTitleCTB.add("Horse and Owner Info");
//
//        // Adding child data
//        ListData1CTB = new ArrayList<String>();
//        ListData1CTB.add("horse");
//
//        ListData2CTB = new ArrayList<String>();
//
//
//        expandableListDetailCTB.put(expandableListTitleCTB.get(0), ListData1CTB); // Header, Child data
//        expandableListDetailCTB.put(expandableListTitleCTB.get(1), ListData2CTB);
//
//        Context context = this.getApplicationContext();
//        expandableListAdapterCTB = new CustomExpandableAdapterCTB(context, expandableListTitleCTB, expandableListDetailCTB);
//
//        // setting list adapter
//        expandableListViewCTB.setAdapter(expandableListAdapterCTB);
//
//
//
//        value1 = (TextView) rootView.findViewById(R.id.ctbValue1Id);
//        value2 = (TextView) rootView.findViewById(R.id.ctbValue2Id);
//        value1.setText("Expired On: " + paid);
//        value2.setText("Email: " + email);
//        return rootView;
//
//    }

    public void ExpandableSetForGenerals() {
        expandableListViewGeneral = (ExpandableListView) findViewById(R.id.expandableListViewGeneralInputs);
        expandableListDetailGeneral = DataForGeneral.getData();
        expandableListTitleGeneral = new ArrayList<String>(expandableListDetailGeneral.keySet());
        expandableListAdapterGeneral = new CustomExpandableAdapterGeneral(this, expandableListTitleGeneral, expandableListDetailGeneral);
        expandableListViewGeneral.setAdapter(expandableListAdapterGeneral);
        expandableListViewGeneral.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitleGeneral.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListViewGeneral.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitleGeneral.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListViewGeneral.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitleGeneral.get(groupPosition)
                                + " -> "
                                + expandableListDetailGeneral.get(
                                expandableListTitleGeneral.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }

    public void ExpandableSetForCTB() {
        expandableListViewCTB = (ExpandableListView) findViewById(R.id.expandableListViewCTB);
        expandableListDetailCTB = DataForCTB.getData();
        expandableListTitleCTB = new ArrayList<String>(expandableListDetailCTB.keySet());
        expandableListAdapterCTB = new CustomExpandableAdapterCTB(this, expandableListTitleCTB, expandableListDetailCTB);
        expandableListViewCTB.setAdapter(expandableListAdapterCTB);
        expandableListViewCTB.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitleCTB.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListViewCTB.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitleCTB.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListViewCTB.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitleCTB.get(groupPosition)
                                + " -> "
                                + expandableListDetailCTB.get(
                                expandableListTitleCTB.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }


    public void ExpandableSetForParameters() {
        expandableListViewParameters = (ExpandableListView) findViewById(R.id.expandableListViewParameters);
        expandableListDetail = DataForParameters.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableAdapterParameters(this, expandableListTitle, expandableListDetail);
        expandableListViewParameters.setAdapter(expandableListAdapter);
        expandableListViewParameters.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListViewParameters.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListViewParameters.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }


}