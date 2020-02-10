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

        TextView textLastName = findViewById(R.id.textViewLastNameDetails);
        TextView textFirstName = findViewById(R.id.textViewFirstNameDetails);
        TextView textEmail = findViewById(R.id.textViewEmailDetails);
        TextView textDescription = findViewById(R.id.textViewDescription);
        TextView textWebsite = findViewById(R.id.textViewWebSite);
        ImageView imageViewDetails= findViewById(R.id.imageViewDevelopperDetails);

        textLastName.setText(developper.getLastName());
        textFirstName.setText(developper.getFirstName());
        textEmail.setText(developper.getMail());
        textWebsite.setText(developper.getWebsite());
        textDescription.setText(developper.getDescription());
        Picasso.get().load(developper.getPictureUrl()).into(imageViewDetails);

        setTitle(developper.getFirstName());

    }
}
