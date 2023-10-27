<template>
  <div>
      <el-container>
          <el-aside  width="auto">
              <commonAside/>
          </el-aside>
          <el-container style="background-color: rgb(22,24,35);">
              <el-header style="padding: 0 0;">
                  <commonHeader/>
              </el-header>
              
              <el-main style="background-color: black; border-radius: 1rem;padding: 0 0;">
                  <!-- 子路由的路由出口在这，这个页面相当于大框架 -->
                  <router-view></router-view>
              </el-main>
          </el-container>
      </el-container>
      
  </div>
</template>

<script>
import commonAside from '../components/commonAside.vue'
import commonHeader from '../components/commonHeader.vue'
export default {
  name:'mainRouter',
  data(){
      return{
          
      }
  },
  components:{
      commonAside,
      commonHeader,
  }
}
</script>
<style scope>

</style>
