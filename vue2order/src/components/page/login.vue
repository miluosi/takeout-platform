<template>
  <el-tabs>
    <el-tab-pane label="顾客">
      <div class="loginbox">
        <el-form ref="ruleForm" :model="ruleForm" :rules="loginRules" class="login_form" label-width="100px">
          <el-form-item   label="顾客序列号" prop="id">
            <el-input   v-model="ruleForm.id" class="login-madia" prefix-icon="iconfont icon-user"/>
          </el-form-item>
          <el-form-item   label="顾客桌号" prop="tableid">
            <el-select v-model="ruleForm.tableid" placeholder="请选择"  >
              <el-option
                v-for="item in options"
                :label="item.label"
                :value="item.label">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item class="btns">
            <el-button type="primary" @click="submitForm">入座</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-tab-pane>
    <el-tab-pane label="管理员">
      <div class="loginbox">
        <el-form ref="ruleForm1" :model="ruleForm1" :rules="loginRules1" class="login_form" label-width="120px">
          <el-form-item   label="管理员用户名" prop="username">
            <el-input   v-model="ruleForm1.username" class="login-madia" prefix-icon="iconfont icon-user"/>
          </el-form-item>
          <el-form-item  label="密码" prop="pawd">
            <el-input   v-model="ruleForm1.pawd" class="login-madia" prefix-icon="iconfont icon-zi" type="password"/>
          </el-form-item>
          <el-form-item class="btns">
            <el-button type="primary" @click="adminsubmit">登录</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-tab-pane>
  </el-tabs>
</template>

<script>
    export default {
        name: "login",
      data(){
        return{
          ruleForm: {
            id: '',
            tableid:'',
          },
          loginRules: {
            id: [
              { required: true, message: "请输入顾客号", trigger: "blur" },
            ],
            tableid: [
              { required: true, message: "请输入桌号", trigger: "blur" },
            ],
          },
          loginRules1: {
            username: [
              { required: true, message: "请输入管理员用户名", trigger: "blur" },
            ],
            pawd: [
              { required: true, message: "请输入管理员密码", trigger: "blur" },
            ],
          },
          ruleForm1: {
            username: '',
            pawd:'',
          },
          options: [],
          value: '',
          num:'',
        }
      },
      methods:{
          test1(){
            console.log(this.value)
            this.ruleForm.tableid = this.value
            console.log(this.ruleForm.tableid)
          },
        /*顾客入座*/
        submitForm(){
          console.log(this.ruleForm)
          this.$axios.post('/customer/add', this.ruleForm).then((res)=>{

            this.$store.commit('SET_USERINFO', res.data.data)
            console.log(res.data.data)
            console.log( this.$store.getters.getUser.tableid)
            this.$alert('入座成功，可以进行点餐', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                this.$router.push("/goods")
                location.reload()
              }
            })
          })
        },
        /*管理员登录*/
      adminsubmit(){
        this.$axios.post('/admin/login', this.ruleForm1).then((res)=>{
          this.$store.commit('SET_USERINFO', res.data.data)
          if(res.data.data.msg=="用户名不存在")
          {
            this.$alert('用户名不存在', '提示', {
              confirmButtonText: '确定',
              callback: action => {
              }
            })
          }
          if(res.data.data.msg=="密码错误")
          {
            this.$alert('密码错误', '提示', {
              confirmButtonText: '确定',
              callback: action => {
              }
            })
          }
          if(res.data.data.adminname){
            this.$alert('管理员登录成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                this.$router.push("/shop")
                location.reload()
              }
            })
          }
          console.log(this.$store.getters.getUser)
        })
      }},
      created() {
        this.$axios.get('/table/list').then((res)=> {
          console.log(res.data.data)
          var arr = res.data.data
          for(let i =0;i<res.data.data.length;i++)
          {
            this.options.push({"label":arr[i].id,"num":arr[i].number})
          }
        })
        this.$axios.get('/customer/num').then((res)=> {
          this.num = res.data.data.num
          console.log(this.num)
          this.ruleForm.id = this.num+1
        })
      }
    }
</script>

<style scoped>
  .loginbox{
    width: 600px;
    height: 400px;
  }
</style>
