package com.dotcapital.user.model;

import com.dotcapital.user.enumer.UserCategory;
import com.dotcapital.user.enumer.UserLanguage;
import com.dotcapital.user.enumer.UserMandateDomain;
import com.dotcapital.user.enumer.UserStatus;
import lombok.Data;

import java.util.List;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.user.model */
@Data
public class User {
    private Long entityId;
    private String actorId;
    private String userIdentifier;
    private UserCategory userCategory;
    private String moralCustomerId;
    private UserLanguage language;
    private String firstName;
    private String lastName;
    private UserStatus userStatus;
    private int numberFailedLoginAttempts;
    private List<UserMandateDomain> userMandateDomain;
    private boolean finalized;
}
