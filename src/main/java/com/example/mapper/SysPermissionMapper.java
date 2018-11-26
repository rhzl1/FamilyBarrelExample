package com.example.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 权限信息
 */
public interface SysPermissionMapper {

    List<Map<String,Object>> selectPermissionAll(@Param("suId") String suId);
}
