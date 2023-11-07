package com.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.dao.VideoOperationDao;
import com.video.model.po.VideoOperation;
import com.video.service.VideoOperationService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (VideoOperation)表服务实现类
 *
 * @author makejava
 * @since 2023-11-06 14:37:23
 */
@Service("videoOperationService")
public class VideoOperationServiceImpl extends ServiceImpl<VideoOperationDao, VideoOperation> implements VideoOperationService {
    @Autowired(required = false)
    private VideoOperationDao videoOperationDao;
    public List<Long> recommend(Integer userId) throws TasteException {
        List<VideoOperation> userList = videoOperationDao.getAllUserPreference();
        for (VideoOperation i:userList){
            System.out.println(i);
        }
        //创建数据模型
        DataModel dataModel = this.createDataModel(userList);
        //获取用户相似程度
        UserSimilarity similarity = new UncenteredCosineSimilarity(dataModel);
        //获取用户邻居
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(2, similarity, dataModel);
        //构建推荐器
        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);
        //推荐2个
        List<RecommendedItem> recommendedItems = recommender.recommend(userId, 5);
        List<Long> itemIds = recommendedItems.stream().map(RecommendedItem::getItemID).collect(Collectors.toList());
        for (Long i:itemIds){
            System.out.println(i);
        }
        return itemIds;
    }
    private DataModel createDataModel(List<VideoOperation> userArticleOperations) {
        FastByIDMap<PreferenceArray> fastByIdMap = new FastByIDMap<>();
        Map<Long, List<VideoOperation>> map = userArticleOperations.stream().collect(Collectors.groupingBy(VideoOperation::getUserId));
        Collection<List<VideoOperation>> list = map.values();
        for(List<VideoOperation> userPreferences : list){
            GenericPreference[] array = new GenericPreference[userPreferences.size()];
            for(int i = 0; i < userPreferences.size(); i++){
                VideoOperation userPreference = userPreferences.get(i);
                GenericPreference item = new GenericPreference(userPreference.getUserId(), userPreference.getVideoId(), userPreference.getValue());
                array[i] = item;
            }
            fastByIdMap.put(array[0].getUserID(), new GenericUserPreferenceArray(Arrays.asList(array)));
        }
        return new GenericDataModel(fastByIdMap);
    }

}

