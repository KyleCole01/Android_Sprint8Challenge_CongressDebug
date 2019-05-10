
package com.lambdaschool.congressdataapiaccess;

import org.json.JSONObject;

import java.io.Serializable;

public class CongresspersonOverview implements Serializable {

    // SerializedName("id")
    private String id;
    // SerializedName("title")
    private String title;
    // SerializedName("short_title")
    private String shortTitle;
    // SerializedName("api_uri")
    private String apiUri;
    // SerializedName("first_name")
    private String firstName;
    // SerializedName("middle_name")
    private String middleName;
    // SerializedName("last_name")
    private String lastName;
    // SerializedName("suffix")
    private String suffix;
    // SerializedName("date_of_birth")
    private String dateOfBirth;
    // SerializedName("gender")
    private String gender;
    // SerializedName("party")
    private String party;
    // SerializedName("leadership_role")
    private String leadershipRole;
    // SerializedName("twitter_account")
    private String twitterAccount;
    // SerializedName("facebook_account")
    private String facebookAccount;
    // SerializedName("youtube_account")
    private String youtubeAccount;
    // SerializedName("govtrack_id")
    private String govtrackId;
    // SerializedName("cspan_id")
    private String cspanId;
    // SerializedName("votesmart_id")
    private String votesmartId;
    // SerializedName("icpsr_id")
    private String icpsrId;
    // SerializedName("crp_id")
    private String crpId;
    // SerializedName("google_entity_id")
    private String googleEntityId;
    // SerializedName("fec_candidate_id")
    private String fecCandidateId;
    // SerializedName("url")
    private String url;
    // SerializedName("rss_url")
    private String rssUrl;
    // SerializedName("contact_form")
    private String contactForm;
    // SerializedName("in_office")
    private boolean inOffice;
    // SerializedName("dw_nominate")
    private double dwNominate;
    // SerializedName("ideal_point")
    private String idealPoint;
    // SerializedName("seniority")
    private String seniority;
    // SerializedName("next_election")
    private String nextElection;
    // SerializedName("total_votes")
    private int totalVotes;
    // SerializedName("missed_votes")
    private int missedVotes;
    // SerializedName("total_present")
    private int totalPresent;
    // SerializedName("last_updated")
    private String lastUpdated;
    // SerializedName("ocd_id")
    private String ocdId;
    // SerializedName("office")
    private String office;
    // SerializedName("phone")
    private String phone;
    // SerializedName("fax")
    private String fax;
    // SerializedName("state")
    private String state;
    // SerializedName("senate_class")
    private String senateClass;
    // SerializedName("state_rank")
    private String stateRank;
    // SerializedName("lis_id")
    private String lisId;
    // SerializedName("missed_votes_pct")
    private double missedVotesPct;
    // SerializedName("votes_with_party_pct")
    private double votesWithPartyPct;

    public CongresspersonOverview(String id, String title, String shortTitle, String apiUri, String firstName, String middleName, String lastName, String suffix, String dateOfBirth, String gender, String party, String leadershipRole, String twitterAccount, String facebookAccount, String youtubeAccount, String govtrackId, String cspanId, String votesmartId, String icpsrId, String crpId, String googleEntityId, String fecCandidateId, String url, String rssUrl, String contactForm, boolean inOffice, double dwNominate, String idealPoint, String seniority, String nextElection, int totalVotes, int missedVotes, int totalPresent, String lastUpdated, String ocdId, String office, String phone, String fax, String state, String senateClass, String stateRank, String lisId, double missedVotesPct, double votesWithPartyPct) {
        this.id = id;
        this.title = title;
        this.shortTitle = shortTitle;
        this.apiUri = apiUri;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.party = party;
        this.leadershipRole = leadershipRole;
        this.twitterAccount = twitterAccount;
        this.facebookAccount = facebookAccount;
        this.youtubeAccount = youtubeAccount;
        this.govtrackId = govtrackId;
        this.cspanId = cspanId;
        this.votesmartId = votesmartId;
        this.icpsrId = icpsrId;
        this.crpId = crpId;
        this.googleEntityId = googleEntityId;
        this.fecCandidateId = fecCandidateId;
        this.url = url;
        this.rssUrl = rssUrl;
        this.contactForm = contactForm;
        this.inOffice = inOffice;
        this.dwNominate = dwNominate;
        this.idealPoint = idealPoint;
        this.seniority = seniority;
        this.nextElection = nextElection;
        this.totalVotes = totalVotes;
        this.missedVotes = missedVotes;
        this.totalPresent = totalPresent;
        this.lastUpdated = lastUpdated;
        this.ocdId = ocdId;
        this.office = office;
        this.phone = phone;
        this.fax = fax;
        this.state = state;
        this.senateClass = senateClass;
        this.stateRank = stateRank;
        this.lisId = lisId;
        this.missedVotesPct = missedVotesPct;
        this.votesWithPartyPct = votesWithPartyPct;
    }

