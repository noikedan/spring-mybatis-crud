package dev.itboot.mb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dev.itboot.mb.model.Staff;

@Mapper
public interface StaffMapper {

    @Select("SELECT * FROM staff")
    List<Staff> selectAll();

    // 以下を追加
    @Select({
        "SELECT * FROM staff",
        "WHERE id = #{id}"
    })
    Staff selectByPrimaryKey(Long id);

    @Insert({
        "INSERT INTO staff(name, email, status, registration)",
        "VALUES(#{name}, #{email}, 't' ,sysdate)"
    })
    int insert(Staff record);

    @Update({
        "UPDATE staff",
        "SET name = #{name}, email = #{email}",
        "WHERE id = #{id}"
    })
    int updateByPrimaryKey(Staff record);

    @Delete({
        "DELETE FROM staff",
        "WHERE id = #{id}"
    })
    int deleteByPrimaryKey(Long id);
}
