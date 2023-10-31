const express = require('express');
const qiniu = require('qiniu');
const app = express();

// 配置七牛云相关信息
const accessKey = 'ud1jGtOB-1fw0phJXYSgjjXE3hQ8xIYM0dhFOJXy';
const secretKey = 'IeCMOi7r3WyDvmSIWSdiGmVCQkk6Q4jQw7Jb8Sj5';
const bucket = 'gogogo-offer';

const mac = new qiniu.auth.digest.Mac(accessKey, secretKey);
const config = new qiniu.conf.Config();

// 定义一个路由来获取上传凭证
app.get('/getUploadToken', (req, res) => {
  const options = {
    scope: bucket,
    expires: 3600, // 上传凭证有效期，单位秒
  };

  const putPolicy = new qiniu.rs.PutPolicy(options);
  const uploadToken = putPolicy.uploadToken(mac);

  res.json({ uploadToken });
});

// 启动Express服务器
const port = 3000;
app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
