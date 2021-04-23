<template>
  <div id="idiomDetail" v-loading="loading">
    <label for="">请输入成语</label><input type="text" v-model="idiomValue"/>
    <input type="button" @click="getDetail" value="查询">
    <div>
      <p> 成语：{{ this.idiomInfo.idiomName }}</p>
      <p> 拼音：{{ this.idiomInfo.idiomPronounce }}</p>
      <p> 解释：{{ this.idiomInfo.idiomContent }}</p>
      <p> 出处：{{ this.idiomInfo.idiomComefrom }}</p>
      <p> 反义词：{{ this.idiomInfo.idiomAntonym }}</p>
      <p> 同义词：{{ this.idiomInfo.idiomThesaurus }}</p>
      <p> 造句：{{ this.idiomInfo.idiomExample }}</p>
    </div>
  </div>
</template>

<script>
  export default {
    name: "idiomDetail",
    data() {
      return {
        loading: false,
        idiomValue: '',
        idiomInfo: {},
      }
    },
    created() {
    },
    methods: {
      getDetail() {
        this.loading = true;
        this.$http.post('/api/idiom/detail/', {
          idiomName: this.idiomValue
        }).then(response => {
          this.loading = false;
          if (response.data.code === '0000') {
            console.log(response.data.data)
            this.idiomInfo = response.data.data;
          } else {
            this.$message({
              type: 'error',
              message: response.data.message
            });
          }
        }).catch(error => {
          this.loading = false;
          this.$message({
            type: 'error',
            message: '系统异常!'
          });
        });
      },
    },
  }
</script>

<style scoped>

</style>
