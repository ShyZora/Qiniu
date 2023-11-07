<template>
    <div class="homePage">
        <div class="home" v-if="urlarr.length">
            <div width="auto" class="aside">
                <Aside :urlarr="urlarr[index]"></Aside>
            </div>
            <div class="main">
                <PlayerVideo :urlarr="urlarr" @dataDelivery="dataDelivery"></PlayerVideo>
            </div>

        </div>
        <div v-if="urlarr.length===0">
            <el-empty description="抱歉，暂无视频播放！" :image-size="400"></el-empty>
        </div>
    </div>
</template>

<script>

import Aside from '/src/components/aside.vue'
import PlayerVideo from "/src/components/PlayerVideo.vue";
export default {
    name: 'mainPage',
    data() {
        return {
           
            index: 0
        }
    },
    props:['urlarr'],
    components: {
        Aside,
        PlayerVideo
    },
    methods: {
        
        dataDelivery(value) {
            this.index = value
            console.log(this.index)
        }
    },
    mounted() {
        
    }
}
</script>
<style scoped>
.homePage {
    width: 100%;
    height: 98%;
    background-color: black;
}

.playerVideo {
    width: 100%;
    height: 100%;
}
</style>