package com.epsi.updapo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.epsi.updapo.Model.Developper;
import com.squareup.picasso.Picasso;

public class DevelopperDetailsActivity extends UPDAPOActivity {
    private Developper developper;

    public static void display(UPDAPOActivity activity, Developper Developper){
        Intent intent=new Intent(activity,DevelopperDetailsActivity.class);
        intent.putExtra("Developper",Developper);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developper_details);
        showBackBtn();
        developper = (Developper) getIntent().getExtras().get("Developper");
        TextView textName = findViewById(R.id.textViewNameDetails);
        TextView textEmail = findViewById(R.id.textViewEmailDetails);
        ImageView imageViewDetails= findViewById(R.id.imageViewDevelopperDetails);

        textName.setText(developper.getName());
        textEmail.setText(developper.getMail());
        Picasso.get().load(developper.getPictureUrl()).into(imageViewDetails);

        setTitle(developper.getName());

    }
}
