package com.example.newinspection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataForParameters {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> Engine = new ArrayList<String>();
        Engine.add("Silencer");
        Engine.add("Abnormal Engine Noise");
        Engine.add("Plugs");
        Engine.add("Oil");
        Engine.add("Raidaitor/Condensor");
        Engine.add("Oil Leakage");
        Engine.add("Fan Belts");
        Engine.add("Filters");

        List<String> Suspension = new ArrayList<String>();
        Suspension.add("Suspension Noise While \n Driving Front and Rear");


        List<String> Steering = new ArrayList<String> ();
        Steering.add("Steering Lock");
        Steering.add("Wheel Alingment/ \n Balancing/ Wobbling");
        Steering.add("Steering Operation");


        List<String> Brakes = new ArrayList<String> ();
        Brakes.add("Pedal Operation");
        Brakes.add("Brakes and Hand Brake");

        List<String> Transmission = new ArrayList<String> ();
        Transmission.add("Gear Engagement");
        Transmission.add("Gear EngagementDifferential And \n Crown Rear Wheel Drive");

        List<String> Electrical = new ArrayList<String> ();
        Electrical.add("Instrument Cluster - \n Warning Lights/Gauges");
        Electrical.add("Alternator");
        Electrical.add("Fuel Pump");
        Electrical.add("Battery Condition");
        Electrical.add("Starter Motor");


        List<String> AC_Function = new ArrayList<String> ();
        AC_Function.add("Cooling");
        AC_Function.add("Heating");

        List<String> Exterior = new ArrayList<String> ();
        Exterior.add("Frame/Underbody");
        Exterior.add("Wind screen");
        Exterior.add("Wiper Blades");
        Exterior.add("Indicators");
        Exterior.add("Headlights");
        Exterior.add("Internal & Rear View Mirrors");
        Exterior.add("Tail Lights");

        List<String> Interiors = new ArrayList<String> ();
        Interiors.add("Power Windows Front");
        Interiors.add("Central Locking");
        Interiors.add("Toolkit");
        Interiors.add("Power Windows Back");
        Interiors.add("Condition of Seats");
        Interiors.add("Horn");
        Interiors.add("Roof Wear & Tear");
        Interiors.add("Headlamp/Indicator Switches");


        List<String> Tyre_Condition = new ArrayList<String> ();
        Tyre_Condition.add("Wheel-Right Front");
        Tyre_Condition.add("Wheel-Right Rear");
        Tyre_Condition.add("Wheel-Left Front");
        Tyre_Condition.add("Wheel-Left Rea");
        Tyre_Condition.add("Wheel Stephaney");

        List<String> Accessories = new ArrayList<String> ();
        Accessories.add("Seat Covers");
        Accessories.add("Fog Lamps");
        Accessories.add("Music System");
        Accessories.add("Floor Mats");
        Accessories.add("Speakers");
        Accessories.add("Tipping Systems");
        Accessories.add("Odometer");

        expandableListDetail.put("Engine", Engine);
        expandableListDetail.put("Suspension", Suspension);
        expandableListDetail.put("Steering", Steering);
        expandableListDetail.put("Brakes", Brakes);
        expandableListDetail.put("Transmission", Transmission);
        expandableListDetail.put("Electrical", Electrical);
        expandableListDetail.put("AC Function", AC_Function);
        expandableListDetail.put("Exterior", Exterior);
        expandableListDetail.put("Interiors", Interiors);
        expandableListDetail.put("Tyre Condition", Tyre_Condition);
        expandableListDetail.put("Accessories", Accessories);


        return expandableListDetail;
    }
}
