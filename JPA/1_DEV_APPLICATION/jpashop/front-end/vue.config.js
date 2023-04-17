const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  //build output directory
  outputDir: "../back-end/src/main/resources/static",
  //build index directory
  indexPath: "../static/index.html",

  //dev server // npm run serve options
  devServer: {
    //proxy
    proxy: {
      // http://locahost:8081 -> http://localhost:8080
      '/': {
        target: 'http://localhost:8080',
        //cross origin
        changeOrigin: true,
      }
    }
  }
})
