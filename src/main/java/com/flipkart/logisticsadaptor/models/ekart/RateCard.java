package com.flipkart.logisticsadaptor.models.ekart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "rateCard")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class RateCard {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String rateCardId;
    private double basePrice;

    public RateCard() {

    }
}
