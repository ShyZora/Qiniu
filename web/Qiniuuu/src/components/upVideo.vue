<template>
    <div>
        <el-popover placement="right" width="230" trigger="click">
            <el-card class="box-card">
                <input type="file" ref="fileInput" @change="uploadVideo" class="uploadButton">
                <div style="width: 200px;height: 200px;" id="main"></div>
            </el-card>

            <ul class="upload" slot="reference">
                <li><i class="el-icon-plus" style="margin-left: 7px;"></i></li>
                <li>投稿</li>
            </ul>


        </el-popover>
    </div>
</template>
  
<script>
import * as qiniu from 'qiniu-js'
import * as echarts from 'echarts';
var axios = require('axios');

export default {
    data() {
        return {
            percent: '1222',
            playToken: '',

        }
    },
    props: ["token"],
    methods: {
        uploadVideo() {
            
            axios({
                method: 'post',
                url: 'video/video/upload',
                header: {
                    token: this.token,
                   
                }

            }).then(function (response) {
                console.log(response.data)
            })
                .catch(function (error) {
                    console.log(error);
                });
            // const fileInput = this.$refs.fileInput;
            // const file = fileInput.files[0];
            // // 上传视频至七牛云
            // const suffix = file.name.split('.')[1];  // 后缀名
            // const that = this
            // if (that.token) {
            //     const current = new Date().getTime();
            //     // const key = `video_${current}.${suffix}`;    // key为上传后文件名 必填
            //     const key = file.name + String(current);    // key：文件资源名，为空字符串时则文件资源名也为空，为 null 或者 undefined 时则自动使用文件的 hash 作为文件名
            //     const config = {
            //         useCdnDomain: true,
            //         region: qiniu.region.z2,    // 根据地区不同，官网有不同的配置
            //         concurrentRequestLimit: 1000,
            //     };
            //     var observable = qiniu.upload(file, key, that.token, config);  // _this.qiniuToken 由后端提供，通过接口获取
            //     var observer = {
            //         next(res) {    // 用于展示上传进度
            //             console.log(res.total.percent,)
            //             that.echartsFun(res.total.percent.toFixed(2))
            //             // this.echartsFun(res.total.percent)
            //         },
            //         error(err) {
            //             // console.log(_this)
            //             // _this.$Message.destroy();
            //             // _this.$Message.error(err.data.error);  // 上传错误报错
            //             console.log(err)
            //         },
            //         // 上传成功的回调，res中可以拿到七牛云返回的key和hash
            //         complete(res) {
            //             // _this.videoForm.file = res.hash;  // 七牛云回传的视频hash 和 key
            //             // _this.$Message.destroy();
            //             // _this.$Message.success('上传成功！');
            //             console.log('上传成功！')
            //             // if (!_this.videoForm.cover) _this.getVideoCover(file);   // 默认截取视频第一帧作为封面(存在用户自定义上传的封面时，不进行覆盖)
            //             let videoName = file.name.split('.')[0].length <= 30 ? file.name.split('.')[0] : file.name.split('.')[0].substring(0, 30);
            //             // _this.videoForm.title = _this.videoForm.title || videoName;  // 默认将视频名称作为标题
            //         },
            //     };
            //     this.subscription = observable.subscribe(observer);  // 开始上传（赋值给一个全局的参数，可以在合适的时机通过：subscription.unsubscribe() 终止上传）
            // } else {
            //     this.$message.error('请您先完成登录');
            // }

        },
        echartsFun(e) {
            var myChart = echarts.init(document.getElementById('main'));
            // 绘制图表
            myChart.setOption({
                title: {
                    show: true,
                    text: e + "%",
                    x: "center",
                    y: "center",// 通过x,y将标题(进度)定位在圆环中心
                    textStyle: {
                        fontSize: "25",
                        color: "black",
                        fontWeight: "400",
                        fontFamily: "DINPro, DINPro-Regular",
                    },
                },
                tooltip: {
                    trigger: "item",
                    formatter: "{d}%",

                    show: false,
                },
                legend: {
                    orient: "vertical",
                    x: "left",
                    show: false,
                },
                series: {
                    name: "",
                    type: "pie",
                    radius: ["65%", "85%"],
                    avoidLabelOverlap: true,
                    hoverAnimation: false,
                    label: {
                        normal: {
                            show: false,
                            position: "center",
                        },
                        emphasis: {
                            show: false,
                        },
                    },
                    labelLine: {
                        normal: {
                            show: false,
                        },
                    },
                    data: [
                        {
                            value: e,
                            name: "",
                            itemStyle: {
                                color: "#2AB296",
                            },
                        },
                        {
                            value: 100 - e,
                            name: "",
                            itemStyle: {
                                color: "transparent",//透明色，也可以设置把其他颜色
                            },
                        },
                    ],
                },
            });
        },

    },
    mounted() {


    }

};
</script>
<style scoped>
.upload {
    color: aliceblue;
    cursor: pointer;
}

/* .uploadButton{
    width: 30px;
    height: 10px;
} */
</style>
  