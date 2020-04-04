package com.glacier.modules.sys.dao;

import com.glacier.modules.sys.domain.Province;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProvinceRepositoryTest {

    @Resource
    private ProvinceRepository provinceDao;

    @Test
    public void testFindProvinceByType() {
        List<Province> citys = provinceDao.findProvinceByType(1);
        System.out.println(citys);
    }

}
