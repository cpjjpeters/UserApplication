package com.dotcapital.user.enumer;

import lombok.Builder;

import java.util.List;
import java.util.Optional;

@Builder
public class UserDomain {

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

    public Optional<Long> getEntityId() {
        return Optional.ofNullable(entityId);
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

    public UserLanguage getLanguage() {
        return language;
    }

    public void setLanguage(UserLanguage language) {
        this.language = language;
    }

    public Optional<String> getFirstName() {
        return Optional.ofNullable(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return Optional.ofNullable(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Optional<String> getFullName() {
        if (getLastName().isEmpty() && getFirstName().isEmpty()) {
            return Optional.empty();
        }
        final String lastName = getLastName().map(ln -> ln.concat(" ")).orElse("");
        final String firstName = getFirstName().orElse("");
        final String fullName = (!lastName.isEmpty() ? lastName + firstName : firstName).trim();

        return fullName.isEmpty() ? Optional.empty() : Optional.of(fullName);
    }

}
