package com.epsi.updapo;

import android.os.Bundle;
import android.view.View;

public class HomeActivity extends UPDAPOActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        findViewById(R.id.buttonZone1).setOnClickListener(this);
        findViewById(R.id.buttonZone2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonZone1:
                DevelopperActivity.display(HomeActivity.this);
                break;
            case R.id.buttonZone2:
                CategoryActivity.display(HomeActivity.this);
                break;
        }
    }
}
