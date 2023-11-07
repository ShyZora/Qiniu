<template>
    <div class="homePage">
        <div class="home">
            <div width="auto" class="aside">
                <Aside :urlarr="urlarr[index]"  v-if="isGetData"></Aside>
            </div>
            <div class="main">
                <PlayerVideo :urlarr="urlarr" @dataDelivery="dataDelivery"  v-if="isGetData"></PlayerVideo>
            </div>

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
                url: '/video/video/feed?userId=user',

            }).then(function (response) {
               
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