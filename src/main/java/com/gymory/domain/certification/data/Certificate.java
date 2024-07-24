package com.gymory.domain.certification.data;

import com.gymory.domain.base.data.BaseEntity;
import com.gymory.domain.user.trainer.data.Trainer;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "CERTIFICATE")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Certificate extends BaseEntity {

    @Id
    @Column(name = "CERTIFICATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Trainer trainer;
    private String certificateName;
    private String pictureUrl;
}
