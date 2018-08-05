package com.my.work.home.serive.impl;

import com.my.framework.page.PageInfo;
import com.my.work.home.serive.IHomeService;
import com.my.work.mapper.IeaseBaseDeptDMapper;
import com.my.work.pojo.IeaseBaseDeptD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 华安  mashuai_bj@si-tech.com.cn
 * @Title:
 * @Date: Create in 10:28 2018/7/19
 * @Description:
 */
@Service
@Transactional
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private IeaseBaseDeptDMapper demoMapper;
    @Override
    public List<IeaseBaseDeptD> pageList(PageInfo pageInfo) {
        return demoMapper.selectIeaseBaseDeptDListPage(pageInfo);
    }
}