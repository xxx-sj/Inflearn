const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  //build output directory
  outputDir: "../back-end/src/main/resources/static",
  // assetsDir: "./",
  //build index directory
  // indexPath: "./index.html",
  //dev server // npm run serve options
  devServer: {
    hot: true,
    //proxy
    proxy: {
      // http://locahost:8081 -> http://localhost:8080
      '/': {
        target: 'http://localhost:8080',
        //cross origin
        changeOrigin: true,
        ws:false,
      }
    }
  }
})
