<template>
    <div>
        <div class="header">
            <div class="center">

                <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="input">
                </el-input>
            </div>
            <div class="right">
                <el-row :gutter="10" style="width: 200px;">
                    <el-col :span="10">
                        <upVideo />
                    </el-col>
                    <el-col :span="14">
                        <login></login>
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
            dialogVisible: false,
            username: '',
            password: ''
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
        login(){}
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
    width: 240px;
    height: 30px;
}

.el-dialog__headerbtn {
    top: -5px;
    right: -235px;
}

.right {
    float: right;
    width: 210px;
    margin-top: -44px;
    // margin-left: -20px;
    font-size: 13px;
    color: white;
}
 .el-input__inner{
    background-color: transparent !important;
}
</style>