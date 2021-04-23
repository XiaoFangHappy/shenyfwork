<template>
  <div v-loading="loading">
    <el-row>
      <el-button type="primary" plain @click="startGame('user')">我先开局</el-button>
      <el-button type="primary" plain @click="startGame('computer')">电脑开局</el-button>
    </el-row>
    <el-row :gutter="20" class="title-row">
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <i class="el-icon-user-solid">你的接龙次数：{{ user_count }}</i></div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <i class="el-icon-s-platform">电脑接龙次数：{{ computer_count }}</i></div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          <i class="el-icon-trophy">当前领先：{{ winner }}</i>
        </div>
      </el-col>
      <el-col :span="6">
        <div class="grid-content bg-purple">
          作答倒计时：{{ time_count }}
        </div>
      </el-col>
    </el-row>
    <el-row style="width: 90%;">
      <div class="grid-content bg-purple" style="text-align: left;margin:10px 60px;">
        当前作答：{{ answer }}
        <p>你的作答：
          <el-input placeholder="请输入你的答案" v-model="result" style="width: 20%;">
            <template slot="prepend">{{ firstWords }}</template>
          </el-input>
          <button type="primary" :disabled="vdisabled" style="height: 40px;width: 70px;" @click="userAnswer">确认</button>
        </p>
      </div>
    </el-row>
    <el-row style="width: 90%;">
      <div class="grid-content bg-purple" style="text-align: left;margin:10px 60px;">
        <!--<el-tag type="success">标签二</el-tag>
        <el-tag type="danger">标签一</el-tag>-->
        <!-- first=0是我红 first=1是电脑绿-->
        <el-tag :key="index" :type="index%2==0?'success':'danger'" v-for="(item, index) in list">{{ item }}</el-tag>
      </div>
    </el-row>
  </div>
</template>

<script>

  export default {
    name: "idiomSearch",
    data() {
      return {
        count: '',
        time_count: '0:00',
        user_count: 0,
        computer_count: 0,
        winner: '',
        answer: '',
        list: [],
        vdisabled: true,
        result: '',
        loading: false,
        roundIdiom: '',
        firstWords: '',
        first: '',
        timer: null,
      }
    },
    created() {
    },
    methods: {
      getCode() {
        const TIME_COUNT = 60;
        if (!this.timer) {
          this.count = TIME_COUNT;
          this.time_count = "0:" + TIME_COUNT;
          this.show = false;
          this.timer = setInterval(() => {
            if (this.count > 0 && this.count <= TIME_COUNT) {
              this.count--;
              this.time_count = "0:" + this.count;
            } else {
              this.show = true;
              clearInterval(this.timer);
              this.timer = null;
              this.vdisabled = true;
              this.openError('抱歉，你输了！');
            }
          }, 1000)
        }
      },
      startGame(type) {
        this.list = [];
        if (type == 'computer') { //电脑开局
          this.first = 1;
          this.loading = true;
          this.$http.post('/api/idiom/roundIdiom/').then(response => {
            this.loading = false;
            if (response.data.code === '0000') {
              this.roundIdiom = response.data.data;//随机成语
              this.list.push("电脑："+this.roundIdiom);
              this.answer = '我'; //当前作答
              this.firstWords = this.roundIdiom.substring(this.roundIdiom.length - 1, this.roundIdiom.length);
              this.openCenter('请您作答');
              this.getCode();//开始倒计时
              this.computer_count++;
              this.vdisabled = false;
              this.winner = '电脑';
            } else {
              this.winner = '我';
              this.openSuccess('恭喜你，你赢啦!!');
            }
          }).catch(error => {
            this.loading = false;
            this.$message({
              type: 'error',
              message: '系统异常!'
            });
          });
        } else {
          this.first = 0;
          this.userAnswer();
        }
      },
      userAnswer() {
        if (this.result === '') {
          this.openError("请输入你的答案");
          return;
        }
        this.$http.post('/api/idiom/userAnswer/', {
          idiom: this.result
        }).then(response => {
          this.loading = false;
          if (response.data.code === '0000') {
            this.list.push("我："+this.result);
            this.roundIdiom = response.data.data;//随机成语
            this.list.push("电脑："+this.roundIdiom);
            this.answer = '我'; //当前作答
            this.firstWords = this.roundIdiom.substring(this.roundIdiom.length - 1, this.roundIdiom.length);
            this.openCenter('请您作答');
            this.count = 60;
            this.computer_count++;
            this.user_count++;
            this.vdisabled = false;
            this.result = '';
          } else if (response.data.code === '9001') {
            this.list.push(this.result);
            this.answer = '电脑'; //当前作答
            this.vdisabled = true;
            this.result = '';
            this.openSuccess('恭喜你，你赢啦!!');
          } else {
            this.result = '';
            this.openError('抱歉，您的成语不符合要求！');
          }
        }).catch(error => {
          this.loading = false;
          this.$message({
            type: 'error',
            message: '系统异常!'
          });
        });
      },
      openCenter(message) {
        this.$message({
          message: message,
          center: true
        });
      },
      openError(message) {
        this.$message.error(message);
      },
      openSuccess(message) {
        this.$message({
          message: message,
          type: 'success'
        });
      },
    },
  }
</script>
<style scoped>
  .title-row {
    width: 60%;
    margin: 20px;
  }

  .el-col {
    border-radius: 4px;
  }

  .bg-purple-light {
    background: #e5e9f2;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }

  .el-tag {
    margin-right: 30px;
    margin-bottom: 30px;
  }
</style>
