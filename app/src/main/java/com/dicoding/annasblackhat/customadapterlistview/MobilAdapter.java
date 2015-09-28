package com.dicoding.annasblackhat.customadapterlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by annasblackhat on 9/28/15.
 */
public class MobilAdapter extends BaseAdapter {

    private ArrayList<MobilModel> listItem;
    private Activity activity;

    public MobilAdapter(ArrayList<MobilModel> listItem, Activity activity) {
        this.listItem = listItem;
        this.activity = activity;
    }

    //Akan me-Return jumlah data yang akan ditampilkan kedalam ListView
    @Override
    public int getCount() {
        return listItem.size();
    }

    //Akan me-Return data per list
    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder = null;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, null);
            holder.imgItem = (ImageView)view.findViewById(R.id.image_item);
            holder.txtTilte = (TextView)view.findViewById(R.id.txt_item_title);
            holder.txtHrg = (TextView)view.findViewById(R.id.txt_item_harga);
            holder.txtLokasi = (TextView)view.findViewById(R.id.txt_item_lokasi);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        MobilModel mobil = (MobilModel)getItem(position);
        holder.txtTilte.setText(mobil.getTitle());
        holder.txtHrg.setText(mobil.getHarga());
        holder.txtLokasi.setText(mobil.getLokasi());
        Picasso.with(activity).load(mobil.getImage()).into(holder.imgItem);
        return view;
    }

    static  class  ViewHolder{
        ImageView imgItem;
        TextView txtTilte, txtHrg, txtLokasi;
    }
}
