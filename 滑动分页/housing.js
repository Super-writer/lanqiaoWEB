//滑动分页的异步
$(function(){
    var itemIndex = 0;//当前序列号
    var tab1LoadEnd = false;
    var counter = 0;//当前页数
    var num = 8;// 每页展示个数
    var pageStart = 0,pageEnd = 0;

    // dropload
    var dropload = $('.content').dropload({
        scrollArea : window,
        loadDownFn : function(me){
            // 加载数据
            if(itemIndex == '0') {
                alert("准备进入异步")
                $.ajax({
                    type: 'GET',
                    url: 'http://yangt.vipgz2.idcfengye.com/ServletProject/FindProductsServlet?hname=',
                    dataType: 'json',
                    success: function (data) {
                        var result = '';
                        counter++;
                        pageEnd = num * counter;//每一页的记录数
                        pageStart = pageEnd - num;

                        if (pageStart <= data.lists.length) {
                            for (var i = pageStart; i < pageEnd; i++) {
                                var hid = data.lists[i].hid;
                                result +='<a href="/ServletProject/housing.html?hid='+hid+'">'
                                    +'<div style="border: 0.5px solid #000000;">'
                                    + '<div style="float: left;">'
                                    + '<img src="' + data.lists[i].hphoto + '"style="width: 150px;height: 100px">'//图片
                                    +'</div>'
                                    +'<div style="float: left;">'
                                    +'<h3>' + data.lists[i].hid + '</h3>'//地址
                                    +'<h3>' + data.lists[i].haddress + '</h3>'//地址
                                    +'<h3>'+"约￥" + data.lists[i].hmoney +"万元"+ '</h3>'//价格
                                    +'<h3>'+data.lists[i].housetype+'</h3>'
                                    + '</div>'+'<div style="clear: both;"></div>'
                                    +'</div>'
                                    +'</a>'
                                if ((i + 1) >= data.lists.length) {
                                    // 数据加载完
                                    tab1LoadEnd = true;
                                    // 锁定
                                    me.lock();
                                    me.lock();
                                    // 无数据
                                    break;
                                }
                            }
                                    me.noData();
                            // 为了测试，延迟1秒加载
                            setTimeout(function () {
                                $('#lists').eq(0).append(result);
                                // 每次数据加载完，必须重置
                                me.resetload();
                            }, 1000);
                        }
                    },
                    error: function (xhr, type) {
                        alert('Ajax error!');
                        // 即使加载出错，也得重置
                        me.resetload();
                    }
                });
            }
        }
    });
});
//
function click_id(){// 当地区被点击时触发函数
    alert("识准备拿分类标")
    var pid = $(this).val();
   // hname=document.getElementById("id1").id;
    // var thisURL = decodeURI(document.URL);//获取当前页面的url,用decodeURL()解码
    // var getval = thisURL.split('?')[1].split("=")[1];
    // console.log(getval);
    // var hid = getval;
    alert("分类"+pid)
    //return hname;

}