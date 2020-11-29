package io.pragra.learning.domain;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class RefData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String value;

    public RefData(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
