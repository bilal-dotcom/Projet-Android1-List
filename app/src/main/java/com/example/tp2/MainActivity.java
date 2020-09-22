package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText text1;
    private EditText text2;
    private  TextView lbl;
    private TextView name;
    private TextView price;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private ListView list;// = (ListView)findViewById(R.id.listProd);
   private ArrayList<produit> prodArrayList ;//= new ArrayList<produit>();
    private ProdArrayAdapter adapter;// = new ProdArrayAdapter(this,R.layout.mon_layout,prodArrayList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.prodArrayList = new ArrayList<produit>();

       this.list = (ListView)findViewById(R.id.listProd);
        this.adapter= new ProdArrayAdapter(this,R.layout.mon_layout,prodArrayList);

       list.setAdapter(adapter);
       adapter.notifyDataSetChanged();


        this.list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /*
                for(int i = 0; i< prodArrayList.size();i++)
                {
                   // list.getChildAt(position).setBackgroundColor(Color.RED);

                    TextView name = findViewById(R.id.lblnomprod);
                    TextView price = findViewById(R.id.lblprix);

                      //name.setTextColor(Color.parseColor("#FF0000"));
                       //price.setTextColor(Color.parseColor("#FF0000"));
                }

                 */
                list.getChildAt(position).setBackgroundColor(Color.RED);

            }
        });


        this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                prodArrayList.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }


    public void listClick(View view) {
        produit newProd ;

        this.text1=(EditText)findViewById(R.id.TxtBoxNom);
        this.text2=(EditText)findViewById(R.id.TxtBoxPrix);

        String nom =text1.getText().toString();
        String part22=text2.getText().toString();
        Double prix = Double.parseDouble(part22);

        radioGroup = (RadioGroup) findViewById(R.id.radiog);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        String type=radioButton.getText().toString();

        //Les case ne peuvent etre vides
        if(nom.isEmpty()  )
 {
            Toast.makeText(this,"Toutes les cases doivent etre remplies",Toast.LENGTH_SHORT).show();
        }
        else
        {


           if(type.equals("Fruits et legumes"))
           {
               newProd= new produit(nom, type, prix, R.drawable.fruitetlegumes);
               prodArrayList.add(newProd);
           }
           else if (type.equals("Viandes et substituts"))
            {
                 newProd = new produit(nom, type, prix, R.drawable.viande);
                prodArrayList.add(newProd);
            }
           else if (type.equals("Patisseries"))
           {
                newProd = new produit(nom, type, prix, R.drawable.patisserie);
               prodArrayList.add(newProd);
           }
           else if (type.equals("Produits laitiers"))
           {
                newProd = new produit(nom, type, prix, R.drawable.produitlaitier);
               prodArrayList.add(newProd);
           }

          // produit newProd = new produit(nom, type, prix, R.drawable.produitlaitier);
          //  prodArrayList.add(newProd);

           this.list = (ListView) findViewById(R.id.listProd);
            this.adapter= new ProdArrayAdapter(this,R.layout.mon_layout,prodArrayList);

           list.setAdapter(adapter);
           adapter.notifyDataSetChanged();

            //Calculer le total des prix des produits
            Double total =0.0;
            for(int i = 0; i< prodArrayList.size();i++)
            {
                Double rep1 = Double.parseDouble(String.valueOf(prodArrayList.get(i).getprix()));
                total = total + rep1;
            }
            this.lbl=(TextView)findViewById(R.id.lbltotal);

            this.lbl.setText(total.toString());

        }


    }


}
