package com.wl.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wl.base.BaseDao;
import com.wl.base.BaseService;
import com.wl.config.MvcConfigure;
import com.wl.model.po.Collection;
import com.wl.model.po.Community;
import com.wl.model.po.Hello;
import com.wl.model.po.Role;
import com.wl.model.po.User;
import com.wl.model.vo.PageResults;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcConfigure.class)
//指定web资源位置
@WebAppConfiguration("src/main/resource")
//不回滚
@Rollback
public class ServiceTest {

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext wac;
	@Autowired
	MockHttpSession session;
	@Autowired
	MockHttpServletRequest request;
	
	@Autowired
	BaseService<Hello, String> helloService;
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void test1() throws Exception {
//		mockMvc.perform(get("/test")).andExpect(view().name("upload"))
//				.andExpect(model().attribute("info", helloService.hello()));
	}
	@Test
	public void JSONTest() {
		List<Hello> hello = helloService.getListByHQL("from Hello");
		System.out.println(hello.size());
	}
	/**
	 * @Author:wuli
	 * @Description:多级菜单测试
	 */
	@Test
	public void levelTest() {
		Community community = new Community();
		community.setName("top");
		Set<Community> set = new HashSet<>();
		for (int i = 0; i < 2; i++) {
			Community community1 = new Community();
			community1.setName("top"+i);
			set.add(community1);
		}
		community.setChild(set);
		Set<Collection> list = new HashSet<>();
		Collection collection = new Collection();
		collection.setName("bottom");
		list.add(collection);
		community.setCollections(list);
//		dao.save(community);
	}
	
	@Test
	public void levelSelectTest() {
//		PageResults<Community> pager = dao.findPageByFetchedHql("from Community", "select count(*) from Community", 1, 2);
//		System.out.println(pager.getPageSize());
	}
	
	@Test
	public void roleTest() {
		Role permission = new Role();
		User user = new User();
		user.setUsername("test");
		user.setPassword("123");
		Set<User> users = new HashSet<>();
		users.add(user);
		permission.setUsers(users);
//		permissionService.save(permission);
	}
	@Test
	public void userTest() {
		User user = new User();
		user.setUsername("test");
		user.setPassword("123");
		Set<Role> permission = new HashSet<>();
		Role obj = new Role();
		obj.setName("权限1");
		permission.add(obj);
		user.setRoles(permission);
//		userService.save(user);
	}
	
}
