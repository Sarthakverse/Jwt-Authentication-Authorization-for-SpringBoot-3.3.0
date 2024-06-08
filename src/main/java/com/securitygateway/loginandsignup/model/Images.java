package com.securitygateway.loginandsignup.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Images {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "image_seq")
    @SequenceGenerator(name = "image_seq",sequenceName = "image_sequence")
    private Integer id;
    private String imageUrl;
}
