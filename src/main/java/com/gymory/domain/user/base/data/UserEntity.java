package com.gymory.domain.user.base.data;

import com.gymory.domain.base.data.BaseEntity;
import com.gymory.domain.user.base.UserPermission;
import com.gymory.domain.user.base.dto.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "USER")
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorColumn(name = "userPermission", discriminatorType = DiscriminatorType.STRING)
public abstract class UserEntity extends BaseEntity {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "USERNAME")
    protected String username;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "PASSWORD")
    protected String password;

    @Column(name = "PERMISSION", insertable = false, updatable = false)
    @Enumerated(value = EnumType.STRING)
    protected UserPermission userPermission;

    @Column(name = "ACCESS_TOKEN", length = 2000)
    protected String accessToken;

    @Column(name = "REFRESH_TOKEN", length = 2000)
    protected String refreshToken;

    public UserEntity setTokens(String accessToken, String refreshToken){
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        return this;
    }
}
