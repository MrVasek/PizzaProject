package com.example.admin.pizza;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;



public class Main extends AppCompatActivity {

    private TextView price;
    private RadioGroup group;
    private CheckBox topCorn;
    private CheckBox topPaprica;
    private CheckBox topMushrooms;
    private CheckBox topBacon;
    private CheckBox topBroccoli;
    private Button order;

    private int pizzaPrice;
    private boolean extraCorn;
    private boolean extraPaprica;
    private boolean extraMushrooms;
    private boolean extraBacon;
    private boolean extraBroccoli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.pizza_choice);
        topCorn = (CheckBox) findViewById(R.id.top_corn);
        topPaprica = (CheckBox) findViewById(R.id.top_paprica);
        topMushrooms = (CheckBox) findViewById(R.id.top_mushrooms);
        topBacon = (CheckBox) findViewById(R.id.top_bacon);
        topBroccoli = (CheckBox) findViewById(R.id.top_broccoli);
        price = (TextView) findViewById(R.id.sum);
        order = (Button) findViewById(R.id.order);

        final SparseIntArray pizzaPrices = new SparseIntArray(4);
        pizzaPrices.put(R.id.choice1, 50);
        pizzaPrices.put(R.id.choice2, 65);
        pizzaPrices.put(R.id.choice3, 45);
        pizzaPrices.put(R.id.choice4, 50);
        pizzaPrices.put(R.id.choice5, 100);
        pizzaPrices.put(R.id.choice6, 35);


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pizzaPrice = pizzaPrices.get(checkedId);
                updatePrice();
            }
        });

        topCorn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                extraCorn = isChecked;
                updatePrice();
            }
        });

        topPaprica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                extraPaprica = isChecked;
                updatePrice();
            }
        });

        topMushrooms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                extraMushrooms = isChecked;
                updatePrice();
            }
        });

        topBacon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                extraBacon = isChecked;
                updatePrice();
            }
        });

        topBroccoli.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                extraBroccoli = isChecked;
                updatePrice();
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main.this, "Ваше замовлення принято, чекайте дзвінка!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updatePrice() {
        int finalPrice = pizzaPrice;
        if (extraCorn) {
            finalPrice += 7;
        }
        if (extraPaprica) {
            finalPrice += 8;
        }
        if (extraMushrooms) {
            finalPrice += 9;
        }
        if (extraBacon) {
            finalPrice += 10;
        }
        if (extraBroccoli) {
            finalPrice += 11;
        }

        price.setText("Сума: " + finalPrice + " грн.");
    }
}
