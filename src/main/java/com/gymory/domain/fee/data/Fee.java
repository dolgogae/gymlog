package com.gymory.domain.fee.data;

import com.gymory.domain.base.data.BaseEntity;
import com.gymory.domain.user.trainer.data.Trainer;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "FEE")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Fee extends BaseEntity {

    @Id
    @Column(name = "FEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private Trainer trainer;
    private Long price;
    private Integer number;
}
