package com.pixelhubllc.customadapterdiffrentarraysize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dialoge1 = new ArrayList<String>();
    ArrayList<String> dialoge2 = new ArrayList<String>();
    ArrayList<String> btranslation1 = new ArrayList<String>();
    ArrayList<String> btranslation2 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String title1[] = getResources().getStringArray(R.array.items_name2);
        String descriptions1[] = getResources().getStringArray(R.array.item_description);
        String title2[] = getResources().getStringArray(R.array.items_name2);
        String descriptions2[] = getResources().getStringArray(R.array.item_description2);

        String dialogeGet = "tarekDATA.=parek=hasan=harek=ver=okok=no=hasan=harek=ver=okoklast=parek=hasan=harek=ver=okok=no=bug=fix.";
        String btranslationGet = "tarekD.=parekD=hasanD=harekD=verD=okokD=noD=hasanD=harekD=verD=okokDlastD=parek=hasan=harek=ver=okok=no=bug=fix.";




        ListView itemsListView = (ListView) findViewById(R.id.list_view_items);


//        CustomListAdapter adapter = new CustomListAdapter(this, Arrays.asList(title1), Arrays.asList(descriptions1));
//        itemsListView.setAdapter(adapter);

        CustomListAdapter3 conversationDetailsAdapter =
                new CustomListAdapter3(this,dialouge1split(dialogeGet), trasnlation1split(btranslationGet), dialouge2split(dialogeGet), trasnlation2split(btranslationGet));

        itemsListView.setAdapter(conversationDetailsAdapter);

    }

    //string(dialouge) spliting in sentence
    public ArrayList<String> dialouge1split(String s){
        Log.e("Split1", "String s: " + s);
        Pattern p = Pattern.compile("=");
        String[] str = p.split(s);


        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                dialoge1.add(str[i]);
            }
        }


        return dialoge1;
    }

    public ArrayList<String> dialouge2split(String s){

        Pattern p = Pattern.compile("=");
        String[] str = p.split(s);
        for (int i = 0; i < str.length; i++) {
            if (i % 2 != 0) {
                dialoge2.add(str[i]);
            }
        }

        return dialoge2;
    }

    //bangla translation translation split
    public ArrayList<String> trasnlation1split(String s){
        Pattern p = Pattern.compile("=");
        String[] str = p.split(s);
        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                btranslation1.add(str[i]);
            }
        }
        return btranslation1;
    }

    public ArrayList<String> trasnlation2split(String s){
        Pattern p = Pattern.compile("=");
        String[] str = p.split(s);
        for (int i = 0; i < str.length; i++) {
            if (i % 2 != 0) {
                btranslation2.add(str[i]);
            }
        }
        return btranslation2;
    }
}