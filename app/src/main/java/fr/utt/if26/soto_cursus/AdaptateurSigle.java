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

public class AdaptateurSigle extends ArrayAdapter<String> {

    ArrayList<String> l;
    Context c;
    int r;


    public AdaptateurSigle(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);

        this.c = context;
        this.r = resource;
        this.l = objects;





    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) c).getLayoutInflater();
        View v = inflater.inflate(r, parent, false);

        String elt = l.get(position);
        TextView tv = (TextView) v.findViewById(R.id.sigle_tv);
        tv.setText(elt);
        return v;

    }
}
