<template>
  <div id="userLayout" :class="['user-layout-wrapper', device]">
    <div class="container">
      <div class="top">
        <div class="header">
          <a href="/">
            <img src="../src/assets/logo_unicom .png" class="logo" alt="logo">
            <span class="title">中国联通</span>
          </a>
        </div>
        <div class="desc">
          采用 Ant Design  Web 设计规范
        </div>
      </div>

      <route-view></route-view>

      <div class="footer">
        <div class="links">
          <a href="_self">帮助</a>
          <a href="_self">隐私</a>
          <a href="_self">条款</a>
        </div>
        <div class="copyright">
          Copyright &copy; 2019 亚信（中国）科技有限公司
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'UserLayout',
  data () {
    return {}
  },
  mounted () {
    document.body.classList.add('userLayout')
  },
  beforeDestroy () {
    document.body.classList.remove('userLayout')
  }
}
</script>
