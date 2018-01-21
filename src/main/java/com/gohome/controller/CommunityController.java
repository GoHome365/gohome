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


    @Autowired
    CommunityService communityService;

    @RequestMapping(value = "/community/getCommunity",method = RequestMethod.POST)
    public List<Community> getCommunity(@RequestBody  Community community){
        String city = community.getCity();
        List<Community> communityList = communityService.getCommunity(city);
        return communityList;
    }




}