    public CongresspersonOverview(JSONObject jsonObject) {
        this.id = CongressDao.getStringFromJson(jsonObject, "id");
        this.title = CongressDao.getStringFromJson(jsonObject, "title");
        this.shortTitle = CongressDao.getStringFromJson(jsonObject, "short_title");
        this.apiUri = CongressDao.getStringFromJson(jsonObject, "api_uri");
        this.firstName = CongressDao.getStringFromJson(jsonObject, "first_name");
        this.middleName = CongressDao.getStringFromJson(jsonObject, "middle_name");
        this.lastName = CongressDao.getStringFromJson(jsonObject, "last_name");
        this.suffix = CongressDao.getStringFromJson(jsonObject, "suffix");
        this.dateOfBirth = CongressDao.getStringFromJson(jsonObject, "date_of_birth");
        this.gender = CongressDao.getStringFromJson(jsonObject, "gender");
        this.party = CongressDao.getStringFromJson(jsonObject, "party");
        this.leadershipRole = CongressDao.getStringFromJson(jsonObject, "leadership_role");
        this.twitterAccount = CongressDao.getStringFromJson(jsonObject, "twitter_account");
        this.facebookAccount = CongressDao.getStringFromJson(jsonObject, "facebook_account");
        this.youtubeAccount = CongressDao.getStringFromJson(jsonObject, "youtube_account");
        this.govtrackId = CongressDao.getStringFromJson(jsonObject, "govtrack_id");
        this.cspanId = CongressDao.getStringFromJson(jsonObject, "cspan_id");
        this.votesmartId = CongressDao.getStringFromJson(jsonObject, "votesmart_id");
        this.icpsrId = CongressDao.getStringFromJson(jsonObject, "icpsr_id");
        this.crpId = CongressDao.getStringFromJson(jsonObject, "crp_id");
        this.googleEntityId = CongressDao.getStringFromJson(jsonObject, "google_entity_id");
        this.fecCandidateId = CongressDao.getStringFromJson(jsonObject, "fec_candidate_id");
        this.url = CongressDao.getStringFromJson(jsonObject, "url");
        this.rssUrl = CongressDao.getStringFromJson(jsonObject, "rss_url");
        this.contactForm = CongressDao.getStringFromJson(jsonObject, "contact_form");
        this.inOffice = CongressDao.getBooleanFromJson(jsonObject, "in_office");
        this.dwNominate = CongressDao.getDoubleFromJson(jsonObject, "dw_nominate");
        this.idealPoint = CongressDao.getStringFromJson(jsonObject, "ideal_point");
        this.seniority = CongressDao.getStringFromJson(jsonObject, "seniority");
        this.nextElection = CongressDao.getStringFromJson(jsonObject, "next_election");
        this.totalVotes = CongressDao.getIntFromJson(jsonObject, "total_votes");
        this.missedVotes = CongressDao.getIntFromJson(jsonObject, "missed_votes");
        this.totalPresent = CongressDao.getIntFromJson(jsonObject, "total_present");
        this.lastUpdated = CongressDao.getStringFromJson(jsonObject, "last_updated");
        this.ocdId = CongressDao.getStringFromJson(jsonObject, "ocd_id");
        this.office = CongressDao.getStringFromJson(jsonObject, "office");
        this.phone = CongressDao.getStringFromJson(jsonObject, "phone");
        this.fax = CongressDao.getStringFromJson(jsonObject, "fax");
        this.state = CongressDao.getStringFromJson(jsonObject, "state");
        this.senateClass = CongressDao.getStringFromJson(jsonObject, "senate_class");
        this.stateRank = CongressDao.getStringFromJson(jsonObject, "state_rank");
        this.lisId = CongressDao.getStringFromJson(jsonObject, "lis_id");
        this.missedVotesPct = CongressDao.getDoubleFromJson(jsonObject, "missed_votes_pct");
        this.votesWithPartyPct = CongressDao.getDoubleFromJson(jsonObject, "votes_with_party_pct");
    }
    public CongresspersonOverview(String firstName, String middleName, String lastName, String party, String state, String id){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.party = party;
        this.state = state;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public String getApiUri() {
        return apiUri;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getParty() {
        return party;
    }

    public String getLeadershipRole() {
        return leadershipRole;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public String getFacebookAccount() {
        return facebookAccount;
    }

    public String getYoutubeAccount() {
        return youtubeAccount;
    }

    public String getGovtrackId() {
        return govtrackId;
    }

    public String getCspanId() {
        return cspanId;
    }

    public String getVotesmartId() {
        return votesmartId;
    }

    public String getIcpsrId() {
        return icpsrId;
    }

    public String getCrpId() {
        return crpId;
    }

    public String getGoogleEntityId() {
        return googleEntityId;
    }

    public String getFecCandidateId() {
        return fecCandidateId;
    }

    public String getUrl() {
        return url;
    }

    public String getRssUrl() {
        return rssUrl;
    }

    public String getContactForm() {
        return contactForm;
    }

    public boolean isInOffice() {
        return inOffice;
    }

    public double getDwNominate() {
        return dwNominate;
    }

    public String getIdealPoint() {
        return idealPoint;
    }

    public String getSeniority() {
        return seniority;
    }

    public String getNextElection() {
        return nextElection;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public int getMissedVotes() {
        return missedVotes;
    }

    public int getTotalPresent() {
        return totalPresent;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public String getOcdId() {
        return ocdId;
    }

    public String getOffice() {
        return office;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getState() {
        return state;
    }

    public String getSenateClass() {
        return senateClass;
    }

    public String getStateRank() {
        return stateRank;
    }

    public String getLisId() {
        return lisId;
    }

    public double getMissedVotesPct() {
        return missedVotesPct;
    }

    public double getVotesWithPartyPct() {
        return votesWithPartyPct;
    }
}
