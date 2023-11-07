<template>
  <div class="user">
    <el-row>
      <el-col :span="8">
        <div style="height: 30vh;">
          
          <p></p>
        </div>
      </el-col>
      <el-col :span="16">
      </el-col>
    </el-row>
    <el-row v-show="!bigVideo">
      <el-tabs type="border-card" style="height: 61vh;overflow: auto;">
        <el-tab-pane>
          <span slot="label"><i class="el-icon-user-solid"></i> 个人作品({{ like.length }})</span>
          <div>
            <!-- <div class="litterBox" v-for="item in user.Video">
              <div class="litter" @click="playBigVideo(item)">
                <img :src="item.coverimg"/>
              </div>
            </div> -->
          </div>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-lollipop"></i> 喜欢({{like.length}})</span>
          <div>
            <div class="litterBox" v-for="item in like">
              <div class="litter" @click="playBigVideo(item)">
                <img :src="item.coverimg"/>
              </div>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </el-row>
    <div class="homePage" v-show="bigVideo">
        <!-- <div class="home">
            <div width="auto" class="aside">
                <Aside ></Aside>
            </div>
            <div class="main">
                <PlayerVideo ></PlayerVideo>
            </div>

        </div> -->

    </div>
  </div>
</template>
  
<script>
import Aside from '/src/components/aside.vue'
import PlayerVideo from "/src/components/PlayerVideo.vue";
import Cookies from "vue-cookies"
var axios = require('axios');
export default {
  name: "home",
  components: {
        Aside,
        PlayerVideo
    },
  data() {
    return {
      bigVideo:false,
      like:[],
    };
  },
  methods: {
    playBigVideo(){}
  },
  mounted() {
    let token = Cookies.get('token')
    if(token){
      axios({
                method: 'get',
                url: 'video/user/likeList?id=2',
                Headers:{
                  token:token
                }

            }).then(function (response) {
                console.log(response.data, that.token)
                
                
            })
                .catch(function (error) {
                    console.log(error);
                });
    }
  },

};
</script>
<style lang="less" scoped>
.user {
  background-image: url(../assets/img/back.png);
}
.litter{
  width: 260px;
  height: 350px;
  background-color: antiquewhite;
  float: left;
  border-radius: 5%;
  margin-left: 10px;
  margin-top: 10px;
}
</style>