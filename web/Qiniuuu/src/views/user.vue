<template>
  <div class="user">
    <el-row>
      <el-col :span="8">
        <div style="height: 30vh;">
          <p>{{ user.userId }}</p>
          <p></p>
        </div>
      </el-col>
      <el-col :span="16">
      </el-col>
    </el-row>
    <el-row v-show="!bigVideo || !bigLike">
      <el-tabs type="border-card" style="height: 61vh;overflow: auto;">
        <el-tab-pane>
          <span slot="label"><i class="el-icon-user-solid"></i> 个人作品({{ user.Video.length }})</span>
          <div>
            <div class="litterBox" v-for="item in user.Video">
              <div class="litter">
                <littlePlay :urlarr="item" :idd="item.createTime"></littlePlay>
              </div>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-lollipop"></i> 喜欢({{ user.like.length }})</span>
          <div>
            <div class="litterBox" v-for="item in user.like">
              <div class="litter">
                <littlePlay :urlarr="item"></littlePlay>
              </div>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
    </el-row>

  </div>
</template>
  
<script>
var axios = require('axios');
import Aside from '/src/components/aside.vue'
import PlayerVideo from "/src/components/PlayerVideo.vue";
import littlePlay from "/src/components/littleplay.vue";
export default {
  name: "home",
  components: {
    Aside,
    PlayerVideo,
    littlePlay
  },
  data() {
    return {
      bigVideo: false,
      bigLike: false,
      user: {
        Video: [],
        like: []
      },
      isGetData: false,
      index: 0
    };
  },
  methods: {
    getPerson() {
      let that = this
      axios({
        method: 'get',
        url: 'video/video/user/feed?userId=' + that.$cookies.get('userId'),


      }).then(function (response) {
        that.isGetData = true
        that.user.Video = response.data.data

      })
        .catch(function (error) {
          console.log(error);
        });
      axios({
        method: 'get',
        url: 'video/video/user/likeList?id=' + that.$cookies.get('userId'),
        Headers: {
          token: that.$cookies.get('token')
        }

      }).then(function (response) {
        that.user.like = response.data.data
        that.isGetData = true
      })
        .catch(function (error) {
          console.log(error);
        });
    },
    
  },
  mounted() {
    this.getPerson()
  },

};
</script>
<style lang="less" scoped>
.user {
  background-image: url(../assets/img/back.png);
}

.litter {
  width: 250px;
  height: 350px;
  background-color: antiquewhite;
  float: left;
  border-radius: 5%;
  margin-left: 10px;
  margin-top: 10px;
}
</style>