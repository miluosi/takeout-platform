<template>
  <div class="left-nav">
    <ul>
        <li>
            <i class="icon iconfont icon-wodezichan"></i>
          <div><router-link v-show="userlogin" to="/cashing">收银</router-link></div>
          <div v-show="!userlogin">收银</div>
        </li>

        <li>
            <i class="icon iconfont icon-dianpu"></i>
          <div><router-link v-show="adminlogin" to="/shop">店铺</router-link></div>
          <div v-show="!adminlogin">店铺</div>
        </li>

        <li>
            <i class="icon iconfont icon-hanbao"></i>
          <div><router-link v-show="userlogin" to="/goods">商品</router-link></div>
          <div v-show="!userlogin">商品</div>
        </li>

        <!-- <li>
            <i class="icon iconfont icon-huiyuanqia"></i>
            <div>会员</div>
        </li>

         <li>
            <i class="icon iconfont icon-shijian"></i>
            <div>抢购</div>
        </li>
-->
        <li>
            <i class="icon iconfont icon-tongji"></i>
          <div><router-link v-show="adminlogin" to="/statistic">统计</router-link></div>
          <div v-show="!adminlogin">统计</div>
        </li>

·
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Main',
  data () {
    return {
      userlogin:false,
      adminlogin:false
    }
  },
  created() {
    /*判断顾客登陆状态*/
    if(this.$store.getters.getUser.id) {
      console.log("顾客已登录")
      this.userlogin = true
      console.log(this.$store.getters.getUser.id)
      console.log(this.$store.getters.getUser.tableid)
    }
    /*判断管理员登陆状态*/
    if(this.$store.getters.getUser.adminname) {
      console.log("管理员已登录")
      this.adminlogin = true
      console.log(this.$store.getters.getUser.adminname)
      console.log(this.$store.getters.getUser.pwd)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
    .left-nav{
       color:#fff;
       font-size:10px;
       height:100%;
       background-color: #1D8ce0;
       float:left;
       width:5%;
    }
    .iconfont{
       font-size:24px;
    }
    .left-nav ul{
        padding:0px;
        margin: 0px;
    }
    .left-nav li{
        list-style: none;
        text-align: center;
        border-bottom:1px solid #20a0ff;
        padding:10px;
    }
</style>
