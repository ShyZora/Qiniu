<template>
    <div>
        <div class="header">
            <div class="center">

                <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="input">
                </el-input>
            </div>
            <div class="right">
                <el-row :gutter="10" style="width: 280px;">
                    <el-col :span="4">
                        <div class="grid-content bg-purple">通知</div>
                    </el-col>
                    <el-col :span="5">
                        <div class="grid-content bg-purple-light">私信</div>
                    </el-col>
                    <el-col :span="5">
                        <!-- <upVideo/> -->
                    </el-col>
                    <el-col :span="9" style="margin-top: -12px;">
                        <el-button type="danger" round style="padding: 8px 27px;"
                            @click="dialogVisible = true">登录</el-button>
                    </el-col>
                </el-row>
            </div>


        </div>
        <div>
            
        </div>
    </div>
</template>

<script>
import login from '../components/login.vue'
import upVideo from '../components/upVideo.vue'
export default {
    name: 'home',
    data() {
        return {
            input: "",
            dialogVisible: false
        }
    },
    components: {
        login,
        upVideo
    },
    methods: {
        handleClose(done) {
            done()
        },
        
    }
    // handleCommand(command){
    //     if(command=='a'){
    //         Cookie.remove('token')
    //         this.$router.push('/login')
    //     }


    // }
}
</script>
<style lang="less" scoped>
.header {
    background-color: rgb(22, 24, 35);
    height: 60px;
    justify-content: space-between;
    align-items: center;
    padding: 0 0
}


.center {

    padding: 12px 0;
    width: 300px;
}
.el-dialog__headerbtn{
    top: -5px;
    right: -235px;
}
.right {
    float: right;
    width: 300px;
    margin-top: -44px;
    margin-left: -20px;
    font-size: 13px;
    color: white;
}
</style>