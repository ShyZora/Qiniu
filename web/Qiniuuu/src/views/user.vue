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
    <el-row v-show="!bigVideo">
      <el-tabs type="border-card" style="height: 61vh;overflow: auto;">
        <el-tab-pane>
          <span slot="label"><i class="el-icon-user-solid"></i> 个人作品({{ user.Video.length }})</span>
          <div>
            <div class="litterBox" v-for="item in user.Video">
              <div class="litter" @click="playBigVideo(item)">
                <img :src="item.coverimg" />
              </div>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane>
          <span slot="label"><i class="el-icon-lollipop"></i> 喜欢({{ user.like.length }})</span>
          <div>
            <div class="litterBox" v-for="item in user.like">
              <div class="litter" @click="playBigVideo(item)">
                <img :src="item.coverimg" />
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
var axios = require('axios');
import Aside from '/src/components/aside.vue'
import PlayerVideo from "/src/components/PlayerVideo.vue";
export default {
  name: "home",
  components: {
    Aside,
    PlayerVideo
  },
  data() {
    return {
      bigVideo: false,
      user: {
        userId: '用户123445',
        userPassward: '',
        Video: [
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: Boolean,
            collect: true,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          }
        ],
        collect: [
          {
            url: '',
            coverurl: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: Boolean,
            collect: true,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          }
        ],
        like: [
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
          {
            url: '',
            upuser: '',
            upTime: '',
            text: '',
            tag: [],
            likeed: true,
            collect: Boolean,
            comment: [
              {
                commentUser: '',
                commentText: '',
                commentTime: '',
              }
            ],

          },
        ]
      }
    };
  },
  methods: {
    getPerson() {
      let that = this
      axios({
        method: 'get',
        url: '/video/video/user/feed?userId=2',
        

      }).then(function (response) {
        console.log(response.data)

      })
        .catch(function (error) {
          console.log(error);
        });
    },
    playBigVideo() { }
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
  width: 260px;
  height: 350px;
  background-color: antiquewhite;
  float: left;
  border-radius: 5%;
  margin-left: 10px;
  margin-top: 10px;
}
</style>