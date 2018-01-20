package com.gohome.controller;

import com.gohome.data.Community;
import com.gohome.service.CommunityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created  by jun
 * 2018-01-20 上午 11:46
 **/

@RestController
public class CommunityController {

    private Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    CommunityService communityService;

    @RequestMapping(value = "/community/getCommunity",method = RequestMethod.POST)
    @ResponseBody
    public List<String> getCommunity(@RequestBody  Community community){
        String city = community.getCity();
        logger.info("查询房源信息，所选城市为" + city);
        List<String> communityList = communityService.getCommunity(city);
        return communityList;
    }




}
