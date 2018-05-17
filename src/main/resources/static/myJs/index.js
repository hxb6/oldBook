/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/17 20:33
 * @Description: 首页相关js
 **/

/**
 * 获取书籍种类
 */
function getBookTypes() {
    $.ajax({
        url: "/user/getAllBookVariety",
        success: function (object) {
            for (var rowsKey in object.rows) {
                var html = '<li onclick="getSellBookByBookVariety(' + object.rows[rowsKey].id + ',' + "'" + object.rows[rowsKey].bookTypeName + "'" + ')"><a href="javascript:void(0)">' + object.rows[rowsKey].bookTypeName + '</a></li>';
                $("#bookTypes").append(html);
            }
        }
    });
}

/**
 * 清除图片
 */
function clearImgDiv() {
    $("#Photo").children("div").remove();
}

/**
 * 获取所有售卖书籍列表
 */
function getSellBook() {
    $.ajax({
        type: "GET",
        url: "/book/getSellBook",
        async: false,
        success: function (msg) {
            if (msg.status != 1) {
                clearImgDiv();
                $("#messageInfo").text(msg.message);
            } else {
                $("#messageInfo").text("全部书籍");
            }
            pageShowData(msg.data)
        }
    });
}

/**
 * 根据书籍种类得到书籍列表
 */
function getSellBookByBookVariety(bookVarietyId, bookName) {
    $.ajax({
        type: "GET",
        url: "/book/getSellBookByBookVariety",
        data: {
            "bookVarietyId": bookVarietyId
        },
        async: false,
        success: function (msg) {
            if (msg.status != 1) {
                clearImgDiv();
                $("#messageInfo").text(msg.message);
            } else {
                $("#messageInfo").text(bookName);
            }
            pageShowData(msg.data)
        }
    });
}

/**
 * 根据书名模糊查询书籍
 */
function getSellBookLikeBookName() {
    var bookName = $("#likeBookName").val();
    if (bookName != '') {
        $.ajax({
            type: "GET",
            url: "/book/getSellBookLikeBookName",
            data: {
                "bookName": bookName,
            },
            async: false,
            success: function (msg) {
                if (msg.status != 1) {
                    clearImgDiv();
                    $("#messageInfo").text(msg.message);
                } else {
                    $("#messageInfo").text(bookName);
                }
                pageShowData(msg.data)
            }
        });
    } else {
        getSellBook();
    }
}

/**
 * 分页显示数据
 */
function pageShowData(data) {
    if (data != null) {
        //数据长度
        var dataLength = data.length;
        //每页显示的数据
        var pageSize = dataLength < 8 ? dataLength : 8;
        //首页默认显示数据
        showImgByPage(data, 0, pageSize);
        //计算有多少页
        var pages = Math.ceil(dataLength / pageSize);
        //初始化bootstrap 分页插件
        $("#pageInfo").bootstrapPaginator({
            //对应bootstrap版本
            bootstrapMajorVersion: 3,
            //当前页面
            currentPage: 1,
            //一页显示几个按钮(页数编码)
            numberOfPages: 5,
            //总页数
            totalPages: pages,
            //设置显示的样式，默认是箭头
            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            //页码改变时调用此方法显示新的书籍列表
            onPageChanged: function (event, oldPage, newPage) {
                //从保存的数据中start下标开始遍历
                var start = (newPage - 1) * pageSize;
                /*
                    结束下标 如果结束下标比数据长度还大,以数据长度作为结束下标
                 */
                var end = start + 8;
                if (end > dataLength) {
                    end = dataLength;
                }
                /*
                    显示数据
                */
                showImgByPage(data, start, end);
            }
        });
        $("#pageInfo").show();
    } else {
        $("#pageInfo").hide();
    }
}

/**
 * 根据分页显示图片列表
 */
function showImgByPage(data, start, end) {
    clearImgDiv();
    for (start; start < end; start++) {
        var bookName = data[start].bookName;
        var imgUrl = "/" + data[start].imgUrl;
        var bookPrice = data[start].bookPrice;
        var bookId = data[start].id;
        if (bookName == undefined) {
            bookName = "暂无标题";
        }
        if (bookPrice == undefined) {
            bookPrice = "暂无售价";
        }
        var html = '<div class="GoodsItem">' +
            '<a href="/book/toBookDetails?id=' + bookId + '">' +
            '<p class="bookName">' + bookName + '</p>' +
            '<img src="' + imgUrl + '">' +
            '<p><span class="price">￥' + bookPrice + '</span></p>' +
            '</a>' +
            '</div>'
        $("#Photo").append(html);
    }
}


/**
 * 回车绑定搜索事件
 */
$(document).keypress(function (e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13) {
        getSellBookLikeBookName();
    }
});