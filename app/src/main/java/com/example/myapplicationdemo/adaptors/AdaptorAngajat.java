package com.example.myapplicationdemo.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplicationdemo.R;
import com.example.myapplicationdemo.model.Angajat;

import org.w3c.dom.Text;

import java.util.List;

public class AdaptorAngajat extends ArrayAdapter<Angajat> {
    private List<Angajat> angajatList;

    private static class ViewHolder {
        TextView nume;
        TextView prenume;
        TextView functie;
        TextView dataNasterii;
        TextView salariu;
        TextView sex;
    }

    public AdaptorAngajat(@NonNull Context context, int resource, @NonNull List<Angajat> angajatList) {
        super(context, resource, angajatList);
        this.angajatList = angajatList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Angajat angajat = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_angajat, parent, false);

            viewHolder.nume = convertView.findViewById(R.id.itemNume);
            viewHolder.prenume = convertView.findViewById(R.id.itemprenume);
            viewHolder.functie = convertView.findViewById(R.id.itemFunctie);
            viewHolder.dataNasterii = convertView.findViewById(R.id.itemDataNasterii);
            viewHolder.salariu = convertView.findViewById(R.id.itemSalariu);
            viewHolder.sex = convertView.findViewById(R.id.itemSex);

            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.nume.setText(angajat.getNume());
        viewHolder.prenume.setText(angajat.getPrenume());
        viewHolder.functie.setText(angajat.getFunctie());
        viewHolder.dataNasterii.setText(angajat.getDataNasterii());
        viewHolder.salariu.setText(String.valueOf(angajat.getSalariu()));
        viewHolder.sex.setText(angajat.getSex());

        return result;
    }
}
