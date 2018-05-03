/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/2 16:04
 * @Description: 注册页面相关js
 **/

/**
 *  用户注册
 */
function register() {
    var options = {
        url : "/register",
        type : "post",
        success : function (object) {
            if(object.status != 1){
                $("#errorInfo").text(object.message);
            } else {
                $("#myModal").modal("show");
                // window.location.href = "/toLogin";
            }
        }
    };

    if(checkData()){
        $("form").ajaxSubmit(options);
    }
}

/**
 * 选择是去登录页面还是留在本页面
 * @param num
 */
function toLogin(num) {
    if(num == 1){
        window.location.href = "/toLogin";
    }else{
        $("#myModal").modal("hide");
    }
}

/**
 * 校验用户名和密码
 */
function checkData() {
    var userAccount = $("#userAccount").val();
    var password = $("#password").val();
    var rePassword = $("#rePassword").val();

    if (password != rePassword) {
        $("#errorInfo").text("两次密码不一样");
        return false;
    } else {
        return true;
    }

}