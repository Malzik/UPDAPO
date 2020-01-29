package com.epsi.updapo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UPDAPOActivity extends AppCompatActivity implements View.OnClickListener {
    protected UPDAPOApp UPDAPOApp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UPDAPOApp = (UPDAPOApp) getApplication();
    }

    protected void showBackBtn() {
        ImageView imageView = findViewById(R.id.backButton);
        if (imageView != null) {
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(this);
        }
    }

    protected void setTitle(String title) {
        TextView textViewTitle = findViewById(R.id.textViewTitle);
        if (textViewTitle != null) {
            textViewTitle.setText(title);
        }
    }

    protected void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButton:
                finish();
                break;
        }
    }
}