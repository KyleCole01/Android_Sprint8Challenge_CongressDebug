package com.lambdaschool.congressdata;

import com.lambdaschool.congressdataapiaccess.CongresspersonOverview;

public class OfficialOverview {
    private String firstName, middleName, lastName;
    private String party, state;
    private String displayName;
    private String id;

    public OfficialOverview(String firstName, String middleName, String lastName, String party, String state, String id) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.party = party;
        this.state = state;
        this.displayName = buildDisplayName();
        this.id = id;
    }

    public OfficialOverview(CongresspersonOverview congresspersonOverview) {
        this.firstName = congresspersonOverview.getFirstName();
        this.middleName = congresspersonOverview.getMiddleName();
        this.lastName = congresspersonOverview.getLastName();
        this.party = congresspersonOverview.getParty();
        this.state = congresspersonOverview.getState();
        this.displayName = buildDisplayName();
        this.id = congresspersonOverview.getId();
    }

    public String buildDisplayName() {
        StringBuilder nameBuilder = new StringBuilder();
        // needed another append for the space between names
        nameBuilder.append(firstName).append(" ");
        if (!middleName.equals("null")) {
            nameBuilder.append(middleName).append(" ");
        }
        nameBuilder.append(lastName);
        //removed .toLowerCase();
        return nameBuilder.toString();
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getId() {
        return id;
    }

    public String getParty() {
        return party;
    }

    public String getState() {
        return state;
    }
}
