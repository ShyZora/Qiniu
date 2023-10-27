const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    // 跨域配置
    proxy: {
      // 接口是以 /api 开头的需要代理
      '/video': {
        target: `http://localhost:8083`, // 代理接口地址。实际请求接口地址会是：https://api.mz-moe.cn/api/xxx/xxx
        // secure:false,
        changeOrigin: true, // 默认false，是否需要改变原始主机头为目标URL
        ws: true, // 是否代理websockets
        pathRewrite: {
          '^/video': '', // 重写请求。实际接口中并没有 /api，所以需要替换为空 ''
        },
      },
    },
  },
})
