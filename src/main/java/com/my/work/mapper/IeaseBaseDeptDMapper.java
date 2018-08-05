package com.my.work.mapper;

import com.my.framework.page.PageInfo;
import com.my.work.pojo.IeaseBaseDeptD;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IeaseBaseDeptDMapper {
    int deleteByPrimaryKey(String deptId);

    int insert(IeaseBaseDeptD record);

    int insertSelective(IeaseBaseDeptD record);

    IeaseBaseDeptD selectByPrimaryKey(String deptId);

    int updateByPrimaryKeySelective(IeaseBaseDeptD record);

    int updateByPrimaryKey(IeaseBaseDeptD record);

    List<IeaseBaseDeptD> selectIeaseBaseDeptDListPage(@Param("page") PageInfo page);
}