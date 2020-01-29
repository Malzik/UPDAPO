package com.epsi.updapo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.epsi.updapo.Model.Developper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DevelopperActivity extends UPDAPOActivity {

    private String data=" {\"items\": [{\"picture_url\": \"https://media-exp1.licdn.com/dms/image/C4D03AQGR0n7NZUPdzQ/profile-displayphoto-shrink_200_200/0?e=1585785600&v=beta&t=n9MuWSVf60XCUhan4TWRcB6kYy268hLisixB2p2f1BI\",\"name\": \"Heroin\",\"mail\": \"alexis.heroin@epsi.fr\"},{\"picture_url\": \"https://media-exp1.licdn.com/dms/image/C4D03AQHCL_Xle99KOQ/profile-displayphoto-shrink_200_200/0?e=1585785600&v=beta&t=WTBWYjNtyb9wjLUzs4DI_rcACnPHWQvNAJuwq0ACkVQ\",\"name\": \"Genevee\",\"mail\": \"damien.genevee@epsi.fr\"},{\"picture_url\": \"https://media-exp1.licdn.com/dms/image/C4E03AQGQVnMdGWDEYw/profile-displayphoto-shrink_200_200/0?e=1585785600&v=beta&t=-dG7kpQCNVEe2M64AdlJLBUgwJDhCy8QAhmhchFXCuw\",\"name\": \"Birac Lucas\",\"mail\": \"lucas.birac@epsi.fr\"}]}";
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
