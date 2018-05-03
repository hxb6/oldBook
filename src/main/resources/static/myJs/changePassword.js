/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/3 19:03
 * @Description: 修改密码页面js
 **/

/**
 * 修改密码
 */
function changePassword(){
    $.ajax({
        url : "/user/changePassword",
        type : "post",
        data : {
            oldPassword : $("#oldPassword").val(),
            newPassword : $("#newPassword").val()
        },
        success : function (object) {
            if (object.status != 1) {
                $("#errorInfo").text(object.message);
            } else {
                //修改密码成功 重新登录
                alert("修改密码成功 重新登录");
                window.location.href = "/user/loginOut"
            }
        }
    });
}

/**
 * 检查密码输入规范
 */
function check(){

}
