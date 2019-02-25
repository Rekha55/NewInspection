package com.example.newinspection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataForCTB {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListCTB = new HashMap<String, List<String>>();

        List<String> CTB = new ArrayList<String> ();
        CTB.add("Buyers/Buisnessman");
        CTB.add("Warranty Cost");
        CTB.add("Transportation Cost");
        CTB.add("RTO Expenses");
        CTB.add("Insurance Cost");
        CTB.add("Taxes +Penalty");
        CTB.add("Refurb Cost");
        CTB.add("Parking Charges");
        CTB.add("Total Cost");


        expandableListCTB.put("CTB", CTB);

        return expandableListCTB;
    }}
