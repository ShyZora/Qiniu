// 嵌套路由的主路由
<template>
    <div class="mainPage">

        <div class="container">
            <div width="auto" class="aside">
                <commonAside>111</commonAside>
            </div>
            <div>
                <div class="header">
                    <commonHeader />
                </div>

                <div class="main">
                    <!-- 子路由的路由出口在这，这个页面相当于大框架  -->
                    <div id="player" style="width: auto;height: 100%;">
                        
                        <PlayerVideo/>
                        
                    </div>

                    <router-view></router-view>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
import commonAside from '/src/components/commonAside.vue'
import commonHeader from '/src/components/commonHeader.vue'
import commonTag from '/src/components/commonTag.vue'
import PlayerVideo from "/src/components/PlayerVideo.vue";
export default {
    name: 'mainPage',
    data() {
        return {
            src: "http://vjs.zencdn.net/v/oceans.mp4",
        }
    },
    components: {
        commonAside,
        commonHeader,
        commonTag,
        PlayerVideo
    }
}
</script>
<style scoped>
.mainPage {
    width: 100%;
    height: 100%;
    background-color: black;
}

.container {
    width: 99%;
    height: 99%;

    .header {
        padding: 0px;
        z-index: 10;
    }

    

    .main {
        height: 95vh;
        width: 100%;
        position: absolute;
        z-index: 5;

    }

}
</style>