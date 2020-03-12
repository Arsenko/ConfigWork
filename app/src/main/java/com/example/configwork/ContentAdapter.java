package com.example.configwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContentAdapter extends BaseAdapter {
    private List<ContentList> items;
    private LayoutInflater inflaiter;
    private Context context;

    public ContentAdapter(Context ctx,List<ContentList> items){
        this.context=ctx;
        this.items=items;
        inflaiter= (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;

        if(view==null){
            view=inflaiter.inflate(R.layout.item_list_view,parent,false);
        }

        ContentList contentList=items.get(position);

        ImageView image=view.findViewById(R.id.itemImage);
        TextView heading=view.findViewById(R.id.heading);
        TextView body=view.findViewById(R.id.body);
        CheckBox itemCheck=view.findViewById(R.id.itemCheck);

        image.setImageDrawable(contentList.getItemImage());
        heading.setText(contentList.getHeading());
        body.setText(contentList.getBody());
        itemCheck.setChecked(contentList.getItemCheck());

        return view;
    }
}
