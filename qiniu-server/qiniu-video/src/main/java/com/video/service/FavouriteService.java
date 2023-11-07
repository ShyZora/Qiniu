package com.video.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.model.ResponseResult;
import com.video.model.po.Favourite;
import com.video.model.po.Like;

/**
 * (Favourite)表服务接口
 *
 * @author makejava
 * @since 2023-11-03 16:14:51
 */
public interface FavouriteService extends IService<Favourite> {

    ResponseResult favouriteVideo(Favourite favourite);

    ResponseResult unFavouriteVideo(Long id);

    ResponseResult getFavouriteVideo(Long id);
}

