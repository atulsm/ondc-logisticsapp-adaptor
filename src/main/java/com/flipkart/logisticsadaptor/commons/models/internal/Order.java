package com.flipkart.logisticsadaptor.commons.models.internal;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

@lombok.ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "order")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private String orderId;

    @Column(name = "tracking_id" , nullable = false)
    private String trackingId;

    @Column(name = "merchant_code" , nullable = false)
    private String merchantCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created;

    @PrePersist
    protected void onCreate() {
         created = new Date();
    }

}
