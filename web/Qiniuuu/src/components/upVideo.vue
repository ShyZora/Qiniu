<template>
    <div>
        <input type="file" @change="handleFileChange" />
        <button @click="uploadVideo">上传视频</button>
    </div>
</template>
  
<script>
import * as qiniuu from "qiniu-js";
import {
    uploadToken, formUploader,
    putExtra
} from '../api/qiniu'
export default {
    data() {
        return {
            videoFile: null,
        };
    },
    methods: {
        handleFileChange(event) {
            this.videoFile = event.target.files[0];
        },
        uploadVideo() {
            // 初始化七牛云配置
            // const config = new qiniu.conf.Config();
            // config.zone = qiniuu.zone.Zone_z0; // 选择华东区域

            // const mac = new qiniu.auth.digest.Mac("i0n_1rEVMkaiRRbnkTOLU4XxbjuLZTXVF2TMCLVb", "n2EXCSWD7STCS-gW-0x1KgFttd3LLvKWj3zh0J3u");
            // const putPolicy = new qiniu.rs.PutPolicy({ scope: "gogogo-offer" });
            // const uploadToken = putPolicy.uploadToken(mac);

            // const formUploader = new qiniu.form_up.FormUploader(config);
            // const putExtra = new qiniu.form_up.PutExtra();

            const key = this.videoFile.name;

            formUploader.putFile(uploadToken, key, this.videoFile, putExtra, (respErr, respBody, respInfo) => {
                if (respErr) {
                    console.log(respErr);
                }
                if (respInfo.statusCode === 200) {
                    console.log("视频上传成功");
                    console.log(respBody);
                } else {
                    console.log("视频上传失败");
                    console.log(respInfo.statusCode);
                    console.log(respBody);
                }
            });
        },
    },
};
</script>
  </script>
  