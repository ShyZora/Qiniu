<template>
    <div class='aside'>
        <ul>
            <li>
                <div style="margin-left: -5px;">
                    <el-avatar  src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                </div>
            </li>
            <li> <img src="../assets/img/heart.png" width="30px"/></li>
            <li><img src="../assets/img/commet.png" width="30px"/></li>
            <li><img src="../assets/img/collect.png" width="30px"/></li>
            <li><img src="../assets/img/share.png" width="30px"/></li>
            <li><img src="../assets/img/more.png" width="30px"/></li>
        </ul>
    </div>
</template>

<script>

export default {
    name: 'commonAside',
    data() {
        return {


        }

    },
    methods: {

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
    height: 89vh;
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

</style>