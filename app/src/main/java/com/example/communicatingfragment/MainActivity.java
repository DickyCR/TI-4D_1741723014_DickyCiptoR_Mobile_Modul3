package com.example.communicatingfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    static boolean isTwoPane = false;

    private FrameLayout mFrameLayout;
    FragmentTransaction mfragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout = findViewById(R.id.frameLayout);
        moveFragment(new MovieFragment());

        if (findViewById(R.id.frameLayout_land) != null){
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }
    }

    private void moveFragment(Fragment fragment){
        getSupportFragmentManager().popBackStackImmediate();
        mfragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,fragment);
        mfragmentTransaction.commit();
    }


}