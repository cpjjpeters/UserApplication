package com.dotcapital.user.entities;

import com.dotcapital.user.enumer.UserCategory;
import com.dotcapital.user.enumer.UserLanguage;
import com.dotcapital.user.enumer.UserMandateDomain;
import com.dotcapital.user.enumer.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import jakarta.persistence.*;
@Table(name = "GEBRUIKERS")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long entityId;
    @Column(unique = true)
    private String journeyId;
    @Column
    private Boolean finalized;
    @Column
    private String actorId;
//    @BusinessKey
    @Column
    private String userIdentifier;
    @Column
    // TODO [mvm] create enum
    private String userStatus;
    @Column
    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;
    @Column
    private String userLastName;
    @Column
    private String userFirstName;
    @Column
    private String userFullName;
    @Column
    @Enumerated(EnumType.STRING)
    private UserLanguage userLanguage;
    @Column
    private String userEmail;
    @Column
    private String userEmailValidated;
    @Column
    private LocalDate userBirthDate;
    @Column
    private String userBirthPlace;
//    @lombok.ToString.Exclude
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private UserContactInformationEntity userContactInformation;
    @Column
    private String password;
    @Column
    private Boolean skipTwoFactorAuthentication;
    @Column
    private String activeOrganisationIdentifier;
//    @Column(length = 17, scale = 10, precision = 38)
//    private BigDecimal numberFailedLoginAttempts;
//    @Column(columnDefinition = "datetime2")
//    private ZonedDateTime lastSuccessfulLoginTimestamp;
//    @Column(columnDefinition = "datetime2")
//    private ZonedDateTime userDisableTimestamp;
    @Column
    private Boolean userLoggedIn;
//    @Column(columnDefinition = "datetime2")
//    private ZonedDateTime creationDateTime;

    private final static long serialVersionUID = -8815982300088333701L;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(String journeyId) {
        this.journeyId = journeyId;
    }

    public Boolean getFinalized() {
        return finalized;
    }

    public void setFinalized(Boolean finalized) {
        this.finalized = finalized;
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

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public UserLanguage getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(UserLanguage userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmailValidated() {
        return userEmailValidated;
    }

    public void setUserEmailValidated(String userEmailValidated) {
        this.userEmailValidated = userEmailValidated;
    }

    public LocalDate getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(LocalDate userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserBirthPlace() {
        return userBirthPlace;
    }

    public void setUserBirthPlace(String userBirthPlace) {
        this.userBirthPlace = userBirthPlace;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSkipTwoFactorAuthentication() {
        return skipTwoFactorAuthentication;
    }

    public void setSkipTwoFactorAuthentication(Boolean skipTwoFactorAuthentication) {
        this.skipTwoFactorAuthentication = skipTwoFactorAuthentication;
    }

    public String getActiveOrganisationIdentifier() {
        return activeOrganisationIdentifier;
    }

    public void setActiveOrganisationIdentifier(String activeOrganisationIdentifier) {
        this.activeOrganisationIdentifier = activeOrganisationIdentifier;
    }

    public Boolean getUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(Boolean userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }
}
