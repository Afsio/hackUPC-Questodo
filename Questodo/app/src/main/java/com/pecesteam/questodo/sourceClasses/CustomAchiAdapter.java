package com.pecesteam.questodo.sourceClasses;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pecesteam.questodo.R;

import java.util.StringTokenizer;

public class CustomAchiAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomAchiAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.list_achievement, itemname);

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_achievement, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.nomAchi);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.achiLogo);
        TextView extratxt = (TextView) rowView.findViewById(R.id.descAchi);

        StringTokenizer tk = new StringTokenizer(itemname[position],":");

        txtTitle.setText(tk.nextToken());
        imageView.setImageResource(imgid[position]);
        extratxt.setText(": " + tk.nextToken());
        return rowView;

    }
}