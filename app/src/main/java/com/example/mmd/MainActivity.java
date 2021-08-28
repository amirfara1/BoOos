//HiIiIiIiIiIiIiIiIiIiIiIiIiIi.......im Amir_Frahani!!
//show added Files in this app
//for:Mr.Maddi
package com.example.mmd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> arrayList = new ArrayList<>();
    MainAdapter adapter;
    private final int STORAGE_PERMISSION_CODE = 1234;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
        recyclerView = findViewById(R.id.ahmad);
        arrayList.addAll(Arrays.asList("mmd1", "mmd2", "mmd3", "mmd4", "mmd5", "mmd6", "mmd7", "mmd8", "mmd9", "mmd10", "mmd11", "mmd12", "mmd13", "mmd14", "mmd15"));
        // Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Initialize adapter
        adapter = new MainAdapter(this, arrayList);
        //set adapter
        recyclerView.setAdapter(adapter);
        //Initialize item touch helper
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //When item swip
                //Remove item from list
                arrayList.remove(viewHolder.getAdapterPosition());
                //notify adapter
                adapter.notifyDataSetChanged();

            }

        }).attachToRecyclerView(recyclerView);
    }

    public void checkPermission(String permission, int requestCode) {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
        } else {
            Toast.makeText(MainActivity.this, "Storage already granted", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == STORAGE_PERMISSION_CODE) {


            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(MainActivity.this, "Permission Permission Granted", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
