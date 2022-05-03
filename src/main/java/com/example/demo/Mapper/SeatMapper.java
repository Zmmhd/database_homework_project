package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Seat;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatMapper extends BaseMapper<Seat> {

    @Select("select * from tb_seat where show_id = #{showID}")
    List<Seat> findByShowId(Integer showId);

    @Select("select * from tb_seat " +
            "where coordinate_x = #{coordinateX} and coordinate_y = #{coordinateY} " +
            "and show_id = #{showId}")
    List<Seat> findByCoordinateAndShowId(Integer coordinateX, int coordinateY, Integer showId );

    @Select("select count(*) from tb_seat where show_id=#{showId} and coordinate_x=#{coordinateX} and coordinate_y=#{coordinateY}")
    public int countByData(Integer showId,Integer coordinateX,Integer coordinateY);

    @Select("select max(seat_id) from tb_seat")
    Integer getMaxId();
}
