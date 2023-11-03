
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
  devServer: {
    proxy: {
      ws: false
    }
  }
})
