package dev.itboot.mb.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.mb.model.Staff;

@Transactional
@SpringBootTest
class StaffServiceTest {
	
	@Autowired StaffService service;
	@Test
	void testSelectAll() {
		service.selectAll();
		assertEquals("中池", service.selectAll().get(0).getName());
		assertEquals("nakaike@example.com", service.selectAll().get(0).getEmail());
		assertEquals("田中", service.selectAll().get(1).getName());
		assertEquals("tanaka@example.com", service.selectAll().get(1).getEmail());
	}
//
	@Test
	void testSelectByPrimaryKey() {
		assertEquals("中池", service.selectByPrimaryKey((long) 1).getName());
		assertEquals("nakaike@example.com", service.selectByPrimaryKey((long) 1).getEmail());
		assertTrue(service.selectByPrimaryKey((long) 1).isStatus());
	}
//
	@Test
	void testSaveUp() {
		Staff staff = new Staff();
		//更新の場合
		staff.setName("Java太郎");
		staff.setEmail("test@gmail.com");
		staff.setId((long)1);
		service.save(staff);
		assertEquals("Java太郎", service.selectByPrimaryKey((long) 1).getName());
		assertEquals("test@gmail.com",service.selectByPrimaryKey((long) 1).getEmail());
	
	}
//	
	@Test
	void testSaveIn() {
		Staff staff = new Staff();
		//更新の場合
		staff.setName("PHP太郎");
		staff.setEmail("testtest@gmail.com");
		service.save(staff);
		assertEquals("PHP太郎", service.selectByPrimaryKey((long) 3).getName());
		assertEquals("testtest@gmail.com",service.selectByPrimaryKey((long) 3).getEmail());
	}
//
	@Test
	void testDeleteByPrimaryKey() {
	service.deleteByPrimaryKey((long)1);
	assertNull(service.selectByPrimaryKey((long) 1));
	}
}
