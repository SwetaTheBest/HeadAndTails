package com.swetajain.headandtails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.swetajain.headandtails.data.AndroidImageAssets;
import com.swetajain.headandtails.data.BodyPartFragment;
import com.swetajain.headandtails.ui.MasterListFragment;

public class MainActivityAll extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    Button next;
    Boolean mTwoPane;
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_all);
        next = findViewById(R.id.next_button);
        if (findViewById(R.id.main_linear_layout) != null) {
            mTwoPane = true;
            next.setVisibility(View.GONE);
            GridView gridView = findViewById(R.id.images_grid_view);
            gridView.setNumColumns(2);
            FragmentManager manager = getSupportFragmentManager();
            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            manager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            manager.beginTransaction()
                    .add(R.id.head_container, bodyFragment)
                    .commit();
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            manager.beginTransaction()
                    .add(R.id.head_container, legFragment)
                    .commit();

        } else {
            mTwoPane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position Clicked: "
                + position, Toast.LENGTH_SHORT).show();
        int bodyPartNumber = position / 12;
        int listIndex = position - 12 * bodyPartNumber;
        if (mTwoPane) {

            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            switch (bodyPartNumber) {
                case 0:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                    bodyPartFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, bodyPartFragment)
                            .commit();
                    break;

                case 1:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
                    bodyPartFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, bodyPartFragment)
                            .commit();
                    break;

                case 2:
                    bodyPartFragment.setImageIds(AndroidImageAssets.getLegs());
                    bodyPartFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, bodyPartFragment)
                            .commit();
                    break;
            }

        } else {

            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
                default:
                    break;

            }

            Bundle b = new Bundle();
            b.putInt("headIndex", headIndex);
            b.putInt("bodyIndex", bodyIndex);
            b.putInt("legIndex", legIndex);

            final Intent intent = new Intent(this, MainActivity.class);
            intent.putExtras(b);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }
    }

}