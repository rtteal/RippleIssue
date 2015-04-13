package com.rippleissue;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity implements RippleAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new ListFragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.mainFragment, fragment)
                .commit();
    }

    @Override
    public void displayActivity() {
        Intent i = new Intent(this, DetailActivity.class);
        startActivity(i);
    }

    @Override
    public void displayFrag() {
        Fragment fragment = DetailFragment.newInstance();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.mainFragment, fragment)
                .addToBackStack("transaction")
                .commit();
    }

    @Override
    public void displayAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hello");
        builder.create();
        builder.show();
    }
}
