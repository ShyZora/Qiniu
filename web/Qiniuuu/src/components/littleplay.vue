<template>
    <div>
        <div :id="idd" style="width: 250px; height: 300px">

        </div>

    </div>
</template>
<script>
import Player from "xgplayer";
import hlsjsPlayer from 'xgplayer-hls.js';
import 'xgplayer';
import 'xgplayer/dist/index.min.css';

export default {
    name: 'commonAside',
    props: ["urlarr",'idd'],
    data() {
        return {
            index: 0,
            tag: '',

        }

    },
    methods: {
        init(url) {
            let that = this
            let player = new Player({
                id: that.idd,
                autoplay: false,
                volume: 0.3,
                url: url,
                playsinline: true,

                danmu: {
                    comments: [
                        {
                            duration: 15000,
                            id: '1',
                            start: 3000,
                            txt: '长弹幕长弹幕长弹幕长弹幕长弹幕',
                            style: {  //弹幕自定义样式
                                color: '#ff9500',
                                fontSize: '20px',
                                border: 'solid 1px #ff9500',
                                borderRadius: '50px',
                                padding: '5px 11px',
                                backgroundColor: 'rgba(255, 255, 255, 0.1)'
                            }
                        }
                    ],
                    area: {
                        start: 0,
                        end: 1
                    }
                },
                
                download: true,
                width: 250,
                height: 350,
                pip: true,
            });

        },
    },
    mounted() {
        console.log(this.urlarr, 'this')
        this.init(this.urlarr.videoUrl)

    },
}



</script>
<style scoped lang="less"></style>