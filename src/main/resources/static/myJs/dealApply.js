/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/9 23:47
 * @Description: dealApply.html 页面js
 **/
/**
 * 更新审批信息和用户信息
 */
function dealApplyInfoAndUpdateUser() {
    $.ajax({
        url: "/admin/dealApplyInfoAndUpdateUser",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            "id": $("#applyId").val(),
            "status": $("#status").val(),
            "returnMessage": $("#returnMessage").val(),
            "userId": $("#userId").val()

        }),
        success: function () {
            //关闭Modal框刷新bootstrap table
            $("#myModal").modal("hide");
            $("#table").bootstrapTable("refresh");
        }
    });
}

/**
 * 检查单选按钮的值并设置审批状态
 * 选中同意按钮 隐藏拒绝理由框
 * 选中拒绝按钮 显示拒绝理由框
 */
function checkApplyStatus(status) {
    //设置审批状态
    $("#status").val(status);
    status == 1 ? $(".common").hide() : $(".common").show();
}

/**
 * 得到申请人详细信息
 */
function viewAndApply(applyId, userId, applyReason) {
    $("#applyId").val(applyId);
    $("#userId").val(userId);
    $("#applyReason").val(applyReason);
    $.ajax({
        url: "/admin/getUserById",
        type: "get",
        data: {
            "userId": userId
        },
        success: function (object) {
            if (object.status == 1) {
                $("#userAccount").val(object.data.userAccount);
                $("#userName").val(object.data.userName);
                $("#userRegisterTime").val(object.data.userRegisterTime);
                $("#myModal").modal("show");
            }
        }
    });
}

/**
 * 初始化bootstrap table数据
 */
function initTable(){
    /**
     * bootstrap table样式定义
     */
    var tableOrder = {
        url: "/admin/getAllApplyForBusiness",         //请求后台的URL（*）
        method: "get",                      //请求方式（*）
        toolbar: "#toolbar",                //工具按钮用哪个容器
        undefinedText: "未审批",            //当数据为 undefined 时显示的字符
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sidePagination: "server",           //分页方式 client客户端分页 server服务端分页
        sortable: true,                     //是否启用排序
        sortName: "status",                 //默认排序字段
        sortOrder: "asc",                   //默认排序方式
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
        formatNoMatches: function(){
            return  "暂无商家申请消息...";
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
                title: "申请人",
                align: "center",
                field: "applyPersonName",
                sortable: true
            },
            {
                title: "申请原因",
                align: "center",
                field: "applyReason"
            },
            {
                title: "申请时间",
                align: "center",
                field: "applyTime",
                sortable: true

            },
            {
                title: '操作',
                align: "center",
                /**
                 * 如果申请未审批 管理员必须去审批
                 * @param value
                 * @param row
                 * @param index
                 * @returns {string}
                 */
                formatter: function (value, row, index) {
                    var userId = row.userId;
                    var applyReason = row.applyReason;
                    var applyId = row.id;
                    var html1 = '<a style="cursor: pointer" title="审批" onclick="viewAndApply(' + applyId + ',' + userId + ',' + "'" + applyReason + "'" + ')"><span class="glyphicon glyphicon-edit" ></span></a>';
                    return html1;
                }
            },
        ]

    };
    $("#table").bootstrapTable(tableOrder);
}