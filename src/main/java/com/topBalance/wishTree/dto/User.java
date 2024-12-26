package com.topBalance.wishTree.dto;
// javax -> jakarta
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id // primary key
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private Date userBirthdate;
    private String userGender;
    private int ranking;
    private int totalScore;
    private Date gameDate;
    private int dailyVisit;

}
