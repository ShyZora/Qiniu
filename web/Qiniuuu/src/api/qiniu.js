
const qiniu = require('qiniu');

var accessKey = 'i0n_1rEVMkaiRRbnkTOLU4XxbjuLZTXVF2TMCLVb';
var secretKey = 'n2EXCSWD7STCS-gW-0x1KgFttd3LLvKWj3zh0J3u';

var mac = new qiniu.auth.digest.Mac(accessKey, secretKey);

// 获取七牛token
var options = {
  scope: 'gogogo-offer',
  expires: 7200
};
const formUploader = new qiniu.form_up.FormUploader(config);
const putExtra = new qiniu.form_up.PutExtra();
var putPolicy = new qiniu.rs.PutPolicy(options);
var uploadToken = putPolicy.uploadToken(mac)
export default {
  putPolicy,
  uploadToken,
  formUploader,
  putExtra
}