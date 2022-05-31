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
@Table(name = "orders")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private String orderId;

    @Column(nullable = false)
    private String trackingId;

    @Column(nullable = false)
    private String merchantCode;

    @Column(nullable = false)
    private String orderStatus;


}
