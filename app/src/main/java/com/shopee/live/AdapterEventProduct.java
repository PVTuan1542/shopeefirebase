package com.shopee.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shopee.R;

import java.util.List;

class AdapterEventProduct extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ProductEvent> list;

    public AdapterEventProduct(Context context, int layout, List<ProductEvent> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        TextView txtTen = (TextView) view.findViewById(R.id.textView);
        TextView txttenShop = (TextView) view.findViewById(R.id.textView2);
        TextView txtthoiGian = (TextView) view.findViewById(R.id.txtte);
        TextView txtnhacNho = (TextView) view.findViewById(R.id.txtnhacnho);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageView);
        ImageView imghinhNho = (ImageView) view.findViewById(R.id.circleImage);

        ProductEvent ProductEvent = list.get(i);

        txtTen.setText(ProductEvent.getTen());
        txttenShop.setText(ProductEvent.getTenshop());
        txtthoiGian.setText(ProductEvent.getThoigian());
        txtnhacNho.setText(ProductEvent.getNhacnho());
        imgHinh.setImageResource(ProductEvent.getHinhanh());
        imghinhNho.setImageResource(ProductEvent.getHinhnho());


        return view;
    }
}
