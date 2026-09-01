package com.app.ecom;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
}