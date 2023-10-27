<template>
    <div>
        <div id="mse" style="width: 100%; height: 100%"></div>
    </div>
</template>
<script>
import Player from "xgplayer";
import hlsjsPlayer from 'xgplayer-hls.js';
import 'xgplayer';
import 'xgplayer/dist/index.min.css';
export default {
    name: 'commonAside',
    data() {
        return {
            urlarr: [
                //接收视频储存列表
              // s32tuvjv2.hn-bkt.clouddn.com
              // "http://s32tuvjv2.hn-bkt.clouddn.com/video/【阿蛋在哪】更新啦，赶紧来围观吧！.mp4"
            ],
            index:0,
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
                thumbnail: {
                    pic_num: 44,
                    width: 160,
                    height: 90,
                    col: 10,
                    row: 10,
                    urls: ['//lf3-static.bytednsdoc.com/obj/eden-cn/nupenuvpxnuvo/xgplayer_doc/xgplayer-demo-thumbnail.jpg'],
                },
                danmu: {
                    comments: [
                        {
                            duration: 15000,
                            id: '1',
                            start: 3000,
                            txt: '长弹幕长弹幕长弹幕长弹幕长弹幕',
                            style: { //弹幕自定义样式
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
                playNext: {
                    urlList: [
                        'url1',
                        'url2',
                        'url3'
                    ],
                },
                pip: true,
            });

        },
        getVedio(){
          // alert("111111111111111")
            axios.get("localhost:8080/vedio/feed").then((res) => {
                for(var i = 0;i < res.data.length; i ++) {
                    urlarr.push(res.data[i].vedioUrl);
                }
            })
        },

        handleKeyUp(event) {
            // if (event.key === "ArrowUp") {
            //     // 释放 up 键时触发的事件
            //     console.log('up')
            // }
            if (event.keyCode === 38) {
                if(this.index!=0){
                    console.log(this.index,'按上键前')
                    this.index-=1
                    this.init(this.urlarr[this.index])
                    console.log(this.index,'按上键后')
                }
            } else if (event.keyCode === 40) {
                if(this.index!=this.urlarr.length-1){
                    console.log(this.index,'按上键前')
                    this.index+=1
                    this.init(this.urlarr[this.index])
                    console.log(this.index,'按上键后')
                }
            }

        },
    },
    mounted() {
        this.getVedio()
        this.init(this.urlarr[this.index])
        document.addEventListener("keyup", this.handleKeyUp);
    },
    beforeDestroy() {
        // 在组件销毁前移除事件监听器以防止内存泄漏
        document.removeEventListener("keyup", this.handleKeyUp);
    },
}



</script>