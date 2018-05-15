/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/9 23:49
 * @Description:   userList.html页面js
 **/

/**
 * 初始化bootstrap table数据
 */
function initTable() {
    /**
     * bootstrap table样式定义
     */
    var tableOrder = {
        url: "/admin/getUserByTableParams",         //请求后台的URL（*）
        method: "get",                      //请求方式（*）
        toolbar: "#toolbar",                //工具按钮用哪个容器
        undefinedText: "不是商家",            //当数据为 undefined 时显示的字符
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sidePagination: "server",           //分页方式 client客户端分页 server服务端分页
        sortable: true,                     //是否启用排序
        sortName: "userRegisterTime",                 //默认排序字段
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
            return "暂无用户...";
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
                title: "用户账号",
                align: "center",
                field: "userAccount",
                sortable: true
            },
            {
                title: "用户姓名",
                align: "center",
                field: "userName",
                sortable: true
            },
            {
                title: "注册时间",
                align: "center",
                field: "userRegisterTime",
                sortable: true
            },
            {
                title: "最近修改时间",
                align: "center",
                field: "userModifiedTime",
                sortable: true
            },
            {
                title: "用户角色",
                align: "center",
                field: "isMerchant",
                sortable: true,
                formatter: function (value, row, index) {
                    return row.isMerchant == false ? "普通用户" : "用户兼商家";
                }
            },
            {
                title: "成为商家时间",
                align: "center",
                field: "registerMerchantTime",
                sortable: true
            },
            {
                title: "账号状态",
                align: "center",
                field: "isValid",
                sortable: true,
                formatter: function (value, row, index) {
                    return row.isValid == false ? "冻结" : "正常";
                }
            },
            {
                title: '操作',
                align: "center",
                formatter: function (value, row, index) {
                    var id = row.id;
                    var html1;
                    if (row.isValid) {
                        html1 = '<a style="cursor: pointer" onclick="changeIsValid(' + id + ',0)"  title="冻结账号"><span class="glyphicon glyphicon-minus-sign" ></span></a>';
                    } else {
                        html1 = '<a style="cursor: pointer" onclick="changeIsValid(' + id + ',1)" title="解封账号"><span class="glyphicon glyphicon-ok-sign" ></span></a>';
                    }
                    var html3 = '<a style="cursor: pointer" onclick="resetPassword(' + id + ')" title="重置密码"><span class="glyphicon glyphicon-cog" ></span></a>';
                    return html1 + "&nbsp;&nbsp;&nbsp;" + html3;
                }
            }
        ]
    };
    $("#table").bootstrapTable(tableOrder);
}



/**
 * 更新账号状态
 * @param id
 * @param isValid
 */
function changeIsValid(id, isValid) {
    if (isValid == 1) {
        $("#isValid").text("解除冻结");
    } else {
        $("#isValid").text("冻结账号");
    }
    $("#userId").val(id);
    $("#valid").val(isValid);
    $("#validModal").modal("show");
}

/**
 * 改变用户账号信息
 */
function adminUpdateUser() {
    $.ajax({
        url: "/admin/adminUpdateUser",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            "id": $("#userId").val(),
            "isValid": $("#valid").val() == 1 ? true : false,
        }),
        success: function () {
            $("#validModal").modal("hide");
            $("#table").bootstrapTable("refresh");
        }
    });
}

/**
 * 记录点击的用户的id
 * 显示重置密码Modal框
 */
function resetPassword(id) {
    $("#userId").val(id);
    $("#resetModal").modal("show");
}

/**
 * 重置用户密码
 */
function adminResetPassword() {
    $.ajax({
        url: "/admin/adminResetPassword",
        type: "post",
        data: {
            "id": $("#userId").val(),
        },
        success: function () {
            $("#resetModal").modal("hide");
            $("#table").bootstrapTable("refresh");
        }
    });
}