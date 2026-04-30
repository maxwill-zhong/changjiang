package com.les.decisionsupport.ods.situation.mapper;

import com.les.decisionsupport.ods.situation.model.RoadSafetyLevelInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoadSafetyLevelInfoMapper {

    /**
     * 根据批次号、道路ID查询
     * @param roadId
     * @param batchNo
     * @return
     */
    RoadSafetyLevelInfo selectOneByRoadIdAndBatchNo(@Param("roadId") String roadId,
                                                    @Param("batchNo") String batchNo);

    /**
     * 查询最新批次号道路评级数据
     * @return
     */
    List<RoadSafetyLevelInfo> selectNewestBatchList();

    /**
     * 根据道路ID,查询最新批次评级数据
     * @param roadId
     * @return
     */
    RoadSafetyLevelInfo selectNewestBatchByRoadId(String roadId);

}
