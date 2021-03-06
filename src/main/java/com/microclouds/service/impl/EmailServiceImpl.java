package com.microclouds.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.microclouds.dao.EmailMapper;
import com.microclouds.entity.Email;
import com.microclouds.service.IEmailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@Service
public class EmailServiceImpl extends ServiceImpl<EmailMapper, Email> implements IEmailService {

    @Override
    public Page<Email> selectEmailPage(Page<Email> page, Integer state) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题
        // page.setOptimizeCountSql(false);
        // 不查询总记录数
        // page.setSearchCount(false);
        // 注意！！ 分页 total 是经过插件自动 回写 到传入 page 对象
        return page.setRecords(this.baseMapper.selectEmailList(page, state));
    }

    @Override
    public Boolean deleteEmail(Integer id) {
        int count = this.baseMapper.deleteEmailById(id);
        return count > 0;
    }
}
