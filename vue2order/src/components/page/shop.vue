<template>
  <div>
    <div class="goods-type">

      <el-tabs>
        <el-tab-pane label="汉堡">
          <el-table
            :data="hamData"
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
              prop="description"
              label="商品描述">
            </el-table-column>
            <!--<el-table-column
              prop="src"
              label="图片路径"
              sortable
              width="180">
              <template slot-scope="scope">
                <img  :src="scope.row.src" alt="" style="width: 50px;height: 50px">
              </template>

            </el-table-column>-->
            <el-table-column label="操作" align="center" min-width="100">
              　　　　<template slot-scope="scope">
              　　　　　　<el-button type="info" @click="alter(scope.row.id)">修改</el-button>
              　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
              　　　　</template>
              　　</el-table-column>
          </el-table>
          <el-button type="info" @click="increase1" class="mybutton">增加</el-button>



          <el-dialog
            title="增加汉堡类商品"
            :visible.sync="increasehanbaodialogVisible"
            width="100%">
            <el-form :model="hamform" status-icon :rules="rules" ref="hamform" label-width="100px"
                     class="demo-ruleForm">
              <el-form-item label="请输入商品名" prop="name">
                <el-input type="text" v-model="hamform.name" ></el-input>
              </el-form-item>
              <el-form-item label="请输入价格" prop="price">
                <el-input type="text" v-model="hamform.price" ></el-input>
              </el-form-item>
              <el-form-item label="请输入商品描述" prop="description">
                <el-input type="text" v-model="hamform.description" ></el-input>
              </el-form-item>
              <el-form-item label="请输入图片网址" prop="src">
                <el-input type="text" v-model="hamform.src" ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submit('hamform')">提交</el-button>
                <el-button @click="resetForm('hamform')">重置</el-button>
              </el-form-item>
            </el-form>
          </el-dialog>



        </el-tab-pane>
        <el-tab-pane label="小食">
          <el-table
            :data="xiaoshiData"
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
            <!--<el-table-column
              prop="src"
              label="图片路径"
              sortable
              width="180">
              <template slot-scope="scope">
                <img  :src="scope.row.src" alt="" style="width: 50px;height: 50px">
              </template>

            </el-table-column>-->
            <el-table-column label="操作" align="center" min-width="100">
              　　　　<template slot-scope="scope">
              　　　　　
              　　　　　　<el-button type="info" @click="alter(scope.row.id)">修改</el-button>
              　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
              　　　　</template>
              　　</el-table-column>
          </el-table>
          <el-button type="info" @click="increase2" class="mybutton">增加</el-button>


          <el-dialog
            title="增加小食类商品"
            :visible.sync="increasexiaoshidialogVisible"
            width="100%">
            <el-form :model="xiaohshiform" status-icon :rules="rules" ref="xiaoshiform" label-width="100px"
                     class="demo-ruleForm">
              <el-form-item label="请输入商品名" prop="name">
                <el-input type="text" v-model="xiaohshiform.name" ></el-input>
              </el-form-item>
              <el-form-item label="请输入价格" prop="price">
                <el-input type="text" v-model="xiaohshiform.price" ></el-input>
              </el-form-item>
              <el-form-item label="请输入商品描述" prop="description">
                <el-input type="text" v-model="xiaohshiform.description" ></el-input>
              </el-form-item>
              <el-form-item label="请输入图片网址" prop="src">
                <el-input type="text" v-model="xiaohshiform.src" ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submit1('xiaoshiform')">提交</el-button>
                <el-button @click="resetForm('xiaoshiform')">重置</el-button>
              </el-form-item>
            </el-form>
          </el-dialog>



        </el-tab-pane>
        <el-tab-pane label="饮料">
          <el-table
            :data="yinliaoData"
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
            <!--<el-table-column
              prop="src"
              label="图片路径"
              sortable
              width="180">
              <template slot-scope="scope">
                <img  :src="scope.row.src" alt="" style="width: 50px;height: 50px">
              </template>

            </el-table-column>-->
            <el-table-column label="操作" align="center" min-width="100">
              　　　　<template slot-scope="scope">
              　　　　
              　　　　　　<el-button type="info" @click="alter(scope.row.id)">修改</el-button>
              　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
              　　　　</template>
              　　</el-table-column>
          </el-table>
          <el-button type="info" @click="increase3" class="mybutton">增加</el-button>

          <el-dialog
            title="增加饮料类商品"
            :visible.sync="increaseyinliaodialogVisible"
            width="100%">
            <el-form :model="yinliaoform" status-icon :rules="rules" ref="yinliaoform" label-width="100px"
                     class="demo-ruleForm">
              <el-form-item label="请输入商品名" prop="name">
                <el-input type="text" v-model="yinliaoform.name" ></el-input>
              </el-form-item>
              <el-form-item label="请输入价格" prop="price">
                <el-input type="text" v-model="yinliaoform.price" ></el-input>
              </el-form-item>
              <el-form-item label="请输入商品描述" prop="description">
                <el-input type="text" v-model="yinliaoform.description" ></el-input>
              </el-form-item>
              <el-form-item label="请输入图片网址" prop="src">
                <el-input type="text" v-model="yinliaoform.src" ></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submit2('yinliaoform')">提交</el-button>
                <el-button @click="resetForm('yinliaoform')">重置</el-button>
              </el-form-item>
            </el-form>
          </el-dialog>

        </el-tab-pane>
        <el-tab-pane label="套餐">
          <el-table
            :data="taocanData"
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
            <!--<el-table-column
              prop="src"
              label="图片路径"
              sortable
              width="180">
              <template slot-scope="scope">
                <img  :src="scope.row.src" alt="" style="width: 50px;height: 50px">
              </template>

            </el-table-column>-->
            <el-table-column label="操作" align="center" min-width="100">
              　　　　<template slot-scope="scope">
              　　　　
              　　　　　　<el-button type="info" @click="alter(scope.row.id)">修改</el-button>
              　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
              　　　　</template>
              　　</el-table-column>
          </el-table>
          <el-button type="info" @click="increase4" class="mybutton">增加</el-button>
        </el-tab-pane>

        <el-dialog
          title="增加套餐类商品"
          :visible.sync="increasetaocandialogVisible"
          width="100%">
          <el-form :model="taocanform" status-icon :rules="rules" ref="taocanform" label-width="100px"
                   class="demo-ruleForm">
            <el-form-item label="请输入商品名" prop="name">
              <el-input type="text" v-model="taocanform.name" ></el-input>
            </el-form-item>
            <el-form-item label="请输入价格" prop="price">
              <el-input type="text" v-model="taocanform.price" ></el-input>
            </el-form-item>
            <el-form-item label="请输入商品描述" prop="description">
              <el-input type="text" v-model="taocanform.description" ></el-input>
            </el-form-item>
            <el-form-item label="请输入图片网址" prop="src">
              <el-input type="text" v-model="taocanform.src" ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submit3('taocanform')">提交</el-button>
              <el-button @click="resetForm('taocanform')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>

        <el-dialog
          title="修改商品信息"
          :visible.sync="alterdialogVisible"
          width="100%">
          <el-form :model="alterform" status-icon :rules="alterrules" ref="alterform" label-width="100px"
                   class="demo-ruleForm">
            <el-form-item label="请输入商品名" prop="name">
              <el-input type="text" v-model="alterform.name" ></el-input>
            </el-form-item>
            <el-form-item label="请输入价格" prop="price">
              <el-input type="text" v-model="alterform.price" ></el-input>
            </el-form-item>
            <el-form-item label="请输入商品描述" prop="description">
              <el-input type="text" v-model="alterform.description" ></el-input>
            </el-form-item>
            <el-form-item label="请输入图片网址" prop="src">
              <el-input type="text" v-model="alterform.src" ></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="update('alterform')">提交</el-button>
              <el-button @click="resetForm('alterform')">重置</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
      </el-tabs>

    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default {
    name: 'shop',
    mounted: function () {
      var orderHeight = document.body.clientHeight;
      document.getElementById("order-list").style.height = orderHeight + 'px';
    },
    created() {
      if(this.$store.getters.getUser.adminname) {
        console.log("管理员已登录")
        this.adminlogin = true
        console.log(this.$store.getters.getUser.adminname)
        console.log(this.$store.getters.getUser.pwd)
      }else{
        console.log("not allowed")
      }
      //读取商品列表
      this.$axios.get('/goods/hamlist').then((res)=> {
        console.log(res.data.data)
        var arr = res.data.data
        for(let i =0;i<res.data.data.length;i++)
        {
          this.hamData.push({"id":arr[i].id,"name":arr[i].name,"price":arr[i].price,"src":arr[i].src,"description":arr[i].description})
        }
      })
      this.$axios.get('/goods/yinliaolist').then((res)=> {
        console.log(res.data.data)
        var arr = res.data.data
        for(let i =0;i<res.data.data.length;i++)
        {
          this.yinliaoData.push({"count":i,"id":arr[i].id,"name":arr[i].name,"price":arr[i].price,"src":arr[i].src,"description":arr[i].description})
        }
      })
      this.$axios.get('/goods/xiaoshilist').then((res)=> {
        console.log(res.data.data)
        var arr = res.data.data
        for(let i =0;i<res.data.data.length;i++)
        {
          this.xiaoshiData.push({"count":i,"id":arr[i].id,"name":arr[i].name,"price":arr[i].price,"src":arr[i].src,"description":arr[i].description})
        }
      })
      this.$axios.get('/goods/taocanlist').then((res)=> {
        console.log(res.data.data)
        var arr = res.data.data
        for(let i =0;i<res.data.data.length;i++)
        {
          this.taocanData.push({"count":i,"id":arr[i].id,"name":arr[i].name,"price":arr[i].price,"src":arr[i].src,"description":arr[i].description})
        }
      })
      console.log(this.hamData)
      console.log(this.xiaoshiData)
      console.log(this.yinliaoData)
    },
    data() {
      return {
        hamData: [],
        yinliaoData:[],
        xiaoshiData:[],
        taocanData:[],
        increasehanbaodialogVisible:false,
        increaseyinliaodialogVisible:false,
        increasexiaoshidialogVisible:false,
        increasetaocandialogVisible:false,
        alterdialogVisible:false,
        alterid:'',
        record: {
          customerid: '',
          tableid: '',
          cuisineid:'',
        },
        alterform: {
          id:'',
          name:'',
          price: '',
          src:'',
          description:'',
        },
        hamform: {
          name:'',
          price: '',
          src:'',
          description:'',
          type:'汉堡',
        },
        xiaohshiform: {
          name:'',
          price: '',
          src:'',
          description:'',
          type:'小食',
        },
        yinliaoform: {
          name:'',
          price: '',
          src:'',
          description:'',
          type:'饮料',
        },
        taocanform: {
          name:'',
          price: '',
          src:'',
          description:'',
          type:'套餐',
        },
        rules:{
          name: [
            {required: true, message: '请输入商品名', trigger: 'blur'},
          ],
          price: [
            {required: true, message: '请输入商品价格', trigger: 'blur'},
          ],
        },
        alterrules:{
          name: [
            {required: true, message: '请输入修改的商品名', trigger: 'blur'},
          ],
          price: [
            {required: true, message: '请输入修改的商品价格', trigger: 'blur'},
          ],
        },
      }
    },
    methods: {
      /*显示添加框*/
      increase1(){
        this.increasehanbaodialogVisible = true;
      },
      increase2(){
        this.increasexiaoshidialogVisible = true;
      },
      increase3(){
        this.increaseyinliaodialogVisible = true;
      },
      increase4(){
        this.increasetaocandialogVisible = true;
      },
      submit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 提交逻辑
            const _this = this;
            this.$axios.post('http://localhost:8081/goods/add', this.hamform).then((res)=>{
              if(res.data.data.id){
                _this.$alert('添加商品成功！', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$router.push("/shop")
                    location.reload()
                  }
                })
                console.log(res.data.data);
              }
            })
          } else {
            console.log('errorsubmit！');
            return false;
          }
        });
      },
      submit1(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 提交逻辑
            const _this = this;
            this.$axios.post('/goods/add', this.xiaohshiform).then((res)=>{
              if(res.data.data.id){
                _this.$alert('添加商品成功！', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$router.push("/shop")
                    location.reload()
                  }
                })
                console.log(res.data.data);
              }
            })
          } else {
            console.log('errorsubmit！');
            return false;
          }
        });
      },
      submit2(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 提交逻辑
            const _this = this;
            this.$axios.post('/goods/add', this.yinliaoform).then((res)=>{
              if(res.data.data.id){
                _this.$alert('添加商品成功！', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$router.push("/shop")
                    location.reload()
                  }
                })
                console.log(res.data.data);
              }
            })
          } else {
            console.log('errorsubmit！');
            return false;
          }
        });
      },
      submit3(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 提交逻辑
            const _this = this;
            this.$axios.post('/goods/add', this.taocanform).then((res)=>{
              if(res.data.data.id){
                _this.$alert('添加商品成功！', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$router.push("/shop")
                    location.reload()
                  }
                })
                console.log(res.data.data);
              }
            })
          } else {
            console.log('errorsubmit！');
            return false;
          }
        });
      },
      update(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            // 提交逻辑
            const _this = this;
            this.$axios.post('/goods/update', this.alterform).then((res)=>{
              if(res.data.data.id){
                _this.$alert('修改商品信息成功！', '提示', {
                  confirmButtonText: '确定',
                  callback: action => {
                    this.$router.push("/shop")
                    location.reload()
                  }
                })
                console.log(res.data.data);
              }
            })
          } else {
            console.log('errorsubmit！');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      //删除单个商品
      deletec(a){
        console.log(a)
        this.$axios.get('/goods/delete/'+a).then((res)=> {
          console.log(res.data.data)
          if(res.data.data.id){
            this.$alert('删除商品成功！', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                this.$router.push("/shop")
                location.reload()
              }
            })
          }else {
            console.log("error commit")
          }
        })
      },
      alter(a){
        console.log(a)
        this.alterdialogVisible = true
        this.alterform.id = a
      },
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .pos {
    font-size: 12px;
  }

  .mybutton{
    margin-top: 30px;
    width: 300px;
  }
  .pos-order {

    background-color: #F9FAFC;
    border-right: 1px solid #C0CCDA;
  }

  .order-btn {
    margin-top: 10px;
    text-align: center;
  }

  .title {
    height: 20px;
    border-bottom: 1px solid #D3DCE6;
    background-color: #F9FAFC;
    padding: 10px;
  }

  .often-goods-list ul li {
    list-style: none;
    float: left;
    border: 1px solid #E5E9F2;
    padding: 10px;
    margin: 5px;
    background-color: #fff;
    cursor: pointer;
  }

  .goods-type {
    clear: both;
  }

  .o-price {
    color: #58B7FF;
  }

  .often-goods-list {
    border-bottom: 1px solid #C0CCDA;
    height: auto;
    overflow: hidden;
    padding-bottom: 10px;
    background-color: #F9FAFC;
  }

  .cookList li {
    list-style: none;
    width: 23%;
    border: 1px solid #E5E9F2;
    height: auto;
    overflow: hidden;
    background-color: #fff;
    padding: 2px;
    float: left;
    margin: 2px;
    cursor: pointer;
  }

  .cookList li span {

    display: block;
    float: left;
  }

  .foodImg {
    width: 40%;
  }

  .foodName {
    font-size: 18px;
    padding-left: 10px;
    color: brown;
  }

  .foodPrice {
    font-size: 16px;
    padding-left: 10px;
    padding-top: 10px;
  }

  .totalDiv {
    height: auto;
    overflow: hidden;
    text-align: right;
    font-size: 16px;
    background-color: #fff;
    border-bottom: 1px solid #E5E9F2;
    padding: 10px;
  }
</style>
