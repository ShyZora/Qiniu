<template>
    <div>
        <input type="file" ref="fileInput" @change="uploadVideo">
    </div>
</template>
  
<script>
import * as qiniu from 'qiniu-js'
export default {
    methods: {
        async uploadVideo() {
            const fileInput = this.$refs.fileInput;
            const file = fileInput.files[0];
            // 上传视频至七牛云
            const suffix = file.name.split('.')[1];  // 后缀名
            const _this = this;
            const current = new Date().getTime();
            // const key = `video_${current}.${suffix}`;    // key为上传后文件名 必填
            const key = null;    // key：文件资源名，为空字符串时则文件资源名也为空，为 null 或者 undefined 时则自动使用文件的 hash 作为文件名
            const config = {
                useCdnDomain: true,
                region: qiniu.region.z2,    // 根据地区不同，官网有不同的配置
                concurrentRequestLimit: 1000,
            };
            var observable = qiniu.upload(file, key, 'ud1jGtOB-1fw0phJXYSgjjXE3hQ8xIYM0dhFOJXy:tWnwrfrl5gK2hoz37DnXL7HWQoI=:eyJzY29wZSI6ImdvZ29nby1vZmZlciIsImRlYWRsaW5lIjoxNjk4NzU1NzcxfQ==', config);  // _this.qiniuToken 由后端提供，通过接口获取
            var observer = {
                next(res) {    // 用于展示上传进度
                    _this.percent = res.total.percent;
                    console.log(res.total.percent)
                },
                error(err) {
                    _this.$Message.destroy();
                    _this.$Message.error(err.data.error);  // 上传错误报错
                    console.log(err.data.error)
                },
                // 上传成功的回调，res中可以拿到七牛云返回的key和hash
                complete(res) {
                    _this.videoForm.file = res.hash;  // 七牛云回传的视频hash 和 key
                    _this.$Message.destroy();
                    _this.$Message.success('上传成功！');
                    console.log('上传成功！')
                    if (!_this.videoForm.cover) _this.getVideoCover(file);   // 默认截取视频第一帧作为封面(存在用户自定义上传的封面时，不进行覆盖)
                    let videoName = file.name.split('.')[0].length <= 30 ? file.name.split('.')[0] : file.name.split('.')[0].substring(0, 30);
                    _this.videoForm.title = _this.videoForm.title || videoName;  // 默认将视频名称作为标题
                },
            };
            this.subscription = observable.subscribe(observer);  // 开始上传（赋值给一个全局的参数，可以在合适的时机通过：subscription.unsubscribe() 终止上传）
        },
        // const fileInput = this.$refs.fileInput;
        // const file = fileInput.files[0];

        // // 使用七牛云SDK上传视频
        // // 请替换以下示例中的相关参数
        // const key = file.name;
        // const token='ud1jGtOB-1fw0phJXYSgjjXE3hQ8xIYM0dhFOJXy:tWnwrfrl5gK2hoz37DnXL7HWQoI=:eyJzY29wZSI6ImdvZ29nby1vZmZlciIsImRlYWRsaW5lIjoxNjk4NzU1NzcxfQ=='
        // const config = {
        //   useCdnDomain: true,
        // };

        // const putExtra = {
        //   params: {},
        //   mimeType: ['video/*'],
        // };

        // const observable = qiniu.upload(file, key, token, putExtra, config);
        // const subscription = observable.subscribe({
        //   next(res) {
        //     // 上传进度
        //     console.log("上传进度", res.total.percent + "%");
        //   },
        //   error(err) {
        //     // 上传失败
        //     console.error("上传失败", err);
        //   },
        //   complete(res) {
        //     // 上传完成
        //     console.log("上传完成", res);
        //   }
        // });
    }

};
</script>
  