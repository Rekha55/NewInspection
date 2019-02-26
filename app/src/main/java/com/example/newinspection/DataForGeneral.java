package com.example.newinspection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataForGeneral {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListGeneral = new HashMap<String, List<String>>();

        List<String> General = new ArrayList<String>();
        General.add("Purpose");
        General.add("Bank / Valuation for");
        General.add("Vehicle Plate Number");
        General.add("Contract No.");
        General.add("Request from");
        General.add("Asset Make");
        General.add("Asset Model");
        General.add("Year of mfg");
        General.add("Repossession Date");
        General.add("RC & Fitness Valid");
        General.add("HMR/KMR");
        General.add("Chassis No.");
        General.add("Engine No");
        General.add("RC NO");
        General.add("Inspector");
        General.add("Location");
        General.add("RC Status");
        General.add("Inspection Date");
        General.add("Tax Status");


        expandableListGeneral.put("Basic Information", General);

        return expandableListGeneral;
    }
}
