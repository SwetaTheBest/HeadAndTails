package com.swetajain.headandtails.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.swetajain.headandtails.MasterListAdapter;
import com.swetajain.headandtails.R;
import com.swetajain.headandtails.data.AndroidImageAssets;

import java.util.Objects;

public class MasterListFragment extends Fragment {

    public MasterListFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = rootView.findViewById(R.id.images_grid_view);
        MasterListAdapter masterListAdapter = new MasterListAdapter(Objects.requireNonNull(getContext()), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);
        return rootView;
    }
}
