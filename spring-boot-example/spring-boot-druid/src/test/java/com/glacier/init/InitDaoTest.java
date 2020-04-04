package com.glacier.init;

import com.glacier.modules.sys.dao.ProvinceRepository;
import com.glacier.modules.sys.dao.RoleRepository;
import com.glacier.modules.sys.dao.UserRepository;
import com.glacier.modules.sys.dao.UserRoleRepository;
import com.glacier.modules.sys.domain.Province;
import com.glacier.modules.sys.domain.Role;
import com.glacier.modules.sys.domain.User;
import com.glacier.modules.sys.domain.UserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InitDaoTest {

    @Resource
    private UserRepository userRepository;
    @Resource
    private ProvinceRepository provinceRepository;
    @Resource
    private RoleRepository roleRepository;
    @Resource
    private UserRoleRepository userRoleRepository;

    @Test
    public void init() {
        // 初始化角色
        Random random = new Random();
        List<Role> roles = new ArrayList<Role>();
        Role role = null;
        char a = 'a';
        String name = null;
        for (int i = 0; i < 10; i++) {
            name = "r_";
            for (int j = 0; j < random.nextInt(10); j++) {
                a = (char) ('a' + random.nextInt(26));
                name += a;
            }
            name = name + (i + 1);
            role = new Role();
            role.setCode(name);
            role.setName(name);
            role.setRemark(name);

            roles.add(role);
        }

        roleRepository.save(roles);

        // 初始化城市
        Date today = Calendar.getInstance().getTime();
        Province province = null;
        Province city = null;
        a = 'A';
        // 保存省份
        for (int i = 0; i < 60; i++) {
            name = "P_";
            for (int j = 0; j < random.nextInt(10); j++) {
                a = (char) ('A' + random.nextInt(26));
                name += a;
            }
            province = new Province();
            province.setCode(name + i);
            province.setName(name + i);
            province.setType(0);
            province.setCreateTime(today);

            province = provinceRepository.save(province);
            System.out.println(province);

            // 保存城市
            for (int j = 0; j < 10; j++) {
                name = "C_";
                for (int k = 0; k < random.nextInt(10); k++) {
                    a = (char) ('A' + random.nextInt(26));
                    name += a;
                }
                city = new Province();
                city.setCode(name + i);
                city.setName(name + i);
                city.setType(province.getType() + 1);
                city.setParentId(province.getId());
                city.setCreateTime(today);

                provinceRepository.save(city);
            }
        }

        // 初始化用户
        List<Province> citys = provinceRepository.findProvinceByType(1);
        List<User> users = new ArrayList<User>();
        User user = null;
        a = 'a';
        for (int i = 0; i < 500; i++) {
            name = "n_";
            for (int j = 0; j < random.nextInt(10); j++) {
                a = (char) ('a' + random.nextInt(26));
                name += a;
            }
            name = name + (i + 1);
            user = new User();
            user.setUserName(name);
            user.setRealName(name);
            user.setUserKey(name);
            user.setPassWord(name);
            user.setEmail(name + "@126.com");
            user.setStatus(random.nextInt(3));
            user.setAdress(name);
            user.setCity(citys.get(random.nextInt(citys.size())));

            users.add(user);
        }

        userRepository.save(users);

        // 初始化
        roles = roleRepository.findAll();
        users = userRepository.findAll();
        List<UserRole> userRoles = new ArrayList<UserRole>();
        UserRole userRole = null;
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < random.nextInt(2) + 1; j++) {
                userRole = new UserRole();
                userRole.setUser(users.get(i));
                userRole.setRole(roles.get(random.nextInt(roles.size())));

                userRoles.add(userRole);
            }
        }

        userRoleRepository.save(userRoles);
    }

}
