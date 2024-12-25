package com.topBalance.wishTree.service;

import com.topBalance.wishTree.dto.User;
import com.topBalance.wishTree.mapper.RankingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RankingServiceImple implements RankingService {

    @Autowired
    private RankingMapper rankingMapper;

    @Override
    public List<Map<String, Object>> getTenRank() {
        List<User> rankList = rankingMapper.getTenRank();
        return rankList.stream().map( user -> {
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", user.getUserId());
            userMap.put("username", user.getUsername());
            userMap.put("email", user.getEmail());
            userMap.put("birthdate", user.getBirthdate().toString());
            return userMap;
        }).collect(Collectors.toList());
    }

    @Override
    public void selectRank(User user) {
        rankingMapper.selectRank(user);
    }


}
