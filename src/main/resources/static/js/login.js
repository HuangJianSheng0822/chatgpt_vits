/*登录*/
$("#sub").click(function () {
    var email = $('input[name="email"]').val();
    var pwd = $('input[name="pwd"]').val();
    var remember = $("#remember").prop("checked");
    $.ajax({
        type: "post",
        url: "/login",
        contentType: "application/json;chatset=utf-8",
        data: JSON.stringify({
            email: email,
            pwd: pwd,
            remember: remember
        }),
        success: function (data, textStatus) {
            if (data.data === "YES") {
                /*重定向*/
                $(location).attr("href", "home.html")
            } else {
                alert(data.msg)
            }
        },
        errors: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error")
        }
    })
})


/*发送验证码*/
$("#send_code").click(function () {
    var email = $('input[name="email"]').val();
    var has_send =
        "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"25\" height=\"25\" fill=\"currentColor\" class=\"bi bi-send-check-fill\" viewBox=\"0 0 16 16\">\n" +
        "  <path d=\"M15.964.686a.5.5 0 0 0-.65-.65L.767 5.855H.766l-.452.18a.5.5 0 0 0-.082.887l.41.26.001.002 4.995 3.178 1.59 2.498C8 14 8 13 8 12.5a4.5 4.5 0 0 1 5.026-4.47L15.964.686Zm-1.833 1.89L6.637 10.07l-.215-.338a.5.5 0 0 0-.154-.154l-.338-.215 7.494-7.494 1.178-.471-.47 1.178Z\"/>\n" +
        "  <path d=\"M16 12.5a3.5 3.5 0 1 1-7 0 3.5 3.5 0 0 1 7 0Zm-1.993-1.679a.5.5 0 0 0-.686.172l-1.17 1.95-.547-.547a.5.5 0 0 0-.708.708l.774.773a.75.75 0 0 0 1.174-.144l1.335-2.226a.5.5 0 0 0-.172-.686Z\"/>\n" +
        "</svg>";


    if (!IsEmail(email)) {
        return;
    }
    $("#is_send").html(has_send)
    $.ajax({
        type: "post",
        url: "/code",
        data: {
            email: email
        },
        success: function (data, textStatus) {
            if (data.data === "YES") {
                alert(data.msg)
            } else {
                alert(data.msg)
            }
        },
        errors: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("error")
        }
    })
})

/*注册*/
$("#reg").click(function () {
    var email = $('input[name="email"]').val();
    var pwd = $('input[name="pwd"]').val();
    var code = $('input[name="code"]').val();
    if (code.trim().length != 0) {
        $.ajax({
            type: "post",
            url: "/register",
            data: {
                email: email,
                pwd: pwd,
                code: code
            },
            success: function (data, textStatus) {
                if (data.data === "YES") {
                    alert(data.msg)
                } else {
                    alert(data.msg)
                }
            },
            errors: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("error")
            }
        })
    }

})


/*邮箱合法*/
function IsEmail(str) {
    var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    return reg.test(str);
}
