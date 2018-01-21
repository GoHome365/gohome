package com.gohome.dao;

import com.gohome.data.Community;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityDao {
    /**
     * 根据城市查询小区
     * @param
     * @return
     */
    List<Community> getCommunityInfo(@Param("city")  String city);





}
