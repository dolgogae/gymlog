package com.gymory.domain.fee.data;

import com.gymory.domain.base.BaseEntity;
import com.gymory.domain.fee.dto.FeeCreateDto;
import com.gymory.domain.fee.dto.FeeUpdateDto;
import com.gymory.domain.user.trainer.data.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Table(name = "FEE")
@NoArgsConstructor
@AllArgsConstructor
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
    private Integer frequency;

    public static Fee create(FeeCreateDto feeCreateDto, Trainer trainer){
        return Fee.builder()
                .trainer(trainer)
                .price(feeCreateDto.getPrice())
                .frequency(feeCreateDto.getFrequency())
                .build();
    }

    public void updateFee(FeeUpdateDto feeUpdateDto){
        this.price = feeUpdateDto.getPrice();
        this.frequency = feeUpdateDto.getFrequency();
    }
}
