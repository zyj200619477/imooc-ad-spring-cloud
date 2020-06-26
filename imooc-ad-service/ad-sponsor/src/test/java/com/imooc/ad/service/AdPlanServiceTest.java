package com.imooc.ad.service;

import com.imooc.ad.Application;
import com.imooc.ad.exception.AdException;
import com.imooc.ad.vo.AdPlanGetRequest;
import com.imooc.ad.vo.AdUnitItRequest;
import com.imooc.ad.vo.AdUnitRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AdPlanServiceTest {

    @Autowired
    private IAdPlanService planService;
    @Autowired
    private IAdUnitService unitService;
    @Test
    public void testGetAdPlan() throws AdException {

        System.out.println(
                planService.getAdPlanByIds(
                        new AdPlanGetRequest(15L, Collections.singletonList(10L))
                )
        );
    }

    @Test
    public void testCreateUnitIt() throws AdException {

        System.out.println(
             unitService.createUnitIt(
                     new AdUnitItRequest(Collections.singletonList(
                             new AdUnitItRequest.UnitIt(20L, "Basketball")))
             )
        );
    }
}
