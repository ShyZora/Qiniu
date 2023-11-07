<template>
    <div class="musicPage">
        <div class="home" v-show="urlarr.length">
            <div width="auto" class="aside">
                <Aside :urlarr="urlarr[index]"  v-if="isGetData"></Aside>
            </div>
            <div class="main">
                <PlayerVideo :urlarr="urlarr" @dataDelivery="dataDelivery"  v-if="isGetData"></PlayerVideo>
            </div>

        </div>
        <div v-show="urlarr.length===0">
            <el-empty description="暂无可播放视频" :image-size="400"></el-empty>
        </div>
    </div>
</template>

<script>
var axios = require('axios');
import Aside from '/src/components/aside.vue'
import PlayerVideo from "/src/components/PlayerVideo.vue";
export default {
    name: 'mainPage',
    data() {
        return {
            urlarr: [],
            index: 0,
            isGetData:false
        }
    },
    components: {
        Aside,
        PlayerVideo
    },
    methods: {
        getVideo() {
            let that=this
            axios({
                method: 'get',
                url: '/api/home/getCategoryTagList?id=4',

            }).then(function (response) {
               console.log(response.data)
                that.urlarr=response.data.data
                console.log(that.urlarr,'that')
                that.isGetData = true
            })
                .catch(function (error) {
                    console.log(error);
                });

        },
        dataDelivery(value) {
            this.index = value
            
        }
    },
    mounted() {
        this.getVideo()
    }
}
</script>
<style scoped>
.musicPage {
    width: 100%;
    height: 98%;
    background-color: black;
}

.playerVideo {
    width: 100%;
    height: 100%;
}
</style>