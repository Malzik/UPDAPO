package com.epsi.updapo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.epsi.updapo.Model.Developper;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DevelopperAdapter extends ArrayAdapter<Developper> {

    public DevelopperAdapter(@NonNull Context context, int resource, @NonNull List<Developper> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.c_developper, null);

        TextView textViewName=convertView.findViewById(R.id.textViewName);
        TextView textViewEmail=convertView.findViewById(R.id.textViewMail);
        ImageView imageView=convertView.findViewById(R.id.imageViewDevelopper);

        Developper student=getItem(position);

        textViewName.setText(student.getFirstName());
        textViewEmail.setText(student.getMail());
        Picasso.get().load(student.getPictureUrl()).into(imageView);
        return convertView;
    }
}

