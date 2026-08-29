package com.app.ecom;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String fname;
    private String lname;
    
    // ID ke getter-setter (jo abhi chal rahe hain)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // 🔴 YE DONO GETTERS APNI CLASS ME ADD KAREIN
    public String getFname() { return fname; }
    public String getLname() { return lname; }

    // Setters bhi add karein taaki data save ho sake
    public void setFname(String fname) { this.fname = fname; }
    public void setLname(String lname) { this.lname = lname; }
}