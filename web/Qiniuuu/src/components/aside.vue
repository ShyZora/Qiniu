<template>
    <div class='aside'>
        <div>
            <ul>
                <li>
                    <div style="margin-left: -5px;">
                        <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                    </div>
                </li>
                <li> <img src="../assets/img/heart.png" width="30px" v-show="!heart" @click="heart = true" /><img
                        src="../assets/img/hearted.png" width="35px" height="30px" v-show="heart" @click="heart = false" />
                </li>
                <li @click="drawer = true"><img src="../assets/img/commet.png" width="30px" />

                </li>

                <li><img src="../assets/img/collect.png" width="30px" v-show="!collect" @click="collect = true" /><img
                        src="../assets/img/collected.png" width="30px" v-show="collect" @click="collect = false" /></li>
                <li><img src="../assets/img/share.png" width="30px" /></li>
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
                <el-row :gutter="20"  v-for="item in urlarr.comment" style="padding: 10px;">
                    <el-col :span="16">
                        <p class="user">@{{ item.commentUser }}</p>
                        <p class="text">{{ item.commentText }}</p>
                        <p class="time">{{ item.commentTime }}</p>
                    </el-col>
                    
                </el-row>
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

export default {
    name: 'commonAside',
    props: ["urlarr"],
    data() {
        return {
            heart: false,
            collect: false,
            drawer: false,
            input: '',

        }

    },
    methods: {

    },
    mounted(){
        console.log(this.urlarr,'url')
    },
    computed: {

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
.user{
    font-size: 11px;
    color: rgb(160, 160, 160);
}
.text{
    font-size: 15px;
   
    padding: 5px;
}
.time{
    font-size: 12px;
    color: rgb(160, 160, 160);
}
</style>