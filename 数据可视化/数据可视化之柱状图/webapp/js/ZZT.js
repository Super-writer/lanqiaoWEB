var dom = document.getElementById("main");
var myChart = echarts.init(dom);
myChart.showLoading({
    text: "图表数据正在努力加载..."
});
SoilTemperature();

function SoilTemperature() {
    var SoilTemperature = [];//用来盛放Y坐标值:土壤温度
    var TM = [];//用来盛放x坐标值:时间
    $.ajax('/XMLX/YY_Servlet', {
        url: '/XMLX/YY_Servlet',
        type: 'POST',
        dataType: 'json',
        async: false,
        success: function (response) {
            //var SQ=eval("("+response+")");//解析Json
            var date = response.data;
            for (var i = 0; i < date.length; i++) {
                SoilTemperature.push(date[i].count);
                TM.push(date[i].dq);
            }
            myChart.hideLoading();    //隐藏加载动画
            option = {
                color: ['#dbcc4c'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        data: TM,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: '人数',
                        type: 'bar',
                        barWidth: '40%',
                        data: SoilTemperature
                    }
                ]
            };
            myChart.setOption(option);
        }
    });
}
