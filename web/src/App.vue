<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
      return {
        value: true
      }
    }
}
</script>

<style>
  *{
    margin:0;
    padding:0;
    list-style: none;
  }
  #app{
    position: relative;
    width: 100%;
    height: 97vh;
  }
  
</style>
