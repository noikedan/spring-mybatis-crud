package dev.itboot.mb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.itboot.mb.model.Staff;
import dev.itboot.mb.mapper.StaffMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class StaffService {

    private final StaffMapper mapper;

    public List<Staff> selectAll() {
        return mapper.selectAll();
    }

    public Staff selectByPrimaryKey(Long id) {
    	
    	
    	try {
    	    
    	} catch (Exception ex) {
    	   
    	} finally {
    	  
    	}
        return mapper.selectByPrimaryKey(id);
    }

    public void save(Staff staff) {
        if (staff.getId() == null) {
            mapper.insert(staff);
        } else {
            mapper.updateByPrimaryKey(staff);
        }
    }

    public void deleteByPrimaryKey(Long id) {
        mapper.deleteByPrimaryKey(id);
    }
}
