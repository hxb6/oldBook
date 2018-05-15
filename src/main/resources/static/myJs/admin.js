/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/9 23:44
 * @Description: admin.html 页面js
 **/

/**
 * 初始化bootstrap table数据
 */
function initTable() {
    /**
     * bootstrap table样式定义
     */
    var tableOrder = {
        url: "/user/getAllBookVariety",         //请求后台的URL（*）
        method: "get",                      //请求方式（*）
        toolbar: "#toolbar",                //工具按钮用哪个容器
        undefinedText: "暂无简介",            //当数据为 undefined 时显示的字符
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sidePagination: "server",           //分页方式 client客户端分页 server服务端分页
        sortable: true,                     //是否启用排序
        sortName: "bookTypeCreateTime",                 //默认排序字段
        sortOrder: "desc",                   //默认排序方式
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 10,                       //每页的记录条数（*）
        pageList: [10, 15, 20, 50],        //可供选择的每页的行数（*）
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
            return "暂无书籍分类消息...";
        },
        queryParams: function (params) {    //查询参数
            var temp = {
                offset: params.offset,
                limit: params.limit,
                sortName: this.sortName,
                sortOrder: this.sortOrder
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
                title: "分类名称",
                align: "center",
                field: "bookTypeName",
            },
            {
                title: "分类简介",
                align: "center",
                field: "bookTypeIntroduce"
            },
            {
                title: "创建时间",
                align: "center",
                field: "bookTypeCreateTime",

            },
            {
                title: "最近修改时间",
                align: "center",
                field: "bookTypeModifiedTime",

            },
            {
                title: "操作",
                align: "center",
                formatter: function (value, row, index) {
                    var id = row.id;
                    var html1;
                    if (row.id == 1) {
                        html1 = "默认分类";
                    } else {
                        html1 = '<a style="cursor: pointer" title="审批" onclick="showBookType(' + id + ')"><span class="glyphicon glyphicon-edit" ></span></a>';
                    }
                    return html1;
                }
            },
        ]

    };

    $("#table").bootstrapTable(tableOrder);
}


/**
 * 保存管理员点击的书籍分类的id 并显示Modal框
 * @param id
 *
 */
function showBookType(id) {
    $("#bookTypeId").val(id);
    $.ajax({
        url: "/user/getBookTypeById",
        type: "get",
        data: {
            "id": id
        },
        success: function (object) {
            $("#bookTypeName").val(object.data.bookTypeName);
            $("#bookTypeIntroduce").val(object.data.bookTypeIntroduce);
        }
    });
    $("#myModal").modal("show");
}

/**
 * 更新书籍分类信息
 */
function updateBookVariety() {
    $.ajax({
        url: "/admin/updateBookVariety",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            "id": $("#bookTypeId").val(),
            "bookTypeName": $("#bookTypeName").val(),
            "bookTypeIntroduce": $("#bookTypeIntroduce").val(),
        }),
        success: function () {
            $("#table").bootstrapTable("refresh");
            $("#myModal").modal("hide");
        }
    });
}

/**
 * 添加书籍分类信息
 */
function addBookVariety() {
    $.ajax({
        url: "/admin/addBookVariety",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            "bookTypeName": $("#addBookTypeName").val(),
            "bookTypeIntroduce": $("#addBookTypeIntroduce").val(),
        }),
        success: function () {
            $("#table").bootstrapTable("refresh");
            $("#addModal").modal("hide");
        }
    });
}