var dom = document.getElementById("main");
var myChart = echarts.init(dom);
myChart.showLoading({
    text: "图表数据正在努力加载..."
});
SoilTemperature();

function SoilTemperature() {
    var SoilTemperature = [];//用来盛放Y坐标值:土壤温度
    var TM = [];//用来盛放x坐标值:时间
    var TM1 = [];//用来盛放x坐标值:时间
    $.ajax('/XMLX/BY_Servlet', {
        url: '/XMLX/BY_Servlet',
        type: 'POST',
        dataType: 'json',
        async: false,
        success: function (response) {
            //var SQ=eval("("+response+")");//解析Json
            var date = response.data;
            for (var i = 0; i < date.length; i++) {
                SoilTemperature.push(date[i].count);
                TM.push(date[i].month);
                TM1.push(date[i].dq)
            }
            myChart.hideLoading();    //隐藏加载动画
            option = {
                title: {
                    text: '折线图堆叠'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {

                    data:['九龙坡区','南岸区','綦江区','江津区','大渡口区']
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: TM
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name: TM1[0],
                        type: 'line',
                        stack: '总量',
                        data: SoilTemperature
                    },
                    {
                        name: TM1[1],
                        type: 'line',
                        stack: '总量',
                        data: SoilTemperature
                    },
                    {
                        name: TM1[2],
                        type: 'line',
                        stack: '总量',
                        data: SoilTemperature
                    },
                    {
                        name: TM1[3],
                        type: 'line',
                        stack: '总量',
                        data: SoilTemperature
                    },
                    {
                        name: TM1[4],
                        type: 'line',
                        stack: '总量',
                        data: SoilTemperature
                    },

                ]
            };
            myChart.setOption(option);
        }
    });
}
