/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/7 19:48
 * @Description: 申请成为商家页面js
 **/

/**
 * 提交申请
 */
function apply() {
    $.ajax({
        url: "/user/applyToBeBusiness",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify({
            "applyReason": $("#applyReason").val()
        }),
        success: function (object) {
            //改变页面显示信息
            window.location.reload();
        }
    });
}


/**
 * 检查审批状态 页面进入时默认加载
 * 已经提交审批后 显示审批状态信息 否则显示提交审批信息表单
 */
function checkStatus() {
    $.ajax({
        url: "/user/queryByUserId",
        type: "get",
        success: function (object) {
            if (object.data != null) {
                //审批状态判断 这里只有两个状态 未审批与审批不通过 审批通过的AOP切面会跳转到商家信息页面
                if(object.data.status == 0){
                    $("#applyStatus").text("未审批");
                } else {
                    $("#applyStatus").text("审批不通过");
                }
                /*
                    显示审批状态信息并
                    显示审批状态信息表单
                 */
                $("#applyReasonBack").text(object.data.applyReason);
                $("#returnMessage").text(object.data.returnMessage);
                $("#applyTime").text(object.data.applyTime);
                $("#backMessage").show();
            } else {
                //显示提交审批信息表单
                $("#apply").show();
            }
        }
    });
}