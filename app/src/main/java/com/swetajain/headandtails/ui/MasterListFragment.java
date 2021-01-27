package com.swetajain.headandtails.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    OnImageClickListener mCallback;

    //    override onAttach to make sure the host activity has implemented the
//    callback interface
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
            throw new ClassCastException(context.toString()
                    + "must implement OnImageClickListener");

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = rootView.findViewById(R.id.images_grid_view);
        MasterListAdapter masterListAdapter =
                new MasterListAdapter(Objects.requireNonNull(getContext()), AndroidImageAssets.getAll());
        gridView.setAdapter(masterListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.onImageSelected(i);
            }
        });
        return rootView;
    }

    public MasterListFragment() {
    }

    public interface OnImageClickListener {
        void onImageSelected(int position);
    }
}
