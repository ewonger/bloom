package com.example.bloom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ExpenseMonthly extends AppCompatActivity {

    Jan janAction;
    Feb febAction;
    Mar marAction;
    Apr aprAction;
    May mayAction;
    Jun JunAction;
    Jul JulyAction;
    Aug AugAction;
    Sep SeptAction;
    Oct OctAction;
    Nov NovAction;
    Dec DecAction;

    Spinner spinner;
    List<String > months;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_monthly);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        spinner=findViewById(R.id.SpinnterMonths);
        janAction = new Jan();
        febAction = new Feb();
        marAction = new Mar();
        aprAction = new Apr();
        mayAction = new May();
        JunAction = new Jun();
        JulyAction = new Jul();
        AugAction = new Aug();
        SeptAction = new Sep();
        OctAction = new Oct();
        NovAction = new Nov();
        DecAction = new Dec();

        months= new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(ExpenseMonthly.this, R.layout.items,months);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        selectFragment(janAction);
                        break;
                    case 1:
                        selectFragment(febAction);
                        break;
                    case 2:
                        selectFragment(marAction);
                        break;
                    case 3:
                        selectFragment(aprAction);
                        break;
                    case 4:
                        selectFragment(mayAction);
                        break;
                    case 5:
                        selectFragment(JunAction);
                        break;
                    case 6:
                        selectFragment(JulyAction);
                        break;
                    case 7:
                        selectFragment(AugAction);
                        break;
                    case 8:
                        selectFragment(SeptAction);
                        break;
                    case 9:
                        selectFragment(OctAction);
                        break;
                    case 10:
                        selectFragment(NovAction);
                        break;
                    case 11:
                        selectFragment(DecAction);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void selectFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}