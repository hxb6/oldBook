/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/3 15:38
 * @Description: 个人中心person页面js
 **/
/**
 * 页面加载时加载登录用户的信息
 */
$(function () {
    $.ajax({
        url : "/user/getUserById",
        type : "get",
        success : function (object) {
            $("#userAccount").text(object.data.userAccount);
            $("#userName").val(object.data.userName);
            $("#userRegisterTime").text(object.data.userRegisterTime);
            $("#userModifiedTime").text(object.data.userModifiedTime);
            $("#isMerchant").text(object.data.isMerchant == 1 ? "是" : "否");
            if(object.data.isMerchant == 1){
               $("#registerMerchantTime").text(object.data.registerMerchantTime);
            }
        }
    });
});

/**
 * 更新对象
 */
function updateUser() {
    $.ajax({
        url : "/user/updateUser",
        type : "post",
        contentType : "application/json",
        data : JSON.stringify({
            "id" : $("#userId").val(),
            "userName" : $("#userName").val(),
        }),
        success : function () {
            window.location.href = "/user/person";
        }
    });
}