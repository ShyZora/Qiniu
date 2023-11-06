<template>
    <div class='test' width="150px">

        <el-menu class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
            background-color="rgb(22,24,35)" text-color="#fff" active-text-color="#ffd04b">
            <img src="../assets/img/douyin-logo.png" width="100px" style="padding: 18px 9px;" />
            <el-menu-item :index="item.name + ''" v-for="item in noChildren" :key="item.name"
                @click="routerSkip(item.path, item)">
                <i :class="`el-icon-${item.icon}`"></i>
                <span slot="title">{{ item.label }}</span>
            </el-menu-item>
            <el-submenu :index="item.name + ''" v-for="item in hasChildren" :key="item.name">
                <template slot="title">
                    <i :class="`el-icon-${item.icon}`"></i>
                    <span>{{ item.label }}</span>
                </template>
                <el-menu-item-group v-for="children in item.children" :key="children.name">
                    <el-menu-item :index="children.name + ''" :class="`el-icon-${children.icon}`"
                        @click="routerSkip(children.path, children)" style="width: 150px;">{{ children.label
                        }}</el-menu-item>
                </el-menu-item-group>
            </el-submenu>

        </el-menu>
    </div>
</template>
    
<script>
var axios = require('axios');
export default {
    name: 'commonAside',
    data() {
        return {

            menuData: [
                {
                    path: '/',
                    name: 'home',
                    label: '首页',
                    icon: 'menu',
                    url: 'home/home'
                },
                {
                    path: '/recommend',
                    name: 'recommend',
                    label: '推荐',
                    icon: 'video-play',
                    url: 'recommend/recommend'
                },
                {
                    path: '/user',
                    name: 'user',
                    label: '我的',
                    icon: 'user',
                    url: 'userManage/userManage'
                },
                {
                    path: '/collect',
                    name: 'collect',
                    label: '收藏',
                    icon: 'star-on',
                    url: 'collect/collect'
                },
                {
                    label: '分类',
                    icon: 'collection',
                    children: [
                        {
                            path: '/game',
                            name: 'game',
                            label: '游戏',
                            icon: 'coordinate',
                            url: 'classification/game'
                        },
                        {
                            path: '/sports',
                            name: 'sports',
                            label: '体育',
                            icon: 'soccer',
                            url: 'classification/sports'
                        },
                        {
                            path: '/fashion',
                            name: 'fashion',
                            label: '时尚',
                            icon: 'sell',
                            url: 'classification/fashion'
                        },
                        {
                            path: '/music',
                            name: 'music',
                            label: '音乐',
                            icon: 'headset',
                            url: 'classification/music'
                        },
                        {
                            path: '/recreation',
                            name: 'recreation',
                            label: '娱乐',
                            icon: 'sunny',
                            url: 'classification/recreation'
                        },
                        {
                            path: '/twoDim',
                            name: 'twoDim',
                            label: '二次元',
                            icon: 'promotion',
                            url: 'classification/twoDim'
                        },
                        {
                            path: '/knowledge',
                            name: 'knowledge',
                            label: '知识',
                            icon: 'mouse',
                            url: 'classification/knowledge'
                        },
                        {
                            path: '/food',
                            name: 'food',
                            label: '美食',
                            icon: 'fork-spoon',
                            url: 'classification/food'
                        },
                    ]
                }
            ]
        }

    },
    methods: {
        handleOpen(key, keyPath) {
            console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            console.log(key, keyPath);
        },
        routerSkip(path, list) {
            // 默认如果跳转还为该页面，则会报错。当页面路由与跳转路由不一致才执行push
            if (this.$route.path !== path && !(this.$route.path === '/home' && (path === '/'))) {
                this.$router.push(path)
            }
            

        },
        getTag() {
            axios({
                method: 'get',
                url: 'api/home/getCategoryHomeList',

            }).then(function (response) {
                console.log(response.data);
            })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    computed: {

        noChildren() {
            return this.menuData.filter(item => !item.children)
        },
        hasChildren() {
            return this.menuData.filter(item => item.children)
        },

    },
    mounted() {
        this.getTag()
    }
}
</script>
<style scoped lang="less">
.el-menu {

    h3 {
        color: #fff;
        text-align: center;
        line-height: 48px;
        font-size: 16px;
        font-weight: 600
    }
}

.el-submenu .el-menu-item {
    min-width: 150px;
}

.el-menu-vertical-demo {
    height: 100vh;
    border-right: none;
    width: 160px;
}
</style>