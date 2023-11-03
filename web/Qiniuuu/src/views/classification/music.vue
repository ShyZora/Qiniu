<template>
    <div class="musicPage">
        <div class="music">
            <div width="auto" class="aside">
                <Aside></Aside>
            </div>
            <div class="main">
                <PlayerVideo></PlayerVideo>
            </div>

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
           
        }
    },
    components: {
        Aside,
        PlayerVideo
    },
    methods: {
   
  
  },
}
</script>
<style scoped>
.musicPage {
    width: 100%;
    height: 98%;
    background-color: black;
}
.playerVideo{
    width: 100%;
    height: 100%;
}
</style>