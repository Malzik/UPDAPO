package com.epsi.updapo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.epsi.updapo.model.Category;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class CategoryAdapter extends ArrayAdapter<Category> {
    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<Category> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.c_category, null);

        TextView textViewTitle = convertView.findViewById(R.id.textViewCategoryTitle);

        Category category = getItem(position);

        assert category != null;
        textViewTitle.setText(category.getTitle());
        return convertView;
    }
}
