package com.example.SqlProviderTool;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class HomeSqlProvider {

    public String selectAll(@Param("suName")String suName,@Param("phone")String phone){

        return new SQL(){
            {
                SELECT("suName,phone");
                FROM("sys_user");
                if (suName != "" && suName != null){
                    WHERE("suName=#{suName}");
                }
                if(phone != "" && phone != null){
                    WHERE("phone=#{phone}");
                }
            }
        }.toString();
    }
}
