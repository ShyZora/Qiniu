<template>
    <div>
        <div>
            <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
                v-show="logined"></el-avatar>
        </div>
        <el-popover placement="right" width="200" trigger="click">
            <div>
                <form>
                    <input type="text" placeholder="请输入用户名" v-model="username" />
                    <input type="password" placeholder="请输入密码" v-model="password" />
                    <button @click.prevent="login">登录</button>
                    <button @click.prevent="enroll" style="margin-left: 10%;">注册</button>
                </form>
            </div>
            <el-button type="danger" round size="small" style="width: 80px;height: 35px;" slot="reference"
                v-show="!logined">
                <i class="el-icon-user-solid"></i>
                <span style="width: 5px;" slot="reference"></span>登录
            </el-button>


        </el-popover>
    </div>
</template>
<script>
var axios = require('axios');
import Cookies from "vue-cookies"
let Base64 = require('js-base64').Base64
import bus from "./bus";
export default {
    data() {
        return {
            username: '',
            password: '',
            token: '',
            logined: false
        }
    },
    methods: {
        login() {
            let that = this
            axios({
                method: 'post',
                url: 'login/user/login',
                data: {
                    nickName: that.username,
                    password: that.password
                }

            }).then(function (response) {

                console.log(response.data.data)
                that.token = response.data.data.token
                that.logined = true
                that.$emit('dataDelivery', that.token)

                Cookies.set('token', that.token, 60 * 60 * 24);
                Cookies.set('userId', response.data.data.usrId, 60 * 60 * 24);
                console.log(Cookies.get('token'), Cookies.get('userId'))
                that.$message({
                    message: '登录成功，开始你的奇幻之旅吧~~',
                    type: 'success'
                });

            })
                .catch(function (error) {
                    console.log(error);
                });
        },
        enroll() {
            let that = this
            axios({
                method: 'post',
                url: 'login/user/register',
                data: {
                    user: {
                        nickName: that.username,
                        password: Base64.encode(that.password)
                    },
                    roleId: 2
                }

            }).then(function (response) {
                that.$message({
                    message: '注册成功，快使用新账号登录吧~',
                    type: 'success'
                });
            })
                .catch(function (error) {
                    console.log(error);
                });
        }
    },
    mounted() {
        if (Cookies.get('token')) {
            this.logined = true
        }
    }
}
</script>
<style>
.login-container {
    width: 300px;
    height: 300px;
    margin: 0 auto;
    border: lpx solid #ccc;
    border-radius: 4px;
}

form {
    padding: 20px;
}

input {
    display: block;
    width: 100%;
    height: 40px;
    margin-bottom: 10px;
    padding: 010px;
    box-sizing: border-box;
    border: lpx solid #ccc;
    border-radius: 4px;
    font-size: 14px;
}

button {
    width: 40%;
    height: 40px;
    margin-top: 20px;
    background-color: #409eff;
    border: none;
    border-radius: 4px;
    color: #fff;
    font-size: 14px;
    cursor: pointer;
    margin-left: 10px;
}
</style>