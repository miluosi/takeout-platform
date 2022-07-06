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
                　　　　　　<el-button type="text" @click="click1(scope.row.id)">查看详情</el-button>
                　　　　　　<el-button type="info" @click="order(scope.row.id)">点餐</el-button>
                　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
                　　　　</template>
                　　</el-table-column>
            </el-table>
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
                　　　　　　<el-button type="text" @click="click3(scope.row.count)">查看详情</el-button>
                　　　　　　<el-button type="info" @click="order(scope.row.id)">点餐</el-button>
                　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
                　　　　</template>
                　　</el-table-column>
            </el-table>
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
                　　　　　　<el-button type="text" @click="click2(scope.row.count)">查看详情</el-button>
                　　　　　　<el-button type="info" @click="order(scope.row.id)">点餐</el-button>
                　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
                　　　　</template>
                　　</el-table-column>
            </el-table>
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
                　　　　　　<el-button type="text" @click="click4(scope.row.count)">查看详情</el-button>
                　　　　　　<el-button type="info" @click="order(scope.row.id)">点餐</el-button>
                　　　　　　<el-button type="info" @click="deletec(scope.row.id)">删除</el-button>
                　　　　</template>
                　　</el-table-column>
            </el-table>
          </el-tab-pane>

        </el-tabs>
      </div>
    </div>
</template>

<script>
  import axios from 'axios';
  export default {
    name: 'goods',
    mounted: function () {
      var orderHeight = document.body.clientHeight;
      document.getElementById("order-list").style.height = orderHeight + 'px';
    },
    created() {
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
        totalMoney: 0, //订单总价格
        totalCount: 0  ,
        record: {
          customerid: '',
          tableid: '',
          cuisineid:'',
        },
      }
    },
    methods: {
      //显示商品详情
      click1(a) {
        const h = this.$createElement;
        console.log(a)
        console.log()
        this.$notify({
          title: this.hamData[a-1].name,
          message: h('i', { style: 'color: teal'}, this.hamData[a-1].description)
        });
      },
      click2(a) {
        const h = this.$createElement;
        console.log(a)
        console.log()
        this.$notify({
          title: this.yinliaoData[a].name,
          message: h('i', { style: 'color: teal'}, this.yinliaoData[a].description)
        });
      },
      click3(a) {
        const h = this.$createElement;
        console.log(a)
        console.log()
        this.$notify({
          title: this.xiaoshiData[a].name,
          message: h('i', { style: 'color: teal'}, this.xiaoshiData[a].description)
        });
      },
      click4(a) {
        const h = this.$createElement;
        console.log(a)
        console.log()
        this.$notify({
          title: this.taocanData[a].name,
          message: h('i', { style: 'color: teal'}, this.taocanData[a].description)
        });
      },
      //添加单个商品
      order(a){
        this.record.cuisineid = a
        this.record.tableid = this.$store.getters.getUser.tableid
        this.record.customerid = this.$store.getters.getUser.id
        console.log(a)
        console.log(this.$store.getters.getUser.tableid)
        console.log(this.$store.getters.getUser.id)
        this.$axios.post('/record/add', this.record).then((res)=>{
          console.log(res)
          if(res.data.data.id){
            this.$message({
              message: '恭喜你，点菜成功',
              type: 'success'
            });
            console.log(res.data.data);
          }
        })
      },
      //删除单个商品
      deletec(a){
        this.record.cuisineid = a
        this.record.tableid = this.$store.getters.getUser.tableid
        this.record.customerid = this.$store.getters.getUser.id
        console.log(a)
        console.log(this.$store.getters.getUser.tableid)
        console.log(this.$store.getters.getUser.id)
        this.$axios.post('/record/delete', this.record).then((res)=>{
          console.log(res.data.data.msg)
          if(res.data.data.msg=="empty"){
            this.$message({
              message: '您并没有点该菜品',
              type: 'warning'
            });
          }else {
            this.$message({
              message: '已经取消该菜品',
              type: 'success'
            });
          }
        })
      },
      //删除所有商品
      delAllGoods() {
        this.tableData = [];
        this.totalCount = 0;
        this.totalMoney = 0;
      },
      //汇总数量和金额
      getAllMoney() {
        this.totalCount = 0;
        this.totalMoney = 0;
        if (this.tableData) {
          this.tableData.forEach((element) => {
            this.totalCount += element.count;
            this.totalMoney = this.totalMoney + (element.price * element.count);
          });
        }
      },
      //结账方法模拟
      checkout() {
        if (this.totalCount!=0) {
          this.tableData = [];
          this.totalCount = 0;
          this.totalMoney = 0;
          this.$message({
            message: '结账成功，感谢你又为店里出了一份力!',
            type: 'success'
          });

        }else{
          this.$message.error('不能空结。老板了解你急切的心情！');

        }

      }


    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .pos {
    font-size: 12px;
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
