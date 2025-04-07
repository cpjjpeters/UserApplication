package com.dotcapital.user.model;

import com.dotcapital.user.enumer.UserCategory;
import com.dotcapital.user.enumer.UserLanguage;
import com.dotcapital.user.enumer.UserMandateDomain;
import com.dotcapital.user.enumer.UserStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/* carlpeters created on 07/04/2025 inside the package - com.dotcapital.user.model */
@Data
@NoArgsConstructor
public class User {
    private Long entityId;
    private String actorId;
    private String userIdentifier;
    private UserCategory userCategory;
    private String moralCustomerId;
    private UserLanguage userLanguage;
    private String userFirstName;
    private String userLastName;
    private UserStatus userStatus;
    private int numberFailedLoginAttempts;
    private List<UserMandateDomain> userMandateDomain;
    private boolean finalized;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public String getMoralCustomerId() {
        return moralCustomerId;
    }

    public void setMoralCustomerId(String moralCustomerId) {
        this.moralCustomerId = moralCustomerId;
    }

    public UserLanguage getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(UserLanguage userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public int getNumberFailedLoginAttempts() {
        return numberFailedLoginAttempts;
    }

    public void setNumberFailedLoginAttempts(int numberFailedLoginAttempts) {
        this.numberFailedLoginAttempts = numberFailedLoginAttempts;
    }

    public List<UserMandateDomain> getUserMandateDomain() {
        return userMandateDomain;
    }

    public void setUserMandateDomain(List<UserMandateDomain> userMandateDomain) {
        this.userMandateDomain = userMandateDomain;
    }

    public boolean isFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }
}
