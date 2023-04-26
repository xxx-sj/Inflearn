<template>
  <div id="app">
    <the-header/>
    <hr />
    <router-view></router-view>
    <hr />
    <the-footer />
  </div>
</template>

<script>
export default {
  name: 'App',
  computed: {
    testMethod() {
      return this.$store.getters['']
    },
  }

}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  padding: 0 80px;
}
</style>
