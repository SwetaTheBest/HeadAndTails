package com.swetajain.headandtails.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.swetajain.headandtails.R;

public class AllActivity extends FragmentActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_all);

        MasterListFragment masterListFragment = new MasterListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Toast.makeText(this, "Master list onCreate", Toast.LENGTH_SHORT).show();
        fragmentManager.beginTransaction()
                .add(R.id.container, masterListFragment)
                .commit();
    }
}
