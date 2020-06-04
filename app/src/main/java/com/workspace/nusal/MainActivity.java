package com.workspace.nusal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.workspace.nusal.fragments.FragmentHome;
import com.workspace.nusal.fragments.FragmentsAccount;
import com.workspace.nusal.fragments.FragmentsFavorite;
import com.workspace.nusal.fragments.FragmentsPembayaran;

public class MainActivity extends AppCompatActivity {
    private FragmentHome fragmentHome;
    private FragmentsFavorite fragmentsFavorite;
    private FragmentsPembayaran fragmentsPembayaran;
    private FragmentsAccount fragmentsAccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentHome = new FragmentHome();
        fragmentsFavorite = new FragmentsFavorite();
        fragmentsPembayaran = new FragmentsPembayaran();
        fragmentsAccount = new FragmentsAccount();

        SpaceNavigationView spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.showIconOnly();

        spaceNavigationView.addSpaceItem(new SpaceItem("home", R.drawable.home));
        spaceNavigationView.addSpaceItem(new SpaceItem("item2", R.drawable.ic_baseline_star_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("item3", R.drawable.list));
        spaceNavigationView.addSpaceItem(new SpaceItem("item4", R.drawable.person));

        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_baseline_shopping_basket_24);




        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Intent chart = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(chart);
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

                switch (itemIndex){
                    case 0:
                        setFragment(fragmentHome);
                         return;
                    case 1:
                        setFragment(fragmentsFavorite);
                        return;
                    case 2:
                        setFragment(fragmentsPembayaran);
                        return;
                    case 3:
                        setFragment(fragmentsAccount);




                }


            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });


    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container2, fragment);
        fragmentTransaction.commit();
    }


}