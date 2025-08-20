package com.ss_reservation.ss_reservation_core.sportsComplex.entity;

import com.ss_reservation.ss_reservation_core.account.entity.Account;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AccountComplexGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long createUserId;

    @Column(nullable = false)
    private Long updateUserId;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_admin_id", nullable = false)
    private Account accountAdmin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sports_complex_id", nullable = false)
    private SportsComplex sportsComplex;

    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return account != null ? account.getId() : null;
    }

    public void setAccountId(Long accountId) {
        if (accountId != null) {
            this.account = new Account();
            this.account.setId(accountId);
        } else {
            this.account = null;
        }
    }

    public Long getAccountAdminId() {
        return accountAdmin != null ? accountAdmin.getId() : null;
    }

    public void setAccountAdminId(Long accountAdminId) {
        if (accountAdminId != null) {
            this.accountAdmin = new Account();
            this.accountAdmin.setId(accountAdminId);
        } else {
            this.accountAdmin = null;
        }
    }

    public Long getSportsComplexId() {
        return sportsComplex != null ? sportsComplex.getId() : null;
    }

    public void setSportsComplexId(Long sportsComplexId) {
        if (sportsComplexId != null) {
            this.sportsComplex = new SportsComplex();
            this.sportsComplex.setId(sportsComplexId);
        } else {
            this.sportsComplex = null;
        }
    }
}
