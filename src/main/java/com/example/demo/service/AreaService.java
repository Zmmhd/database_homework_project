package com.example.demo.service;

import com.example.demo.Mapper.AreaMapper;
import com.example.demo.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaService {

    @Autowired
    private AreaMapper areaMapper;

    public List<Area> getAreaList() {

        return areaMapper.selectList(null);
    }


    public Area getAreaById(int areaId) {

        return areaMapper.selectById(areaId);
    }

    @Transactional
    public boolean addArea(Area area) {
        if(area.getAreaName()!=null&&!"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            area.setAreaId(areaMapper.getMaxId()+1);
            try{
                int effectedNum = areaMapper.insert(area);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("插入区域信息失败");
                }

            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }

    }


    public boolean modifyArea(Area area) {
        if(area.getAreaId()!=null && area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try{
                //更新区域信息
                int effectedNum = areaMapper.updateById(area);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }


    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                int effectedNum = areaMapper.deleteById(areaId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败:"+e.toString());
            }
        }else{
            throw new RuntimeException("区域ID不能为空！");
        }
    }
}
