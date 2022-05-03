package com.example.demo.service;

import com.example.demo.Mapper.SeatMapper;
import com.example.demo.entity.Seat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SeatService {
    @Autowired
    private SeatMapper seatMapper;

    public List<Seat> getSeatById(Integer showId) {
        return seatMapper.findByShowId(showId);
    }

    @Transactional

    public boolean addSeat(Seat seat) {
        if(seat.getSeatId()!=null && !"".equals(seat.getSeatId())){
            try{
                seat.setSeatId(seatMapper.getMaxId()+1);
                int effectedNum = seatMapper.insert(seat);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入座位信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入座位信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("座位信息不能为空！");
        }
    }


    public boolean deleteSeat(int seatId) {
        if(seatId>0){
            try{
                int effectedNum = seatMapper.deleteById(seatId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除座位信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除座位信息失败:"+e.toString());
            }
        }else{
            throw new RuntimeException("座位ID不能为空！");
        }
    }


    public boolean modifySeat(Seat seat) {
        if(seat.getSeatId()!=null && seat.getSeatId()>0){
            try{
                //更新区域信息
                int effectedNum = seatMapper.updateById(seat);
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("更新座位信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新座位信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("座位信息不能为空！");
        }
    }


    public List<Seat> getSeatIdByCoordinate(Integer coordinateX, Integer coordinateY, Integer showId) {
        return seatMapper.findByCoordinateAndShowId(coordinateX,coordinateY,showId);
    }


    public PageInfo<Seat> pageQuery(Integer seatId, Integer showId, Integer coordinateX, Integer coordinateY, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        if(seatId!=null){
            map.put("seat_id",seatId);
        }
        if(showId!=null){
            map.put("show_id",showId);
        }
        if(coordinateX!=null){
            map.put("coordinate_x",coordinateX);
        }
        if(coordinateY!=null){
            map.put("coordinate_y",coordinateY);
        }

        List<Seat> all = seatMapper.selectByMap(map);
        return new PageInfo<>(all);
    }
}
