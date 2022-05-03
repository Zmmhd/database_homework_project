package com.example.demo.service;

import com.example.demo.Mapper.ShowMapper;
import com.example.demo.entity.Show;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShowService {
    @Autowired
    private ShowMapper showMapper;

    public List<Show> getShowList() {

        return showMapper.selectList(null);
    }


    public List<Show> getShowByType(String showType) {
        return showMapper.selectByShowType(showType);
    }

    public List<Show> getShowByName(String showName) {
        return showMapper.selectByShowName(showName);
    }


    @Transactional
    public boolean addShow(Show show) {
        if(show.getShowName()!=null&&!"".equals(show.getShowName())){
            try{
                show.setShowId(showMapper.getMaxId()+1);
                int effectedNum = showMapper.insert(show);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("信息不能为空！");
        }
    }

    public boolean modifyShow(Show show) {
        if(show.getShowId()!=null && show.getShowId()>0){
            try{
                //更新区域信息
                int effectedNum = showMapper.updateById(show);
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


    public boolean deleteShow(int showId) {
        if(showId>0){
            try{
                int effectedNum = showMapper.deleteById(showId);
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


    public PageInfo<Show> pageQuery(Integer showId, String showName, String showType, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        if(showId!=null){
            map.put("show_id",showId);
        }
        if(showName!=null && !showName.isEmpty()){
            map.put("show_name",showName);
        }
        if(showType!=null && !showType.isEmpty()){
            map.put("show_type",showType);
        }
        List<Show> all = showMapper.selectByMap(map);
        return new PageInfo<>(all);
    }


    public Show getShowById(Integer showId) {
        return showMapper.selectById(showId);
    }


}
