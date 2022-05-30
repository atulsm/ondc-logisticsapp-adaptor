package com.flipkart.logisticsadaptor.models.ekart.internal;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@lombok.ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "rateCard")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class RateCard {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String rateCardId;
    private double basePrice;

}
