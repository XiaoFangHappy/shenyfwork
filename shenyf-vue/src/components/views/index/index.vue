<template>
  <div>
    <el-row style="width: 60%;margin: 0 auto;">
      <el-col :span="8" v-for="menu in menuList" style="margin: 50px 50px 0px 60px;">
        <el-card :body-style="{ padding: '0px' }">
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
               class="image">
          <div style="padding: 14px;">
            <span>{{ menu.menuName }}</span>
            <div class="bottom clearfix">
              <time class="time">{{ menu.menuClick }}</time>
              <el-button type="text" @click="goPage(menu.menuUrl)" class="button">去看看</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>

  </div>

</template>
<style>
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
</style>
<script>
  export default {
    name: "index",
    data() {
      return {
        menuList: [],
        currentDate: new Date()
      }
    },
    created() {
      this.init();
    },
    methods: {
      init() {
        this.$http.post('/api/index/init/')
          .then(successResponse => {
            if (successResponse.data.code === '0000') {
              console.log(successResponse.data.data)
              this.menuList = successResponse.data.data;
            } else {
              this.$message({
                type: 'error',
                message: successResponse.data.message
              });
            }
          })
          .catch(failResponse => {
            this.$message({
              type: 'error',
              message: '系统异常!'
            });
          })
      },
      goPage(url){
        this.$router.push({name:url});
      }
    }

  }
</script>

<style scoped>

</style>
