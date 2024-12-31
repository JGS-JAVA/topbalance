package com.topBalance.wishTree.dto;
// javax -> jakarta
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor // 필수생성자 자동생성
@NoArgsConstructor // 기본생성자 자동생성
@Getter // 게터 자동생성
@Setter // 세터 자동생성
public class User {

    @Id // 해당필드를 primary key로 지정
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
