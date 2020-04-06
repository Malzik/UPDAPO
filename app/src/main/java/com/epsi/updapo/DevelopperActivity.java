package com.epsi.updapo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.epsi.updapo.model.Developper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.Nullable;


public class DevelopperActivity extends UPDAPOActivity {

    private String data=" {\"items\": [{\"picture_url\": \"https://media-exp1.licdn.com/dms/image/C4D03AQGR0n7NZUPdzQ/profile-displayphoto-shrink_200_200/0?e=1585785600&v=beta&t=n9MuWSVf60XCUhan4TWRcB6kYy268hLisixB2p2f1BI\",\"last_name\": \"Heroin\",\"first_name\":\"Alexis\",\"mail\": \"alexis.heroin@epsi.fr\",\"description\": \"Je suis le boss du code Cutty sark scots whisky van winkle family reserve zombie, springbank lime rickey, widow’s cork. Glen scotia redline godfather bowmore bull shot aberlour gummy and coke snowball aberfeldy harvey wallbanger. Oban four horsemen critty bo old rip van winkle negroni, bloody aztec, crown royal paradise champagne cocktail redline flaming volcano. Stinger chimayó cocktail lemon split brandy manhattan presbyterian, old rip van winkle calvert glenfarclas toro rojo. Smirnoff mai-tai long island iced tea. French 75 three wise men glengoyne, bacardi orgasm balvenie strathmill bunnahabhain el presidente, dailuaine house of lords mudslide blue blazer.\"},{\"picture_url\": \"https://media-exp1.licdn.com/dms/image/C4D03AQHCL_Xle99KOQ/profile-displayphoto-shrink_200_200/0?e=1585785600&v=beta&t=WTBWYjNtyb9wjLUzs4DI_rcACnPHWQvNAJuwq0ACkVQ\",\"last_name\": \"Genevee\",\"first_name\": \"Damien\",\"mail\": \"damien.genevee@epsi.fr\", \"description\": \"Je suis le boss de la gestion de projet Paneer st. agur blue cheese cheese on toast. Halloumi pecorino macaroni cheese monterey jack melted cheese stinking bishop stinking bishop camembert de normandie. Chalk and cheese fromage frais cow cheddar fromage frais cheese strings queso boursin. Roquefort mascarpone cheeseburger.\"},{\"picture_url\": \"https://media-exp1.licdn.com/dms/image/C4E03AQGQVnMdGWDEYw/profile-displayphoto-shrink_200_200/0?e=1585785600&v=beta&t=-dG7kpQCNVEe2M64AdlJLBUgwJDhCy8QAhmhchFXCuw\",\"last_name\": \"Birac\", \"first_name\": \"Lucas\",\"mail\": \"lucas.birac@epsi.fr\", \"website\":\"sepradc-serv.ovh\", \"description\": \"J'aime les jeux vidéos 😋 Jelly tootsie roll pudding candy gummies cookie gingerbread. Lemon drops lollipop jelly. Liquorice fruitcake cake oat cake pastry tart donut chocolate sweet. Soufflé marshmallow tootsie roll gingerbread sweet roll candy canes.\"}]}";
    private ArrayList<Developper> developpers;

    public static void display(UPDAPOActivity activity){
        Intent intent=new Intent(activity, DevelopperActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
        showBackBtn();
        initData();
        ListView listView=findViewById(R.id.listViewCategories);
        DevelopperAdapter adapter=new DevelopperAdapter(this,R.layout.c_developper,developpers);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DevelopperDetailsActivity.display(DevelopperActivity.this,developpers.get(position));
            }
        });
    }

    private void initData() {
        developpers=new ArrayList<>();
        try {
            JSONObject jsonObject;
            jsonObject=new JSONObject(data);
            JSONArray jsonArray=jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                Developper student=new Developper(jsonArray.getJSONObject(i));
                developpers.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        displayToast(String.valueOf(developpers.size()));
    }
}
