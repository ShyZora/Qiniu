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
        <div v-if="urlarr.length === 0">
            <el-empty description="抱歉，暂无视频播放！" :image-size="400"></el-empty>
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
            isGetData: false
        }
    },
    components: {
        Aside,
        PlayerVideo
    },
    methods: {
        getVideo() {
            let that = this
            axios({
                method: 'get',
                url: 'video/user/favourite?userId='+that.$cookies.get('userId'),
                headers: {
                    token: this.$cookies.get('token'),

                }

            }).then(function (response) {

                that.urlarr = response.data.data
                console.log(that.urlarr, 'that')
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