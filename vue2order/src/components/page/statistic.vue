<template>
  <div>
        <el-table
          :data="liushui"
          style="width: 100%">
          <el-table-column
            prop="id"
            label="流水号"
            width="180">
          </el-table-column>
          <el-table-column
            prop="customerid"
            label="顾客编号"
            width="180">
          </el-table-column>
          <el-table-column
            prop="income"
            label="收入">
          </el-table-column>
          <el-table-column
            prop="date"
            label="收入日期">
          </el-table-column>
          <el-table-column label="操作" align="center" min-width="100">
            　　　　<template slot-scope="scope">
            　　　　　　<el-button type="info" @click="check(scope.row.customerid)">查看订单详情</el-button>
            　　　　</template>
            　　</el-table-column>
        </el-table>
        <div style="width: 800px;height: 300px" id="main">
        </div>
    <div style="width: 800px;height: 300px" id="main2">
    </div>
        <div style="width: 800px;height: 300px" id="main1">
        </div>
  </div>
</template>

<script>
    export default {
        name: "statistic",
      data(){
          return{
            liushui: [],
            detail:[],
            echartdata:{
              date:[],
              income:[]
            },
            piedata:[]
          }
      },
      methods:{
        check(a){
          this.$axios.get('/income/detail/'+a).then((res)=> {
            let string = ''
            let detail1=[]
            var arr = res.data.data.result
            console.log(res.data.data.result)
            for(let i =0;i<arr.length;i++)
            {
              detail1.push({"name":arr[i].name,"price":arr[i].price,"num":arr[i].num})
            }
            for(let i=0;i<detail1.length;i++){
              string+=`商品名:${detail1[i].name}, `
              string+=`价格:${detail1[i].price}, `
              string+=`销售数量:${detail1[i].num}, `
              string+='\n'
            }
            console.log(string)
            const h = this.$createElement;
            this.$notify({
              title: "订单详情",
              message: h('i', { style: 'color: teal'}, string)
            });
          })
        },
        echartsInit() {
          //柱形图
          //因为初始化echarts 的时候，需要指定的容器 id='main'
          this.$echarts.init(document.getElementById('main')).setOption({
            title: {
              text: '收入记录',
            },
            xAxis: {
              type: 'category',
              data: this.echartdata.date
            },
            yAxis: {
              type: 'value'
            },
            series: [{
              data: this.echartdata.income,
              type: 'bar',
              title: '收入',
              showBackground: true,
              backgroundStyle: {
                color: 'rgba(220, 220, 220, 0.8)'
              }
            }]
          }),
            this.$echarts.init(document.getElementById('main2')).setOption({
              title: {
                text: '收入记录',
              },
              xAxis: {
                type: 'category',
                data: this.echartdata.date
              },
              yAxis: {
                type: 'value'
              },
              series: [
                {
                  data: this.echartdata.income,
                  type: 'line',
                  markPoint: {
                    data: [
                      { type: 'max', name: 'Max' },
                      { type: 'min', name: 'Min' }
                    ]
                  },
                  markLine: {
                    data: [
                      { type: 'average', name: 'Avg', label: {
                          position: 'end',
                          formatter: 'Average'
                        } },[
                        {
                          symbol: 'none',
                          x: '90%',
                          yAxis: 'max'
                        },
                        {
                          symbol: 'circle',
                          label: {
                            position: 'start',
                            formatter: 'Max'
                          },
                          type: 'max',
                          name: '最高点'
                        }
                      ]
                    ]
                  }
                }
              ]
            }),
            this.$echarts.init(document.getElementById('main1')).setOption({
              title: {
                text: '日期收入饼图',
              },
              tooltip: {
                trigger: 'item'
              },
              legend: {
                orient: 'vertical',
                left: 'right'
              },
              series: [
                {
                  name: 'Access From',
                  type: 'pie',
                  radius: '50%',
                  data: this.piedata,
                  emphasis: {
                    itemStyle: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                  }
                }
              ]
            })
        },
      },
      created() {
        this.$axios.get('/income/list').then((res)=> {
          var arr = res.data.data
          for(let i =0;i<res.data.data.length;i++)
          {
            this.liushui.push({"id":arr[i].id,"customerid":arr[i].customerid,"income":arr[i].income,"date":arr[i].date})
          }
        })
        this.$axios.get('/income/info').then((res)=> {
          var arr = res.data.data.result
          for (let i=0; i<arr.length; i++){
            this.echartdata.date.push(arr[i].date)
            this.echartdata.income.push(arr[i].income)
            this.piedata.push({"name":arr[i].date,"value":arr[i].income})
          }
          console.log(this.piedata)
            this.echartsInit();
        }
        )
        console.log(this.echartdata.date)
      }
    }
</script>

<style scoped>

</style>
