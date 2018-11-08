package com.example.sqlProviderTool;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * 对应SQL语句
 */
public class HomeSqlProvider {

    public String selectAll(@Param("suName")String suName,@Param("phone")String phone){

        return new SQL(){
            {
                SELECT("suName,phone");
                FROM("sys_user");
                if (suName.equals("") && suName.isEmpty()){
                    WHERE("suName=#{suName}");
                }
                if(phone.equals("") && phone.isEmpty()){
                    WHERE("phone=#{phone}");
                }
            }
        }.toString();
    }
}
