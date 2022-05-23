package com.flipkart.logisticsadaptor.models.ekart;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@lombok.ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "merchant")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class Merchant {
    @Id
    @Column(name = "id", nullable = false)
    private String merchantId;
    private String merchantCode;
    private String authHeader;
    @OneToOne
    @JoinColumn(name = "rateCardId" , referencedColumnName = "id")
    private RateCard rateCardId;

    public Merchant() {

    }
}
