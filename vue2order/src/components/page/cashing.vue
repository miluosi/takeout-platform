<template>
   <div>
     <el-table
       :data="cashinfo"
       style="width: 100%">
       <el-table-column
         prop="id"
         label="商品序号"
         width="180">
       </el-table-column>
       <el-table-column
         prop="name"
         label="商品名"
         width="180">
       </el-table-column>
       <el-table-column
         prop="price"
         label="价格">
       </el-table-column>
       <el-table-column
         prop="num"
         label="数量">
       </el-table-column>
     </el-table>
     <el-form >
       <el-form-item class="btns">
         <el-button type="primary" @click="cash" class="mybutton">结账</el-button>
         <el-button type="info" @click="more" class="mybutton">再点一些</el-button>
       </el-form-item>
     </el-form>
   </div>
</template>

<script>
    export default {
        name: "check",
      data(){
          return{
            user: {
              customerid: '',
              tableid: '',
              sum:'',
            },
            cashinfo:[],
            usercash:{
              customerid:'',
              income:''
            }
          }
      },
      created() {
        this.user.tableid = this.$store.getters.getUser.tableid
        this.user.customerid = this.$store.getters.getUser.id
        this.usercash.customerid = this.$store.getters.getUser.id
        this.$axios.get('/record/check/'+this.user.customerid).then((res)=> {
          console.log(res.data.data.result)
          var arr = res.data.data.result
          this.user.sum = res.data.data.sum
          this.usercash.income = res.data.data.sum
          for(let i = 0;i<arr.length;i++){
            this.cashinfo.push({'id':i,'name':arr[i].name,'num':arr[i].num,'price':arr[i].price})
          }
          console.log(this.cashinfo)
        })
      },
      methods:{
          cash(){
            this.$confirm("是否结账，总价:"+this.user.sum, "提示", {
              iconClass: "el-icon-question",//自定义图标样式
              confirmButtonText: "确认",//确认按钮文字更换
              cancelButtonText: "取消",//取消按钮文字更换
              showClose: true,//是否显示右上角关闭按钮
              type: "warning",//提示类型  success/info/warning/error
            }).then(function () {
            }).then((data) => {
              this.$axios.post('/income/add', this.usercash).then((res)=>{
               if(res.data.data.id){
                 this.$alert('结账成功成功', '提示', {
                   confirmButtonText: '确定',
                   callback: action => {
                     this.$router.push("/")
                     location.reload()
                   }
                 })
               }
              })
            })
          },
        more(){
          this.$router.push("/goods")
        }
      }
    }
</script>

<style scoped>
  .cashform{
    height: 100px;
    width: 500px;
  }
  .mybutton{
    width: 300px;
    height: 50px;
  }
</style>
