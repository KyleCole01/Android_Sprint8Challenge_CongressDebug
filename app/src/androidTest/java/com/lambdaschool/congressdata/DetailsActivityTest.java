package com.lambdaschool.congressdata;

import android.content.Context;
import android.content.Intent;
import android.text.Html;

import androidx.test.rule.ActivityTestRule;

import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.Serializable;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.openLinkWithText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailsActivityTest {

    public static final String STATIC_TEST_ID = "A000374";
    Intent intent;
    CongresspersonProfile profile;
    Context context;

    @Rule
    public ActivityTestRule<DetailsActivity> activityTestRule = new ActivityTestRule<>(DetailsActivity.class, false, false);

    @Before
    public void setUp() {
        profile = new CongresspersonProfile(CongressDao.getMemberDetails(STATIC_TEST_ID));
        profile.setImage(CongressDao.getImage(profile.getId()));

        intent = new Intent();
        intent.putExtra(DetailsActivity.DETAILS_INTENT_TAG, profile.getId());

        activityTestRule.launchActivity(intent);

        context = activityTestRule.getActivity();

    }

    @Test
    public void shouldShowDisplayName() {
        onView(withId(R.id.profile_name)).check(matches(withText(profile.getDisplayName())));
    }

    @Test
    public void shouldShowDisplayParty() {
        onView(withId(R.id.profile_party)).check(matches(withText(profile.getParty())));
    }

    @Test
    public void shouldDisplayDistrict() {
        onView(withId(R.id.profile_district)).check(matches(withText(profile.getLocation())));
    }

    @Test
    public void shouldShowDisplayTwitter() {
       String expected = Html.fromHtml("<a href=\"https://twitter.com/" + profile.getTwitterAccount() + "\">Twitter</a>").toString();
        onView(withId(R.id.profile_twitter)).check(matches(withText(expected)));
    }

    @Test
    public void shouldShowDisplayFacebook() {
        String expected = Html.fromHtml("<a href=\"https://www.facebook.com/" + profile.getFacebookAccount() + "/\">Facebook</a>").toString();
        onView(withId(R.id.profile_facebook)).check(matches(withText(expected)));
    }


}