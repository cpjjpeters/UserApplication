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
    @Version
    private Long version;
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

}
