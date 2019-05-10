package com.lambdaschool.congressdata;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OverviewListAdapter extends RecyclerView.Adapter<OverviewListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textListName;
        public TextView textListParty;
        public TextView textListState;
        public ViewGroup cardParent;
        public ViewHolder(View view) {
            super(view);

            textListName = view.findViewById(R.id.text_list_name);
            textListParty = view.findViewById(R.id.text_list_party);
            textListState = view.findViewById(R.id.text_list_state);
            cardParent   = view.findViewById(R.id.card_view);
        }
    }

    private ArrayList<OfficialOverview> dataList;
    private Context context;

    public OverviewListAdapter(ArrayList<OfficialOverview> dataList) {
        this.dataList = dataList;
    }

    @Override
    public OverviewListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.congressperson_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OverviewListAdapter.ViewHolder holder, int position) {
        OfficialOverview data = dataList.get(position);

        holder.textListName.setText(data.getDisplayName());
        holder.textListParty.setText(data.getParty());
        holder.textListState.setText(data.getState());
        holder.cardParent.setTag(data.getId());
        holder.cardParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("id", view.getTag().toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
