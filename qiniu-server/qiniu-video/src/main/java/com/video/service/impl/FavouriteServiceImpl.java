package com.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.model.ResponseResult;
import com.video.config.CurrentUser;
import com.video.dao.FavouriteDao;
import com.video.model.po.Favourite;
import com.video.model.po.Video;
import com.video.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Favourite)表服务实现类
 *
 * @author makejava
 * @since 2023-11-03 16:14:51
 */
@Service("favouriteService")
public class FavouriteServiceImpl extends ServiceImpl<FavouriteDao, Favourite> implements FavouriteService {
    @Autowired
    private FavouriteService favouriteService;
    @Autowired
    private FavouriteDao favouriteDao;
    @Override
    public ResponseResult favouriteVideo(Favourite favourite) {
        save(favourite);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult unFavouriteVideo(Long id) {
        CurrentUser.getUserId();
        LambdaQueryWrapper<Favourite> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Favourite::getUserId,CurrentUser.getUserId());
        wrapper.eq(Favourite::getVideoId,id);
        favouriteService.remove(wrapper);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getFavouriteVideo(Long id) {
        LambdaQueryWrapper<Favourite> wrapper = new LambdaQueryWrapper<>();
        List<Favourite> favouriteList;
        try {
            wrapper.eq(Favourite::getUserId, id);
            favouriteList = favouriteDao.selectList(wrapper);
        } catch (Exception e) {
            return new ResponseResult(HttpStatus.FORBIDDEN.value(), "获取失败");
        }
        return new ResponseResult<>(HttpStatus.OK.value(), "获取收藏列表成功", favouriteList);
    }
}

