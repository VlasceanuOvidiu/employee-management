package net.ovica.departamentservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}