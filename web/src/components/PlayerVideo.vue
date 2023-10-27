<template>
    <div class="box-card">
        <div class="video-player vjs-custom-skin">
            <video id="myVideo" class="video-js">
                <!-- 视频地址 -->
                <source src="" type="video/mp4">
            </video>
        </div>
    </div>
</template>
<script>
export default {

    name: "TestTwo",
    data() {
        return {
        };
    },
    mounted() {
        this.initVideo();
    },
    methods: {
        initVideo() {
            //初始化视频方法
            let myPlayer = this.$video(myVideo, {
                //确定播放器是否具有用户可以与之交互的控件。没有控件，启动视频播放的唯一方法是使用autoplay属性或通过Player API。
                controls: true,
                volume: 0.1,
                playbackRates: [0.7, 1.0, 1.5, 2.0], // 播放速度
                //自动播放属性,muted:静音播放
                autoplay: "muted",
                // autoplay: "true",
                //建议浏览器是否应在<video>加载元素后立即开始下载视频数据。
                preload: "auto",
                //设置视频播放器的显示宽度（以像素为单位）
                width: "90%",
                //设置视频播放器的显示高度（以像素为单位）
                height: "80vh",
                language: "zh-CN",
                aspectRatio: "32:15", // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
                fluid: true, // 当true时,Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
            });
        },
    },

};
</script>
<style scoped>

.video-js{
   top: 15px;
}
</style>
  
 