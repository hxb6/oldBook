/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/15 20:11
 * @Description: 我是商家页面 js
 **/

/*------------书籍管理div相关js--开始------------------------*/

/**
 * 用户点击书籍管理按钮 显示自己的售卖书籍
 */
function bookManager() {
    /**
     * 全局变量
     * 保存书籍分类 id作为Map对象key
     * bookTypeName作为Map对象value
     */
    var map = new Map();

    /**
     * 获取书籍分类信息
     */
    getAllBookVariety();

    /**
     * 初始化bootstrap table并加载数据
     */
    initTable();

    /**
     * 获取书籍分类信息
     */
    function getAllBookVariety() {
        /**
         * 获取书籍分类信息
         */
        $.ajax({
            url: "/user/getAllBookVariety",
            async: false,
            success: function (object) {
                /*
                    遍历json数组中的rows 设置map数据
                 */
                //清空下拉框 填充页面书籍下拉框
                $("#target").empty();
                $("#target").append("<option selected='selected' value='" + 0 + "'>按书籍分类查询</option>");
                //清空下拉框 填充修改书籍Modal框中书籍种类
                $("#bookVarietyId").empty();
                for (var rowsKey in object.rows) {
                    $("#target").append("<option  value='" + object.rows[rowsKey].id + "'>" + object.rows[rowsKey].bookTypeName + "</option>");
                    $("#bookVarietyId").append("<option  value='" + object.rows[rowsKey].id + "'>" + object.rows[rowsKey].bookTypeName + "</option>");
                    map.set(object.rows[rowsKey].id, object.rows[rowsKey].bookTypeName)
                }
            }
        });
    }


    /**
     * 初始化bootstrap table并加载数据
     */
    function initTable() {
        /**
         * bootstrap table样式定义
         */
        var tableOrder = {
            url: "/book/getBooksByTableParams",         //请求后台的URL（*）
            method: "get",                      //请求方式（*）
            toolbar: "#toolbar",                //工具按钮用哪个容器
            undefinedText: "暂无简介",            //当数据为 undefined 时显示的字符
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sidePagination: "server",           //分页方式 client客户端分页 server服务端分页
            sortable: true,                     //是否启用排序
            sortName: "bookCreateTime",                 //默认排序字段
            sortOrder: "desc",                   //默认排序方式
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 4,                       //每页的记录条数（*）
            pageList: [4, 10, 20, 50],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            formatNoMatches: function () {
                return "暂无售卖书籍...";
            },
            queryParams: function (params) {    //查询参数
                var temp = {
                    offset: params.offset,
                    limit: params.limit,
                    sortName: this.sortName,
                    sortOrder: this.sortOrder,
                    target: $("#target").val()
                };
                return temp;
            },
            columns: [
                {
                    title: "序号",
                    align: "center",
                    formatter: function (value, row, index) {
                        return index + 1;
                    },
                },
                {
                    title: "书籍图片",
                    align: "center",
                    formatter: function (value, row, index) {
                        var url = "/" + row.imgUrl;
                        return '<img style="width: 74px;height: 74px" src="' + url + '">';
                    }
                },
                {
                    title: "书籍名称",
                    align: "center",
                    field: "bookName",
                    sortable: true
                },
                {
                    title: "书籍分类",
                    align: "center",
                    field: "bookVarietyId",
                    sortable: true,
                    formatter: function (value, row, index) {
                        //根据书籍分类id从map中获取对应的分类名称
                        return map.get(row.bookVarietyId);
                    }

                },
                {
                    title: "书籍价格",
                    align: "center",
                    field: "bookPrice",
                    sortable: true
                },
                {
                    title: "书籍存货",
                    align: "center",
                    field: "bookSave",
                    sortable: true
                },
                {
                    title: "添加时间",
                    align: "center",
                    field: "bookCreateTime",
                    sortable: true
                },
                {
                    title: "书籍状态",
                    align: "center",
                    field: "bookStatus",
                    sortable: true,
                    formatter: function (value, row, index) {
                        return row.bookStatus == 0 ? "未上架" : "已上架";
                    }
                },
                {
                    title: '操作',
                    align: "center",
                    formatter: function (value, row, index) {
                        var id = row.id;
                        var bookStatus = row.bookStatus;
                        var html1 = '<a onclick="getBookById(' + id + ')" style="cursor: pointer" title="修改"><span class="glyphicon glyphicon-edit" ></span></a>';
                        var html2;
                        if (bookStatus == 0) {
                            html2 = '<a style="cursor: pointer" onclick="setBookStatus(' + id + ',' + 1 + ')" title="上架"><span class="glyphicon glyphicon-circle-arrow-up" ></span></a>';
                        } else {
                            html2 = '<a style="cursor: pointer" onclick="setBookStatus(' + id + ',' + 0 + ')" title="下架"><span class="glyphicon glyphicon-circle-arrow-down" ></span></a>';
                        }
                        var html3 = '<a style="cursor: pointer" onclick="setBookStatus(' + id + ',' + 2 + ')" title="删除"><span class="glyphicon glyphicon-trash" ></span></a>';
                        return html1 + "&nbsp;&nbsp;&nbsp;" + html2 + "&nbsp;&nbsp;&nbsp;" + html3;
                    }
                }
            ]
        };
        $("#table").bootstrapTable(tableOrder);
    }



}

