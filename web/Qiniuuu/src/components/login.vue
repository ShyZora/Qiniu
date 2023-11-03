<template>
    <div>
        <el-popover placement="right" width="200" trigger="click">
            <div>
                <form>
                    <input type="text" placeholder="请输入用户名" v-model="username" />
                    <input type="password" placeholder="请输入密码" v-model="password" />
                    <button @click.prevent="login">登录</button>
                </form>
            </div>
            <el-button type="danger" round size="small" style="width: 80px;height: 35px;" slot="reference"><i
                    class="el-icon-user-solid"></i><span style="width: 5px;" slot="reference"></span>登录</el-button>
        </el-popover>
    </div>
</template>
<script>
export default {
    data() {
        return {
            username: '',
            password: ''
        }
    },
    methods: {
        login() {
            // 处理登录逻辑
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
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
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
    width: 100%;
    height: 40px;
    margin-top: 20px;
    background-color: #409eff;
    border: none;
    border-radius: 4px;
    color: #fff;
    font-size: 14px;
    cursor: pointer;
}
</style>