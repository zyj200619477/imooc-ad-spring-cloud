package com.imooc.ad.client;

import com.imooc.ad.client.vo.AdPlan;
import com.imooc.ad.client.vo.AdPlanGetRequest;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
public class SponsorClientHystrix implements SponsorClient{

    @RequestMapping( value = "/ad-sponsor/get/adPlan",
        method = RequestMethod.POST)
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(AdPlanGetRequest request) {
        return new CommonResponse<>(-1,
                "eureka-client-ad-sponsor error");
    }
}
