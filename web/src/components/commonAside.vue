<template>
    <div class='aside'>
        <ul>
            <li>
                <div >
                    <el-avatar  src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                </div>
            </li>
            <li> <img src="../assets/img/heart.png" width="40px"/></li>
            <li><img src="../assets/img/commet.png" width="40px"/></li>
            <li><img src="../assets/img/collect.png" width="40px"/></li>
            <li><img src="../assets/img/share.png" width="40px"/></li>
            <li><img src="../assets/img/more.png" width="40px"/></li>
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
    z-index: 10;
    height: 98vh;
    border-right: none;
    width: 6%;
    

    ul {
        margin-top: 40vh;
        margin-left: 3vh;

        li {
            margin-top: 50%;
        }
        
    }
}

</style>