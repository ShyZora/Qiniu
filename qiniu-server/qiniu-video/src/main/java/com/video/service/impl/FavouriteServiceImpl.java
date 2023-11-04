package com.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.model.ResponseResult;
import com.video.config.CurrentUser;
import com.video.dao.FavouriteDao;
import com.video.model.po.Favourite;
import com.video.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public ResponseResult favouriteVideo(Long id) {
        Favourite favourite = new Favourite();
        favourite.setVideoId(id);
        favourite.setUserId(CurrentUser.getUserId());
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
    public ResponseResult getFavouriteVideo() {
        return null;
    }
}

