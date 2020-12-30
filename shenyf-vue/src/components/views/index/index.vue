<template>
  <div>
    <el-row>
      <el-card :body-style="{ padding: '0px' }">
        <el-col :span="8" v-for="menu in menuList">

        <!--<img :src="menu.value1" class="image">-->
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
          <div style="padding: 14px;">
            <span>{{menu.menuName}}</span>
            <div class="bottom clearfix">
              <time class="time">{{menu.menuClick}}</time>
              <el-button type="text" class="button">去看看</el-button>
            </div>
          </div>
      </el-col>
      </el-card>

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

/*  .image {
    width: 100%;
    display: block;
  }*/

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
                "user": JSON.parse(this.$route.query.user),
                "menuList": self.menuList
            }
        },
        created() {
            this.init()
        },
        methods: {
            init(){
                var self = this;
                this.$axios
                    .post('/api/index/init/', {
                        userId: this.user.userId
                    })
                    .then(successResponse => {
                        if (successResponse.data.code === '0000') {
                            console.log(successResponse.data.data)
                            self.menuList = successResponse.data.data;
                        }else {
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
        }

    }
</script>

<style scoped>

</style>
