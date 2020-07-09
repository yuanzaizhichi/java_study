package com.spring.test;

import com.cxf.test.HttpDemo;
import com.work.Application;
import com.work.entity.SysUser;
import com.work.repository.SysUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class JpaApplicationTest {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Test
    void contextLoads(){
//        SysUser sysUser = sysUserRepository.findById(2l).get();
//        System.out.println(sysUser.getName());
//        HttpDemo.httpSend(sysUser);

        List<SysUser> all = sysUserRepository.findAll();
        for (SysUser s : all) {
            HttpDemo.httpSend(s);
        }
    }
}
