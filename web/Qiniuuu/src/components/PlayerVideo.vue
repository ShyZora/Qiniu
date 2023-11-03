<template>
    <div>
        <div id="mse" style="width: 100%; height: 100%">

        </div>
        <div class="info">
            <p>@{{ urlarr[index].upuser }}<span style="font-size: 15px;margin-left: 20px; color: grey;">.{{
                urlarr[index].upTime }}</span></p>
            <p>{{ urlarr[index].text }}<span v-for="item in urlarr[index].tag">#<span @click="skipTag(item)"
                        style="color: rgb(230, 230, 137);cursor: pointer;">{{ item }}</span></span></p>
            <p></p>
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
    props: ["urlarr"],
    data() {
        return {
            // urlarr:
            //     [
            //         {
            //             url: 'http://s35y978n4.bkt.clouddn.com/test1.mp41698928518604',
            //             upuser: '用户12138',
            //             upTime: '2023-11-27',
            //             text: '愿意沉溺在世界里',
            //             tag: ['生活', '时尚'],
            //             collect: Boolean,
            //             likeed: Boolean,
            //             comment: [
            //                 {
            //                     commentUser: '',
            //                     commentText: '',
            //                     commentTime: '',
            //                 }
            //             ],

            //         },
            //         {
            //             url: 'http://s35y978n4.bkt.clouddn.com/test1.mp41698928518604',
            //             upuser: '用户12138',
            //             upTime: '2023-11-27',
            //             text: '愿意沉溺在世界里',
            //             tag: ['生活', '时尚'],
            //             collect: Boolean,
            //             likeed: Boolean,
            //             comment: [
            //                 {
            //                     commentUser: '',
            //                     commentText: '',
            //                     commentTime: '',
            //                 }
            //             ],

            //         },
            //         // 'http://s35y978n4.bkt.clouddn.com/test1.mp41698928518604',
            //         // ' http://s35y978n4.bkt.clouddn.com/test1.mp41698928580785',
            //         // 'http://s35y978n4.bkt.clouddn.com/test1.mp41698930474229',
            //         // 'http://s35y978n4.bkt.clouddn.com/test2.mp4',
            //         // 'http://s35y978n4.bkt.clouddn.com/test2.mp41698929826131',
            //         // 'http://s35y978n4.bkt.clouddn.com/test2.mp41698929875514',
            //         // 'http://s35y978n4.bkt.clouddn.com/test2.mp41698930622104',
            //         // 'http://s35y978n4.bkt.clouddn.com/test3.mp41698929979985',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698928867912',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930247891',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930336898',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930536997',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930629850',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930665690',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930695096',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930791675',
            //         // ' http://s35y978n4.bkt.clouddn.com/testbig.mp41698930853301',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698930960447',
            //         // 'http://s35y978n4.bkt.clouddn.com/testbig.mp41698931002307'

            //         //接收视频储存列表
            //     ],
            index: 0,

        }

    },
    methods: {
        init(url) {
            let player = new Player({
                id: 'mse',
                autoplay: true,
                volume: 0.3,
                url: url,
                playsinline: true,
                // thumbnail: {
                //     pic_num: 44,
                //     width: 160,
                //     height: 90,
                //     col: 10,
                //     row: 10,
                //     urls: [url],
                // },
                // icons: {
                //     loadingIcon:`<div class='customclass'><img src="..assets/img/loading.jpg"/></div>`
                // },
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
                screenShot: {
                    saveImg: true,
                    quality: 0.92,
                    type: 'image/png',
                    format: '.png'
                },
                download: true,
                height: 630,
                width: 1300,
                pip: true,
            });

        },
        skipTag(item) {
            let path = '/home'
            if (item === '音乐') {
                path = '/music'
            } else if (item === '运动') {
                path = '/sports'
            }
            else if (item === '游戏') {
                path = '/game'
            }
            else if (item === '时尚') {
                path = '/fashion'
            }

            else if (item === '娱乐') {
                path = '/recreation'
            }
            if (this.$route.path !== path && !(this.$route.path === '/home' && (path === '/'))) {
                this.$router.push(path)
            }
        },

        handleKeyUp(event) {
            // if (event.key === "ArrowUp") {
            //     // 释放 up 键时触发的事件
            //     console.log('up')
            // }
            if (event.keyCode === 38) {
                if (this.index != 0) {
                    this.index -= 1
                    this.init(this.urlarr[this.index].url)
                    this.$emit('dataDelivery', this.index)
                } else {
                    this.index = this.urlarr.length - 1
                    this.init(this.urlarr[this.urlarr.length - 1].url)
                    this.$emit('dataDelivery', this.index)
                }
            } else if (event.keyCode === 40) {
                if (this.index != this.urlarr.length - 1) {
                    this.index += 1
                    this.init(this.urlarr[this.index].url)
                    this.$emit('dataDelivery', this.index)
                } else {
                    this.index = 0
                    this.init(this.urlarr[0].url)
                    this.$emit('dataDelivery', this.index)
                    this.$message({
                        showClose: true,
                        message: '抱歉暂无更多视频,为您从头播放',
                        type: 'warning'
                    });
                }
            }

        },
    },
    mounted() {
        this.init(this.urlarr[this.index].url)
        document.addEventListener("keyup", this.handleKeyUp);
    },
    beforeDestroy() {
        // 在组件销毁前移除事件监听器以防止内存泄漏
        document.removeEventListener("keyup", this.handleKeyUp);
    },
}



</script>
<style scoped lang="less">
.info {
    width: 800px;
    height: 60px;
    color: aliceblue;
    z-index: 100;
    position: absolute;
    top: 78%;
    left: 200px;

    p {
        margin-top: 15px;
    }
}
</style>