/**
 * 用户按书籍分类chaxun
 */
function refreshTable() {
    $("#table").bootstrapTable("refresh");
}

/**
 * 显示Modal框 设置相应信息 保存书籍的id
 * @param bookStatus 要设置的书籍状态信息
 */
function setBookStatus(bookId, bookStatus) {
    if (bookStatus == 2) {
        $("#setBookStatusLabel").text("删除书籍");
        $("#statusInfo").text("确定删除书籍!");
    } else {
        $("#setBookStatusLabel").text("改变书籍状态");
        if (bookStatus == 0) {
            $("#statusInfo").text("确定下架该书籍，再等等就会有买家哦...");
        } else {
            $("#statusInfo").text("确定上架该书籍");
        }
    }
    //设置点击书籍id到input框
    $("#bookId").val(bookId);
    //保存更改的书籍状态
    $("#bookStatus").val(bookStatus);
    //显示Modal框
    $("#setBookStatusModal").modal("show");
}

/**
 * 提交服务器改变书籍状态
 * 刷新表格 关闭Modal框
 */
function submitChangeBookStatus() {
    $.ajax({
        url: "/book/setBookStatus",
        type: "post",
        data: {
            "id": $("#bookId").val(),
            "bookStatus": $("#bookStatus").val()
        },
        success: function () {
            $("#table").bootstrapTable("refresh");
            $("#setBookStatusModal").modal("hide");
        }
    });
}

/**
 * 根据书籍id得到书籍信息
 * @param bookId
 */
function getBookById(bookId) {
    //保存需要修改书籍的id
    $("#updateBookId").val(bookId);
    $.ajax({
        url : "/book/getBookById",
        data : {
            "id" : bookId
        },
        success : function (object) {
            $("#bookName").val(object.data.bookName);
            $("#bookIntroduction").val(object.data.bookIntroduction);
            $("#bookPrice").val(object.data.bookPrice);
            $("#bookSave").val(object.data.bookSave);
            $("#bookVarietyId").val(object.data.bookVarietyId);
            $("#updateBookInfoModal").modal("show");
        }
    });
}

/**
 * 提交修改
 */
function updateBookInfo() {
    $.ajax({
        url : "/book/updateBook",
        type : "post",
        contentType : "application/json",
        data : JSON.stringify({
            "id" : $("#updateBookId").val(),
            "bookName" : $("#bookName").val(),
            "bookPrice" : $("#bookPrice").val(),
            "bookSave" : $("#bookSave").val(),
            "bookIntroduction" : $("#bookIntroduction").val(),
            "bookVarietyId" : $("#bookVarietyId").val()
        }),
        success : function () {
            $("#table").bootstrapTable("refresh");
            $("#updateBookInfoModal").modal("hide");
        }
    });
}

/*------------书籍管理div相关js--结束------------------------*/


/*------------书籍添加div相关js--开始------------------------*/
/**
 * 书籍添加相关js
 */
function bookAdd() {
    /**
     * 初始化 web uploader插件
     */
    initImgDiv();

    /**
     * 获取书籍分类信息 并填充到书籍添加分类框
     */
    getAllBookVariety();

    /**
     * 获取书籍分类信息
     */
    function getAllBookVariety() {
        /**
         * 获取书籍分类信息
         */
        $.ajax({
            url: "/user/getAllBookVariety",
            async: false,
            success: function (object) {
                $("#bookVarietyId").empty();
                $("#bookVarietyId").append("<option selected='selected' value='" + 0 + "'>请选择书籍分类(默认为其它分类)</option>");
                for (var rowsKey in object.rows) {
                    $("#bookVarietyId").append("<option  value='" + object.rows[rowsKey].id + "'>" + object.rows[rowsKey].bookTypeName + "</option>");
                }
            }
        });
    }
}

/*------------书籍添加div相关js--结束------------------------*/
