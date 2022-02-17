package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.config.DicConfig;
import com.codesniper.smartcampus.dao.RiskAreaDao;
import com.codesniper.smartcampus.dto.RiskAreaReq;
import com.codesniper.smartcampus.entity.RiskArea;
import com.codesniper.smartcampus.service.RiskAreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * (RiskArea)表服务实现类
 *
 * @author CodeSniper
 * @since 2022-01-29 01:44:10
 */
@Service("riskAreaService")
public class RiskAreaServiceImpl implements RiskAreaService {

    @Autowired
    private RiskAreaDao riskAreaDao;

    @Override
    public PageInfo<RiskArea> getRiskAreaList(RiskAreaReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 :dto.getPageNum(),dto.getPageSize()==null ? 10 :dto.getPageSize());
        List<RiskArea> list = riskAreaDao.getRiskAreaList(dto);
        for (RiskArea item : list) {
            item.setRiskLevel(DicConfig.RISK_LEVEL_MAP.get(item.getRiskLevel()));
        }
        return new PageInfo<>(list);
    }

    @Override
    public RiskArea getRiskAreaDetail(String id) {
        return riskAreaDao.queryById(id);
    }

    @Override
    public void updateRiskArea(RiskArea dto) {
        dto.setUpdateTime(new Date());
        riskAreaDao.updateRiskArea(dto);
    }
}
