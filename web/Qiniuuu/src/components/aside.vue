<template>
    <div class='aside'>
        <div>
            <ul>

                <li> <img src="../assets/img/heart.png" width="30px" v-show="!hearted" @click="heart(true)" />
                    <img src="../assets/img/hearted.png" width="35px" height="30px" v-show="hearted"
                        @click="heart(false)" />
                    <p class="urltext1">{{ urlarr.likeNum }}</p>
                </li>
                <li @click="drawer = true">
                    <img src="../assets/img/commet.png" width="30px" />
                    <!-- <p class="urltext">{{ urlarr.comment.length }}</p> -->
                </li>

                <li><img src="../assets/img/collect.png" width="30px" v-show="!collected" @click="collect(true)" />
                    <img src="../assets/img/collected.png" width="30px" v-show="collected" @click="collect(false)" />
                    <p class="urltext">{{ urlarr.favouriteNum }}</p>
                </li>
                <li><img src="../assets/img/share.png" width="30px" @click="copy" />
                    <p class="urltext">{{ urlarr.shareNum }}</p>
                </li>
            </ul>

        </div>
        <div v-show="drawer" class="drawer">
            <div style="height: 20px;"></div>
            <el-row :gutter="20">
                <el-col :span="12">
                    <p style="font-size: 24px;font-weight: bold;margin-left: 20px;">评论</p>
                </el-col>
                <el-col :span="12">
                    <img src="../assets/img/close.png" @click="drawer = false" width="20px"
                        style="margin-left: 100px;margin-top: 6px; cursor: pointer;" />
                </el-col>

            </el-row>
            <div style="padding: 20px;height: 70%;">
                <!-- <el-row :gutter="20" v-for="item in urlarr.comment" style="padding: 10px;">
                    <el-col :span="16">
                        <p class="user">@{{ item.commentUser }}</p>
                        <p class="text">{{ item.commentText }}</p>
                        <p class="time">{{ item.commentTime }}</p>
                    </el-col>

                </el-row> -->
            </div>
            <el-row :gutter="10">
                <el-col :span="19">
                    <el-input placeholder="请输入评论内容" v-model="input" style="margin-left: 10px;">
                    </el-input>
                </el-col>
                <el-col :span="4"><el-button type="success" icon="el-icon-upload2" circle></el-button></el-col>
            </el-row>

        </div>

    </div>
</template>

<script>
var axios = require('axios');
import Cookies from "vue-cookies"
export default {
    name: 'commonAside',
    props: ["urlarr"],
    data() {
        return {
            hearted: false,
            collected: false,
            drawer: false,
            input: '',
            token: '',
        }

    },
    methods: {
        copy() {
            this.$copyText(this.urlarr.videoUrl).then(
                e => {
                    this.$message({
                        message: '复制视频链接成功，快去和朋友们分享叭~',
                        type: 'success'
                    });
                },
            )
            this.urlarr.shareNum+=1

        },
        collect(va) {
            let that = this
            console.log(this.$cookies.get('token'))
            let data = {
                    id: that.urlarr.id,
                    userId: that.urlarr.userId,
                    videoId: that.urlarr.videoId,
                    title: that.urlarr.title,
                    videoUrl: that.urlarr.videoUrl,
                    coverUrl: that.urlarr.coverUrl,
                    createTime: that.urlarr.createTime,
                    updateTime: that.urlarr.updateTime
                }
            if (va) {
                this.collected = true
                this.urlarr.favouriteNum += 1
                
                
                axios({
                    method: 'post',
                    url: 'video/user/favourite',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    data: data
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
                axios({
                    method: 'post',
                    url: 'video/user/favouriteNum',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    data: {
                        id: that.$cookies.get('userId'),
                        favouriteNum: that.urlarr.likeNum
                    }
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            } else {
                this.collected = false
                this.urlarr.favouriteNum -= 1
                
                axios({
                    method: 'post',
                    url: 'video/user/unfavourite',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    id:that.urlarr.id
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
                axios({
                    method: 'post',
                    url: 'video/user/favouriteNum',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    data: {
                        id: that.$cookies.get('userId'),
                        favouriteNum: that.urlarr.likeNum
                    }
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        heart(va) {
            let that = this
            console.log(this.$cookies.get('token'))
            let data = {
                    id: that.urlarr.id,
                    userId: that.urlarr.userId,
                    videoId: that.urlarr.videoId,
                    title: that.urlarr.title,
                    videoUrl: that.urlarr.videoUrl,
                    coverUrl: that.urlarr.coverUrl,
                    createTime: that.urlarr.createTime,
                    updateTime: that.urlarr.updateTime
                }
            if (va) {
                this.hearted = true
                that.urlarr.likeNum += 1
                
                
                axios({
                    method: 'post',
                    url: 'video/user/like',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    data: data
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
                axios({
                    method: 'post',
                    url: 'video/user/videoLikeNum',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    data: {
                        id: that.$cookies.get('userId'),
                        favouriteNum: that.urlarr.likeNum
                    }
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            } else {
                this.hearted = false
                this.urlarr.likeNum -= 1
                
                axios({
                    method: 'post',
                    url: 'video/user/unlike',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    id:that.urlarr.id
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
                axios({
                    method: 'post',
                    url: 'video/user/videoLikeNum',
                    headers: {
                        token: that.$cookies.get('token'),

                    },
                    data: {
                        id: that.$cookies.get('userId'),
                        favouriteNum: that.urlarr.likeNum
                    }
                }).then(function (response) {
                    console.log(response.data)
                })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        }
    },
    mounted() {
        this.$nextTick(function () {
            let token = Cookies.get('token')
            console.log(token, 'cook')
        })

    },
    computed: {

    },
    watch: {
        token: {
            handler() {

            }
        }
    }
}
</script>
<style scoped lang="less">
.aside {
    position: absolute;
    left: 92%;
    z-index: 15;
    height: 80vh;
    border-right: none;
    width: 5.8%;


    ul {
        margin-top: 30vh;
        margin-left: 3vh;

        li {
            margin-top: 40%;
        }

    }

}

img {
    cursor: pointer;
}

.drawer {
    width: 300px;
    height: 90vh;
    position: absolute;
    right: -20px;
    top: 0;
    background-color: white;
    border-radius: 7%;
}

input {
    margin-bottom: 0px;
}

.user {
    font-size: 11px;
    color: rgb(160, 160, 160);
}

.text {
    font-size: 15px;

    padding: 5px;
}

.time {
    font-size: 12px;
    color: rgb(160, 160, 160);
}

.urltext {
    color: aliceblue;
    margin-left: 9px;
}

.urltext1 {
    margin-left: 8px;
    color: aliceblue;
}
</style>