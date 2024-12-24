package com.topBalance.wishTree.dto;
// javax -> jakarta
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id // primary key
    private int userId;
    private String userBirthdate;
    private String userGender;
    private String userPassword;
    private int dailyVisit;
    private String userPhone;
    private String userName;
}
