
const NodePolyfillPlugin = require('node-polyfill-webpack-plugin')
const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  configureWebpack: {
    plugins: [new NodePolyfillPlugin()],
    resolve: { fallback: { fs: false, tls: false, net: false } }
  },
  transpileDependencies: true,
  pluginOptions: {
    electronBuilder: {
      nodeIntegration: true
    }
  },
  devServer:{
    proxy:{
      '/api':{
        target:'https://qiniu.wcilzo.site:12008',
        ws:false,
        changeOrigin:true,
        secure:true,
        pathRewrite:{
          '^/api':''
        }
      },
      '/login':{
        target:'https://qiniu.wcilzo.site:12006',
        ws:false,
        changeOrigin:true,
        secure:true,
        pathRewrite:{
          '^/login':''
        }
      },
      '/video':{
        target:'https://qiniu.wcilzo.site:12007',
        ws:false,
        changeOrigin:true,
        secure:true,
        pathRewrite:{
          '^/video':''
        }
      },
    }
  }

})
