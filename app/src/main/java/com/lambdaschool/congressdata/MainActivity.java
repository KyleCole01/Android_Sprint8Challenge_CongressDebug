package com.lambdaschool.congressdata;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private RecyclerView layoutList;
    private RecyclerView.LayoutManager layoutManager;
    private OverviewListAdapter listAdapter;

    private Context context;
    private CongresspersonListViewModel viewModel;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity = this;
        themeUtils.onActivityCreateSetTheme(activity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        layoutList = findViewById(R.id.layout_list);
        layoutList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        layoutList.setLayoutManager(layoutManager);


        viewModel = ViewModelProviders.of(this).get(CongresspersonListViewModel.class);

        viewModel.getOverviewList().observe(this, overviewList -> runOnUiThread(() -> {
            assert overviewList != null;

            // using recycler view
            listAdapter = new OverviewListAdapter(overviewList);
            layoutList.setAdapter(listAdapter);

        }));
    }

    private int themeId;

    @Override
    public void setTheme(int themeId) {
        super.setTheme(themeId);
        this.themeId = themeId;
    }

    public int getThemeId() {
        return themeId;
    }


    @Override
    protected void onStart() {
        if (getThemeId() != themeUtils.getcTheme(activity)) {
            themeUtils.refreshActivity(activity);
        }
        super.onStart();
    }

    @Override
    protected void onResume() {
        if (getThemeId() != themeUtils.getcTheme(activity)) {
            themeUtils.refreshActivity(activity);
        }
        super.onResume();
    }

    /**
     * This method generates default TextView objects for the congressperson list in this activity.
     *
     * @param text display name for the congressperson
     * @param id   api id for the congressperson
     * @return TextView object with the text and tag set as provided
     */
    @NonNull
    private TextView getDefaultTextView(String text, String id) {
        TextView dataView = new TextView(context);
        dataView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        dataView.setPadding(10, 20, 10, 20);
        dataView.setTypeface(Typeface.DEFAULT_BOLD);
        dataView.setText(text);
        dataView.setTag(id);

        dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("id", view.getTag().toString());
                startActivity(intent);
            }
        });
        return dataView;
    }
}
