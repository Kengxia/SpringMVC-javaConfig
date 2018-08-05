package com.my.work.home.serive;

import com.my.framework.page.PageInfo;
import com.my.work.pojo.IeaseBaseDeptD;

import java.util.List;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 10:27 2018/7/19
 * @Description:
 */
public interface IHomeService {

    List<IeaseBaseDeptD> pageList(PageInfo pageInfo)    ;
}
