package com.gohome.service;

import com.gohome.dao.CommunityDao;
import com.gohome.data.Community;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {


    @Autowired
    CommunityDao communityDao;


    private Log logger = LogFactory.getLog(this.getClass());


    /**
     * 根据城市获取小区名
     * @param city
     * @return
     */
    public  List<Community> getCommunity(String city) {
        List<Community>  communityList;
        try {
            logger.info("数据库查询城市" + city);
              communityList = communityDao.getCommunityInfo(city);
        } catch (Exception e) {
            logger.error("查询数据库出现异常",e);
            return null;
        }
        logger.info("查询到的社区数据：" + communityList);
        return communityList;
    }


}
