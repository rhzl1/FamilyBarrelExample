package com.example.mapper;

import com.example.sqlProviderTool.HomeSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface HomeMapper {

    @SelectProvider(type = HomeSqlProvider.class,method = "selectAll")
    List<Map<String,Object>> getAll(@Param("suName")String suName,@Param("phone")String phone);


}
