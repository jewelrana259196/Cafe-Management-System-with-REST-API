package com.in.cafe.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "bill")
public class BkashData implements Serializable {
    public static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "invoiceId")
    private String invoiceId;

    @Column(name = "totalAmount")
    private String totalAmount;

    @Column(name = "phone")
    private String phone;

    @Column(name = "otp")
    private String otp;

    @Column(name = "createdby")
    private String createdBy;
}
