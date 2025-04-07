package com.dotcapital.user.enumer;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Builder
public class UserMandateDomain {

    private Long entityId;
    private String journeyId;
    private boolean finalized;
    private String mandateIdentifier;
    private String userIdentifier;
    private OrganisationType organisationType;
    private String organisationIdentifier;
    private UserMandateStatus mandateStatus;
    private UserMandateRole mandateRole;
    private boolean investmentsAllowed;
    private boolean issuesAllowed;
    private BigDecimal maxOrderAmount;
    private DailyOrderAmountDomain dailyOrderAmount;
    private String createdBy;
    private ZonedDateTime createdTimestamp;
    private String lastUpdatedBy;
    private ZonedDateTime lastUpdatedTimestamp;

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

    public boolean getFinalized() {
        return finalized;
    }

    public void setFinalized(boolean finalized) {
        this.finalized = finalized;
    }

    public String getMandateIdentifier() {
        return mandateIdentifier;
    }

    public void setMandateIdentifier(String mandateIdentifier) {
        this.mandateIdentifier = mandateIdentifier;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public OrganisationType getOrganisationType() {
        return organisationType;
    }

    public void setOrganisationType(OrganisationType organisationType) {
        this.organisationType = organisationType;
    }

    public String getOrganisationIdentifier() {
        return organisationIdentifier;
    }

    public void setOrganisationIdentifier(String organisationIdentifier) {
        this.organisationIdentifier = organisationIdentifier;
    }

    public UserMandateStatus getMandateStatus() {
        return mandateStatus;
    }

    public void setMandateStatus(UserMandateStatus mandateStatus) {
        this.mandateStatus = mandateStatus;
    }

    public UserMandateRole getMandateRole() {
        return mandateRole;
    }

    public void setMandateRole(UserMandateRole mandateRole) {
        this.mandateRole = mandateRole;
    }

    public boolean getInvestmentsAllowed() {
        return investmentsAllowed;
    }

    public void setInvestmentsAllowed(boolean investmentsAllowed) {
        this.investmentsAllowed = investmentsAllowed;
    }

    public boolean getIssuesAllowed() {
        return issuesAllowed;
    }

    public void setIssuesAllowed(boolean issuesAllowed) {
        this.issuesAllowed = issuesAllowed;
    }

    public BigDecimal getMaxOrderAmount() {
        return maxOrderAmount;
    }

    public void setMaxOrderAmount(BigDecimal maxOrderAmount) {
        this.maxOrderAmount = maxOrderAmount;
    }

    public DailyOrderAmountDomain getDailyOrderAmount() {
        return dailyOrderAmount;
    }

    public void setDailyOrderAmount(DailyOrderAmountDomain dailyOrderAmount) {
        this.dailyOrderAmount = dailyOrderAmount;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(ZonedDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public ZonedDateTime getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(ZonedDateTime lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }
}
