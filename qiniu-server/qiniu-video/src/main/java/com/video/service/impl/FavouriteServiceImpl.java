package com.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.video.dao.FavouriteDao;
import com.video.model.po.Favourite;
import com.video.service.FavouriteService;
import org.springframework.stereotype.Service;

/**
 * (Favourite)表服务实现类
 *
 * @author makejava
 * @since 2023-11-03 16:14:51
 */
@Service("favouriteService")
public class FavouriteServiceImpl extends ServiceImpl<FavouriteDao, Favourite> implements FavouriteService {

}

