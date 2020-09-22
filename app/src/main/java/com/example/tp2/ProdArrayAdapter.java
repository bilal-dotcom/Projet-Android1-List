package com.example.tp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProdArrayAdapter extends ArrayAdapter<produit> {


    private Context context;
    private ArrayList<produit> lp;
    private int resource;


    public ProdArrayAdapter(Context context, int resource, List<produit> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        lp = new ArrayList<produit>();
        lp = (ArrayList<produit>)objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        produit ptemp = this.lp.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(this.resource,parent,false);

        TextView nom = (TextView)convertView.findViewById(R.id.lblnomprod);
        TextView type = (TextView)convertView.findViewById(R.id.lbltype);
        TextView prix = (TextView)convertView.findViewById(R.id.lblprix);
        ImageView img =(ImageView)convertView.findViewById(R.id.img);

        nom.setText("Nom:" +ptemp.getNom());
        type.setText("Type:"+ptemp.gettype());
        prix.setText("Prix:"+ptemp.getprix());
        img.setImageResource(ptemp.getImage());

        return convertView;
    }
}


