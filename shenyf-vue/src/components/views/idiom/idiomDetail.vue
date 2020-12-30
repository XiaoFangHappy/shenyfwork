<template>
  <div id="idiomDetail">
    <label for="">请输入成语</label><input type="text"/>
    <input type="button" @click="" value="查询">
    <div>
      成语：<p></p>
      拼音：<p></p>
      解释：<p></p>
      出处：<p></p>
      反义词：<p></p>
      同义词：<p></p>
    </div>
  </div>
</template>

<script>
    export default {
        name: "idiomDetail",
        data() {
            this.user = this.$route.query.user
            return {}
        },
        created() {
            console.log(this.user.userId);
            this.$message({
                type: "info",
                message: this.user.userId
            })
        }
    }
</script>

<style scoped>

</style>
