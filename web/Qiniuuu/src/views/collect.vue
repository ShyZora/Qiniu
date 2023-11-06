<template>
    <div class="homePage">
        <div class="home">
            <div width="auto" class="aside">
                <Aside :urlarr="urlarr[index]"></Aside>
            </div>
            <div class="main">
                <PlayerVideo :urlarr="urlarr" @dataDelivery="dataDelivery"></PlayerVideo>
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
            urlarr:
                [
                    {
                        url: 'http://s35y978n4.bkt.clouddn.com/test1.mp41698928518604',
                        upuser: '用户12138',
                        upTime: '2023-11-27',
                        text: '愿意沉溺在世界里',
                        tag: ['生活', '时尚'],
                        collect: Boolean,
                        likeed: Boolean,
                        comment: [
                            {
                                commentUser: '用户233',
                                commentText: '真好玩',
                                commentTime: '2023-11-03',
                            },
                            {
                                commentUser: '用户133',
                                commentText: '很beautiful',
                                commentTime: '2023-11-04',
                            }
                        ],

                    },
                    {
                        url: 'http://s35y978n4.bkt.clouddn.com/test2.mp41698930622104',
                        upuser: '用户12138',
                        upTime: '2023-11-27',
                        text: '愿意沉溺在世界里',
                        tag: ['生活', '时尚'],
                        collect: Boolean,
                        likeed: Boolean,
                        comment: [
                            {
                                commentUser: 'dier用户233',
                                commentText: 'dier真好玩',
                                commentTime: '2023-11-03',
                            },
                            {
                                commentUser: 'dier用户133',
                                commentText: 'dier很beautiful',
                                commentTime: 'dier2023-11-04',
                            }
                        ],

                    },
                ],
            index: 0
        }
    },
    components: {
        Aside,
        PlayerVideo
    },
    methods: {
        getVideo() {
            // axios({
            //     method: 'get',
            //     url: 'video/feed',
            //     headers: {
            //         'User-Agent': 'Apifox/1.0.0 (https://apifox.com)'
            //     }
            // }).then(function (response) {
            //     console.log(response.data);
            // })
            //     .catch(function (error) {
            //         console.log(error);
            //     });
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