package com.lambdaschool.congressdata;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

public class DetailsActivity extends AppCompatActivity {

    public static final String DETAILS_INTENT_TAG = "id";
    private Context context;
    private ImageView profileImage;
    private TextView profileName;
    private TextView profileParty;
    private TextView profileDistrict;
    private TextView profileTwitter;
    private TextView profileFacebook;
    private TextView profileMap;
    private TextView profilePhone;
    private ProgressBar profileVotingBar;
    private LinearLayout profileCommitteeList;
    private LinearLayout profileSubcommitteeList;

    private Activity activity;

    private String memberId;

    private CongresspersonProfileViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity = this;
        themeUtils.onActivityCreateSetTheme(activity);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_view);
        context = this;

        Intent intent = getIntent();
        memberId = intent.getStringExtra(DETAILS_INTENT_TAG);

        viewModel = ViewModelProviders.of(this).get(CongresspersonProfileViewModel.class);

        profileImage = findViewById(R.id.profile_image);
        profileName = findViewById(R.id.profile_name);
        profileParty = findViewById(R.id.profile_party);
        profileDistrict = findViewById(R.id.profile_district);
        profileTwitter = findViewById(R.id.profile_twitter);
        profileFacebook = findViewById(R.id.profile_facebook);
        profileMap = findViewById(R.id.profile_map);
        profilePhone = findViewById(R.id.profile_phone);
        profileVotingBar = findViewById(R.id.profile_voting_bar);
        profileCommitteeList = findViewById(R.id.profile_committee_list);
        profileSubcommitteeList = findViewById(R.id.profile_subcommittee_list);


        findViewById(R.id.profile_name).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themeUtils.nextTheme(activity);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        viewModel.init(memberId);

        viewModel.getProfile().observe(this, profile -> runOnUiThread(() -> {
            assert profile != null;
//            profileImage.setImageBitmap(profile.getImage());
            //TODO commented out line above and do this instead to download photos as needed rather than beforehand.
            profileImage.setImageBitmap(CongressDao.getImage(profile.getId()));
            profileName.setText(profile.getDisplayName());
            profileParty.setText(profile.getParty());
            profileDistrict.setText(profile.getLocation());
            profileTwitter.setText(Html.fromHtml("<a href=\"https://twitter.com/" + profile.getTwitterAccount() + "\">Twitter</a>"));
            profileFacebook.setText(Html.fromHtml("<a href=\"https://www.facebook.com/" + profile.getFacebookAccount() + "/\">Facebook</a>"));
            profileMap.setText(Html.fromHtml("<a href=\"https://www.google.com/maps/search/" + profile.getOffice().replace(" ", "-") + "\">Office</a>"));
            profilePhone.setText(profile.getPhone());
            profileVotingBar.setProgress((int) profile.getPrimaryProgress());
            profileVotingBar.setSecondaryProgress((int) profile.getSecondaryProgress());

            for (String name : profile.getCommittees()) {
                profileCommitteeList.addView(getDefaultTextView(name));
            }

            for (String name : profile.getSubcommittees()) {
                profileSubcommitteeList.addView(getDefaultTextView(name));
            }

            profileTwitter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!profile.getTwitterAccount().equals("null")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/" + profile.getTwitterAccount())));
                    }
                }
            });
            profileFacebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!profile.getFacebookAccount().equals("null")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/" + profile.getFacebookAccount())));
                    }
                }
            });
            profileMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!profile.getOffice().equals("null")) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/search/" + profile.getOffice())));
                    }
                }
            });
        }));
    }
// removed all unneeded and commented out code from here.

    private TextView getDefaultTextView(String text) {
        TextView dataView = new TextView(context);
        dataView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        dataView.setPadding(5, 5, 5, 5);
        dataView.setText(text);
        return dataView;
    }
}
