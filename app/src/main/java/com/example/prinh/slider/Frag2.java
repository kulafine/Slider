package com.example.prinh.slider;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag2 extends Fragment {

    private Spinner classes,faculties;


    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        classes = (Spinner)view.findViewById(R.id.cls);
        faculties = (Spinner)view.findViewById(R.id.fty);

        List<String> cs = new ArrayList<String>();
        cs.add("Computer Science");
        cs.add("Finance");


        List<String> fcts = new ArrayList<String>();
        fcts.add("Computer Science");
        fcts.add("EBS");

        ArrayAdapter<String> class_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, cs);
        class_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> faculty_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, fcts);
        faculty_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        classes.setAdapter(class_adapter);
        faculties.setAdapter(faculty_adapter);

        classes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), item, Toast.LENGTH_SHORT).show();
            }
        });

        faculties.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getContext(), item, Toast.LENGTH_SHORT).show();

            }
        });



        return view;
    }


}
