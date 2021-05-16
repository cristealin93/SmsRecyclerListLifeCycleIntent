package com.lista.listrecyclerintent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> list;
    ArrayList<String> listSearch;
    RecyclerView recyclerView;
    MyViewHolderAdapter adapter;
    ToggleButton toggleButton;
    SearchView searchView;
    Button next;

    ListView listView;
    TextView txtlista;
    String[] listItem;
    EditText editText;

    RadioButton r1, r2;
    RadioGroup rg;
    ConstraintLayout cs;
    AlertDialog.Builder alert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);


        cs = findViewById(R.id.constraintLayout);
        listView = findViewById(R.id.listView);
        txtlista = findViewById(R.id.txtlist);
        searchView = findViewById(R.id.searchView);
        editText = findViewById(R.id.editText);
        next = findViewById(R.id.next);

        listSearch = new ArrayList<>();
        listSearch.add("Apple");
        listSearch.add("Banana");
        listSearch.add("Pineapple");
        listSearch.add("Orange");
        listSearch.add("Lychee");
        listSearch.add("Gavava");
        listSearch.add("Peech");
        listSearch.add("Melon");
        listSearch.add("Watermelon");
        listSearch.add("Papaya");


        r1 = new RadioButton(this);
        r2 = new RadioButton(this);
        rg = new RadioGroup(this);
        rg.addView(r1);
        rg.addView(r2);
        rg.setOrientation(LinearLayout.HORIZONTAL);

        listItem = getResources().getStringArray(R.array.array_technology);
        final ArrayAdapter<String> adapterList = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listSearch);
        listView.setAdapter(adapterList);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FragmentAcrivity.class);
                startActivity(intent);
            }
        });

// SEARCH
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapterList.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, adapterList.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

        // Adapter

        AddItem();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyViewHolderAdapter(MainActivity.this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        //EditTexgt search

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Toast.makeText(getApplicationContext(), "before text change", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapterList.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getApplicationContext(), "after text change", Toast.LENGTH_LONG).show();
            }
        });

        //Toggle button

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("buton").append(toggleButton.getText());

                if (toggleButton.isChecked()) {

                    alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("Vezi daca merge").setCancelable(false).
                            setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Toast.makeText(MainActivity.this, "Test", Toast.LENGTH_SHORT).show();
                                }
                            }).
                            setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                                }
                            });

                    //AlertDialog testare=alert.create();
                    alert.setTitle("AlertDialogTest");
                    alert.show();
                }

            }
        });

    }


    private void AddItem() {
        list = new ArrayList<>();
        list.add(new Model("1", "https://www.javatpoint.com/android-intent-tutorial"));

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy invoked");
    }
}