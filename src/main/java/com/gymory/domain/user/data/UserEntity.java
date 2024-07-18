package com.gymory.domain.user.data;

import com.gymory.domain.base.data.BaseEntity;
import com.gymory.domain.user.UserRole;
import com.gymory.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "USER")
@EntityListeners(AuditingEntityListener.class)
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING)
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

    @Column(name = "ROLE")
    @Enumerated(value = EnumType.STRING)
    protected UserRole userRole;

    @Column(name = "ACCESS_TOKEN", length = 2000)
    protected String accessToken;

    @Column(name = "REFRESH_TOKEN", length = 2000)
    protected String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", insertable = false, updatable = false)
    protected UserRole role;

    public UserEntity setTokens(String accessToken, String refreshToken){
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        return this;
    }
}
