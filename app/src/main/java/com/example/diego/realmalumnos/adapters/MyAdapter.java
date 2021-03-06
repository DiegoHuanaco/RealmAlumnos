package com.example.diego.realmalumnos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.diego.realmalumnos.R;
import com.example.diego.realmalumnos.models.Alumno;


import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<Alumno> list;
    private int layout;
    private Context context;

    public MyAdapter(List<Alumno> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Alumno getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.alumno = (TextView) convertView.findViewById(R.id.textAlumno);
            vh.id = (TextView) convertView.findViewById(R.id.textViewId);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Alumno p = list.get(position);
        vh.id.setText(p.getId() + "");
        vh.alumno.setText(p.getRut() + "\n" + p.getNombre() + "\n" + p.getApellido() + "\n" + p.getEdad() + "\n" + p.getCarrera() + "\n" + p.getAño() + "\n" + p.getSemestre());

        return convertView;
    }
    public class ViewHolder {
        TextView id;
        TextView alumno;
    }
}