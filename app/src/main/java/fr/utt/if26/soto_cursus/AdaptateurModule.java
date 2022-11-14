package fr.utt.if26.soto_cursus;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class AdaptateurModule extends ArrayAdapter<Module> {

    ArrayList<Module> l;
    Context c;
    int r;


    public AdaptateurModule(Context context, int resource, ArrayList<Module> objects) {
        super(context, resource, objects);

        this.c = context;
        this.r = resource;
        this.l = objects;





    }


    @Override
    public View getView(int index, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) c).getLayoutInflater();
        View v = inflater.inflate(r, parent, false);

        TextView tv = (TextView) v.findViewById(R.id.module_sigle);
        tv.setText(l.get(index).getSigle());

        TextView tv2 = (TextView) v.findViewById(R.id.module_categorie);
        tv2.setText(l.get(index).getCategorie());

        TextView tv3 = (TextView) v.findViewById(R.id.module_parcours);
        tv3.setText(l.get(index).getParcours());

        int credit = l.get(index).getCredit();
        TextView tv4 = (TextView) v.findViewById(R.id.module_credits);
        tv4.setText(String.valueOf(credit));

        return v;

    }
}