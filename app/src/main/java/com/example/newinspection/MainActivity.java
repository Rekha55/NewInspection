package com.example.newinspection;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String purposeText, bankValuationforText, contractNoText, requestFormText, assetMakeText, assetModelText, yearOfMfgText, repoDateText, rcAndFitnessText,
            hmrKmrText, chassisNoText, engineNoText, rcNoText, inspectorText, locationText, rcStatusText, inspectionDateText, taxStatusText;

    ExpandableListView expandableListViewParameters, expandableListViewCTB, expandableListViewGeneral;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListAdapter expandableListAdapterCTB;
    ExpandableListAdapter expandableListAdapterGeneral;
    List<String> expandableListTitle, expandableListTitleCTB, expandableListTitleGeneral;
    HashMap<String, List<String>> expandableListDetail, expandableListDetailCTB, expandableListDetailGeneral;
    EditText editTextForGenerals;
    TextView tvGeneral,tvParameters,tvCTBtitle,tvCTBdetail;
    ImageButton imgbtn;
    Spinner spinnerParameters;

    View v;
    List<String> dataOfSpinner;
    String[] itemOfSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TypeCast();
        ExpandableSetForGenerals();
        ExpandableSetForCTB();
        ExpandableSetForParameters();

    }
    public void TypeCast(){
        editTextForGenerals = (EditText)findViewById(R.id.generalEditId);
        tvCTBdetail=(TextView)findViewById (R.id.ctbValue2Id);
        tvCTBtitle=(TextView)findViewById (R.id.ctbValue1Id);
        tvGeneral=(TextView)findViewById (R.id.generalTextId);
        tvParameters=(TextView)findViewById (R.id.listChildTextId);
        imgbtn=(ImageButton)findViewById (R.id.imageButtonNewInspection);

  }





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
               Log.d ("collapse--->"," "+ expandableListDetailGeneral.get (1));

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
                        expandableListTitle + " List Collapsed.",
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

    public void OnSubmitNewInspection(View view){


        createPdf(editTextForGenerals.getText ().toString ());

        final Intent iSubmitNewInspection= new Intent(MainActivity.this,DisplayReport.class);
        startActivity(iSubmitNewInspection);
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void createPdf(String text){
        // create a new document
        PdfDocument document = new PdfDocument();
        // crate a page description

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);

        canvas.drawText(text, 20, 60, paint);
        // canvas.drawText(description,1,20,20.0f,30.0f,paint);
        //canvas.drawt
        // finish the page
        document.finishPage(page);
// draw text on the graphics object of the page

        // write the document content
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Valuation Reports/";
       Log.d("data -------->", directory_path);
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        String targetPdf = directory_path+currentDateTimeString+".pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));

        } catch (IOException e) {
            Log.e("main", "error "+e.toString());

        }
        // close the document
        document.close();
    }

    class ViewHolder {
        //Log.e("text view",txtListChild.toString());
        TextView lblListHeader;
        HashMap<Integer, HashMap<Integer, View>> multiHash = new HashMap<>();
        HashMap<Integer, View> innerHashMap;


        public ViewHolder(View v) {
            innerHashMap = new HashMap<>();
            lblListHeader = v.
                    findViewById(R.id.listGroupId);


        }

        public View getInnerView(int pos, int groupPos) {
            return multiHash.get(groupPos).get(pos);
        }


//        lblListHeader.setTypeface(null, Typeface.BOLD);
//        lblListHeader.setText(headerTitle.getCatName());

        public void setInnerView(int pos, int groupPos, View innerView) {

            innerHashMap.put(pos, innerView);
            multiHash.put(groupPos, innerHashMap);


        }
    }
}