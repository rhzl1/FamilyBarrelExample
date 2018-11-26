package com.example.mapper;

import com.example.pojo.SysUser;
import com.example.sqlProviderTool.HomeSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    /**
     * 注解请求方式
     * @param suName
     * @param phone
     * @return
     */
    @SelectProvider(type = HomeSqlProvider.class, method = "selectAll")
    List<Map<String,Object>> getAll(@Param("suName")String suName,@Param("phone")String phone);

    /**
     * xml请求方式
     * @param suName
     * @return
     */
    Map<String,Object> selectQueryBySuName(@Param("suName") String suName);
}
