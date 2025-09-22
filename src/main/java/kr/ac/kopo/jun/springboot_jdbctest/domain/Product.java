package kr.ac.kopo.jun.springboot_jdbctest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
// 단방향 : P
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "detail_id")
//    private Detail detail;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Detail detail;
}
