package com.lambdaschool.congressdata;

import android.graphics.Bitmap;

import com.lambdaschool.congressdataapiaccess.Committee;
import com.lambdaschool.congressdataapiaccess.CongressDao;
import com.lambdaschool.congressdataapiaccess.CongresspersonDetails;
import com.lambdaschool.congressdataapiaccess.Subcommittee;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CongresspersonProfile {

    public static final String INDEPENDENT             = "Independent";
    public static final String REPUBLICAN              = "Republican";
    public static final String DEMOCRAT                = "Democrat";
    public static final String COMMITTEE_DETAIL_TARGET = "name";

    private String firstName, middleName, lastName, displayName, party, state, id, twitterAccount,
            facebookAccount, district, phone, location, office;
    private float missedVotesPct, votesWithPartyPct;
    private ArrayList<String> committees, subcommittees;
    private Bitmap image;

//    public CongresspersonProfile() {
//    }

    /**
     * This is a constructor
     *
     * @param firstName
     * @param middleName
     * @param lastName
     * @param party
     * @param state
     * @param id
     * @param twitterAccount
     * @param facebookAccount
     * @param district
     * @param phone
     * @param missedVotesPct
     * @param office
     * @param votesWithPartyPct
     */
    public CongresspersonProfile(String firstName, String middleName, String lastName, String party,
                                 String state, String id, String twitterAccount,
                                 String facebookAccount, String district, String phone,
                                 String missedVotesPct, String office, String votesWithPartyPct) {
        this.firstName         = firstName;
        this.middleName        = middleName;
        this.lastName          = lastName;
        this.state             = state;
        this.office            = office;
        this.district          = district;
        this.location          = state + " - " + "District " + district;
        this.id                = id;
        this.twitterAccount    = twitterAccount;
        this.facebookAccount   = facebookAccount;
        this.phone             = phone;
        this.missedVotesPct    = Float.parseFloat(missedVotesPct);
        this.votesWithPartyPct = Float.parseFloat(votesWithPartyPct);
        this.displayName       = buildDisplayName();

        switch (party) {
            case "R":
                this.party = REPUBLICAN;
                break;
            case "D":
                this.party = DEMOCRAT;
                break;
            case "I":
                this.party = INDEPENDENT;
                break;
        }
    }

    public CongresspersonProfile(CongresspersonDetails congresspersonDetails) {

        this(congresspersonDetails.getFirstName(),
                congresspersonDetails.getMiddleName(),
                congresspersonDetails.getLastName(),
                congresspersonDetails.getCurrentParty(),
                congresspersonDetails.getRoles().get(0).getState(),
                congresspersonDetails.getMemberId(),
                congresspersonDetails.getTwitterAccount(),
                congresspersonDetails.getFacebookAccount(),
                congresspersonDetails.getRoles().get(0).getDistrict(),
                congresspersonDetails.getRoles().get(0).getPhone(),
                Double.toString(congresspersonDetails.getRoles().get(0).getMissedVotesPct()),
                congresspersonDetails.getRoles().get(0).getOffice(),
                Double.toString(congresspersonDetails.getRoles().get(0).getVotesWithPartyPct()));

        //get correct role index
        int index = 0;
        for(int i = 0; i < congresspersonDetails.getRoles().size(); ++i) {
            if(congresspersonDetails.getRoles().get(i).getCongress().equals(CongressDao.CONGRESS_NUMBER)) {
                index = i;
                break;
            }
        }

        final List<Committee> committees = congresspersonDetails.getRoles().get(index).getCommittees();
        this.setCommittees(committees);
        final List<Subcommittee> subcommittees = congresspersonDetails.getRoles().get(index).getSubcommittees();
        this.setSubcommittees(subcommittees);
    }

    public String buildDisplayName() {
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(firstName).append(" ");
        if (!middleName.equals("null")) {
            nameBuilder.append(middleName).append(" ");
        }
        nameBuilder.append(lastName);
        return nameBuilder.toString();
    }

    public float getPrimaryProgress() {
        if(this.party.equals(REPUBLICAN)) {
            return this.votesWithPartyPct;
        } else {
            return 100 - this.votesWithPartyPct - this.missedVotesPct;
        }
    }

    public float getSecondaryProgress() {
        if(this.party.equals(DEMOCRAT)) {
            return this.votesWithPartyPct;
        } else {
            return 100 - this.votesWithPartyPct - this.missedVotesPct;
        }
    }

    public ArrayList<String> getCommittees() {
        return committees;
    }

//    public void setCommittees(JSONArray committeesJson) {
//        this.committees = parseJsonList(committeesJson, COMMITTEE_DETAIL_TARGET);
//    }

    public void setCommittees(List<Committee> committees) {
        this.committees = new ArrayList<>();
        for(Committee committee: committees) {
            this.committees.add(committee.getName());
        }
    }

    public ArrayList<String> getSubcommittees() {
        return subcommittees;
    }

//    public void setSubcommittees(JSONArray subcommitteesJson) {
//        this.subcommittees = this.committees = parseJsonList(subcommitteesJson, COMMITTEE_DETAIL_TARGET);;
//    }

    public void setSubcommittees(List<Subcommittee> subcommittees) {
        this.subcommittees = new ArrayList<>();
        for(Subcommittee subcommittee: subcommittees) {
            this.subcommittees.add(subcommittee.getName());
        }
    }

//    private ArrayList<String> parseJsonList(JSONArray array, String target) {
//        ArrayList<String> result = new ArrayList<>();
//
//        for(int i = 0; i < array.length(); ++i) {
//            try {
//                result.add(array.getJSONObject(i).getString(target));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return result;
//    }

    public String getOffice() {
        return office;
    }

    public String getLocation() {
        return location;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getParty() {
        return party;
    }

//    public String getState() {
//        return state;
//    }

    public String getId() {
        return id;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public String getFacebookAccount() {
        return facebookAccount;
    }

//    public String getDistrict() {
//        return district;
//    }

    public String getPhone() {
        return phone;
    }

//    public float getMissedVotesPct() {
//        return missedVotesPct;
//    }

//    public Bitmap getImage() {
//        return image;
//    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
