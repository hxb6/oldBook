/**
 * @Author:         HeXiaoBo
 * @CreateDate:     2018/5/2 15:32
 * @Description: 登录页面相关js
 **/


/**
 *用户登录
 */
function login() {
    var options = {
        url: "/login",
        type: "post",
        success: function (object) {
            //用户名或密码错误或账号不可用
            if (object.status != 1) {
                //重绘验证码
                drawPic();
                //选中用户框
                $("#userAccount").select();
                $("#errorInfo").text(object.message);
            } else {
                //如果用户是普通用户 进入首页 否则进入后台管理页面
                if(object.data.roleType == 1){
                    //进入首页
                    window.location.href = "/index";
                } else {
                    //进入后台管理页面
                    window.location.href = "/admin/toAdmin";
                }
            }
        }
    };
    if (checkCode()) {
        $("form").ajaxSubmit(options);
    }
}

/**
 * 回车绑定登录事件
 */
$(document).keypress(function (e) {
    var eCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
    if (eCode == 13) {
        login();
    }
});

/**
 * 校验验证码
 * */
function checkCode() {
    var myCode = $("#myCode").val();
    myCode = myCode.toUpperCase();
    code = code.toUpperCase().slice(-4);
    if (myCode == code) {
        return true;
    } else {
        //选择错误的验证码 方便快速删除
        $("#myCode").select();
        //重绘验证码
        drawPic();
        $("#errorInfo").text("验证码错误");
        return false;
    }
}

/**验证码**/
var code = "";
drawPic();

/**生成一个随机数**/
function randomNum(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
}

/**生成一个随机色**/
function randomColor(min, max) {
    var r = randomNum(min, max);
    var g = randomNum(min, max);
    var b = randomNum(min, max);
    return "rgb(" + r + "," + g + "," + b + ")";
}


/**绘制验证码图片**/
function drawPic() {
    var canvas = document.getElementById("canvas");
    var width = canvas.width;
    var height = canvas.height;
    var ctx = canvas.getContext('2d');
    ctx.textBaseline = 'bottom';

    /**绘制背景色**/
    ctx.fillStyle = randomColor(180, 240); //颜色若太深可能导致看不清
    ctx.fillRect(0, 0, width, height);
    /**绘制文字**/
    var str = 'ABCEFGHJKLMNPQRSTWXY123456789';

    for (var i = 0; i < 4; i++) {
        var txt = str[randomNum(0, str.length)];
        ctx.fillStyle = randomColor(50, 160);  //随机生成字体颜色
        ctx.font = randomNum(25, 40) + 'px SimHei'; //随机生成字体大小
        var x = 10 + i * 25;
        var y = randomNum(25, 45);
        var deg = randomNum(-45, 45);
        //修改坐标原点和旋转角度
        ctx.translate(x, y);
        ctx.rotate(deg * Math.PI / 180);
        ctx.fillText(txt, 0, 0);
        //恢复坐标原点和旋转角度
        ctx.rotate(-deg * Math.PI / 180);
        ctx.translate(-x, -y);
        code = code + txt;
    }
    /**绘制干扰线**/
    for (var i = 0; i < 3; i++) {
        ctx.strokeStyle = randomColor(40, 180);
        ctx.beginPath();
        ctx.moveTo(randomNum(0, width), randomNum(0, height));
        ctx.lineTo(randomNum(0, width), randomNum(0, height));
        ctx.stroke();
    }
    /**绘制干扰点**/
    for (var i = 0; i < 40; i++) {
        ctx.fillStyle = randomColor(0, 255);
        ctx.beginPath();
        ctx.arc(randomNum(0, width), randomNum(0, height), 1, 0, 2 * Math.PI);
        ctx.fill();
    }
}